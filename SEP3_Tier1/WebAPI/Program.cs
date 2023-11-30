using System.Text;
using Application.DaoInterface;
using Application.Logic;
using Application.LogicInterface;
using Domain.Auth;
using obsolete_FileData;
using GrpcClient.Services;
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.IdentityModel.Tokens;
using obsolete_FileData.DAOs;
using WebAPI;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddScoped<FileContext>();



builder.Services.AddScoped<IUserLogic, UserLogic>();
builder.Services.AddScoped<IAnnouncementLogic, AnnouncementLogic>();

//When using GRPc
// builder.Services.AddScoped<IUserDao, GrpcUserService>();
// builder.Services.AddScoped<IAnnouncementDao, GrpcAnnouncementService>();

//When savind to file
builder.Services.AddScoped<IUserDao, UserFileDao>();
builder.Services.AddScoped<IAnnouncementDao, AnnouncementFileDao>();




builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();

builder.Services.AddGrpcClient<UserService.UserServiceClient>(o =>
{
    o.Address = new Uri("http://localhost:9090");
});
builder.Services.AddGrpcClient<AnnouncementService.AnnouncementServiceClient>(o =>
{
    o.Address = new Uri("http://localhost:9090");
});

builder.Services.AddSignalR();

builder.Services.AddSwaggerGen();

builder.Services.AddAuthentication(JwtBearerDefaults.AuthenticationScheme).AddJwtBearer(options =>
{
    options.RequireHttpsMetadata = false;
    options.SaveToken = true;
    options.MapInboundClaims = false;
    options.TokenValidationParameters = new TokenValidationParameters()
    {
        ValidateIssuer = true,
        ValidateAudience = true,
        ValidAudience = builder.Configuration["Jwt:Audience"],
        ValidIssuer = builder.Configuration["Jwt:Issuer"],
        IssuerSigningKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(builder.Configuration["Jwt:Key"])),
    };
});

AuthorizationPolicies.AddPolicies(builder.Services);


var app = builder.Build();


if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseAuthentication();

app.UseCors(policy => policy
    .AllowAnyHeader()
    .AllowAnyMethod()
    .AllowAnyOrigin());

app.UseHttpsRedirection();
app.UseAuthorization();

app.MapControllers();
app.MapHub<MyHub>("myhub");
app.MapHub<OfferHub>("offers");

app.Run();
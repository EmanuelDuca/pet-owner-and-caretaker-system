using System.Text.Json;
using Application.DaoInterface;
using Application.Logic;
using Application.LogicInterface;
using FileData;
using FileData.DAOs;
using Microsoft.AspNetCore.Builder;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddScoped<FileContext>();
builder.Services.AddScoped<IUserDao, UserFileDao>();
builder.Services.AddScoped<IUserLogic, UserLogic>();
builder.Services.AddScoped<IPetOwnerDao, PetOwnerFileDao>();
builder.Services.AddScoped<IPetOwnerLogic, PetOwnerLogic>();
builder.Services.AddScoped<IAnnouncementLogic, AnnouncementLogic>();
builder.Services.AddScoped<IAnnouncementDao, AnnouncementFileDao>();
builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
;

builder.Services.AddSwaggerGen();


var app = builder.Build();

app.UseCors(x => x
    .AllowAnyMethod()
    .AllowAnyHeader()
    .SetIsOriginAllowed(origin => true) // allow any origin
    .AllowCredentials());

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
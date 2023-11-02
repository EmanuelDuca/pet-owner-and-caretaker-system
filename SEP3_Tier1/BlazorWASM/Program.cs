using Microsoft.AspNetCore.Components.Web;
using Microsoft.AspNetCore.Components.WebAssembly.Hosting;
using BlazorClient;
using BlazorClient.Auth;
using BlazorWASM;
using Domain.Auth;
using HttpClients.ClientInterfaces;
using HttpClients.Implementations;
using Microsoft.AspNetCore.Components.Authorization;
using PexelsDotNetSDK.Api;
using Radzen;

var builder = WebAssemblyHostBuilder.CreateDefault(args);
builder.RootComponents.Add<App>("#app");
builder.RootComponents.Add<HeadOutlet>("head::after");

builder.Services.AddScoped(sp => new HttpClient { BaseAddress = new Uri("http://localhost:5123") });
builder.Services.AddScoped(sp => new HttpClient { BaseAddress = new Uri("https://localhost:7230") });

builder.Services.AddScoped(sp => new PexelsClient("ksD29mFZLavlPiGY8JBSzGJBrx5oNUZW0EcJbphg4GL3muk39MSM9olr"));

builder.Services.AddRadzenComponents();
builder.Services.AddScoped<IPexelsService, PexelsService>();
builder.Services.AddScoped<IAnnouncementService, AnnouncementHttpClient>();
builder.Services.AddScoped<IUserAuthService, JwtUserAuthAuthHttpService>();
builder.Services.AddScoped<AuthenticationStateProvider, CustomAuthProvider>();

AuthorizationPolicies.AddPolicies(builder.Services);

await builder.Build().RunAsync();
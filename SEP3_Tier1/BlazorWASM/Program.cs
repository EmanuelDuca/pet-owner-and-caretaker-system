using Microsoft.AspNetCore.Components.Web;
using Microsoft.AspNetCore.Components.WebAssembly.Hosting;
using BlazorClient;
using BlazorClient.Auth;
using BlazorWASM;
using Domain.Auth;
using HttpClients.ClientInterfaces;
using HttpClients.Implementations;
using Microsoft.AspNetCore.Components.Authorization;
using Radzen;

var builder = WebAssemblyHostBuilder.CreateDefault(args);
builder.RootComponents.Add<App>("#app");
builder.RootComponents.Add<HeadOutlet>("head::after");

builder.Services.AddScoped(sp => new HttpClient { BaseAddress = new Uri("http://localhost:5123") });
builder.Services.AddRadzenComponents();
builder.Services.AddScoped<IAnnouncementService, AnnouncementHttpClient>();
builder.Services.AddScoped<IUserAuthService, JwtUserAuthAuthHttpService>();
builder.Services.AddScoped<AuthenticationStateProvider, CustomAuthProvider>();

AuthorizationPolicies.AddPolicies(builder.Services);

await builder.Build().RunAsync();
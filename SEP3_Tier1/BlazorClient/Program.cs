using Microsoft.AspNetCore.Components.Web;
using Microsoft.AspNetCore.Components.WebAssembly.Hosting;
using BlazorClient;
using HttpClients.ClientInterfaces;
using HttpClients.Implementations;
using Radzen;

var builder = WebAssemblyHostBuilder.CreateDefault(args);
builder.RootComponents.Add<App>("#app");
builder.RootComponents.Add<HeadOutlet>("head::after");

builder.Services.AddScoped(sp => new HttpClient { BaseAddress = new Uri("https://localhost:7230") });
builder.Services.AddRadzenComponents();
builder.Services.AddScoped<IAnnouncementService, AnnouncementHttpClient>();
builder.Services.AddScoped<IUserService, UserHttpClient>();

await builder.Build().RunAsync();
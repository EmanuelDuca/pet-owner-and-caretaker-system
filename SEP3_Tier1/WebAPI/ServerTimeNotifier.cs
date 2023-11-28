using Microsoft.AspNetCore.SignalR;

namespace WebAPI;

public class ServerTimeNotifier : BackgroundService
{
    private static readonly TimeSpan Period = TimeSpan.FromSeconds(5);
    private readonly ILogger<ServerTimeNotifier> logger;
    private readonly IHubContext<MyHub, IMyClient> _context;

    public ServerTimeNotifier(ILogger<ServerTimeNotifier> logger, IHubContext<MyHub, IMyClient> context)
    {
        this.logger = logger;
        _context = context;
    }

    protected override async Task ExecuteAsync(CancellationToken stoppingToken)
    {
        using var Timer = new PeriodicTimer(Period);

        while (!stoppingToken.IsCancellationRequested && await Timer.WaitForNextTickAsync(stoppingToken))
        {
            var dateTime = DateTime.Now;
            logger.LogInformation("Executing {Service} {Time}", nameof(ServerTimeNotifier), dateTime);
            await _context.Clients.All.Receive($"Server time = {dateTime}");
        }
    }
}
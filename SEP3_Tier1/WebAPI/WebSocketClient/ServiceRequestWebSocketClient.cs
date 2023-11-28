using System.Net.WebSockets;
using System.Text;

namespace WebAPI.WebSocketClient;

class ServiceRequestWebSocketClient : BackgroundService
{
    private ClientWebSocket clientWebSocket;
    private readonly string serverUri;

    public ServiceRequestWebSocketClient(string serverUri)
    {
        clientWebSocket = new();
        this.serverUri = serverUri;
    }


    private async Task Connect()
    {
        try
        {
            await clientWebSocket.ConnectAsync(new Uri(serverUri), CancellationToken.None);
            Console.WriteLine("Connected to the websocket server!");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Connection closed: {ex.Message}");
            if (clientWebSocket.State == WebSocketState.Open)
                await clientWebSocket.CloseAsync(WebSocketCloseStatus.NormalClosure, string.Empty, CancellationToken.None);
            clientWebSocket.Dispose();
            Console.WriteLine($"Connection closed");
        }
    }

    private async Task Send(string message)
    {
        byte[] buffer = Encoding.UTF8.GetBytes(message);
        await clientWebSocket.SendAsync(new ArraySegment<byte>(buffer), WebSocketMessageType.Text, true, CancellationToken.None);
    }

    private async Task Receive()
    {
        byte[] buffer = {};
        while (clientWebSocket.State == WebSocketState.Open)
        {
            WebSocketReceiveResult result = await clientWebSocket.ReceiveAsync(new ArraySegment<byte>(buffer), CancellationToken.None);
            if (result.MessageType == WebSocketMessageType.Text)
            {
                string receivedMessage = Encoding.UTF8.GetString(buffer, 0, result.Count);
                Console.WriteLine($"Received message: {receivedMessage}");
            }
        }
    }

    protected override async Task ExecuteAsync(CancellationToken stoppingToken)
    {
        await Connect();
        await Send("Hello Java)");
    }
}
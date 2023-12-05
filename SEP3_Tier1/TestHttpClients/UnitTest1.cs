using System.Net;
using System.Net.Http.Json;
using Domain.DTOs;
using HttpClients.ClientInterfaces;
using HttpClients.Implementations;
using Moq;

namespace TestHttpClients;

[TestFixture]
public class Tests
{
    private JwtAuthAuthHttpService jwtAuthService;
    private Mock<HttpClient> mockHttpClient;

    [SetUp]
    public void Setup()
    {
        mockHttpClient = new Mock<HttpClient>();
        jwtAuthService = new JwtAuthAuthHttpService(mockHttpClient.Object);
    }

    [Test]
    public async Task Name()
    {
        // Arrange
        
        // Act
        
        // Assert
        
    }
    
}

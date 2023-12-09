using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface ICareServiceService
{
    Task OfferServiceAsync(CreateOfferCareDto offerDto);
    Task AcceptServiceAsync(int requestId);
    Task EndServiceAsync(int serviceId);
    Task DenyServiceAsync(int requestId);
    Task<IEnumerable<ServiceRequest>> GetServiceOffersAsync(int announcementId);
    Task<Service> GetServiceAsync(int serviceId);
    Task<IEnumerable<Service>> GetServicesAsync(SearchServicesDto dto);
    Task GiveFeedbackAsync(Feedback feedback);
    Task DeleteFeedbackAsync(int serviceId, string email);
    Task<IEnumerable<Feedback>> GetFeedbacks(string email);
}
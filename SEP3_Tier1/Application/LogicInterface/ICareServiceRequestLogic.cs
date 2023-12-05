using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterface;

public interface ICareServiceRequestLogic
{
    Task OfferCare(CreateOfferCareDto dto);
    Task AcceptOffer(int requestId);
    Task EndOffer(int serviceId);
    Task DenyOffer(int requestId);
    Task<IEnumerable<ServiceRequest>> GetRequestsAsync(int announcementId);
    Task<Service> GetServiceAsync(int serviceId);
    Task<IEnumerable<Service>> GetServicesAsync(SearchServicesDto dto);
    Task AddFeedbackAsync(Feedback feedback);
    Task DeleteFeedbackAsync(int serviceId, string email);
    Task<IEnumerable<Feedback>> GetFeedbacks(string email);
}
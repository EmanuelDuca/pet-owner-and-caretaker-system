using Domain.DTOs;
using Domain.Models;

namespace Application.DaoInterface;

public interface ICareServiceRequestDao
{
    Task OfferAsync(CreateOfferCareDto dto);
    Task AcceptAsync(int requestId);
    Task EndAsync(int serviceId);
    Task DenyAsync(int requestId);
    Task<IEnumerable<ServiceRequest>> GetRequestsAsync(int announcementId);
    Task<Service> GetServiceAsync(int serviceId);
    Task<IEnumerable<Service>> GetServicesAsync(SearchServicesDto dto);
    Task AddFeedbackAsync(Feedback feedback);
    Task DeleteFeedbackAsync(int serviceId, string email);
    Task<IEnumerable<Feedback>> GetFeedbacks(string email);
}
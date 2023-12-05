using Domain.DTOs;
using Domain.Models;

namespace Application.DaoInterface;

public interface ICareServiceRequestDao
{
    Task OfferAsync(CreateOfferCareDto dto);
    Task AcceptAsync(int requestId);
    Task EndAsync(int serviceId);
    Task DenyAsync(int requestId);
    Task<IEnumerable<Service>> GetServicesAsync(SearchServicesDto dto);

}
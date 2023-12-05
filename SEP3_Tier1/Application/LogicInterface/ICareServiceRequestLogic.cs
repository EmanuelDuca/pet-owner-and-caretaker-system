using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterface;

public interface ICareServiceRequestLogic
{
    Task OfferCare(CreateOfferCareDto dto);
    Task AcceptOffer(int requestId);
    Task EndOffer(int serviceId);
    Task DenyOffer(int requestId);
}
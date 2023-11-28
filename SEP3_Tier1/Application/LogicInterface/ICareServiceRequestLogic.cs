using Domain.Models;

namespace Application.LogicInterface;

public interface ICareServiceRequestLogic
{
    Task OfferCare(string initiatorEmail, int announcementId, string recipientEmail);
}
using Domain.DTOs;
using Domain.Models;

namespace Application.DaoInterface;

public interface ICareServiceRequestDao
{
    Task OfferAsync(string initiatorEmail, int announcementId, string recipient);
}
using Application.DaoInterface;
using Application.LogicInterface;
using Domain.DTOs;
using Domain.Models;

namespace Application.Logic;

public class CareServiceRequestLogic : ICareServiceRequestLogic
{
    private readonly ICareServiceRequestDao careServiceRequestDao;

    public async Task OfferCare(string initiatorEmail, int announcementId, string recipientEmail)
    {
        await careServiceRequestDao.OfferAsync(initiatorEmail, announcementId, recipientEmail);
    }
}
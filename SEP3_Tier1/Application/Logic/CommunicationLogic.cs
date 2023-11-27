using Application.DaoInterface;
using Domain.DTOs;
using Domain.Models;

namespace Application.Logic;

public class CommunicationLogic : ICommunicationLogic
{
    private readonly ICommunicationDao communicationDao;

    public async Task OfferCare(CareTaker caretaker)
    {
        await communicationDao.OfferAsync(caretaker);
    }
}
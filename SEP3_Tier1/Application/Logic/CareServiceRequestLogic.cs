using Application.DaoInterface;
using Application.LogicInterface;
using Domain.DTOs;
using Domain.Models;

namespace Application.Logic;

public class CareServiceRequestLogic : ICareServiceRequestLogic
{
    private readonly ICareServiceRequestDao careServiceRequestDao;
    
    public async Task OfferCare(CreateOfferCareDto dto)
    {
        await careServiceRequestDao.OfferAsync(dto);
    }

    public async Task AcceptOffer(int requestId)
    {
        await careServiceRequestDao.AcceptAsync(requestId);
    }

    public async Task EndOffer(int serviceId)
    {
        await careServiceRequestDao.EndAsync(serviceId);
    }
}
using Application.DaoInterface;
using Application.LogicInterface;
using Domain.DTOs;
using Domain.Models;

namespace Application.Logic;

public class CareServiceRequestLogic : ICareServiceRequestLogic
{
    private readonly ICareServiceRequestDao careServiceRequestDao;
    
    public CareServiceRequestLogic(ICareServiceRequestDao dao)
    {
        this.careServiceRequestDao = dao;
    }
    
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
    
    public async Task DenyOffer(int requestId)
    {
        await careServiceRequestDao.EndAsync(requestId);
    }

    public async Task<IEnumerable<ServiceRequest>> GetRequestsAsync(int announcementId)
    {
        return await careServiceRequestDao.GetRequestsAsync(announcementId);
    }

    public async Task<Service> GetServiceAsync(int serviceId)
    {
        return await careServiceRequestDao.GetServiceAsync(serviceId);
    }

    public async Task<IEnumerable<Service>> GetServicesAsync(SearchServicesDto dto)
    {
        
        return await careServiceRequestDao.GetServicesAsync(dto);
    }

    public async Task AddFeedbackAsync(Feedback feedback)
    {
        await careServiceRequestDao.AddFeedbackAsync(feedback);
    }

    public async Task DeleteFeedbackAsync(int serviceId, string email)
    {
        await careServiceRequestDao.DeleteFeedbackAsync(serviceId, email);
    }

    public async Task<IEnumerable<Feedback>> GetFeedbacks(string email)
    {
        return await careServiceRequestDao.GetFeedbacks(email);
    }
}
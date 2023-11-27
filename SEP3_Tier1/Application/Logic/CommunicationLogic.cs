using Application.DaoInterface;
using Domain.DTOs;
using Domain.Models;

namespace Application.Logic;

public class CommunicationLogic : ICommunicationLogic
{
    private readonly ICommunicationDao communicationDao;


    public async Task<IEnumerable<CareTaker>> GetAsync(SearchCaretakerDto parameters)
    {
        return await communicationDao.GetAsync(parameters);
    }
}
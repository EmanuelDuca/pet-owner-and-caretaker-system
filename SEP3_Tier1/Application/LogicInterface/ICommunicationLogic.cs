using Domain.DTOs;
using Domain.Models;

namespace Application.DaoInterface;

public interface ICommunicationLogic
{
    Task<IEnumerable<CareTaker>> GetAsync(SearchCaretakerDto parameters);
}
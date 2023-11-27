using Domain.DTOs;
using Domain.Models;

namespace Application.DaoInterface;

public interface ICommunicationDao
{
    Task<IEnumerable<CareTaker>> GetAsync(SearchCaretakerDto parameters);
}
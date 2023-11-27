using Domain.DTOs;
using Domain.Models;

namespace Application.DaoInterface;

public interface ICommunicationDao
{
    Task OfferAsync(CareTaker caretaker);
}
using Domain.DTOs;
using Domain.Models;

namespace Application.DaoInterface;

public interface ICommunicationLogic
{
    Task OfferCare(CareTaker caretaker);
}
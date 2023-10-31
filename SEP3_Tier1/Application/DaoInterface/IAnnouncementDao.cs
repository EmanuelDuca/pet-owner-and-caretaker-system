using Domain.DTOs;
using Domain.Models;

namespace Application.DaoInterface;

public interface IAnnouncementDao
{
    Task<AnnouncementCreationDto> CreateAsync(AnnouncementCreationDto announcement);
}
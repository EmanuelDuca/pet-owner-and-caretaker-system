using Domain.DTOs;
using Domain.Models;

namespace Application.DaoInterface;

public interface IAnnouncementDao
{
    Task<Announcement> CreateAsync(AnnouncementCreationDto announcement);
    Task<IEnumerable<Announcement>> GetAsync(SearchAnnouncementDto dto);
}
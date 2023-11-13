using Domain.DTOs;
using Domain.Models;

namespace Application.DaoInterface;

public interface IAnnouncementDao
{
    Task<Announcement> CreateAsync(AnnouncementCreationDto dto);
    Task<IEnumerable<Announcement>> GetAsync(SearchAnnouncementDto dto);
    Task UpdateAsync(AnnouncementUpdateDto announcement);
    Task<Announcement> CreateAsync(Announcement announcement);
    Task DeleteAsync(int id);
}
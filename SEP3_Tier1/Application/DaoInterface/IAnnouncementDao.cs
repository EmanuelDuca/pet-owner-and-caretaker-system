using Domain.DTOs;
using Domain.Models;

namespace Application.DaoInterface;

public interface IAnnouncementDao
{
    //Task<Announcement> CreateAsync(AnnouncementCreationDto dto);
    Task<IEnumerable<Announcement>> GetAsync(SearchAnnouncementDto dto);
    Task<Announcement> GetByIdAsync(int id);
    Task UpdateAsync(UpdateAnnouncementDto updateAnnouncement);
    Task<Announcement> CreateAsync(Announcement ann);
    Task DeleteAsync(int id);
}
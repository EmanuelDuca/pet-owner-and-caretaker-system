using Domain.Models;

namespace Application.DaoInterface;

public interface IAnnouncementDao
{
    Task<Announcement> CreateAsync(Announcement announcement);
}
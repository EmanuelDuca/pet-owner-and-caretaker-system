using Domain.Models;

namespace Application.DaoInterface;

public interface IPetOwnerDao
{
    Task<Announcement> CreateAnnouncementAsync(Announcement announcement);
}
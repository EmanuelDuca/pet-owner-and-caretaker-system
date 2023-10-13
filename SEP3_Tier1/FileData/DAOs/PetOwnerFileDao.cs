using System.Linq;
using System.Threading.Tasks;
using Application.DaoInterface;
using Domain.Models;

namespace FileData.DAOs;

public class PetOwnerFileDao : IPetOwnerDao
{
    private readonly FileContext context;

    public Task<Announcement> CreateAnnouncementAsync(Announcement announcement)
    {
        int id = 1;
        if (context.Announcements.Any())
        {
            id = context.Announcements.Max(a => a.Id);
            id++;
        }

        announcement.Id = id;
        
        context.Announcements.Add(announcement);
        context.SaveChanges();

        return Task.FromResult(announcement);
    }
}
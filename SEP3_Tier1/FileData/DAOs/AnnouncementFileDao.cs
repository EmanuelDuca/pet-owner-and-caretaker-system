using Application.DaoInterface;
using Domain.Models;

namespace FileData.DAOs;

public class AnnouncementFileDao : IAnnouncementDao
{
    private readonly FileContext context;

    public AnnouncementFileDao(FileContext context)
    {
        this.context = context;
    }

    public Task<Announcement> CreateAsync(Announcement announcement)
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
using Application.DaoInterface;
using Domain.DTOs;
using Domain.Models;

namespace obsolete_FileData.DAOs;

public class AnnouncementFileDao : IAnnouncementDao
{
    private readonly FileContext context;

    public AnnouncementFileDao(FileContext context)
    {
        this.context = context;
    }

    public Task<Announcement> CreateAsync(AnnouncementCreationDto announcement)
    {
        throw new NotImplementedException();
    }

    public Task<IEnumerable<Announcement>> GetAsync(SearchAnnouncementDto searchParameters)
    {
        IEnumerable<Announcement> announcements = context.Announcements.AsEnumerable();
        if (!string.IsNullOrEmpty(searchParameters.StartTime))
        {
            announcements = announcements.Where(t => t.StartDate.Equals(DateTime.Parse(searchParameters.StartTime)));
        }
        
        if (!string.IsNullOrEmpty(searchParameters.StartTime))
        {
            announcements = announcements.Where(t => t.StartDate.Equals(DateTime.Parse(searchParameters.StartTime)));
        }

        return Task.FromResult(announcements);
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
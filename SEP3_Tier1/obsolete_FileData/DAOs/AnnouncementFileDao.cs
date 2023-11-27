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

    public Task<IEnumerable<Announcement>> GetAsync(SearchAnnouncementDto searchParameters)
    {
        IEnumerable<Announcement> announcements = context.Announcements.AsEnumerable();
        if (searchParameters.StartTime == null)
        {
            announcements = announcements.Where(t => t.StartDate.Equals(searchParameters.StartTime));
        }

        if (searchParameters.StartTime == null)
        {
            announcements = announcements.Where(t => t.StartDate.Equals(searchParameters.StartTime));
        }

        if (!string.IsNullOrEmpty(searchParameters.DescriptionContains))
        {
            announcements = announcements.Where(t => t.ServiceDescription.Contains(searchParameters.DescriptionContains, StringComparison.OrdinalIgnoreCase));
        }

        if (!string.IsNullOrEmpty(searchParameters.PostalCode))
        {
            announcements = announcements.Where(t => t.PostalCode.Equals(searchParameters.PostalCode));
        }

        if (searchParameters.PetTypes != null && searchParameters.PetTypes.Any())
        {
            announcements = announcements.Where(t => searchParameters.PetTypes.Contains(t.Pet.PetType));
        }

        return Task.FromResult(announcements);
    }

    public Task<Announcement> CreateAsync(Announcement ann)
    {
        int id = 1;
        if (context.Announcements.Any())
        {
            id = context.Announcements.Max(a => a.Id);
            id++;
        }

        ann.Id = id;
        
        context.Announcements.Add(ann);
        context.SaveChanges();

        return Task.FromResult(ann);
    }

    public Task UpdateAsync(UpdateAnnouncementDto updateAnnouncement)
    {
        Announcement? existing = context.Announcements.FirstOrDefault(a => a.Id == updateAnnouncement.Id);
        if (existing == null)
        {
            throw new Exception($"Announcement with id {updateAnnouncement.Id} does not exist!");
        }

        Announcement createdAnnouncement = new Announcement
        {
            Id = updateAnnouncement.Id,
            PetOwner = existing.PetOwner,
            CreationDateTime = existing.CreationDateTime,
            EndDate = updateAnnouncement.EndDate ?? existing.EndDate,
            StartDate = updateAnnouncement.StartDate ?? existing.EndDate,
            Pet = updateAnnouncement.Pet ?? existing.Pet,
            PostalCode = updateAnnouncement.PostalCode ?? existing.PostalCode,
            ServiceDescription = updateAnnouncement.ServiceDescription ?? existing.PostalCode
        };
        context.Announcements.Remove(existing);
        context.Announcements.Add(createdAnnouncement);
        
        context.SaveChanges();

        return Task.CompletedTask;
    }

    public Task DeleteAsync(int id)
    {
        Announcement? existing = context.Announcements.FirstOrDefault(announcement =>
            announcement.Id == id);
        if (existing == null)
        {
            throw new Exception($"Announcement with id {id} does not exist!");
        }

        context.Announcements.Remove(existing);
        context.SaveChanges();
        
        return Task.CompletedTask;
    }
}
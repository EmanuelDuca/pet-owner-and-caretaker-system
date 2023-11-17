using Application.DaoInterface;
using Domain.Models;

namespace GrpcClient.Mappers;

public class AnnouncementMapper
{
    private readonly IUserDao userService;
    public PetMapper PetMapper { get; private set; }

    public AnnouncementMapper(IUserDao userService)
    {
        this.userService = userService;
        PetMapper = new PetMapper(this.userService);
    }

    
    
    public async Task<Announcement> MapToEntity(AnnouncementProto proto)
    {
        var announcement = new Announcement
        {
            Id = proto.Id,
            CreationDateTime = DateTime.Parse(proto.DateOfCreation),
            StartDate = DateTime.Parse(proto.TimeStart),
            EndDate = DateTime.Parse(proto.TimeFinish),
            PetOwner = (PetOwner) (await userService.GetByEmailAsync(proto.PetOwnerEmail))!,
            PostalCode = proto.PostalCode,
            ServiceDescription = proto.Description,
            Pet = await PetMapper.MapToEntity(proto.Pet)
        };
        return announcement;
    }
    
    public void PrintAnnouncement(AnnouncementProto dto)
    {
        Console.WriteLine($"Email: {dto.PetOwnerEmail} \ndateOfCreation: {dto.DateOfCreation}\nPostalCode: {dto.PostalCode}");
    }

    public async Task<IEnumerable<Announcement>> MapToEntityList(AnnouncementsProto announcements)
    {
        return await Task.WhenAll(announcements.Announcements
            .Select(async announcement => await MapToEntity(announcement)));
    }
}
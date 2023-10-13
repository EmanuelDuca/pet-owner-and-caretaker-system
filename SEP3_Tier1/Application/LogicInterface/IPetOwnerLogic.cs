using Domain.DTOs;
using Domain.Models;

namespace Application.LogicInterface;

public interface IPetOwnerLogic
{
    Task<Announcement> CreateAnnouncementAsync(AnnouncementCreationDto announcementCreationDto);
}
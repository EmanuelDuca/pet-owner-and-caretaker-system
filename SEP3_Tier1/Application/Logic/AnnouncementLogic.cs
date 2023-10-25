using Application.DaoInterface;
using Application.LogicInterface;
using Domain.DTOs;
using Domain.Models;

namespace Application.Logic;

public class AnnouncementLogic : IAnnouncementLogic
{
    private readonly IAnnouncementDao announcementDao;
    private readonly IUserDao userDao;

    public AnnouncementLogic(IAnnouncementDao announcementDao, IUserDao userDao)
    {
        this.announcementDao = announcementDao;
        this.userDao = userDao;
    }
    public async Task<Announcement> CreateAsync(AnnouncementCreationDto creationDto)
    {
        //todo validate
        Announcement announcement = new Announcement()
        {
            EndDate = creationDto.EndDate,
            StartDate = creationDto.StartDate,
            petOwner = await userDao.GetByEmail(creationDto.OwnerEmail),
            ServiceDescription = creationDto.ServiceDescription,
            PostalCode = creationDto.PostalCode
        };
        return await announcementDao.CreateAsync(announcement);
    }
}
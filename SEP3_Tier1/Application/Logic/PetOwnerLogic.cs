using Application.DaoInterface;
using Application.LogicInterface;
using Domain.DTOs;
using Domain.Models;

namespace Application.Logic;

public class PetOwnerLogic : IPetOwnerLogic
{
    private readonly IPetOwnerDao petOwnerDao;
    private readonly IUserDao userDao;

    public PetOwnerLogic(IPetOwnerDao petOwnerDao, IUserDao userDao)
    {
        this.petOwnerDao = petOwnerDao;
        this.userDao = userDao;
    }
    
    public async Task<Announcement> CreateAnnouncementAsync(AnnouncementCreationDto dto)
    {
        User? user = await userDao.GetByEmail(dto.petOwner.Email);
        if (user == null)
        {
            throw new Exception($"User with email {dto.petOwner.Email} was not found.");
        }
        
        Announcement announcement = new Announcement
        {
            petOwner = dto.petOwner,
            StartDate = dto.StartDate,
            EndDate = dto.EndDate,
            PostalCode = dto.PostalCode,
            ServiceDescription = dto.ServiceDescription
        };
        Announcement created = await petOwnerDao.CreateAnnouncementAsync(announcement);
        return created;

    }
}
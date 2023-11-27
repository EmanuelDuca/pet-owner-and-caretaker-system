using System.Runtime.CompilerServices;
using System.Text.Json;
using Application.DaoInterface;
using Application.LogicInterface;
using Domain.DTOs;
using Domain.Exceptions;
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
    public async Task<Announcement> CreateAsync(CreateAnnouncementDto dto)
    {
        User? existing = await userDao.GetByEmailAsync(dto.OwnerEmail);
        if (existing == null || existing.Type != "PetOwner")
        {
            throw new UserNotFoundException(dto.OwnerEmail);
        }
    
        
        ValidateData(dto.StartDate, dto.EndDate, dto.PostalCode);
        Announcement toCreate = new Announcement
        {
            EndDate = dto.EndDate,
            StartDate = dto.StartDate,
            PostalCode = dto.PostalCode,
            ServiceDescription = dto.ServiceDescription,
            CreationDateTime = DateTime.Now,
            PetOwner = new PetOwner(existing),
            Pet = new Pet
            {
                Id = dto.PetDto.Id,
                PetOwner = new PetOwner(existing),
                Description = dto.PetDto.Description,
                Weight = dto.PetDto.Weight,
                PetType = dto.PetDto.PetType,
                PetName = dto.PetDto.PetName
            }
        };
        toCreate.Pet.PetOwner = toCreate.PetOwner;
        Announcement announcement = await announcementDao.CreateAsync(toCreate);
        
        return announcement;
    }

    public async Task<IEnumerable<Announcement>> GetAsync(SearchAnnouncementDto searchAnnouncementDto)
    {
        return (await announcementDao.GetAsync(searchAnnouncementDto)).OrderByDescending(a => a.CreationDateTime);
    }

    private void ValidateData(DateTime? startDate, DateTime? endDate, string? postalCode)
    {
        if (startDate < DateTime.Today || startDate > endDate || endDate > startDate + TimeSpan.FromDays(30)) 
            throw new InvalidDataException("Chosen date is invalid, check that end date is after start date.");

        if (postalCode != null && (postalCode?.Length != 4 || !postalCode.All(char.IsDigit)))
        {
            throw new InvalidDataException("Postal code should be 4 characters long and consist from digits.");
        }
    }
    
    public async Task UpdateAsync(UpdateAnnouncementDto dto)
    {
        ValidateData(dto.StartDate,dto.EndDate,dto.PostalCode);
        await announcementDao.UpdateAsync(dto);
    }

    public async Task DeleteAsync(int id)
    {
        await announcementDao.DeleteAsync(id);
    }
}
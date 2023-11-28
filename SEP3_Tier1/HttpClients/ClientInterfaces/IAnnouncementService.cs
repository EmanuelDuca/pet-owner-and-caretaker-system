using Domain.DTOs;
using Domain.Models;

namespace HttpClients.ClientInterfaces;

public interface IAnnouncementService
{
    Task<Announcement> CreateAsync(CreateAnnouncementDto dto);
    Task<IEnumerable<Announcement>> GetAsync(SearchAnnouncementDto? dto);
    Task UpdateAsync(UpdateAnnouncementDto dto);
    Task DeleteAsync(int id);
}
using System.Collections.Generic;
using Domain.Models;

namespace FileData;

public class DataContainer
{
    public ICollection<User> Users { get; set; }
    public ICollection<Announcement> Announcements { get; set; }
}
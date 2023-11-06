using System.Collections.Generic;
using Domain.Models;
using Newtonsoft.Json;

namespace obsolete_FileData;

public class DataContainer
{
    public ICollection<User> Users { get; set; }
    public ICollection<Announcement> Announcements { get; set; }
}
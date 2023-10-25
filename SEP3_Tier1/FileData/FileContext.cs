using System.Collections.Generic;
using System.IO;
using System.Text.Json;
using Domain.Models;
using Newtonsoft.Json;
using JsonSerializer = System.Text.Json.JsonSerializer;

namespace FileData;

public class FileContext
{
    private const string filePath = "data.json";
    private DataContainer? dataContainer;

    public ICollection<Announcement> Announcements
    {
        get
        {
            LoadData();
            return dataContainer.Announcements;
        }
    }

    public ICollection<User> Users
    {
        get
        {
            LoadData();
            return dataContainer.Users;
        }
    }
    
    
    
    
    private void LoadData()
    {
        if(dataContainer != null) return;
        
        if (!File.Exists(filePath))
        {
            dataContainer = new ()
            {
                Announcements = new List<Announcement>(),
                Users = new List<User>()
            };
            return;
        }
        string content = File.ReadAllText(filePath);
        dataContainer = JsonSerializer.Deserialize<DataContainer>(content);
    }
    
    public void SaveChanges()
    {
        string serialized = JsonSerializer.Serialize(dataContainer, new JsonSerializerOptions
        {
            WriteIndented = true
        });
        File.WriteAllText(filePath,serialized);
        dataContainer = null;
    }
}
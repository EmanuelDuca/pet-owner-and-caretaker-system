﻿using Domain.Models;

namespace Domain.DTOs;

public class AnnouncementCreationDto
{
    public string OwnerEmail { get; set; }
    public DateTime StartDate { get; set; }
    public DateTime EndDate { get; set; }
    public string PostalCode { get; set; }
    public string ServiceDescription { get; set; }
    public DateTime CreationDateTime { get; set; }

    
    public AnnouncementCreationDto(string ownerEmail, DateTime startDate,
        DateTime endDate, string serviceDescription, string postalCode)
    {
        OwnerEmail = ownerEmail;
        StartDate = startDate;
        EndDate = endDate;
        ServiceDescription = serviceDescription;
        PostalCode = postalCode;
        CreationDateTime = DateTime.Now;
    }
}
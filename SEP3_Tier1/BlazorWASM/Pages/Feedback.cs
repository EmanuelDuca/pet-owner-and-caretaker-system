using Domain.Models;
using Microsoft.AspNetCore.Components;

namespace BlazorWASM.Pages;

public class Feedback
{
    private Service? service;
    [Parameter] public int serviceId { get; init; }
    private string message = "Loading...";
    private string feedbackGood = "";
    private string feedbackBad = "";
    private double myRating = 0;
    
    protected override async Task OnInitializedAsync()
    {
        Console.WriteLine("we are new new");
    }
    
    private async Task SubmitFeedback()
    {
        
    }

    private void OnChange(double rating)
    {
        myRating = rating;
    }

}
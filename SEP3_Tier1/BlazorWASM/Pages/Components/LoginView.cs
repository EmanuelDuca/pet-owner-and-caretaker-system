using HttpClients.ClientInterfaces;

namespace BlazorWASM.Pages.Components;

public class LoginView
{
    private string? username;
    private string? email;
    private string? password;
    private int userType = 1;
    private bool isLoginView = true;
    
    private bool backgroundIsLoaded;
    private string backgroundImageUrl;
    
    public IPexelsService ImageService { get; set; }

    

    protected override async Task OnInitializedAsync()
    {
        backgroundImageUrl = await ImageService.SearchPetImage();
        await LocalStorageService.SetItemAsStringAsync("backgroundImage", backgroundImageUrl);
        Console.WriteLine(backgroundImageUrl);
    }


    private async Task LoginAsync()
    {
        try
        {
            HandleEmptyFields();
            if (isLoginView)
                await AuthService.LoginAsync(new UserLoginDto(email!, password!));
                
            else
            {
                string type = userType == 1 ? "PetOwner" : "CareTaker";
                await AuthService.RegisterAsync(new UserCreationDto(email!, username!, password!, type));
            }
        }
        catch (Exception e)
        {
            Console.WriteLine(e);
            NotificationService.Notify(new NotificationMessage()
            {
                Severity = NotificationSeverity.Error,
                Duration = 6000,
                Detail = e.Message
            });
        }
    }

    private void HandleEmptyFields()
    {
        string msg = "";
        int emptyFieldsCounter = 0;
        if (string.IsNullOrEmpty(email))
        {
            msg += string.IsNullOrEmpty(msg) ? "Email" : ", email";
            emptyFieldsCounter++;
        }

        if (string.IsNullOrEmpty(password))
        {
            msg += string.IsNullOrEmpty(msg) ? "Password" : ", password";
            emptyFieldsCounter++;
        }

        if (string.IsNullOrEmpty(username) && !isLoginView)
        {
            msg += string.IsNullOrEmpty(msg) ? "Username" : ", username";
            emptyFieldsCounter++;
        }
        

        if (!string.IsNullOrEmpty(msg))
            throw new Exception(emptyFieldsCounter > 1 ? $"{msg} fields are empty." : $"{msg} field is empty.");
    }
}
using Microsoft.Extensions.DependencyInjection;

namespace Domain.Auth;

public class AuthorizationPolicies
{
    public static void AddPolicies(IServiceCollection services)
    {
        services.AddAuthorizationCore(options =>
        {
            options.AddPolicy("MustBePetOwner", a =>
                a.RequireAuthenticatedUser().RequireClaim("Type", "PetOwner"));
            
            options.AddPolicy("MustBeCareTaker", a =>
                a.RequireAuthenticatedUser().RequireClaim("Type", "CareTaker"));
        });
    }
}
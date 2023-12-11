using Microsoft.AspNetCore.Components;

namespace BlazorWASM.Shared;

public class NavMenu
{
    [Parameter] 
    public string Actor { get; set; }
    
    private bool collapseNavMenu = true;

    private string? NavMenuCssClass => collapseNavMenu ? "collapse" : null;

    private void ToggleNavMenu()
    {
        collapseNavMenu = !collapseNavMenu;
    }

}
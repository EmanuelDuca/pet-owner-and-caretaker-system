using BlazorWASM.Pages;
using Microsoft.AspNetCore.Components;
using Microsoft.AspNetCore.Components.Rendering;

namespace BlazorWASM.Shared;

public class TestComponent : ComponentBase
{
    protected override void BuildRenderTree(RenderTreeBuilder builder)
    {
        // base.BuildRenderTree(builder);
        builder.OpenComponent<Notification>(2);
        builder.CloseComponent();
    }
}
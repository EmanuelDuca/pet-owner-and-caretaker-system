namespace Domain.Models;


public class PetType
{
    public Type Value { get; set; }
    public string Name => NameFromPetType(Value);

    public static string NameFromPetType(Type type)
    {
        string name = type.ToString();
        if (name.Count(char.IsUpper) > 1)
        {
            name = string.Join("",
                name.Select((c, i) => i > 0 && char.IsUpper(c)
                    ? $" {c.ToString().ToLower()}"
                    : c.ToString()));
        }

        return name;
    }

    public static List<PetType> PetTypesWithNames
    {
        get
        {
            return Enum.GetValues<Type>().Select(t => new PetType { Value = t }).ToList();
        }
    }

    public enum Type
    {
        Dog,
        Cat,
        Parrot,
        Hamster,
        Rabbit,
        GuineaPig,
        Fish,
        Turtle,
        Ferret,
        Iguana,
        Snake,
        Lizard,
        Finch,
        Canary,
        Budgerigar,
        Cockatoo,
        Horse,
        Gerbil,
        Chinchilla,
        HermitCrab,
        Tarantula,
        Frog,
        Gecko,
        Hedgehog,
        Axolotl,
        SugarGlider,
        BettaFish,
        Mouse,
        Rat
    }
}




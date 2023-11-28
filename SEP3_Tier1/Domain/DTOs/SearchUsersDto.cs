namespace Domain.DTOs;

public class SearchUsersDto : SearchDto
{
   //We inherit SearchDto to be able to use automatic query constructor
   //(in case we would like to use it, cause currently we don't)
   public string? Type { get; init; }
   public string? Name { get; init; }
   public int? Age { get; init; }

}
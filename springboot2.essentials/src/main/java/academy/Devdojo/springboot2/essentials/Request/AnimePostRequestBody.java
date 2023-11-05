package academy.Devdojo.springboot2.essentials.Request;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnimePostRequestBody {
    @NotEmpty(message = "the anime name cannot be empty")
    @NotNull(message = "the anime name cannot be null")
    private String name;
}

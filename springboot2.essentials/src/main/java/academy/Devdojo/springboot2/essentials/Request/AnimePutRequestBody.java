package academy.Devdojo.springboot2.essentials.Request;


import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class AnimePutRequestBody {
    private long id;

    private String nome;

}

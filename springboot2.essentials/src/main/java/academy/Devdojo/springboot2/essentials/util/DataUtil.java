package academy.Devdojo.springboot2.essentials.util;



import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Data
@Component
public class DataUtil {
    public String formaterLocalDataTimetoDataBaseStyle(LocalDateTime localDateTime){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);

    }

    public DataUtil() {
    }
}

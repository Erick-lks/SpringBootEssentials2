package academy.Devdojo.springboot2.essentials.Mapper;


import academy.Devdojo.springboot2.essentials.Request.AnimePostRequestBody;
import academy.Devdojo.springboot2.essentials.Request.AnimePutRequestBody;
import academy.Devdojo.springboot2.essentials.domain.Anime;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class  AnimeMapper {

    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);
    public abstract Anime toanime (AnimePostRequestBody animePostRequestBody);
    public abstract Anime toanime (AnimePutRequestBody animePutRequestBody);
}

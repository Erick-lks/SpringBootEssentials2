package academy.Devdojo.springboot2.essentials.service;

import academy.Devdojo.springboot2.essentials.Request.AnimePostRequestBody;
import academy.Devdojo.springboot2.essentials.Request.AnimePutRequestBody;
import academy.Devdojo.springboot2.essentials.domain.Anime;
import academy.Devdojo.springboot2.essentials.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AnimeService {
    private final AnimeRepository animerepository;
    public List<Anime> listAll(){
        return animerepository.findAll();

    }
    public Anime findByIdOrThowBadRequestException(long id){
        return animerepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found "));


    }

    public Anime save(AnimePostRequestBody animePostRequestBody) {
      return animerepository.save(Anime.builder().nome(animePostRequestBody.getNome()).build());


    }

    public void delete(long id) {
    animerepository.delete(findByIdOrThowBadRequestException(id));

    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
     Anime savedAnime = findByIdOrThowBadRequestException(animePutRequestBody.getId());

       Anime anime= animerepository.save(Anime.builder()
                        .id(savedAnime.getId())
                        .nome(animePutRequestBody.getNome()).build());

        animerepository.save(anime);

    }
}

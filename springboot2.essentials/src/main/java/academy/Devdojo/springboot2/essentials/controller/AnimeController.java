package academy.Devdojo.springboot2.essentials.controller;

import academy.Devdojo.springboot2.essentials.domain.Anime;
import academy.Devdojo.springboot2.essentials.service.AnimeService;
import academy.Devdojo.springboot2.essentials.util.DataUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {


    private final DataUtil dateutil;
    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity <List <Anime>>  list(){
        log.info(dateutil.formaterLocalDataTimetoDataBaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(animeService.listAll());

    }
    @GetMapping(path = "/{id}")
    public ResponseEntity <Anime>  findById(@PathVariable long id ){
        return ResponseEntity.ok(animeService.findById(id));
    }


    @PostMapping

    public ResponseEntity<Anime> save (@RequestBody Anime anime){
       return new ResponseEntity<>(animeService.save(anime), HttpStatus.CREATED);

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity <Void>  delete (@PathVariable long id ){
        animeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity <Void>  replace (@RequestBody Anime anime){
        animeService.replace(anime);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
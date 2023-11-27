package com.example.webclient;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class RickAndMortyController {

    @GetMapping("/characters")
    public List<RickAndMortyCharacter> getCharacters() {
       List<RickAndMortyCharacter> characterList = Objects.requireNonNull(
                WebClient.create()
                        .get()
                        .uri("https://rickandmortyapi.com/api/character")
                        .retrieve()
                        .toEntityList(RickAndMortyCharacter.class)
                        .block()
        ).getBody();

        return characterList;

    }




}

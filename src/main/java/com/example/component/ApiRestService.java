package com.example.component;

import com.example.Dto.MarvelCharacter;
import com.example.entities.LogApiRest;

import java.util.List;

public interface ApiRestService {

    List<MarvelCharacter> getCharacters();

    List<MarvelCharacter> getCharacterById(String Id);

    List<LogApiRest> getLogs();
}

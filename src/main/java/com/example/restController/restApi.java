package com.example.restController;

import com.example.Dto.MarvelCharacter;
import com.example.component.ApiRestService;
import com.example.entities.LogApiRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
public class restApi {

    @Autowired
    ApiRestService apiService;

    /** GET Method get all characters Own RestApi
     *  return List Dto Response
     * **/
    @GetMapping(value="/getCharacters")
    public ResponseEntity<List<MarvelCharacter>> getCharacters() {
        List<MarvelCharacter> response = new ArrayList<>();
        response = apiService.getCharacters();
        return new ResponseEntity<List<MarvelCharacter>>(response, HttpStatus.OK);
    }

    /** GET Method get  characterById Own RestApi
     *  return List Dto Response
     * **/
    @GetMapping(value="/getCharacterById/{Id}")
    public ResponseEntity<List<MarvelCharacter>> getCharacterById(@PathVariable("Id")String Id) {
        List<MarvelCharacter> response = new ArrayList<>();
        response = apiService.getCharacterById(Id);
        return new ResponseEntity<List<MarvelCharacter>>(response, HttpStatus.OK);
    }

    /** GET Method get all logs Own RestApi
     *  return List Dto Response
     * **/
    @GetMapping(value="/getLogs")
    public ResponseEntity<List<LogApiRest>> getLogs() {
        List<LogApiRest> responseLog = new ArrayList<>();
        responseLog = apiService.getLogs();
        return new ResponseEntity<List<LogApiRest>>(responseLog, HttpStatus.OK);
    }
}

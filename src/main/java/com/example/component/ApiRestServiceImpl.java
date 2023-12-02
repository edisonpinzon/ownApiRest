package com.example.component;

import com.example.Dto.MarvelCharacter;
import com.example.entities.LogApiRest;
import com.example.repository.LogApiRestRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.*;

@Service
public class ApiRestServiceImpl implements ApiRestService{

    @Autowired
    LogApiRestRepository logRepository;

    @Autowired
    RestTemplate restTemplate;
    List<MarvelCharacter> responseBody;

    final String URL_API = "http://localhost:8090/";

    public void createLog(String url) {

        LogApiRest log = new LogApiRest();

        try {
            log.setLog_url_api(url);
            log.setTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
            logRepository.save(log);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public List<LogApiRest>  getLogs(){
        List<LogApiRest> logs = new ArrayList<>();
        logs = logRepository.findAll();
        return  logs;
    }

    /** Call external .Jar ApiRest get all characters
     *  return List Dto Response
     * **/
    public List<MarvelCharacter> getCharacters(){

        responseBody = new ArrayList<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        //create audit log in H2 Database
        createLog("getCharacters");

        ResponseEntity<List<MarvelCharacter>> rateResponse =
                restTemplate.exchange(URL_API+"apiMarvel/getCharacters",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<MarvelCharacter>>() {
                        });
        responseBody = rateResponse.getBody();

        return   responseBody;
    }

    /** Call external .Jar ApiRest get  character
     *  return List Dto Response
     * **/
    public List<MarvelCharacter> getCharacterById(String Id){

        responseBody = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        //create audit log in H2 Database
        createLog("getCharacterById/"+Id);

        ResponseEntity<List<MarvelCharacter>> rateResponse =
                restTemplate.exchange(URL_API+"/apiMarvel/getCharacterById/"+Id,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<MarvelCharacter>>() {
                        });
        responseBody = rateResponse.getBody();
        return responseBody;
    }
}

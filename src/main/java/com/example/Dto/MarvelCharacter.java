package com.example.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarvelCharacter {
    @JsonProperty
    int id;
    @JsonProperty
    String name;
    @JsonProperty
    String description;
    @JsonProperty
    String modified;
    @JsonProperty
    String thumbnail;

    public MarvelCharacter(int id, String name, String description, String modified, String thumbnail) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.modified = modified;
        this.thumbnail = thumbnail;
    }
}

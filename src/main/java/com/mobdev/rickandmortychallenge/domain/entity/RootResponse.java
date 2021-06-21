package com.mobdev.rickandmortychallenge.domain.entity;

import com.mobdev.rickandmortychallenge.domain.dto.OriginDTO;

import java.io.Serializable;

public class RootResponse implements Serializable {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private int episode_count;
    private OriginDTO origin;

    public RootResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEpisode_count() {
        return episode_count;
    }

    public void setEpisode_count(int episode_count) {
        this.episode_count = episode_count;
    }

    public OriginDTO getOrigin() {
        return origin;
    }

    public void setOrigin(OriginDTO origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "RootResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", species='" + species + '\'' +
                ", type='" + type + '\'' +
                ", episode_count=" + episode_count +
                ", origin=" + origin +
                '}';
    }
}

package com.mobdev.rickandmortychallenge.domain.entity;

import java.io.Serializable;
import java.util.List;

public class LocationResponse implements Serializable {
    private long id;
    private String name;
    private String type;
    private String dimension;
    private List<String> residents;
    private String url;
    private String created;

    public LocationResponse() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public List<String> getResidents() {
        return residents;
    }

    public void setResidents(List<String> residents) {
        this.residents = residents;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "LocationResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", dimension='" + dimension + '\'' +
                ", residents=" + residents +
                ", url='" + url + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}

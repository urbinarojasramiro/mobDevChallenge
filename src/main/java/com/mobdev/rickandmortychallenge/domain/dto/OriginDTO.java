package com.mobdev.rickandmortychallenge.domain.dto;

import com.mobdev.rickandmortychallenge.domain.constants.Constants;
import com.mobdev.rickandmortychallenge.domain.entity.LocationResponse;

import java.io.Serializable;
import java.util.List;

public class OriginDTO implements Serializable {
    private String name;
    private String url;
    private String dimension;
    private List<String> residents;

    public OriginDTO() {
    }

    public OriginDTO getOrigin(LocationResponse locationResponse) {
        OriginDTO originDTO = new OriginDTO();
        if(locationResponse.getName().equals(Constants.UNKNOWN_LOCATION)){
            originDTO.setName(Constants.UNKNOWN_LOCATION);
            originDTO.setUrl("");
            originDTO.setDimension(Constants.UNKNOWN_LOCATION);
            return originDTO;
        }

        originDTO.setName(locationResponse.getName());
        originDTO.setUrl(locationResponse.getUrl());
        originDTO.setDimension(locationResponse.getDimension());
        originDTO.setResidents(locationResponse.getResidents());

        return originDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    @Override
    public String toString() {
        return "OriginDTO{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", dimension='" + dimension + '\'' +
                ", residents=" + residents +
                '}';
    }
}

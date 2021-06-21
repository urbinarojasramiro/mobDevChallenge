package com.mobdev.rickandmortychallenge.use_cases.service.impl;

import com.mobdev.rickandmortychallenge.domain.constants.Constants;
import com.mobdev.rickandmortychallenge.domain.dto.OriginDTO;
import com.mobdev.rickandmortychallenge.domain.entity.CharacterResponse;
import com.mobdev.rickandmortychallenge.domain.entity.LocationResponse;
import com.mobdev.rickandmortychallenge.domain.entity.RootResponse;
import com.mobdev.rickandmortychallenge.infrastructure.repositories.CharacterRepository;
import com.mobdev.rickandmortychallenge.infrastructure.repositories.LocationRepository;
import com.mobdev.rickandmortychallenge.use_cases.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("rickAndMortyService")
public class RickAndMortyServiceImpl implements RickAndMortyService {

    @Autowired
    CharacterRepository characterRepository;

    @Autowired
    LocationRepository locationRepository;

    @Override
    public RootResponse getCharacter(int id) {
        CharacterResponse characterResponse = characterRepository.getCharacter(id);

        LocationResponse locationResponse = new LocationResponse();
        locationResponse.setName(Constants.UNKNOWN_LOCATION);

        if(!characterResponse.getOrigin().getName().equals(Constants.UNKNOWN_LOCATION)){
            locationResponse = locationRepository.getLocation(characterResponse.getOrigin().getUrl());
        }

        OriginDTO originDTO = new OriginDTO().getOrigin(locationResponse);

        return getRootResponse(characterResponse, originDTO);
    }

    private RootResponse getRootResponse(CharacterResponse characterResponse, OriginDTO originDTO) {
        RootResponse rootResponse = new RootResponse();
        rootResponse.setId(characterResponse.getId());
        rootResponse.setName(characterResponse.getName());
        rootResponse.setStatus(characterResponse.getStatus());
        rootResponse.setSpecies(characterResponse.getSpecies());
        rootResponse.setType(characterResponse.getType());
        rootResponse.setEpisode_count(characterResponse.getEpisode().size());
        rootResponse.setOrigin(originDTO);
        return rootResponse;
    }
}

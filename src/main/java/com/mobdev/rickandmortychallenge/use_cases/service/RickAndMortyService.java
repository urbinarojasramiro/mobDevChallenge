package com.mobdev.rickandmortychallenge.use_cases.service;

import com.mobdev.rickandmortychallenge.domain.entity.RootResponse;

public interface RickAndMortyService {
    RootResponse getCharacter(int id);
}

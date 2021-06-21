package com.mobdev.rickandmortychallenge.infrastructure.repositories;

import com.mobdev.rickandmortychallenge.domain.entity.CharacterResponse;

public interface CharacterRepository {
    CharacterResponse getCharacter(int id);
}

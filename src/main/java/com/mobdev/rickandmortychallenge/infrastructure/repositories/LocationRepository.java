package com.mobdev.rickandmortychallenge.infrastructure.repositories;

import com.mobdev.rickandmortychallenge.domain.entity.LocationResponse;

public interface LocationRepository {
    LocationResponse getLocation(String url);
}

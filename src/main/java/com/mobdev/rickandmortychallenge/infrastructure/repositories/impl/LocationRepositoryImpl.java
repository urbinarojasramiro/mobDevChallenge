package com.mobdev.rickandmortychallenge.infrastructure.repositories.impl;

import com.mobdev.rickandmortychallenge.domain.constants.Constants;
import com.mobdev.rickandmortychallenge.domain.entity.LocationResponse;
import com.mobdev.rickandmortychallenge.domain.exception.LocationNotFoundException;
import com.mobdev.rickandmortychallenge.infrastructure.repositories.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class LocationRepositoryImpl implements LocationRepository {

    private static Logger LOG = LoggerFactory.getLogger(LocationRepositoryImpl.class);

    @Override
    public LocationResponse getLocation(String url) {
        LOG.info("Repository getLocation");

        HttpHeaders httpHeaders = getHeaders();
        HttpEntity<LocationResponse> httpEntity = new HttpEntity<>(httpHeaders);

        RestTemplate restTemplate = new RestTemplate();

        LocationResponse locationResponse = new LocationResponse();
        try {

            ResponseEntity<LocationResponse> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, LocationResponse.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                locationResponse = responseEntity.getBody();
                LOG.info("get location Success: " + locationResponse.toString());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (e.getMessage().contains(Constants.LOCATION_NOT_FOUND)) {
                throw new LocationNotFoundException(Constants.LOCATION_NOT_FOUND);
            }
        }

        return locationResponse;
    }

    private static HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", "application/json");
        httpHeaders.set("Content-Type", "application/json");

        return httpHeaders;
    }
}

package com.mobdev.rickandmortychallenge.infrastructure.repositories.impl;

import com.mobdev.rickandmortychallenge.domain.constants.Constants;
import com.mobdev.rickandmortychallenge.domain.entity.CharacterResponse;
import com.mobdev.rickandmortychallenge.domain.exception.CharacterNotFoundException;
import com.mobdev.rickandmortychallenge.infrastructure.repositories.CharacterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {

    private static Logger LOG = LoggerFactory.getLogger(CharacterRepositoryImpl.class);

    @Value("${url.getCharacter}")
    private String urlCharacter;

    @Override
    public CharacterResponse getCharacter(int id) {
        LOG.info("Repository getCharacter");

        final String url = urlCharacter + id;


        HttpHeaders httpHeaders = getHeaders();
        HttpEntity<CharacterResponse> httpEntity = new HttpEntity<>(httpHeaders);

        RestTemplate restTemplate = new RestTemplate();

        CharacterResponse characterResponse = new CharacterResponse();
        try {

            ResponseEntity<CharacterResponse> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, CharacterResponse.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                characterResponse = responseEntity.getBody();
                LOG.info("get Character Success: " + characterResponse.toString());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (e.getMessage().contains(Constants.CHARACTER_NOT_FOUND)) {
                throw new CharacterNotFoundException(Constants.CHARACTER_NOT_FOUND);
            }
        }

        return characterResponse;
    }

    private static HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", "application/json");
        httpHeaders.set("Content-Type", "application/json");

        return httpHeaders;
    }

}

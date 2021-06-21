package com.mobdev.rickandmortychallenge.infrastructure.controllers;

import com.mobdev.rickandmortychallenge.domain.entity.RootResponse;
import com.mobdev.rickandmortychallenge.use_cases.service.RickAndMortyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="rickandmorty/api")
public class RickAndMortyController {

    @Autowired
    RickAndMortyService rickAndMortyService;

    @GetMapping(value = "getCharacter/{id}")
    public ResponseEntity<RootResponse> getCharacter(@PathVariable(value = "id") int id) {

        RootResponse response = rickAndMortyService.getCharacter(id);
        return ResponseEntity.ok(response);
    }

}

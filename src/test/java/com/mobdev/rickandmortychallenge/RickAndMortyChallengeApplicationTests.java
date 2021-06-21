package com.mobdev.rickandmortychallenge;

import com.mobdev.rickandmortychallenge.domain.entity.CharacterResponse;
import com.mobdev.rickandmortychallenge.domain.entity.LocationResponse;
import com.mobdev.rickandmortychallenge.domain.exception.CharacterNotFoundException;
import com.mobdev.rickandmortychallenge.domain.exception.LocationNotFoundException;
import com.mobdev.rickandmortychallenge.infrastructure.repositories.CharacterRepository;
import com.mobdev.rickandmortychallenge.infrastructure.repositories.LocationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RickAndMortyChallengeApplicationTests {

	@Autowired
	CharacterRepository characterRepository;

	@Autowired
	LocationRepository locationRepository;



	@Test
	void getCharacter() {
		CharacterResponse characterResponse = characterRepository.getCharacter(1);

		assertEquals("Rick Sanchez", characterResponse.getName());

	}

	@Test
	void getUnknownOrigin() {
		CharacterResponse characterResponse = characterRepository.getCharacter(30);

		assertEquals("unknown", characterResponse.getOrigin().getName());
	}

	@Test
	void characterNotFound(){
		Exception exception = assertThrows(CharacterNotFoundException.class, () -> {
			CharacterResponse characterResponse = characterRepository.getCharacter(1000);
		});
		String expectedMessage = "Character not found";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void getLocation(){
		LocationResponse locationResponse = locationRepository.getLocation("https://rickandmortyapi.com/api/location/1");

		assertEquals("Earth (C-137)", locationResponse.getName());
	}

	@Test
	void locationNotFound(){
		Exception exception = assertThrows(LocationNotFoundException.class, () -> {
			LocationResponse locationResponse = locationRepository.getLocation("https://rickandmortyapi.com/api/location/1000");
		});
		String expectedMessage = "Location not found";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

}

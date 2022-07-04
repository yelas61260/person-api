package com.pragma.route.backend.person.infrastructure.db.repository.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.PersonDataTests;
import com.pragma.route.backend.person.infrastructure.db.dao.CityDao;
import com.pragma.route.backend.person.infrastructure.db.repository.CityRepository;

@SpringBootTest
public class CityRepositoryImplTests {
	
	private CityRepository cityRepository;
	
	@Mock
	private CityDao cityDao;
	
	@BeforeEach
	public void setup() {
		cityRepository = new CityRepositoryImpl(cityDao);
		
		Mockito.when(cityDao.findById(0)).thenReturn(Optional.empty());
 		Mockito.when(cityDao.findById(1)).thenReturn(Optional.of(PersonDataTests.cityEntityOk));
	}
	
	@Test
	public void exist() {
		assertThat(cityRepository.exist(0)).isEqualTo(false);
		assertThat(cityRepository.exist(1)).isEqualTo(true);
	}

}

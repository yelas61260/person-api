package com.pragma.route.backend.person.infrastructure.db.repository.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.PersonDataTests;
import com.pragma.route.backend.person.infrastructure.db.dao.ProfileDao;
import com.pragma.route.backend.person.infrastructure.db.repository.ProfileRepository;

@SpringBootTest
public class ProfileRepositoryImplTests {
	
	private ProfileRepository profileRepository;
	
	@Mock
	private ProfileDao profileDao;
	
	@BeforeEach
	public void setup() {
		profileRepository = new ProfileRepositoryImpl(profileDao);

		Mockito.when(profileDao.findById(0)).thenReturn(Optional.empty());
 		Mockito.when(profileDao.findById(1)).thenReturn(Optional.of(PersonDataTests.profileEntityOk));
	}
	
	@Test
	public void exist() {
		assertThat(profileRepository.exist(0)).isEqualTo(false);
		assertThat(profileRepository.exist(1)).isEqualTo(true);
	}

}

package com.pragma.route.backend.person;

import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.person.infrastructure.client.image.entity.ImageEntity;

@SpringBootTest
public class ImageDataTests {

	public static ImageEntity imageOKCreated = ImageEntity.builder()
			.imageId("PI-1")
			.imageName("mi imagen")
			.imageBase64(ImageFileDataTests.stringBaseOk)
			.build();
	
}

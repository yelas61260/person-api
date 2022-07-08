package com.pragma.route.backend.person.infrastructure.client.image.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String imageId;
	private String imageName;
	private String imageBase64;

}

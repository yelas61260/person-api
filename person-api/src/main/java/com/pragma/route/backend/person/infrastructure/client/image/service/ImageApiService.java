package com.pragma.route.backend.person.infrastructure.client.image.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pragma.route.backend.person.infrastructure.client.image.entity.ImageEntity;

@FeignClient(name = "image-service", url = "http://localhost:8082/image")
public interface ImageApiService {
	
	@PostMapping("/{associationType}/{resourceId}")
	public ImageEntity create(@RequestParam(value = "image", required = true) MultipartFile imageFile);
	
	@PutMapping("/{associationType}/{resourceId}")
	public ImageEntity update(@PathVariable("imageId") String imageId, @RequestParam(value = "image", required = true) MultipartFile imageFile);
	
	@GetMapping("/{associationType}/{resourceId}/base64")
	public @ResponseBody String getImageBase64(@PathVariable("imageId") String imageId);

}

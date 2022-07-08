package com.pragma.route.backend.person;

import java.util.Base64;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

@SpringBootTest
public class ImageFileDataTests {
	
	public static String stringBaseOk = Base64.getEncoder().encodeToString("Contenido".getBytes());
	public static byte[] stringByteOk = Base64.getDecoder().decode(stringBaseOk);
	public static MockMultipartFile multipartFileOk = new MockMultipartFile("mi imagen", stringByteOk);

}
package com.cis.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


public interface LawyerService {

	String uploadImageToFileSystem(MultipartFile file) throws IOException;

	byte[] downloadImageFromFileSystem(String fileName) throws IOException;

	List<String> getAllImageFilenames();

}

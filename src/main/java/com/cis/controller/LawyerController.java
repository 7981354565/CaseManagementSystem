package com.cis.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cis.service.LawyerService;


@RestController
@RequestMapping("/lawyer")
public class LawyerController {

	@Autowired
	private LawyerService lawyerService;

	@PostMapping("/fileUpload")
	public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image")MultipartFile file) throws IOException {
		String uploadImage = lawyerService.uploadImageToFileSystem(file);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}

	@GetMapping("/getFile/{fileName}")
	public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
		byte[] imageData=lawyerService.downloadImageFromFileSystem(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);

	}
	
	 @GetMapping("/getAllFiles")
	    public ResponseEntity<List<String>> getAllImageFilenames() {
	        List<String> filenames = lawyerService.getAllImageFilenames();
	        return ResponseEntity.ok(filenames);
	    }
	
}

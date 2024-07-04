package com.cis.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cis.entity.LawyerEntity;
import com.cis.repository.LawyerRepository;
import com.cis.service.LawyerService;

@Service
public class LawyerServiceImpl implements LawyerService {

	 @Autowired
	    private LawyerRepository lawyerRepository;

	    private final String FOLDER_PATH= "C:\\imageProject\\";

	 

	    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
	        String filePath=FOLDER_PATH+file.getOriginalFilename();

	        LawyerEntity lawyerData=lawyerRepository.save(LawyerEntity.builder()
	                .name(file.getOriginalFilename())
	                .type(file.getContentType())
	                .filePath(filePath).build());

	        file.transferTo(new File(filePath));

	        if (lawyerData != null) {
	            return "file uploaded successfully : " + filePath;
	        }
	        return null;
	    }

	    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
	        Optional<LawyerEntity> fileData = lawyerRepository.findByName(fileName);
	        String filePath=fileData.get().getFilePath();
	        byte[] images = Files.readAllBytes(new File(filePath).toPath());
	        return images;
	    }

	    public List<String> getAllImageFilenames() {
	        return lawyerRepository.getAllImageFilenames(); // Implement this method in your repository
	    }

}

package com.fisrt.test.helpers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public FileUploadHelper() throws Exception
	{}
	
	//for static path 
	//public final String  storagePath1 ="D:\\SpringJDBC\\RestAPIDemo\\src\\main\\resources\\static\\Image\\";
	//for dynamic path 
	public final String  storagePath  = new ClassPathResource("static/image").getFile().getAbsolutePath();
	
	
	public boolean uplodFile(MultipartFile file) {
		
		boolean fileuploded = false;
		try {
		InputStream inputStream =file.getInputStream();
		
		/*
		 * int i = inputStream.available();
		 * 
		 * byte [] filebyte =new byte[i];
		 * 
		 * int soOutputStream = inputStream.read(filebyte);
		 * 
		 * FileOutputStream outputStream = new FileOutputStream(storagePath+
		 * File.pathSeparator+ file.getOriginalFilename());
		 * outputStream.write(filebyte);
		 * 
		 * outputStream.flush(); outputStream.close();
		 */
		   
		  long b =  Files.copy(file.getInputStream(), Paths.get(storagePath + file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
		  return true;
		}
		catch (Exception e) {
		e.printStackTrace();
		return false;
		}
		
		
		
	}
}

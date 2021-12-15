package com.wndeld777.memo.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wndeld777.memo.service.FileService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("fileServiceV1")
public class FileServiceImplV1 implements FileService{

	private ResourceLoader resLoader;
	protected final String winPath;
	
	protected String fileUpPath;
	
	@Autowired
	public void getFilePath(String winPath) {
		this.fileUpPath = this.winPath;
	}
	@Override
	public String fileUp(MultipartFile file) throws Exception {
		String originalFileName = file.getOriginalFilename();
		if(originalFileName.isEmpty()) {
			return null;
		}
		
		Resource res = resLoader.getResource("/files");
		String filePath =res.getURI().getPath();
		String strUUID = UUID.randomUUID().toString();
		strUUID += originalFileName;	
		File uploadPathAndFile = new File(filePath,strUUID);
		file.transferTo(uploadPathAndFile);
		return strUUID;
	}

	@Override
	public List<String> filesUp(MultipartHttpServletRequest files) throws Exception {
		List<String> fileNames = new ArrayList<String>();
		String tagName = "m_image";
		
		List<MultipartFile> fileList = files.getFiles(tagName);
		for(MultipartFile file : fileList) {
			String fileName = this.fileUp(file);
			fileNames.add(fileName);
		}
		
		
		return fileNames;
	}

	

}

package com.wndeld777.memo.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public abstract class FileServiceABS {
	
	protected String fileUpPath;
	
	public void fileUpPath(String winPath) {
		this.fileUpPath = winPath;
	}

	public abstract Map<String,String> fileUp(MultipartFile file);
	public abstract List<Map<String,String>> filesUp(MultipartHttpServletRequest files);
}

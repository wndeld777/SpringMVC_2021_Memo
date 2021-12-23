package com.wndeld777.memo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wndeld777.memo.model.FileDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class FileService {
	
	// 업로드한 파일이 저장될 폴더
	protected String fileUpPath ;
	
	/**
	 * file-context.xml 에 설정된 
	 * winFilePath, macFilePath 값을 가져와서
	 * 변수에 세팅하는 코드
	 */
	@Autowired
	public void fileUpPath(String winPath, String macPath) {
		this.fileUpPath = macPath;
		
		// 시스템 변수에서 
		// 운영체제의 이름을 가져오는 코드
		// 운영체제 이름을 가져와서 대문자로 변환
		String osName = System
							.getProperty("os.name")
							.toUpperCase();
		
		log.debug("현재 운영체제 {}", osName);
		
		// 운영체제 이름에 WIN 단어가 포함되어 있으면
		if(osName.contains("WIN")) {
			this.fileUpPath = winPath;
		}
		log.debug("파일 저정폴더 {}", this.fileUpPath);
	
	}
	
	public abstract Map<String, String> fileUp(MultipartFile file) ;
	public abstract 
		List<Map<String,String>> filesUp(MultipartHttpServletRequest files);
	
	public abstract List<FileDTO> selectAll();
	public abstract int delete(Long f_seq);
	public abstract FileDTO findById(Long f_seq);

	
}
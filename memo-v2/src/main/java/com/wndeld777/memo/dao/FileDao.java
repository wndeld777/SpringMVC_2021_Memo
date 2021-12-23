package com.wndeld777.memo.dao;

import java.util.List;
import java.util.Map;

import com.wndeld777.memo.model.FileDTO;

public interface FileDao {
	
	public List<FileDTO> selectAll();
	public FileDTO findById(Long f_seq);
	public int delete(Long f_seq);

	public int create_table(Map<String, String> resultMaps);
}

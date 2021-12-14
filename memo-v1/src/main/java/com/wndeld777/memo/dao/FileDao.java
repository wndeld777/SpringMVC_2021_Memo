package com.wndeld777.memo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wndeld777.memo.model.FileDTO;

public interface FileDao {


	public List<FileDTO> selectAll();
	public FileDTO findById(Long f_seq);
	
	public int insert(FileDTO fileDTO);
	public int update(FileDTO fileDTO);
	public int delete(Long f_seq);
	
	public int create_table(Map<String,String> resultMaps);
	
	public int insertOrUpdate(FileDTO fileDTO);
	public int insertWithList(@Param("filesList") List<FileDTO> fileList);
	
	public int insertOrUpdateWithList(@Param("filesList") List<FileDTO> fileList);
}

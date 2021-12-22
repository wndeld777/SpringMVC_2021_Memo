package com.wndeld777.memo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.wndeld777.memo.model.MemoVO;

public interface MemoService {

	public List<MemoVO> selectAll();
	public int insert(MemoVO memoVO);
	

	public int delete(Long m_seq);
	
	public MemoVO detail(Long m_seq);
	
	public MemoVO findById(Long m_seq);
	
	public Long makeMseq();
	public int update(MemoVO memoVO, MultipartFile m_image);
}

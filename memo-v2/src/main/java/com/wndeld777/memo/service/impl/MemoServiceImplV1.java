package com.wndeld777.memo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wndeld777.memo.dao.MemoDao;
import com.wndeld777.memo.model.MemoVO;
import com.wndeld777.memo.service.FileService;
import com.wndeld777.memo.service.MemoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("memoServiceV1")
public class MemoServiceImplV1 implements MemoService{
	
	
	
	protected final MemoDao memoDao;
	
	protected final FileService fileService;
	
	@Override
	public List<MemoVO> selectAll() {
		List<MemoVO> memoList = memoDao.selectAll(); 
		return memoList;
	}
	@Override
	public Long makeMseq() {

		Long intMseq = 0L;
		if(memoDao.getMaxMseq() != null) {
			intMseq = memoDao.getMaxMseq() + 1;	
		}
		
			
		
		return intMseq;
		
	}

	@Override
	public int insert(MemoVO memoVO) {
		
		return memoDao.insert(memoVO);
	}

	@Override
	public int update(MemoVO memoVO) {
		
		
		return memoDao.update(memoVO);
	}


	@Override
	public MemoVO findById(Long m_seq) {
		
		return memoDao.findById(m_seq);
	}
	@Override
	public int delete(Long m_seq) {
		
		return memoDao.delete(m_seq);
	}



	
	
}

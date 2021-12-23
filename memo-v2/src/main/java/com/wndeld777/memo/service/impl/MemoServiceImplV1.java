package com.wndeld777.memo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	
	
	@Autowired
	public void create_table(MemoDao memoDao) {
		Map<String,String> maps = new HashMap<String,String>();
		memoDao.create_table(maps);
		
	}
	
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
	@Override
	public MemoVO detail(Long m_seq) {
		
		return memoDao.detail(m_seq);
	}


	@Override
	public int image_delete(MultipartFile m_image) {
		// TODO Auto-generated method stub
		return memoDao.image_delete(m_image);
	}



	
	
}

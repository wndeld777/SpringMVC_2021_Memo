package com.wndeld777.memo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.wndeld777.memo.dao.MemoDao;
import com.wndeld777.memo.model.MemoVO;
import com.wndeld777.memo.service.MemoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("memoServiceV1")
public class MemoServiceImplV1 implements MemoService{

	protected final MemoDao memoDao;
	
	@Override
	public List<MemoVO> selectAll() {
		List<MemoVO> memoList = memoDao.selectAll(); 
		return memoList;
	}


	@Override
	public int insert(MemoVO memoVO) {
		
		return memoDao.insert(memoVO);
	}

	@Override
	public int update(MemoVO memoVO) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public MemoVO findById(Integer m_seq) {
		
		return memoDao.findById(m_seq);
	}





	
	
}

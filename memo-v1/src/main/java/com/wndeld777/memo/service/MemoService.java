package com.wndeld777.memo.service;

import java.util.List;

import com.wndeld777.memo.model.MemoVO;

public interface MemoService {

	public List<MemoVO> selectAll();
	public int insert(MemoVO memoVO);
	public int update(MemoVO memoVO);
	public MemoVO findById(Integer m_seq);
}

package com.wndeld777.memo.dao;

import java.util.List;

import com.wndeld777.memo.model.MemoVO;

public interface MemoDao {

	public List<MemoVO> selectAll();
	public MemoVO findById(Long m_seq);
	public int insert(MemoVO memoVO);
	public int update(MemoVO memoVO);
	public int delete(Long m_seq);
	
	public Long getMaxMseq();
}

package com.wndeld777.memo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wndeld777.memo.dao.MemoDao;
import com.wndeld777.memo.model.MemoVO;
import com.wndeld777.memo.service.MemoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {
	
	protected final MemoService mService;

	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String home(Model model) {
		
		List<MemoVO> mList = mService.selectAll();
		log.debug("Controller{}",mList.toString());
		
		model.addAttribute("MEMO",mList);
		model.addAttribute("BODY","MEMO_LIST");
		
		return "home";
	}
	
	@RequestMapping(value = "/insert",method=RequestMethod.GET)
	public String insert(Model model) {
		MemoVO memoVO = new MemoVO();
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");
		
		String curDate = sd.format(date);
		String curTime = st.format(date);
		
		memoVO = MemoVO.builder()
							.m_date(curDate)
							.m_time(curTime)
							.build();
		
		model.addAttribute("MEMO",memoVO);
		model.addAttribute("BODY","MEMO_INPUT");
		
		return "home";
	}
	
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	public String insert(MemoVO memoVO,Model model) {
		mService.insert(memoVO);
		model.addAttribute("BODY","MEMO_INPUT");
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/detail",method=RequestMethod.GET)
	public String detail(@RequestParam("id")Integer m_seq ,Model model) {
	
		MemoVO memoVO = mService.findById(m_seq);
		model.addAttribute("MEMO",memoVO);
		model.addAttribute("BODY","MEMO_DETAIL");
		
		return "home";
	}
	
	
}

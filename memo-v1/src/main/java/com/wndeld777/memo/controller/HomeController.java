package com.wndeld777.memo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wndeld777.memo.config.QualifierConfig;
import com.wndeld777.memo.dao.MemoDao;
import com.wndeld777.memo.model.MemoVO;
import com.wndeld777.memo.service.FileServiceABS;
import com.wndeld777.memo.service.MemoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {
	
	@Autowired
	protected final MemoService memoService;
	
	private final List<MemoVO> memoList = new ArrayList<MemoVO>();
	private final FileServiceABS fileService;

	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String home(Model model) {
		
		List<MemoVO> mList = memoService.selectAll();
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
		
		Long makeInt = Long.parseLong(String.valueOf(memoService.makeMseq()));
		
		memoVO = MemoVO.builder()
							.m_date(curDate)
							.m_time(curTime)
							.m_seq(makeInt)
							.build();
		
		model.addAttribute("MEMO",memoVO);
		model.addAttribute("BODY","MEMO_INPUT");
		
		return "home";
	}
	
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	public String insert(MemoVO memoVO,Model model, @RequestParam("m_image") MultipartFile m_image) {
		
		Map<String, String> retFileName = fileService.fileUp(m_image);
		memoVO = MemoVO.builder().m_image(retFileName.get(QualifierConfig.FILE_SERVICE.SAVENAME)).build();
		memoList.add(memoVO);
		
		
		memoService.insert(memoVO);
		model.addAttribute("BODY","MEMO_INPUT");
		model.addAttribute("IMAGES",retFileName);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/detail",method=RequestMethod.GET)
	public String detail(Long m_seq ,Model model) {
	
		MemoVO memoVO = memoService.findById(m_seq);
		model.addAttribute("MEMO",memoVO);
		model.addAttribute("BODY","MEMO_DETAIL");
		
		return "home";
	}
	
	@RequestMapping(value = "/delete", method=RequestMethod.GET)
	public String delete(@RequestParam Long m_seq) {
		memoService.delete(m_seq);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/update", method=RequestMethod.GET)
	public String update(MemoVO memoVO, Model model) {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");
		
		String curDate = sd.format(date);
		String curTime = st.format(date);
		
		memoVO = MemoVO.builder()
							.m_seq(memoVO.getM_seq())
							.m_author(memoVO.getM_author())
							.m_date(curDate)
							.m_time(curTime)
							.m_memo(memoVO.getM_memo())
							.m_image(memoVO.getM_image())
							.build();
		
		model.addAttribute("MEMO",memoVO);
		
		model.addAttribute("BODY","MEMO_INPUT");
		
		return "home";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(MemoVO memoVO ) {
		
		memoService.update(memoVO);
		return "redirect:/";
		
	}
	
}

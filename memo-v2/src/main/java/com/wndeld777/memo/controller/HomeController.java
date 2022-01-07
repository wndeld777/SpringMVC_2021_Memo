package com.wndeld777.memo.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wndeld777.memo.config.QualifierConfig;
import com.wndeld777.memo.model.MemoVO;
import com.wndeld777.memo.service.FileService;
import com.wndeld777.memo.service.MemoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	
	private final List<MemoVO> memoList = new ArrayList<MemoVO>();

	private final MemoService memoService;
	private final FileService fileService;
	public HomeController(@Qualifier(QualifierConfig.SERVICE.FILE_SERVICE_V1)
			FileService fileService, MemoService memoService) {
		this.memoService = memoService;
		this.fileService = fileService;

}
	Date date = new Date(System.currentTimeMillis());
	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");
	
	String curDate = sd.format(date);
	String curTime = st.format(date);
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String home(Model model) {
		
		List<MemoVO> memoList = memoService.selectAll();
		
		log.debug("Controller{}",memoList.toString());
		
		model.addAttribute("MEMO",memoList);
		model.addAttribute("BODY","MEMO_LIST");
		
		return "home";
	}
	
	@RequestMapping(value = "/insert",method=RequestMethod.GET)
	public String insert(Model model,MemoVO memoVO) {
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
	public String insert(Long m_seq,String m_author,String m_date,
			String m_time,String m_memo,Model model,
			@RequestParam("m_image") MultipartFile m_image ){
		Map<String,String> retFileName 
		= fileService.fileUp(m_image);
		MemoVO memoVO = new MemoVO();
		if(m_image.isEmpty()) {
			memoVO = MemoVO.builder()
					.m_seq(m_seq)
					.m_author(m_author)
					.m_date(m_date)
					.m_time(m_time)
					.m_memo(m_memo)
					.build();
		}else {
			memoVO = MemoVO.builder()
					.m_seq(m_seq)
					.m_author(m_author)
					.m_date(m_date)
					.m_time(m_time)
					.m_memo(m_memo)
					.m_image(retFileName
						.get(QualifierConfig
							.FILE_SERVICE
							.SAVENAME)).build();
		}
		memoList.add(memoVO);
		memoService.insert(memoVO);
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
	public String update(Long m_seq,Model model) {
		
		MemoVO memoVO = memoService.detail(m_seq);

		
		log.debug("이미지 정보{}",memoVO.toString());
		
//		memoVO = MemoVO.builder()
//							.m_image(memoVO.getM_image())
//							.build();
		
		model.addAttribute("MEMO",memoVO);
		
		model.addAttribute("BODY","MEMO_INPUT");
		
		return "home";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Long m_seq,String m_author,String m_date,
			String m_time,String m_memo,Model model,MemoVO memoVO,MultipartFile m_image) {
		
		
		
		Map<String,String> retFileName 
		= fileService.fileUp(m_image);
		
		memoVO = MemoVO.builder()
				.m_seq(memoVO.getM_seq())
				.m_author(m_author)
				.m_date(m_date)
				.m_time(m_time)
				.m_memo(m_memo)
				.m_image(retFileName
					.get(QualifierConfig
						.FILE_SERVICE
						.SAVENAME)).build();
		
		
		memoList.add(memoVO);
		memoService.update(memoVO);

		return "redirect:/";
	}
	

	
}

package com.wndeld777.memo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/file")
public class FileController {
	
	@RequestMapping(value = {"/",""},method=RequestMethod.GET)
	public String fileUp() {
		
		
		return "redirect:/";
	}


	
}

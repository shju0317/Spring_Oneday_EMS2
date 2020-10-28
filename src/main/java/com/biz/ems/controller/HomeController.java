package com.biz.ems.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.ems.model.EmsVO;
import com.biz.ems.service.EmsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	@Qualifier("emsServiceV1")
	private EmsService emsService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		List<EmsVO> emsList = emsService.selectAll();
		model.addAttribute("EMS_LIST", emsList);
		
		return "home";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "ems-write";
	}

	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(@ModelAttribute EmsVO emsVO, Model model) {
	// public String write(String from_email, String to_email, String s_subject, Model model) { // 고전적인 방법
		
		log.debug("EMSVO {}", emsVO.toString()); // 데이터가 잘 들어왔는지 확인하는 용도
		
		int ret = emsService.insert(emsVO);
		if(ret > 0) {
			log.debug("INSERT 수행한 후 결과 {}개 성공", ret);
		}
		
		// case1
		model.addAttribute("from_email", emsVO.getFrom_email());
		model.addAttribute("to_email", emsVO.getTo_email());
		model.addAttribute("s_subject", emsVO.getS_subject());
		
		// case2
		model.addAttribute("EMS", emsVO); // emsVO에 담겨있는 모든 객체가 EMS라는 이름이 있는 view파일로 전송됨
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(String id) {
		return "ems-write";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(EmsVO emsVO) {
		return "ems-view";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(String id) {
		return "redirect:/";
	}
	
}

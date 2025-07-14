package org.portfolio.controller;

import org.portfolio.domain.PortfolioVO;
import org.portfolio.service.PortfolioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/portfolio/*") // http://192.168.111.104:80/portfolio/* (모든경로 담당)
@AllArgsConstructor
public class PortfolioController {
	
	// 리스트와 CRUD를 담당하는 분기 설정 (URL)
	
	//----------------------------------------------------------------------------------
	
	private PortfolioService service;
	
	//----------------------------------------------------------------------------------
	
	@GetMapping("/list")
	public void list(Model model) { 
	// model은 스프링에서 데이터 관리용 객체 (예전의 request영역, session 영역과 같은 의미)
		
		log.info("PortfolioController.list 메서드 실행...........");
		
		model.addAttribute("list", service.getList());
	}
	
	//----------------------------------------------------------------------------------
	
	@GetMapping("/register")
	public String register() { 
		// JSP 페이지 전달용
		
		return "/portfolio/register";
	}

	//----------------------------------------------------------------------------------
	
	@PostMapping("/register")
	public String register(PortfolioVO portfolio, RedirectAttributes rttr) {
		
		log.info("PortfolioController.register 메서드 실행...........");
		service.register(portfolio);
		rttr.addAttribute("result", portfolio.getBno());
		
		return "redirect:/portfolio/list";
	}
	
	
}

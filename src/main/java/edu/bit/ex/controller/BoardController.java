package edu.bit.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.bit.ex.service.BoardService;
import edu.bit.ex.vo.BoardVO;
import edu.bit.ex.vo.Criteria;
import edu.bit.ex.vo.PageVO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/list")
	public String list(Criteria cri, Model model) {
		log.info("list");
		model.addAttribute("list", boardService.getList(cri));
		int total = boardService.totalCount(cri);
		
		log.info("page");
		PageVO pageVO = new PageVO(cri, total);		
		model.addAttribute("page", pageVO);
		System.out.println(cri.getAmount());
		
		return "list";
	}
	
	@GetMapping("/content_view")
	public String content_view(BoardVO boardVO, Model model) {
		log.info("content_view");
		model.addAttribute("content_view", boardService.content(boardVO.getbId()));
		
		return "content_view";
	}
}

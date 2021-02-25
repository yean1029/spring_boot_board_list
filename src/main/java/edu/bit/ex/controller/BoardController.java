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
		
		return "list";
	}
	
	@GetMapping("/content_view")
	public String content_view(BoardVO boardVO, Model model) {
		log.info("content_view");
		model.addAttribute("content_view", boardService.content(boardVO.getbId()));
		
		return "content_view";
	}
	
	@GetMapping("/write_view")
	public String write_view() {
		log.info("write_view");

		return "write_view";
	}
	
	@PostMapping("/write")
	public String write(BoardVO boardVO, Model model) {
		log.info("write");
		boardService.write(boardVO);

		return "redirect:list";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO boardVO) {
		log.info("modify");
		boardService.modify(boardVO);
		
		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String delete(BoardVO boardVO) {
		log.info("delete");
		boardService.delete(boardVO.getbId());

		return "redirect:list";
	}
	
	@GetMapping("/reply_view")
	public String replyview(BoardVO boardVO, Model model) {
		log.info("delete");
		model.addAttribute("reply_view", boardService.replyView(boardVO.getbId()));

		return "reply_view";
	}
	
	@PostMapping("/reply")
	public String reply(BoardVO boardVO) {
		log.info("reply");
		boardService.reply(boardVO);
		
		return "redirect:list";
	}
	
	
}

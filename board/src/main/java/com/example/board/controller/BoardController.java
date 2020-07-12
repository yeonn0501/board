package com.example.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.board.dto.Board;
import com.example.board.service.BoardService;



@Controller
public class BoardController {
	
	
	// Constructor (생성자 메서드 통한) 의존성 주입 
	private final BoardService boardService;
	
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	
	// 게시글 리스트 Select
	@GetMapping("/boardList")
	public String boardList(
			@RequestParam(value="currentPage", required=false, defaultValue="1")int currentPage, 
			Model model,
			@RequestParam(value="viewSize", required=false, defaultValue="10")int viewSize
							) {
		// System.out.println("BoardController------boardList실행");
		
		//페이징 작업을 위한 map 객체 생성 (ex : 쿼리문 Limit 시작번호와 끝번호 등 을 담기위해)
		Map<String, Object> boardMap = boardService.selectBoardList(currentPage,viewSize);
		List<Board> result = boardService.selectCategory();
		// System.out.println(result+"---------------게시판 카테고리 조회 결과값");
		System.out.println(viewSize+"---------------페이징 데이터 개수");
			
		model.addAttribute("boardList", boardMap.get("boardList"));
		model.addAttribute("listCount", boardMap.get("listCount"));
		model.addAttribute("currentPage", boardMap.get("currentPage"));
		model.addAttribute("lastPage", boardMap.get("lastPage"));
		model.addAttribute("startPageNum", boardMap.get("startPageNum"));
		model.addAttribute("endPageNum", boardMap.get("endPageNum"));
		model.addAttribute("viewSize", boardMap.get("viewSize"));
		model.addAttribute("category", result);
		return "board/boardList";
	}
	
	
	
	// 게시글 상세 정보 Select
	// boardSeq 값을 @RequestParam으로 받아 게시글 상세 정보를 조회 후 정보를  Model 에 담아 view에서 보여준다.
	@GetMapping("/boardView")
	public String boardView(Model model, @RequestParam(value = "boardSeq", required = false) int boardSeq) {
		// System.out.println("BoardController------boardView실행");
		// System.out.println("boardSeq:  " + boardSeq);
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		boardMap = boardService.boardDetailView(boardSeq);
		model.addAttribute("boardView", boardMap.get("boardView"));
		
		return "board/boardView";
	}
	
	
	
	
	@PostMapping("/boardInsert")
	// 게시글 Insert
	public String boardInsert(Board bDto, RedirectAttributes redirectAtr) {
		// System.out.println("BoardController------boardInsert실행");
		// System.out.println(bDto+"-----------bDto");
		
		int boardSeq = boardService.insertBoardList(bDto);
		// System.out.println(boardSeq+"<-----게시글 등록 후 seq");
		
		redirectAtr.addAttribute("boardSeq", boardSeq);
		
		return "redirect:/boardView";
	
	}
	
	
	
	
	// 게시글 생성 입력 form
	@GetMapping("/boardWrite")
	public String boardWrite(Model model) {
		// System.out.println("BoardController------boardWrite실행");
		
		List<Board> result = boardService.selectCategory();
		// System.out.println(result+"---------------게시판 카테고리 조회 결과값");
		
		model.addAttribute("category", result);
		return "board/boardWrite";
	}
	
	
	
	
	
	// 게시글 Delete
	@GetMapping("/boardDelete/{boardSeq}")
	public String deleteBoard(@PathVariable(value="boardSeq") int boardSeq ) {
		// System.out.println("boardDelete 실행");
		// System.out.println(boardSeq+"-----------------boardDelete 실행 boardSeq");
		boardService.deleteBoard(boardSeq);
		return "redirect:/boardList";
	}
	
	
	
	
	
	
	// 게시글 Update form
	@GetMapping("/boardUpdateForm")
	public String boardUpdateForm(@RequestParam(value="boardSeq") int boardSeq, Model model) {
		// System.out.println("updateBoardForm 실행");
		// System.out.println(boardSeq+"-----------------updateBoardForm 실행 boardSeq");
	
		Map<String, Object> boardMap = new HashMap<String, Object>();
		boardMap = boardService.boardDetailView(boardSeq);
		// System.out.println(boardMap.get("boardView")+"<-------게시글 수정 form을 위한 데이터");
		// System.out.println(boardService.selectCategory()+"<-------게시글 수정 form을 위한 category 정보");
		
		model.addAttribute("boardView", boardMap.get("boardView"));
		model.addAttribute("category", boardService.selectCategory());
		return "board/boardUpdate";
	}
	
	
	
	
	// 게시글 Update
	@PostMapping("/boardUpdate")
	public String boardUpdate(Model model, Board bDto, RedirectAttributes redirectAtr) {
		// System.out.println("boardUpdate 실행");
		// System.out.println(bDto.toString()+"<---------게시글 수정 요청한 정보");
		boardService.boardUpdate(bDto);
		redirectAtr.addAttribute("boardSeq", bDto.getBoardSeq());
		return "redirect:/boardView";
	}
}

package com.example.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.board.dto.Board;
import com.example.board.service.BoardService;



@Controller
public class BoardController {
	
	
	
	
	@Autowired
	private BoardService boardService;
	
	
	
	
	
	// 게시글 리스트 조회
	@GetMapping("/boardList")
	public String boardList(Model model, Board bDto) {
		System.out.println("BoardController------boardList실행");
		Map<String, Object> boardMap = new HashMap<String, Object>();
		boardMap = boardService.getBoardList(bDto);
		model.addAttribute("boardList", boardMap.get("boardList"));
		return "board/boardList";
	}
	
	
	
	
	// 게시글 상세 조회
	// boardSeq 값을 @RequestParam으로 받아 게시글 상세 정보를 조회 후 정보를  Model 에 담아 view에서 보여준다.
	@GetMapping("/boardView")
	public String boardView(Model model, @RequestParam(value = "boardSeq", required = false) Object boardSeq, Board bDto) {
		System.out.println("BoardController------boardView실행");
		if(boardSeq != null) {
			System.out.println("boardSeq:  " + boardSeq);
		}
		
		Map<String, Object> boardMap = new HashMap<String, Object>();
		boardMap = boardService.boardDetailView(bDto);
		model.addAttribute("boardView", boardMap.get("boardView"));
		
		return "board/boardView";
	}
	
	
	
	
	@PostMapping("/boardInsert")
	// 게시글 등록시 /boardView 로 
	public String boardInsert(Model model, Board bDto) {
		System.out.println("BoardController------boardInsert실행");
		
		
		return null;
	}
	
	
	
	
	
	
	// 게시글 생성 화면으로 이동
	@GetMapping("/boardWrite")
	public String boardWrite() {
		System.out.println("BoardController------boardWrite실행");
		return "board/boardWrite";
	}
	
	
	
	
	
	
	
	// 게시글 삭제
	
	
	
	
	
	
	
	
	
	// 게시글 수정
}

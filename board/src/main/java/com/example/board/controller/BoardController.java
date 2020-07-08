package com.example.board.controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.board.dto.Board;
import com.example.board.service.BoardService;



@RestController
public class BoardController {
	
	private final BoardService boardService;
	
	BoardController(BoardService boardService){
		this.boardService = boardService;
	}
	
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
	@GetMapping("/boardView")
	public String boardView() {
		System.out.println("BoardController------boardView실행");
		return "board/boardView";
	}
	
	
	// 게시글 생성
	@GetMapping("/boardWrite")
	public String boardWrite() {
		System.out.println("BoardController------boardWrite실행");
		return "board/boardWrite";
	}
	
	
	// 게시글 삭제
	
	
	
	
	// 게시글 수정
}

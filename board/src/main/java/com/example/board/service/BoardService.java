package com.example.board.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.board.dto.Board;
import com.example.board.mapper.BoardMapper;

@Service
public class BoardService {

	// Constructor (생성자 메서드 통한) 의존성 주입 
	private final BoardMapper boardMapper;
	
	public BoardService (BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}

	
	
	// 게시글 리스트 Select
	public Map<String, Object> getBoardList(Map<String, Object> boardMap) {	
		
		List<Board> boardList = boardMapper.selectBoardList(boardMap);
		boardMap.put("boardList", boardList);

		return boardMap;
	}

	
	
	
	// 게시글 상세 정보 Select
	public Map<String, Object> boardDetailView(int boardSeq) {

		Map<String, Object> boardMap = new HashMap<String, Object>();
		Board boardView = boardMapper.boardDetailView(boardSeq);
		boardMap.put("boardView", boardView);
		// System.out.println("boardView boardView확인 : " + boardView.toString());

		return boardMap;
	}
	
	
	
	
	// 게시판 카테고리 Select
	public List<Board> selectCategory(){
		
		// System.out.println("게시판카테고리 실행");
		List<Board> result = boardMapper.selectCategory();
	
		return result;
	}

	
	
	// 게시글 Insert
	public int insertBoardList(Board bDto) {
		
		int result = boardMapper.insertBoardList(bDto);
		// System.out.println(result+"<----- 게시글 등록 성공여부");
		
		if(result!=1) {
			// System.out.println("게시글이 정상적으로 등록되지 않았습니다.");
			return 0;
		}
		
		int boardSeq = boardMapper.selectMaxBoardSeq();
		
		return boardSeq;
	}
	

	
	
	// 게시글 Delete
	public int deleteBoard(int boardSeq) {
		
		int result = boardMapper.deleteBoard(boardSeq);
		return result;
	}
	
	
	
	
	// 게시글 Update
	public int boardUpdate(Board bDto) {
		
		int result = boardMapper.boardUpdate(bDto);
		return result;
	}
}

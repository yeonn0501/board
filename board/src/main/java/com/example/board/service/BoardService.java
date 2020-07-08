package com.example.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Service;

import com.example.board.dto.Board;
import com.example.board.mapper.BoardMapper;

@Service
public class BoardService {
	// 수정
	private final BoardMapper boardMapper;
	
	BoardService(BoardMapper boardMapper){
		this.boardMapper = boardMapper;
	}
	
	// 게시글 리스트 조회
	public Map<String, Object> getBoardList(Board bDto){
		System.out.println("BoardService----- getBoardList 메소드 실행");
		
		List<Board> boardList = new ArrayList<Board>();
		Map<String, Object> boardMap = new HashMap<String, Object>();
		boardList = boardMapper.selectBoardList(boardMap);
		System.out.println("BoardService----- selectBoardList 메소드 실행");
		
		boardMap.put("boardList", boardList);
		
		return boardMap;
	}

}
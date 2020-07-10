package com.example.board.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.board.dto.Board;
import com.example.board.mapper.BoardMapper;

@Service
public class BoardService {

	@Autowired
	private BoardMapper boardMapper;

	// 게시글 리스트 조회
	public Map<String, Object> getBoardList(Board bDto) {

		Map<String, Object> boardMap = new HashMap<String, Object>();
		boardMap.put("boardDto", bDto);
		List<Board> boardList = new ArrayList<Board>();
		boardList = boardMapper.selectBoardList(boardMap);
		boardMap.put("boardList", boardList);

		return boardMap;

	}

	// 게시글 상세 정보 조회
	public Map<String, Object> boardDetailView(Board bDto) {

		Map<String, Object> boardMap = new HashMap<String, Object>();
		List<Board> boardView = new ArrayList<Board>();
		boardView = boardMapper.boardDetailView(bDto);
		boardMap.put("boardView", boardView);
		System.out.println("boardView boardView확인 : " + boardView.toString());

		return boardMap;
	}

	// 게시글 생성
	public Map<String, Object> insertBoardList(Board bDto) {

		boardMapper.insertBoardList(bDto);
		Map<String, Object> boardMap = new HashMap<String, Object>();

		return null;

	}
}

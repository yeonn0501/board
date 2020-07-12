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
	public Map<String, Object> selectBoardList(int currentPage, int viewSize) {	
		// 페이징 로직
		
		// 리스트사이즈 (10,15,20,30개씩)
		int listSize = viewSize;
		// 시작 페이지 숫자(맨 왼쪽)
		int startPageNum = 1;
		// 끝 페이지 숫자(맨 오른쪽)
		int endPageNum = 10;
		
		
		if(listSize == 10 && currentPage > (listSize / 2)) {
			startPageNum = currentPage - ((endPageNum / 2) - 1);
			endPageNum += (startPageNum - 1);
		}
		
		if(listSize == 15 && currentPage > (listSize / 3)) {
			startPageNum = currentPage - ((endPageNum / 2) - 1);
			endPageNum += (startPageNum - 1);
		}
		
		if(listSize == 20 && currentPage > (listSize / 4)) {
			startPageNum = currentPage - ((endPageNum / 2) - 1);
			endPageNum += (startPageNum - 1);
		}
		
		if(listSize == 30 && currentPage > (listSize / 6)) {
			startPageNum = currentPage - ((endPageNum / 2) - 1);
			endPageNum += (startPageNum - 1);
		}
		
		Map<String, Object> boardMap = new HashMap<String, Object>();

		int startRow = (currentPage - 1) * listSize;
		
		boardMap.put("startRow", startRow);
		boardMap.put("listSize", listSize);
		
		double listCount = boardMapper.selectListCount();
		
		int lastPage = (int) Math.ceil((listCount / listSize));
		boardMapper.selectBoardList(boardMap);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		int listCount1 = (int) listCount;
		resultMap.put("listCount", listCount1);
		resultMap.put("boardList", boardMapper.selectBoardList(boardMap));
		resultMap.put("currentPage", currentPage);
		resultMap.put("lastPage", lastPage);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("endPageNum", endPageNum);
		resultMap.put("viewSize", listSize);
		
		return resultMap;
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

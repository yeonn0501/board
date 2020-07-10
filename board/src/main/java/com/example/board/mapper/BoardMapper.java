package com.example.board.mapper;

import java.util.List;
import java.util.Map;
import com.example.board.dto.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
	
	// 게시글 리스트 조회
	public List<Board> selectBoardList(Map<String, Object> map);
	
	// 게시글 상세 정보 조회
	public List<Board> boardDetailView(Board bDto);
	
	// 게시글 생성
	public void insertBoardList(Board bDto);
}



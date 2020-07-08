package com.example.board.mapper;

import java.util.List;
import java.util.Map;
import com.example.board.dto.Board;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
	
	// 게시글 조회 메소드
	public List<Board> selectBoardList(Map<String, Object> map);
	//
}

package com.example.board.mapper;

import java.util.List;
import java.util.Map;
import com.example.board.dto.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
	
	// 게시글 리스트 Select
	List<Board> selectBoardList(Map<String, Object> map);

	// 게시판 카테고리 Select
	List<Board> selectCategory();
	
	// 게시글 리스트 총 개수 Select
	int selectListCount();
	
	// 게시글 상세 정보 Select
	Board boardDetailView(int boardSeq);

	// 게시글 Insert
	int insertBoardList(Board bDto);
	
	// 게시글 생성 후 게시글 번호 MAX 값 Select
	int selectMaxBoardSeq();
	
	// 게시글 Delete
	int deleteBoard(int boardSeq);
	
	// 게시글 Update
	int boardUpdate(Board bDto);
}



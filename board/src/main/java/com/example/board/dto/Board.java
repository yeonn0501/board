package com.example.board.dto;

import java.util.Date;

public class Board {
	private int boardCode;
	private String boardCategory;
	private int boardSeq;
	private String boardWriter;
	private String boardTitle;
	private String boardContent;
	private int boardCount;
	private int boardCommentCount;
	private Date boardDate;
	
	
	public int getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(int boardCode) {
		this.boardCode = boardCode;
	}
	public String getBoardCategory() {
		return boardCategory;
	}
	public void setBoardCategory(String boardCategory) {
		this.boardCategory = boardCategory;
	}
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getBoardCount() {
		return boardCount;
	}
	public void setBoardCount(int boardCount) {
		this.boardCount = boardCount;
	}
	public int getBoardCommentCount() {
		return boardCommentCount;
	}
	public void setBoardCommentCount(int boardCommentCount) {
		this.boardCommentCount = boardCommentCount;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [boardCode=");
		builder.append(boardCode);
		builder.append(", boardCategory=");
		builder.append(boardCategory);
		builder.append(", boardSeq=");
		builder.append(boardSeq);
		builder.append(", boardWriter=");
		builder.append(boardWriter);
		builder.append(", boardTitle=");
		builder.append(boardTitle);
		builder.append(", boardContent=");
		builder.append(boardContent);
		builder.append(", boardCount=");
		builder.append(boardCount);
		builder.append(", boardCommentCount=");
		builder.append(boardCommentCount);
		builder.append(", boardDate=");
		builder.append(boardDate);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}

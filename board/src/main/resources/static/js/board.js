/**
 * 작성자 김연지
 */
 
$(function(){
	// 게시글 제목 클릭시 post 방식으로 글 상세 화면 이동
	$('.a_board_title').on('click',function(){	
		var boardNumber = $(this).parent().siblings('.td_number').text();
		console.log(boardNumber);
		
		
	})

	
	// 글 입력 후 submit 버튼 클릭시 /boardInsert로 연결 
	$('.write_submit_btn').on('click',function(boardWriteCheck){
		var boardWriter = $('input[name="boardWriter"]');
		var boardTitle = $('input[name="boardTitle"]');
		var boardContent = $('textarea[name="boardContent"]');
		
		if(boardWriter.val()=='' || boardWriter.val()==null){
			boardWriter.focus();
			alert('작성자를 입력해주세요.');
			return false;
		}if(boardTitle.val()=='' || boardTitle.val()==null){
			boardTitle.focus();
			alert('제목을 입력해주세요.');
			return false;
		}
			console.log(boardWriter.val());
			console.log(boardTitle.val());
			console.log(boardContent.val());
		
		$('#write_form').submit();
	})


	$('.write_cancel_btn').on('click',function(){
		
		var write_cancel = confirm('사이트에서 나가시겠습니까? 변경사항이 저장되지 않을 수 있습니다.');
		if(write_cancel == true){
			history.back();
		}
	
	})

})



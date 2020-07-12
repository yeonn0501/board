/**
 * 작성자 김연지
 */
 
$(function(){
		
	
	// boardList.html 에서 list_size 선택시 버튼 text 변경
	$('.list_size_li').on('click',function(){
		var listSize = $(this).text();
		$('.list_size_span').text(listSize);
		
		var listSizeValue = $(this).val();
		console.log(listSizeValue);
		
		
	})
	
	
	
	// 글 insert form 및 update form에서 카테고리 선택
	$('.form_category_list').on('click', function(){
		var boardCode = $(this).val();
		console.log(boardCode);
		
		var boardCategory = $(this).text();
		$('.category_type').text(boardCategory);
		$('input[name="boardCode"]').val(boardCode);
	})

	
	
	// 글 작성 중 '이전 화면' 클릭시 confirm 실행
	$('.form_cancel_btn').on('click',function(){
		var write_cancel = confirm('사이트에서 나가시겠습니까? 변경사항이 저장되지 않을 수 있습니다.');
		if(write_cancel == true){
			history.back();
		}
	
	})
	
	
	
	// 글 입력 후 submit 버튼 클릭시 유효성 검사 후 /boardInsert로 submit
	$('.form_submit_btn').on('click',function(){
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
		
			$('form[name="insertForm"]').attr({
				action:'/boardInsert',
				method:'post' 

				}).submit();

	})

	


	
	// 게시글 '삭제' 버튼 클릭시 boardSeq 값 전달
	$('.board_delete_btn').on('click', function(){
		var view_delete = confirm('해당 글을 삭제하시겠습니까?');
		if(view_delete == true){
			var boardSeq = $('input[name="boardSeq"]').val();
			location.href='/boardDelete/'+boardSeq;
		}
	})
	
	
	
	
	// 게시글 '수정' 버튼 클릭시 수정 폼 화면으로 이동
	$('.board_update_btn').on('click', function(){
		var boardSeq = $('input[name="boardSeq"]').val();
		location.href='/boardUpdateForm?boardSeq='+boardSeq;
	})
	
	
	
	
	// 수정form 에서 '수정완료' 버튼 클릭시 /boardUpdate로 값 전달
	$('.form_update_btn').on('click', function(){
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
		
			$('form[name="updateForm"]').attr({
				action:'/boardUpdate',
				method:'post' 

				}).submit();

	})
})





function goTop(){
	// top 버튼 클릭시 스크롤 위치 맨 위로 이동.
	document.documentElement.scrollTop = 0;
}

function adjustHeight() {
// 함수를 실행하면 자동으로 textarea의 높이 조절
  var textEle = $('textarea');
  textEle[0].style.height = 'auto';
  var textEleHeight = textEle.prop('scrollHeight');
  textEle.css('height', textEleHeight);
};




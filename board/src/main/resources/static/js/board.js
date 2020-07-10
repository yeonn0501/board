/**
 * 작성자 김연지
 */
 
$(function(){
		
	// 글 입력 후 submit 버튼 클릭시 /boardInsert로 연결 
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
		
		$('#write_form').submit();
	})


	$('.form_cancel_btn').on('click',function(){
		// 글 작성 중 '이전 화면' 클릭시 confirm 실행
		var form_cancel = confirm('사이트에서 나가시겠습니까? 변경사항이 저장되지 않을 수 있습니다.');
		if(form_cancel == true){
			history.back();
		}
	
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




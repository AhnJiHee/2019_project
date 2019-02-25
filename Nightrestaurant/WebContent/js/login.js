
$(document).ready(function(){
	$('#div3').show();   
    $('#div4').show();   

$('.toggle').on('click', function() {
  $('.container').stop().addClass('active');
});
 
$('.close').on('click', function() {
  $('.container').stop().removeClass('active');
});
 
//로그인 했을 때 로그인 창 없어진다는 조건 하에 버튼 만듬 
$('.button-container').on('click', function() {  
	
  
    var divLoc = $('#one').offset();
    $('html, body').animate({scrollTop: divLoc.top-20}, 2000);
    
}); 

function open() {

	 window.open('https://www.naver.com');

	}

});


 
//로그인 화면 전에 컨텐츠들 안보이게 함 

 
$(document).ready(function(){
$('.toggle').on('click', function() {
  $('.container').stop().addClass('active');
});
 
$('.close').on('click', function() {
  $('.container').stop().removeClass('active');
});
 
//로그인 했을 때 로그인 창 없어진다는 조건 하에 버튼 만듬 
$('.button-container').on('click', function() {  
    $('.container').hide(2000, 'linear');  
}); 
 
});
 
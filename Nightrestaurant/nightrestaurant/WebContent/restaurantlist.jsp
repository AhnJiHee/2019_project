<%@page import="vo.LocaltimeVO"%>
<%@page import="dao.RestaurantDAO"%>
<%@page import="vo.RestaurantVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>음식점 리스트</title>

<script src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#Search").on('click',function(){
			if($("#province option:selected").val().length<1) {
				alert("지역을 선택하세요.")
			}
			
			if($("#closetime option:selected").val().length<1) {
				alert("시간대를 선택하세요.")
			}
			/* var province=$("#province option:selected").val();
			var closetime=$("#closetime option:selected").val();
			var param="branch=2&block=1&province="+province+"&closetime="+closetime;
			$.ajax({
				type: "POST",
				url: "restaurantlist.jsp",
				data: param,
				success: function(data) {
					$("#div4").html(data);
				}
			}); */
		}) //Search end
		
	}); // ready end
		
</script>

<style>
	div div.list {
		width: 250px;
		height: 80%;
		background-color: lightgray;
		padding: 10px
	}
	div div table.restaurant {
		width: 200px;
		height: 100px;
		text-align: center;
		padding: 10px;
	}
	tr,td {
		border: 1px;
	}
	a {
		color:black;
	}
</style>
</head>
<body>
<%!
String[] province = {"강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구",
            "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구",
            "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구"};
RestaurantDAO dao = new RestaurantDAO(); 
int each = RestaurantDAO.EACH;
%>

<div id = "div4">
	<!--게시판 제목-->
	<div class="center" id="div1">
		<!-- 제목 -->
		<h1>음식점 목록입니다.</h1>
		
		<!-- selection form -->
		<form action = "main">
			<!-- 구 선택 select-->
			<select id="province" name="province"> 
				<option value='' selected>구를 선택하세요</option>
				<% for(int i = 0; i < province.length; i++) {
					out.println("<option value='"+province[i]+"'>" + province[i] + "</option>");
				}%>
			</select>
			<!-- 시간 선택 => 마감시간으로 전달 select-->
			<select id="closetime" name="closetime"> 
				<option value='' selected>원하는 시간대를 선택하세요</option>
				<option id='23' value='23'>22:00-23:00시</option>
				<option id='24' value='24'>23:00-24:00시</option>
				<option id='25' value='25'>24:00-01:00시</option>
				<option id='26' value='26'>01:00-02:00시</option>
				<option id='27' value='27'>02:00-03:00시</option>
			</select>
			<input id="Search" type=submit value="검색하기">
		</form>
		
		<!-- 식당 리스트 -->
		<div class="list">
			<%
				ArrayList<RestaurantVO> list = null;
				int pagenumb = 1; // 기본으로 보여줄 페이지
				
				// 총 식당 개수 출력 및 리스트 생성 - <span>
				int total=0;
				if (request.getParameter("province") !=null && request.getParameter("closetime") !=null) {
					String province = request.getParameter("province");
					String closetime = request.getParameter("closetime");
					LocaltimeVO ltvo = new LocaltimeVO (province, closetime);
					list = dao.getSelectedList(ltvo);
					total = dao.getTotalRestaurants(ltvo);
					} 
				else {
					list = dao.getRestaurantList();
					total = dao.getTotalRestaurants();
					}
				out.println("<span>해당 지역 내 총 "+total+"개의 식당이 존재합니다.</span>");
	
				// 페이지 번호 호출
				if(request.getParameter("page") != null){
					pagenumb = Integer.parseInt(request.getParameter("page"));
				}
				
				// 식당 리스트 출력
				for (int i = each*(pagenumb-1); i < each*pagenumb; i++) {
				RestaurantVO vo = list.get(i);
				out.println (
						"<table class='restaurant' id='list"+i+"' border=1px><tr><td colspan='2'>" + vo.getName() + "</td></tr>" +
						"<tr><td colspan='2'>" + vo.getAddress() + "</td></tr>" +
						"<tr><td>"+ vo.getTag() + "</td><td>" + vo.getKeyword() + "</td></tr>" +
						"<tr><td colspan='2'>" + vo.getBhours() + "</td></tr></table>"
				);}
			%>
		</div> 
	</div> 
	
	<!--페이지 번호-->
	<table class="center" >
		<tr>
			<%
			int totalcont = dao.getTotalRestaurants();
			if (totalcont % each ==0){
				pagenumb = totalcont / each;
			} else {
				pagenumb = totalcont / each +1;
			}
			/* for (int i =1 ; i <= pagenumb; i ++){
			out.print("<td><a href='main?branch=2&page="+i+"'>"+i+"</a></td>");
			} */
			
			int block = 1;
			if( request.getParameter("block") != null) {
				block = Integer.parseInt(request.getParameter("block"));}
			
			int prevblock = block-1;
			int nextblock = block+1;
			int prevpage = 10*block - 11;
			int nextpage = 10*block + 1;
			int maxblock = 100;
			if( pagenumb % 10 == 0) {
				maxblock = pagenumb / 10;
			} else {
				maxblock = pagenumb / 10 + 1;
			}
			
			// page 처리
			if (block > 1) {
				out.print("<td><a href='main?branch=2&block="+prevblock+"&page="+prevpage+"'>이전</a></td>");
			}
			for (int i = block * 10-9 ; i < block * 10+1; i++) {
				out.print("<td><a href='main?branch=2&block="+block+"&page="+i+"'>&nbsp"+i+"</a></td>");
				if ( i >= pagenumb) {
					break;
				};	
			};
			if (block < maxblock) {
				out.print("<td><a href='main?branch=2&block="+nextblock+"&page="+nextpage+"'>다음</a></td>");			
			}
			%>
		</tr>
	</table>
</div>


</body>
</html>
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
			var branch = 2
			var province = $("#province option:selected").val();
			var closetime = $("#closetime option:selected").val();
			param = "branch="+branch+"&province="+province+"&closetime="+closetime+"&block=1&page=1"
			$.ajax({
				type: "get",
				url: "restaurantlist.jsp",
				data: param,
				success: function(data) {
					$("#div4").html(data);
				}
			});
			$.ajax({
	            type: "POST",
	            url: "http://localhost:8081/nightrestaurant/R",
	            
	            data: {"province" : province, "closetime" : closetime} ,
	            success: function() {
	               /* alert("ㅋㅋ"); */
	               
	               $("#iframearea").html("<iframe src='http://localhost:8081/nightrestaurant/leafletchart2/index.html' width='100%' height='500' seamless></iframe>"); 
	            },
	            error : function(){
	               alert("오류발생")}
	         });
		}) //Search end
		
		$(".prev").on('click', function(e){
			var branch = 2
			var block = parseInt($("#block").val())-1;
			var page = $("#prevpage").val();
			var param = "branch="+branch+"&block="+block+"&page="+page;
			$.ajax({
				type: "get",
				url: "restaurantlist.jsp",
				data: param,
				success: function(data) {
					$("#div4").html(data);
				}
			});
		}); //.page end
		
		$(".page").on('click', function(e){
			var branch = 2
			var block = $("#block").val();
			var page = $(e.target).html();
			var param = "branch="+branch+"&block="+block+"&page="+page;
			alert(param);
			$.ajax({
				type: "get",
				url: "restaurantlist.jsp",
				data: param,
				success: function(data) {
					$("#div4").html(data);
				}
			});
		}); //.page end
		
		$(".next").on('click', function(e){
			var branch = 2
			var block = parseInt($("#block").val())+1;
			var page = $("#nextpage").val();
			var param = "branch="+branch+"&block="+block+"&page="+page;
			$.ajax({
				type: "get",
				url: "restaurantlist.jsp",
				data: param,
				success: function(data) {
					$("#div4").html(data);
				}
			});
		}); //.page end
		
		
		
		
	}); // ready end
		
</script>

<style>
	div div.list {
		width: 250px;
		height: 80%;
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
			<option id='23' value='23'>10시 이후</option>
			<option id='24' value='24'>11시 이후</option>
			<option id='25' value='25'>12시 이후</option>
			<option id='26' value='26'>새벽 1시 이후</option>
			<option id='27' value='27'>새벽 2시 이후</option>
			<option id='28' value='28'>새벽 3시 이후</option>
			<option id='29' value='29'>새벽 4시 이후</option>
			<option id='30' value='30'>새벽 5시 이후</option>
		</select>
		<input id="Search" type=button value="검색하기">
		
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
					list = dao.getSelectedList(province, closetime); 
					total = dao.getTotalRestaurants(province, closetime);
					session.setAttribute("province", province);
					session.setAttribute("closetime", closetime);
					} 
				else if (session.getAttribute("province") != null & session.getAttribute("closetime") != null){
					String province = (String) session.getAttribute("province");
					String closetime = (String) session.getAttribute("closetime");
					list = dao.getSelectedList(province, closetime); 
					total = dao.getTotalRestaurants(province, closetime);
				} else {
					list = dao.getRestaurantList();
					total = dao.getTotalRestaurants();
					}	
				// 페이지 번호 호출
				if(request.getParameter("page") != null){
					pagenumb = Integer.parseInt(request.getParameter("page"));
				}
			%>
			
			<div>
			<th> 해당 지역 내 총 <%=total%>개의 식당이 존재합니다.</th>
			<%
				// 식당 리스트 출력
				for (int i = each*(pagenumb-1); i < each*pagenumb; i++) {
				RestaurantVO vo = list.get(i);
				out.println (
						"<table class='restaurant' id='list"+i+"' border=1px><tr><td colspan='2'>" + vo.getName() + "</td></tr>" +
						"<tr><td colspan='2'>" + vo.getAddress() + "</td></tr>" +
						"<tr><td>"+ vo.getTag() + "</td><td>" + vo.getKeyword() + "</td></tr>" +
						"<tr><td colspan='2'>" + vo.getBhours() + "</td></tr></table>" +
						"<tr><td><input type='button' value='찜하기'></input></td></tr></table>"
				);}
			%>
			</div>
			
			
			
		</div> 
	</div> 
	
	<!--페이지 번호-->
	<table class="center" >
		<tr>
			<%
			if (total % each ==0){
				pagenumb = total / each;
			} else {
				pagenumb = total / each +1;
			}
			/* for (int i =1 ; i <= pagenumb; i ++){
			out.print("<td><a href='test.jsp?branch=2&page="+i+"'>"+i+"</a></td>");
			} */
			
			int block = 1;
			if( request.getParameter("block") != null) {
				block = Integer.parseInt(request.getParameter("block"));}
			
			int prevblock = block-1;
			int nextblock = block+1;
			int prevpage = 10*block - 10;
			int nextpage = 10*block + 1;
			int maxblock = 100;
			if( pagenumb % 10 == 0) {
				maxblock = pagenumb / 10;
			} else {
				maxblock = pagenumb / 10 + 1;
			}
			
			// page 처리
			if (block > 1) {
				out.print("<td><span class='prev'>이전</span>");
			}
			for (int i = block * 10-9 ; i < block * 10+1; i++) {
				out.print("<td><span class='page'>"+i+"</span></td>");
				if ( i >= pagenumb) {
					break;
				};	
			};
			if (block < maxblock) {
				out.print("<td><span class='next'>다음</span></td>");			
			}
			%>
			<input type=hidden id='block' value= <%=block%>>
			<input type=hidden id='prevpage' value= <%=prevpage%>>
			<input type=hidden id='nextpage' value= <%=nextpage%>>
		</tr>
	</table>
</div>
<div id='div5'>
   
<div id="iframearea"></div>      
      
</div>

</body>
</html>
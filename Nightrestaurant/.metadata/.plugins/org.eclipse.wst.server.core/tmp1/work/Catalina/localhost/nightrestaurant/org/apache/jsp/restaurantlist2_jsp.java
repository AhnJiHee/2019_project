/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.9
 * Generated at: 2019-02-21 03:59:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.RestaurantDAO;
import vo.RestaurantVO;
import java.util.ArrayList;
import dao.BoardDAO;

public final class restaurantlist2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


String[] province = {"강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구",
            "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구",
            "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구"};
RestaurantDAO dao = new RestaurantDAO(); 
int each = RestaurantDAO.EACH;

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>음식점 리스트</title>\r\n");
      out.write("\r\n");
      out.write("<script src=\"jquery-3.2.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t\t$(\"#Search\").on('click',function(){\r\n");
      out.write("\t\t\tif($(\"#province option:selected\").val().length<1) {\r\n");
      out.write("\t\t\t\talert(\"지역을 선택하세요.\")\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif($(\"#closetime option:selected\").val().length<1) {\r\n");
      out.write("\t\t\t\talert(\"시간대를 선택하세요.\")\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tvar branch = 2\r\n");
      out.write("\t\t\tvar province = $(\"#province option:selected\").val();\r\n");
      out.write("\t\t\tvar closetime = $(\"#closetime option:selected\").val();\r\n");
      out.write("\t\t\tparam = \"branch=\"+branch+\"&province=\"+province+\"&closetime=\"+closetime+\"&block=1&page=1\"\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype: \"get\",\r\n");
      out.write("\t\t\t\turl: \"restaurantlist.jsp\",\r\n");
      out.write("\t\t\t\tdata: param,\r\n");
      out.write("\t\t\t\tsuccess: function(data) {\r\n");
      out.write("\t\t\t\t\t$(\"#div4\").html(data);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t            type: \"POST\",\r\n");
      out.write("\t            url: \"http://localhost:8081/nightrestaurant/R\",\r\n");
      out.write("\t            \r\n");
      out.write("\t            data: {\"province\" : province, \"closetime\" : closetime} ,\r\n");
      out.write("\t            success: function() {\r\n");
      out.write("\t               /* alert(\"ㅋㅋ\"); */\r\n");
      out.write("\t               \r\n");
      out.write("\t               $(\"#iframearea\").html(\"<iframe src='http://localhost:8081/nightrestaurant/leafletchart2/index.html' vertical-align=bottom width=100% height=100% seamless></iframe>\"); \r\n");
      out.write("\t            },\r\n");
      out.write("\t            error : function(){\r\n");
      out.write("\t               alert(\"오류발생\")}\r\n");
      out.write("\t         });\r\n");
      out.write("\t\t}) //Search end\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\".prev\").on('click', function(e){\r\n");
      out.write("\t\t\tvar branch = 2\r\n");
      out.write("\t\t\tvar block = parseInt($(\"#block\").val())-1;\r\n");
      out.write("\t\t\tvar page = $(\"#prevpage\").val();\r\n");
      out.write("\t\t\tvar param = \"branch=\"+branch+\"&block=\"+block+\"&page=\"+page;\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype: \"get\",\r\n");
      out.write("\t\t\t\turl: \"restaurantlist.jsp\",\r\n");
      out.write("\t\t\t\tdata: param,\r\n");
      out.write("\t\t\t\tsuccess: function(data) {\r\n");
      out.write("\t\t\t\t\t$(\"#div4\").html(data);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}); //.page end\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\".page\").on('click', function(e){\r\n");
      out.write("\t\t\tvar branch = 2\r\n");
      out.write("\t\t\tvar block = $(\"#block\").val();\r\n");
      out.write("\t\t\tvar page = $(e.target).html();\r\n");
      out.write("\t\t\tvar param = \"branch=\"+branch+\"&block=\"+block+\"&page=\"+page;\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype: \"get\",\r\n");
      out.write("\t\t\t\turl: \"restaurantlist.jsp\",\r\n");
      out.write("\t\t\t\tdata: param,\r\n");
      out.write("\t\t\t\tsuccess: function(data) {\r\n");
      out.write("\t\t\t\t\t$(\"#div4\").html(data);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}); //.page end\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\".next\").on('click', function(e){\r\n");
      out.write("\t\t\tvar branch = 2\r\n");
      out.write("\t\t\tvar block = parseInt($(\"#block\").val())+1;\r\n");
      out.write("\t\t\tvar page = $(\"#nextpage\").val();\r\n");
      out.write("\t\t\tvar param = \"branch=\"+branch+\"&block=\"+block+\"&page=\"+page;\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\ttype: \"get\",\r\n");
      out.write("\t\t\t\turl: \"restaurantlist.jsp\",\r\n");
      out.write("\t\t\t\tdata: param,\r\n");
      out.write("\t\t\t\tsuccess: function(data) {\r\n");
      out.write("\t\t\t\t\t$(\"#div4\").html(data);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}); //.page end\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t}); // ready end\r\n");
      out.write("\t\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\t#div1 {\r\n");
      out.write("\t\twidth: 100%;\r\n");
      out.write("\t\theight: 20%;\r\n");
      out.write("\t\tpadding: 10px;\r\n");
      out.write("\t}\r\n");
      out.write("\t#iframearea {\r\n");
      out.write("\t\twidth: 60%;\r\n");
      out.write("\t\theight: 80%;\r\n");
      out.write("\t\tpadding: 10px;\r\n");
      out.write("\t\tfloat: right;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tdiv div button{\r\n");
      out.write("\t\tfloat: right;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tdiv div.list {\r\n");
      out.write("\t\twidth: 40%;\r\n");
      out.write("\t\theight: 80%;\r\n");
      out.write("\t\tpadding: 10px;\r\n");
      out.write("\t\tfloat: left;\r\n");
      out.write("\t}\r\n");
      out.write("\tdiv div table.restaurant {\r\n");
      out.write("\t\twidth:325px;\r\n");
      out.write("\t\theight: 100px;\r\n");
      out.write("\t\ttext-align: center;\r\n");
      out.write("\t\tpadding: 10px;\r\n");
      out.write("\t}\r\n");
      out.write("\ttr,td {\r\n");
      out.write("\t\tborder: 1px;\r\n");
      out.write("\t}\r\n");
      out.write("\ta {\r\n");
      out.write("\t\tcolor:black;\r\n");
      out.write("\t}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id = \"div4\">\r\n");
      out.write("\t<!--게시판 제목-->\r\n");
      out.write("\t<div class=\"center\" id=\"div1\">\r\n");
      out.write("\t\t<!-- 제목 -->\r\n");
      out.write("\t\t<h1>음식점 목록입니다.</h1>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- selection form -->\r\n");
      out.write("\t\t<!-- 구 선택 select-->\r\n");
      out.write("\t\t<select id=\"province\" name=\"province\" style = \"float: left; width: 40%\"> \r\n");
      out.write("\t\t\t<option value='' selected>구를 선택하세요</option>\r\n");
      out.write("\t\t\t");
 for(int i = 0; i < province.length; i++) {
				out.println("<option value='"+province[i]+"'>" + province[i] + "</option>");
			}
      out.write("\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\t\t<h4 style = \"float: left; width: 1%\" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h4>\r\n");
      out.write("\t\t<!-- 시간 선택 => 마감시간으로 전달 select-->\r\n");
      out.write("\t\t<select id=\"closetime\" name=\"closetime\" style = \"float: left; width: 40%\"> \r\n");
      out.write("\t\t\t<option value='' selected>원하는 시간대를 선택하세요</option>\r\n");
      out.write("\t\t\t<option id='23' value='23'>10시 이후</option>\r\n");
      out.write("\t\t\t<option id='24' value='24'>11시 이후</option>\r\n");
      out.write("\t\t\t<option id='25' value='25'>12시 이후</option>\r\n");
      out.write("\t\t\t<option id='26' value='26'>새벽 1시 이후</option>\r\n");
      out.write("\t\t\t<option id='27' value='27'>새벽 2시 이후</option>\r\n");
      out.write("\t\t\t<option id='28' value='28'>새벽 3시 이후</option>\r\n");
      out.write("\t\t\t<option id='29' value='29'>새벽 4시 이후</option>\r\n");
      out.write("\t\t\t<option id='30' value='30'>새벽 5시 이후</option>\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\t\t<h4 style = \"float: left; width: 5%\" >&nbsp;&nbsp;</h4>\r\n");
      out.write("\t\t<input id=\"Search\" type=button value=\"검색하기\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<!-- 식당 리스트 -->\r\n");
      out.write("\t\t<div class=\"list\">\r\n");
      out.write("\t\t\t");

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
			
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<th> 해당 지역 내 총 ");
      out.print(total);
      out.write("개의 식당이 존재합니다.</th>\r\n");
      out.write("\t\t\t");

				// 식당 리스트 출력
				for (int i = each*(pagenumb-1); i < each*pagenumb; i++) {
				RestaurantVO vo = list.get(i);
				if(vo.getKeyword().equals("NA")) {
					vo.setKeyword("ㅡ");
				}
				out.println (
						"<table class='restaurant' id='list"+i+"' border=1px><tr><td colspan='2'>" + vo.getName() + "</td></tr>" +
						"<tr><td colspan='2'>" + vo.getAddress() + "</td></tr>" +
						"<tr><td>"+ vo.getTag() + "</td><td>" + vo.getKeyword() + "</td></tr>" +
						"<tr><td colspan='2'>" + vo.getBhours() + "</td></tr></table>"
				);}
			
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div> \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div id=\"iframearea\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</div>      \r\n");
      out.write("\t</div> \r\n");
      out.write("\t\r\n");
      out.write("\t<!--페이지 번호-->\r\n");
      out.write("\t<table class=\"center\" >\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t");

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
			
      out.write("\r\n");
      out.write("\t\t\t<input type=hidden id='block' value= ");
      out.print(block);
      out.write(">\r\n");
      out.write("\t\t\t<input type=hidden id='prevpage' value= ");
      out.print(prevpage);
      out.write(">\r\n");
      out.write("\t\t\t<input type=hidden id='nextpage' value= ");
      out.print(nextpage);
      out.write(">\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
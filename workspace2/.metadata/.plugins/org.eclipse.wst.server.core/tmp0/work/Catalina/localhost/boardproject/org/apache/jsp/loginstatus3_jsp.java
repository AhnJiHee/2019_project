/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.9
 * Generated at: 2019-02-05 05:09:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginstatus3_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>회원정보창</title>\n");
      out.write("<script src=\"jquery-3.2.1.min.js\"></script>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t$(document).ready(function(){\t\n");
      out.write("\t$(\"#logout\").on(\"click\", function(){\n");
      out.write("\t\talert(\"로그아웃 되었습니다\");\n");
      out.write("\t}); // logout end\n");
      out.write("\t}); // ready end\n");
      out.write("</script>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");

String result ="";
	if ( session.getAttribute("id") != null && session.getAttribute("password") != null){
		String id = (String) session.getAttribute("id");
		String pw = (String) session.getAttribute("password");
		result = id + " 회원님 환영합니다.<br>"
			+ "<form id='logout' action = 'logout.jsp'> <input type=submit value='로그아웃'> </form>";
	} else{
		result = "로그인이 필요합니다.<br>"
			+ "<input type='button' id='login' value='로그인 하기'>";
	}

      out.write("\n");
      out.write("<script>\n");
      out.write("document.querySelector('#login').addEventListener('click', function(event){\n");
      out.write("\tvar xhr = new XMLHttpRequest();\n");
      out.write("\txhr.open('GET', 'login.jsp');\n");
      out.write("\txhr.onreadystatechange = function(){\n");
      out.write("\t\tif(xhr.readyState === 4 && xhr.status === 200){\n");
      out.write("\t\t\tdocument.querySelector('input').innerHTML = xhr.responseText;\n");
      out.write("\t\t}\n");
      out.write("\txhr.send();\n");
      out.write("\t}\n");
      out.write("})\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("<table id=\"left\" border=1>\n");
      out.write("<tr>\n");
      out.write("<td><h3>");
      out.print(result );
      out.write("</h3></td>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
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
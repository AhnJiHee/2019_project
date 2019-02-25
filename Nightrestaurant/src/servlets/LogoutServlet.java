package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
      request.setCharacterEncoding("UTF-8");
      HttpSession session = request.getSession();
      String id = (String)session.getAttribute("id");
      String password = (String)session.getAttribute("password");
      session.removeAttribute("id");
      session.removeAttribute("password");
      session.invalidate();
      /*response.sendRedirect("test.jsp");*/
      /*request.getRequestDispatcher("test.jsp").forward(request, response);*/
   
   }

}
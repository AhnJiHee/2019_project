package servlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Rconnect.RLeaflet;

@WebServlet("/R")
public class RServlet extends HttpServlet {
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String action = "leaflet2";
      if(action.equals("leaflet2")) {
         RLeaflet rc = new RLeaflet();      
         String real_path = request.getSession().getServletContext().getRealPath("/");
         System.out.println(real_path);
          real_path = real_path.replace("\\", "/");
         File f = new File(real_path+"/leafletchart2");
         if(!f.exists()) f.mkdir();
         String result = rc.returnLeaflet2(real_path+"/leafletchart2");
         request.setAttribute("leafletChartName", "http://localhost:8081/redu/leafletchart2/"+result);   
      }
   }

   

}
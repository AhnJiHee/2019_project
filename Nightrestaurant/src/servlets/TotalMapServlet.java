package servlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Rconnect.RLeaflet;
import Rconnect.RLeaflet2;

@WebServlet("/totalmap")
public class TotalMapServlet extends HttpServlet {
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   request.setCharacterEncoding("UTF-8");
      //String action = "leaflet2";
      //if(action.equals("leaflet2")) {
      /*String province = (String) request.getSession().getAttribute("province");
      String closetime = (String) request.getSession().getAttribute("closetime");*/
      
      /*request.setCharacterEncoding("UTF-8");*/
      
        RLeaflet2 rc = new RLeaflet2();      
        String real_path = request.getSession().getServletContext().getRealPath("/");
        System.out.println(real_path);
         real_path = real_path.replace("\\", "/");
        File f = new File(real_path+"/leafletchart2");
        if(!f.exists()) f.mkdir();
        String result = rc.returnLeaflet1((real_path+"/leafletchart2"));
        System.out.println(result);
        request.setAttribute("leafletChartName2", "http://70.12.111.108:8081/nightrestaurant/leafletchart2/"+result);   
        
        String leafletCharName2 = ("http://70.12.111.108:8081/nightrestaurant/leafletchart2/"+result);
        
//        response.getWriter().print(leafletCharName2);


        /*response.setContentType("application/x-json; charset=UTF-8");*/
        
        
      
      request.getRequestDispatcher("/resultmap.jsp").include(request, response);
   }

   

}
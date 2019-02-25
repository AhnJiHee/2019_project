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
       
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //String action = "leaflet2";
      //if(action.equals("leaflet2")) {
      /*String province = (String) request.getSession().getAttribute("province");
      String closetime = (String) request.getSession().getAttribute("closetime");*/
      
      request.setCharacterEncoding("UTF-8");
      
      String province = (String) request.getParameter("province");
      String closetime = (String) request.getParameter("closetime");
      
      System.out.println(province);
      System.out.println(closetime);
      
        RLeaflet rc = new RLeaflet();      
        String real_path = request.getSession().getServletContext().getRealPath("/");
        System.out.println(real_path);
         real_path = real_path.replace("\\", "/");
        File f = new File(real_path+"/leafletchart2");
        if(!f.exists()) f.mkdir();
        String result = rc.returnLeaflet2((real_path+"/leafletchart2"), province, closetime);
        System.out.println(result);
        request.setAttribute("leafletChartName", "http://70.12.111.108:8081/nightrestaurant/leafletchart2/"+result);   
        
        String leafletCharName = ("http://70.12.111.108:8081/nightrestaurant/leafletchart2/"+result);
        
        response.getWriter().print(leafletCharName);


        /*response.setContentType("application/x-json; charset=UTF-8");*/
        
        
      
      /*request.getRequestDispatcher("/resultmap.jsp").include(request, response);*/
   }

   

}
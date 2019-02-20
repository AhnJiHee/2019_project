package Rconnect;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.rosuda.REngine.Rserve.RConnection;

import dao.RestaurantDAO;

public class RLeaflet {
   
   
   
      public String returnLeaflet2(String path, String province, String closetime)  {
         
         RestaurantDAO rdao = new RestaurantDAO();
          
       ArrayList<String> list1 = rdao.getLonList(province, closetime);
       ArrayList<String> list2 = rdao.getLatList(province, closetime);
         
         RConnection r = null;
         String retStr = "";
         try {
            r = new RConnection();
            r.eval("library(leaflet)");
            r.eval("library(dplyr)");
            r.eval("library(htmltools)");
            r.eval("library(ggmap)");
            r.eval("register_google(key=\"AIzaSyBzXGGVVyG111us_Gw86i3yTdxumfo4SLA\")");
            r.eval("seoul_lonlat = unlist(geocode('seoul', source='google'))");
            r.eval("names(seoul_lonlat) <- NULL");
           /* r.eval("setwd('C:/Rstudy2')");*/
            /*r.eval("data <- read.csv('map_convert.csv', stringsAsFactors = FALSE)");
            r.eval("msg <- paste(data$repl_v3, data$new_v,data$repl_cate,sep='  ')");*/
           /* r.eval("map5<-leaflet(data) %>% setView(lng = seoul_lonlat[1], lat = seoul_lonlat[2], zoom = 11) %>% addTiles() %>% addCircles(lng = ~mk_lon, lat=~mk_lat, popup = ~msg)");*/
            r.eval("mk_lon1 <- NULL");
            r.eval("mk_lat1 <- NULL");
            for(int i=0; i<list1.size(); i++) {
               r.eval("mk_lon1 <- c(mk_lon1," + list1.get(i)+")");
            }
            for(int i = 0; i <list2.size(); i++) {
               r.eval("mk_lat1 <- c(mk_lat1," + list2.get(i)+")");
            }
            /*r.eval("mk_lon <- " + list1);
            r.eval("mk_lat <- " + list2);*/
            r.eval("map5<-leaflet()%>%addTiles()%>%setView(lng = seoul_lonlat[1], lat = seoul_lonlat[2], zoom=11)%>% addCircles(lng=mk_lon1, lat=mk_lat1)");
            String fileName = path + "/index.html";
            String libPath = path + "/lib";
            System.out.println(fileName);
            System.out.println(libPath);
            r.eval("save_html(map5,'" + fileName + "', libdir='" + libPath + "')");
            retStr = r.eval("'index.html'").asString();
         } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
         } finally {
            r.close();
         }
         return retStr;
      }


}
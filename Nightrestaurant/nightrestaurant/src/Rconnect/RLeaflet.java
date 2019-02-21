package Rconnect;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.rosuda.REngine.Rserve.RConnection;

import dao.RestaurantDAO;
import vo.RestaurantVO;

public class RLeaflet {
   
   
   
      public String returnLeaflet2(String path, String province, String closetime)  {
         
         RestaurantDAO rdao = new RestaurantDAO();
          
       ArrayList<String> list1 = rdao.getLonList(province, closetime);
       ArrayList<String> list2 = rdao.getLatList(province, closetime);
       ArrayList<RestaurantVO> list_res = rdao.getSelectedList(province, closetime);
         
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
            
            //******************************
            /*r.eval("setwd('C:/Rstudy2')");*/
            r.eval("name_v <- NULL");
            r.eval("hour_v <- NULL");
            for(int i=0; i<list_res.size(); i++) {
               r.eval("name_v <- c(name_v," + "'" + list_res.get(i).getName() + "'" + ")");
            }
            
            for(int i=0; i<list_res.size(); i++) {
               r.eval("hour_v <- c(hour_v," + "'" + list_res.get(i).getBhours() + "'" + ")");
            }
            r.eval("msg <- paste(name_v, hour_v, sep='  ')");
           /* r.eval("pp <- cbind(name_v,hour_v)");
            
            r.eval("write.csv(pp, 'pp.csv')");*/
            
            //******************************
            
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
            /*r.eval("map5<-leaflet()%>%addTiles()%>%setView(lng = seoul_lonlat[1], lat = seoul_lonlat[2], zoom=11)%>% addCircles(lng=mk_lon1, lat=mk_lat1, color='black')");*/
            
            /*r.eval("map5<-leaflet() %>% setView(lng = seoul_lonlat[1], lat = seoul_lonlat[2], zoom = 11) %>%addTiles() %>%addMarkers(lng = mk_lon1, lat = mk_lat1, popup = msg)");*/
            r.eval("map5<-leaflet() %>% setView(lng = mean(mk_lon1), lat = mean(mk_lat1), zoom = 13) %>%addTiles() %>%addMarkers(lng = mk_lon1, lat = mk_lat1, popup = msg)");
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
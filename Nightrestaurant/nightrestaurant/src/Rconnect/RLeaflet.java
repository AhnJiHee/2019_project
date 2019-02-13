package Rconnect;

import org.rosuda.REngine.Rserve.RConnection;

public class RLeaflet {

   
      public String returnLeaflet2(String path)  {
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
            r.eval("setwd('C:/Rstudy')");
            r.eval("data <- read.csv('pagenew2.csv', stringsAsFactors = FALSE)");
            r.eval("msg <- paste(data$repl_v3, data$new_v,data$repl_cate,sep='  ')");
            r.eval("leaflet(data) %>% setView(lng = seoul_lonlat[1], lat = seoul_lonlat[2], zoom = 11) %>% addTiles() %>% addCircles(lng = ~mk_lon, lat=~mk_lat, popup = ~msg)");
            String fileName = path + "/index.html";
            String libPath = path + "/lib";
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
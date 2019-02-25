package Rconnect;
import org.rosuda.REngine.Rserve.RConnection;



public class RLeaflet2 {   
   public String returnLeaflet1(String path)  {
      RConnection r = null;
      String retStr = "";
      try {
         r = new RConnection(); 
         r.eval("library(dplyr)");
         r.eval("library(tmap)");
         r.eval("library(leaflet)");
         r.eval("library(Kormaps)");
         r.eval("library(htmltools)");
         r.eval("food <- read.csv('c:/Rstudy2/2019food.csv')");

         r.eval("Encoding(names(korpopmap2))<-'UTF-8'");
         r.eval("Encoding(korpopmap2@data$name)<-'UTF-8'");
         r.eval("Encoding(korpopmap2@data$����������_���鵿)<-'UTF-8'");
         r.eval("korpopmap2@data <- korpopmap2@data[-26:-251,]");
         r.eval("korpopmap2@polygons<-korpopmap2@polygons[-26:-251]");
         r.eval("mymap <- korpopmap2@data");
         r.eval("palette1<-colorNumeric(palette = 'Oranges', domain = food$�ɾ߽Ĵ�)");
         r.eval("popup1 <- paste0(mymap$name,'<br> ������ : ',food$�ɾ߽Ĵ�, '��')");
         String baseMap = "map1<-leaflet(korpopmap2)%>%" + "addTiles()%>%"
               + "setView(lat=37.559957 ,lng=126.975302 , zoom=11)%>%";
            r.eval(baseMap
               + "addPolygons(stroke=FALSE,smoothFactor=0.2,fillOpacity=.5, popup=popup1, color=~palette1(food$�ɾ߽Ĵ�), group='�Ĵ�')");
         String fileName = path + "/index2.html";
         String libPath = path + "/lib2";
         r.eval("save_html(map1,'" + fileName + "', libdir = '" + libPath + "')");
         retStr = r.eval("'index2.html'").asString();
      } catch (Exception e) {
         System.out.println(e);
         e.printStackTrace();
      } finally {
         r.close(); 
      }
      return retStr;
   }
}   
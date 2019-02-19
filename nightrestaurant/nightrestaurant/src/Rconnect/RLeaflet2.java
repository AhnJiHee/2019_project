package Rconnect;
import org.rosuda.REngine.Rserve.RConnection;
public class RLeaflet2 {	
	public String returnLeaflet1(String path, String type)  {
		RConnection r = null;
		String retStr = "";
		try {
			r = new RConnection(); 
			r.eval("library(dplyr)");
			r.eval("library(tmap)");
			r.eval("library(leaflet)");
			r.eval("library(Kormaps)");
			r.eval("library(htmltools)");
			r.eval("food <- read.csv('c:/Rstudy/2019food.csv')");

			r.eval("Encoding(names(korpopmap2))<-'UTF-8'");
			r.eval("Encoding(korpopmap2@data$name)<-'UTF-8'");
			r.eval("Encoding(korpopmap2@data$?ñâ?†ïÍµ¨Ïó≠Î≥?_?ùçÎ©¥Îèô)<-'UTF-8'");
			r.eval("korpopmap2@data <- korpopmap2@data[-26:-251,]");
			r.eval("korpopmap2@polygons<-korpopmap2@polygons[-26:-251]");
			r.eval("mymap <- korpopmap2@data");
			r.eval("palette1<-colorNumeric(palette = 'Oranges', domain = food$?ã¨?ïº?ãù?ãπ)");
			r.eval("popup1 <- paste0(mymap$name,'<br> ?òÅ?óÖÏ§? : ',food$?ã¨?ïº?ãù?ãπ, 'Í∞?')");
			String baseMap = "map1<-leaflet(korpopmap2)%>%" + "addTiles()%>%"
					+ "setView(lat=37.559957 ,lng=126.975302 , zoom=11)%>%";
			if(type.equals("?ãù?ãπ"))
				r.eval(baseMap
					+ "addPolygons(stroke=FALSE,smoothFactor=0.2,fillOpacity=.5, popup=popup1, color=~palette1(food$?ã¨?ïº?ãù?ãπ), group='?ãù?ãπ')");
			String fileName = path + "/index.html";
			String libPath = path + "/lib";
			r.eval("save_html(map1,'" + fileName + "', libdir = '" + libPath + "')");
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

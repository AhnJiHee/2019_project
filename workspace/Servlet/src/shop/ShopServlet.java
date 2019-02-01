package shop;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ProductVO;

public class ShopServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String file = "";
		String menu = request.getParameter("menu");
		
		if ( menu == null) {
			file = "JSP/start.jsp";
		} else {
			file = "JSP/" + menu + ".jsp";
		}
		
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();
		list.add(new ProductVO(1000, "삼성에어컨", 1000000, 10));
		list.add(new ProductVO(2000, "엘지에어컨", 2100000, 20));
		list.add(new ProductVO(3000, "멀티컴퓨터", 3000000, 10));
		list.add(new ProductVO(4000, "멀티라면", 1000, 1000));
		list.add(new ProductVO(5000, "멀티맥주", 2000, 100));
		
		request.setAttribute("productlist", list);
		RequestDispatcher rd = request.getRequestDispatcher(file);
		rd.forward(request, response);
		
		
	}

}

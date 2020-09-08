package joyou.Products.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import joyou.Products.dao.ProductsDao;
import joyou.util.HibernateUtil;


@WebServlet("/ProductsDeleteServlet.do")
@javax.servlet.annotation.MultipartConfig
public class ProductsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		String strId = request.getParameter("productsId");	
		int pId = Integer.parseInt(strId);
		
		ProductsDao pDao = new ProductsDao();
		boolean result = pDao.delete(pId);
		
		if(result) {
			request.setAttribute("DeleteMsg", "Delete Success!");
		}else {
			request.setAttribute("DeleteMsg", "Delete UnSuccess!");
		}
	}

}

package joyou.Products.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import joyou.Products.dao.ProductsDao;
import joyou.Products.model.ProductsBean;
import joyou.util.HibernateUtil;

@WebServlet("/ProductsGetServlet.do")
@javax.servlet.annotation.MultipartConfig
public class ProductsGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int pageNo;
      

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		
		String pageStr = request.getParameter("pageNo");
		if(pageStr==null) {
			pageNo=1;
		}

		ProductsDao pDao = new ProductsDao(session);
		List<ProductsBean> pageBean = pDao.selectByPage(pageNo);
		session.getTransaction().commit();
		request.setAttribute("products_DPP", pageBean);
		request.getRequestDispatcher("ProductsMaintainPage.jsp").forward(request, response);;
		
	}

}

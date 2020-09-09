package joyou.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import joyou.Products.dao.ProductsDao;
import joyou.Products.model.ProductsBean;

@WebServlet("/showImgServlet.do")
@javax.servlet.annotation.MultipartConfig
public class ShowImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Blob imgB;
	private String imgName;
	private String newName;
	private ServletOutputStream outSream;
	private InputStream isImg;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		try {
		System.out.println(35);
		String strid = request.getParameter("id");
		System.out.println(strid);
		String type = request.getParameter("type");
		System.out.println(type);
		if(type.equals("Product")) {
			int id = Integer.parseInt(strid);
			ProductsDao pDao = new ProductsDao(session);
			ProductsBean pBean = pDao.selectbyId(id);
			if(pBean!=null) {
				imgB=pBean.getProductImg();
				isImg=imgB.getBinaryStream();
				imgName=pBean.getImgName();
			}
			
		}
		newName=getServletContext().getMimeType(imgName);
		response.setContentType(newName);
		outSream=response.getOutputStream();
		System.out.println(isImg);
		int len = 0;
		byte[] bytes = new byte[8192];
		while ((len = isImg.read(bytes)) != -1) {
			outSream.write(bytes, 0, len);
		}
		
		session.getTransaction().commit();

		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			isImg.close();
			outSream.close();
		}
	}

	
}

package joyou.Products.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import joyou.Products.dao.FileDao;
import joyou.Products.dao.ProductsDao;
import joyou.Products.model.ProductsBean;
import joyou.util.HibernateUtil;

@WebServlet("/ProductsUpdateServlet.do")
@javax.servlet.annotation.MultipartConfig
public class ProductsUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductsDao pDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();

		try {
			String name = "";
			String namestr = "";
			Integer stock = 0;
			Integer price = 0;
			String age = "";
			String agestr = "";
			Integer gametype = 0;
			String lang = "";
			String langstr = "";
			String stockstr = "";
			String pricestr = "";
			String gametypestr = "";
			String fileName = "";
			long sizeInBytes = 0;
			InputStream is = null;

			Collection<Part> parts = request.getParts();
			if (parts != null) {
				for (Part p : parts) {
					String fldName = p.getName();
					String value = request.getParameter(fldName);
					if (p.getContentType() == null) {
//					System.out.println(58);
						if (fldName.equals("name")) {
							namestr = value;
							name = namestr;
							request.setAttribute("name", name);
//						System.out.println(62);
						} else if (fldName.equals("stock")) {
							stockstr = value;
							stock = Integer.parseInt(stockstr);
							request.setAttribute("stock", stock);

						} else if (fldName.equals("price")) {
							pricestr = value;
							price = Integer.parseInt(pricestr);
							request.setAttribute("price", price);

						} else if (fldName.equals("age")) {
							agestr = value;
							age = agestr;
							request.setAttribute("age", age);

						} else if (fldName.equals("gametype")) {
							gametypestr = value;
							gametype = Integer.parseInt(gametypestr);
							request.setAttribute("gametype", gametype);

						} else if (fldName.equals("lang")) {
							langstr = value;
							lang = langstr;
							request.setAttribute("lang", lang);
						}

					} else {
						fileName = FileDao.getFileName(p);
						FileDao.adjustFileName(fileName, FileDao.IMAGE_FILENAME_LENGTH);
						if (fileName != null && fileName.trim().length() > 0) {
							sizeInBytes = p.getSize();
							is = p.getInputStream();
						}
					}
				}
			}
			if (is == null) {   //假如沒有圖片資料
				ProductsBean pBean = new ProductsBean(name, stock, price, gametype, age, lang);
				pDao.insert(pBean);
			} else {
				Blob fileBlob = FileDao.fileToBlob(is, sizeInBytes);
				ProductsBean pBean = new ProductsBean(name, stock, price, gametype, age, lang, fileBlob);
				pDao = new ProductsDao(session);
				pDao.insert(pBean);
			}
			
			session.getTransaction().commit();
			request.setAttribute("p", "Update Success!");		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("p", "Update UnSuccess!");

		}
	}

}

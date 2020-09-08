package joyou.Members.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import joyou.Members.model.MembersBeanDao;
import joyou.util.HibernateUtil;

@WebServlet("/memberLogin.do")
public class TestLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String loginAcc;
	private String loginPwd;

	private Session session;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			processAction(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void processAction(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		loginAcc = request.getParameter("userAcc");
		loginPwd = request.getParameter("userPwd");

		System.out.println("userAcc=" + loginAcc);
		System.out.println("userPwd=" + loginPwd);

		SessionFactory factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
		session.beginTransaction();

		checkenter(request, response);
		session.close();
	}

	private void checkenter(ServletRequest request, ServletResponse response) throws SQLException, ServletException, IOException {

		MembersBeanDao md = new MembersBeanDao(session);
		boolean result = md.checkCorrectAccPwd(loginAcc, loginPwd);

		if (result) {
			request.setAttribute("p", "登入成功，請選擇搜尋條件");
			request.getRequestDispatcher("Success.jsp").forward(request, response);

		} else {
			request.setAttribute("p", "帳號或密碼錯誤");
			request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
		}
	}

}
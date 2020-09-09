package joyou.Members.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import joyou.Members.model.MembersBean;
import joyou.Members.model.MembersBeanDao;
import joyou.util.HibernateUtil;

@WebServlet("/MemberRegister.do")
public class TestRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PrintWriter out;
	private String userAcc;
	private String userPwd;
	private String userName;
	private String userPhone;
	private String userMail;
	private String userGender;
	private String userBirth;
	private String gameType;
//	private String md5Acc;
	private String md5Pwd;
	private Session session;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			response.setContentType("text/html;charset=UTF-8");
			out = response.getWriter();

			request.setCharacterEncoding("UTF-8");

			userAcc = request.getParameter("userAcc");
			userPwd = request.getParameter("userpwd");
//			userName = request.getParameter("userName");
//			userPhone = request.getParameter("userphone");
			userMail = request.getParameter("usermail");
//			userGender = request.getParameter("usergender");
//			userBirth = request.getParameter("userbirth");
//			gameType = request.getParameter("gametype");
//			md5Acc = changeMD5(userAcc);
//			md5Pwd = changeMD5(userPwd);

			checkInsertData(request, response);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.close();
	}

	private void checkInsertData(HttpServletRequest request, HttpServletResponse response) // 判斷帳號是否重複若無則寫入資料庫
			throws IOException, SQLException, ServletException {

		SessionFactory factory = HibernateUtil.getSessionFactory();

		session = factory.openSession();
		session.beginTransaction();

		MembersBeanDao md1 = new MembersBeanDao(session);
		boolean result = md1.checkDuplicateAccount(userAcc);
		boolean result2 = md1.checkDuplicateMail(userMail);

		if (userAcc.trim().equals("") || userPwd.trim().equals("")) {
//		if (userAcc.trim().equals("") || userPwd.trim().equals("") || userName.trim().equals("") || userPhone.trim().equals("")
//				|| userMail.trim().equals("") || userGender.trim().equals("") || userBirth.trim().equals("") || gameType.trim().equals("")) {

			request.setAttribute("p", "欄位不可空白");
			request.getRequestDispatcher("RegisterPage.jsp").forward(request, response);

		} else if (result) {
			request.setAttribute("p", "帳號重複"); // 設定傳值
			request.getRequestDispatcher("RegisterPage.jsp").forward(request, response);

		} else if (!result && userAcc != null && userAcc.length() > 0 && userPwd != null && userPwd.length() > 0) {
//		} else if (!result && userAcc != null && userAcc.length() > 0 && userPwd != null && userPwd.length() > 0 && userName != null
//				&& userName.length() > 0 && userPhone != null && userPhone.length() > 0 && userMail != null && userMail.length() > 0
//				&& userGender != null && userGender.length() > 0 && userBirth != null && userBirth.length() > 0 && gameType != null
//				&& gameType.length() > 0) {

			MembersBeanDao md2 = new MembersBeanDao(session);
			MembersBean mBean = new MembersBean(userAcc, userPwd);
//			MemberBean mBean = new MemberBean(userAcc, userName, md5Pwd, userGender, userPhone, gameType, userMail, userBirth);
			md2.insert(mBean);
			session.getTransaction().commit();

			request.setAttribute("p", "註冊成功請登入");
			request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
		}
	}

}

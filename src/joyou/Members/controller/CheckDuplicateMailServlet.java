package joyou.Members.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.google.gson.Gson;

import joyou.Members.model.MembersBeanDao;
import joyou.util.HibernateUtil;

@WebServlet("/CheckDuplicateMailServlet")
public class CheckDuplicateMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Session session;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberMail = request.getParameter("mail");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// String id = "";
		Gson gson = new Gson();
		Map<String, String> map = new HashMap<>();
		if (memberMail != null && memberMail.trim().length() != 0) {
			try {
				// MemberService service = new MemberServiceImpl();
				// id = service.checkMemberId(memberId);
				// map.put("id", id);
				SessionFactory factory = HibernateUtil.getSessionFactory();

				session = factory.openSession();
				session.beginTransaction();

				MembersBeanDao md1 = new MembersBeanDao(session);
				Boolean result2 = new Boolean(md1.checkDuplicateAccount(memberMail));
				map.put("memberMailisDuplicate", result2.toString());

				session.getTransaction().commit();
				session.close();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		out.println(gson.toJson(map));
		out.close();
	}

}

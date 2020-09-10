package joyou.Members.controller;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import joyou.Members.model.MembersBean;

public class TestMail {

	public void send(MembersBean mbean) {
		String host = "smtp.gmail.com";
		int port = 587;
		final String username = "eeit117G1@gmail.com";
		final String password = "java11736";

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", port);
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mbean.getMail()));
			message.setSubject("安安這是一封驗證信");
			message.setText(
					"註冊帳號:" + mbean.getAccount() + "\r\n" + "驗證碼:" + mbean.getVerified() + "\r\n" + "\r\n" + "\r\n" + "臣亮言：先帝創業未半，而中道崩殂。今天下三分，益州\r\n"
							+ "疲弊，此誠危急存亡之秋也。然侍衛之臣，不懈於內；忠志之\r\n" + "士，忘身於外者，蓋追先帝之殊遇，欲報之於陛下也。誠宜開\r\n" + "張聖聽，以光先帝遺德，恢弘志士之氣；不宜妄自菲薄，引喻\r\n"
							+ "失義，以塞忠諫之路也。宮中府中，俱為一體，陟罰臧否，不\r\n" + "宜異同。若有作姦犯科，及為忠善者，宜付有司，論其刑賞，\r\n" + "以昭陛下平明之治，不宜篇私，使內外異法也。");

			Transport transport = session.getTransport("smtp");
			transport.connect(host, port, username, password);

			Transport.send(message);

			System.out.println("寄送email結束.");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}

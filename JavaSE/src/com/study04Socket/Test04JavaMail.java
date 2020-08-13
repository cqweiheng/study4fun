package com.study04Socket;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.StringTokenizer;

public class Test04JavaMail {

	public static void main(String[] args) throws MessagingException {
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.auth", "true");
		props.put("mail.smtps.host", "smtp.qq.com");
		props.put("mail.smtps.user", "812821266@qq.com");
		Session mailSession = Session.getDefaultInstance(props);

		MimeMessage message = new MimeMessage(mailSession);
		message.setFrom(new InternetAddress("812821266@qq.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("2966348692@qq.com"));
		message.setSubject("测试JavaMail");
		message.setText("邮件发送内容test");

		Transport tr = mailSession.getTransport();
		tr.connect(null, "fkhqbetfpttmbced");
		tr.sendMessage(message, message.getAllRecipients());
		tr.close();

		StringTokenizer stringTokenizer = new StringTokenizer("", " ");
	}
}

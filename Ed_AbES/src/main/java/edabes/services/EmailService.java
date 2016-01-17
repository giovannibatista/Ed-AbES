package edabes.services;

import java.security.Security;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailService {
	@Autowired
	private MailSender mailSender;

	// @Autowired
	// private SimpleMailMessage preConfiguredMessage;

	private String mailhost = "smtp.gmail.com";

	/** Metodo para enviar um email
     * @param  String recipients - email destinatário
     * @param  String subject - assunto do email
     * @param  String body - mensagem do email
     * @return boolean usuarioCadastrado - retorna true se o usuario foi cadastrado corretamente
     */
	public boolean sendMail(String recipients, String subject, String body) {

		boolean emailEnviado = false;
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

		String sender = "sistemaedabes@gmail.com";
				
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.host", mailhost);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "25");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.quitwait", "false");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication("sistemaedabes@gmail.com",
								"edabes!@#");
					}
				});

		try {
			Transport transport = session.getTransport("smtp");
			transport.connect("sistemaedabes@gmail.com", "edabes!@#");
			MimeMessage message = new MimeMessage(session);
			message.setSender(new InternetAddress(sender));
			message.setSubject(subject);
			message.setContent(body, "text/plain");
			if (recipients.indexOf(',') > 0) {
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));
			} else {
				message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipients));
			}
			
			transport.sendMessage(message, message.getAllRecipients());
			emailEnviado = true;
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emailEnviado;
	}

	/**
	 * This method will send a pre-configured message public void
	 * sendPreConfiguredMail(String message) { SimpleMailMessage mailMessage =
	 * new SimpleMailMessage(preConfiguredMessage);
	 * mailMessage.setText(message); mailSender.send(mailMessage); }
	 * */
}
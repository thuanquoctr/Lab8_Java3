package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import view.view_sendmail;

public class controller_sendemail implements ActionListener {
	private view_sendmail viewsend;
	String duongdan = "";

	public controller_sendemail(view_sendmail viewsend) {
		this.viewsend = viewsend;
	}

	public boolean checknull() {
		if (viewsend.txtto.getText().equals("")) {
			return false;
		}
		if (viewsend.txtsubject.getText().equals("")) {
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		if (event.equals("Send")) {
			if (checknull()) {
				final String from = viewsend.txtusername.getText();
				final String pass = viewsend.txtpass.getText();

				Properties pr = new Properties();
				pr.put("mail.smtp.host", "smtp.gmail.com");
				pr.put("mail.smtp.post", "587");
				pr.put("mail.smtp.auth", "true");
				pr.put("mail.smtp.starttls.enable", "true");

				// create authenticator : dang nhap gmail;
				Authenticator auth = new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
						return new PasswordAuthentication(from, pass);
					}
				};
				// phien lam viec;
				Session s = Session.getInstance(pr, auth);
				// nguoi nhan : to;
				final String to = viewsend.txtto.getText();
				// tao 1 tin nhan;
				MimeMessage msg = new MimeMessage(s);
				try {
					// content: noi dung , texthtml : duoc gui code html va test , utf8;
					msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
					// nguoi gui;
					msg.setFrom(from);
					// nguoi nhan;
					msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
					msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(viewsend.txtcc.getText(), false));
					msg.setRecipients(Message.RecipientType.BCC,
							InternetAddress.parse(viewsend.txtbcc.getText(), false));
					msg.setSubject(viewsend.txtsubject.getText());
					msg.setSentDate(new Date());

					MimeMultipart mimeMultipart = new MimeMultipart();

					MimeBodyPart bodyPart = new MimeBodyPart();
					bodyPart.attachFile(new File(viewsend.txtfile.getText()));

					MimeBodyPart bodyPart1 = new MimeBodyPart();
					bodyPart1.setContent(viewsend.txtmess.getText(), "text/HTML; charset=UTF-8");

					mimeMultipart.addBodyPart(bodyPart);
					mimeMultipart.addBodyPart(bodyPart1);

					msg.setContent(mimeMultipart);

					Transport.send(msg);
					JOptionPane.showMessageDialog(null, "OK !");
					return;
				} catch (Exception eee) {
					JOptionPane.showMessageDialog(null, "Err !");
				}
			} else {
				JOptionPane.showMessageDialog(null, "To and Subject null !");
				return;
			}
		}
		if (event.equals("Đính kèm")) {
			try {
				JFileChooser f = new JFileChooser("D:\\");
				f.setDialogTitle("Mở file");
				f.showOpenDialog(null);
				f.setForeground(Color.red);
				File ftenanh = f.getSelectedFile();
				duongdan = ftenanh.getAbsolutePath();
				viewsend.txtfile.setText(duongdan);
			} catch (Exception e2) {
				// TODO: handle exception
			}

		}
	}
}

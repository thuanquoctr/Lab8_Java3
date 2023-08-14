package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controller.controller_sendemail;

public class view_sendmail extends JFrame {
	public JLabel title, username, pass, to, subject, cc, bcc, mess;
	public JTextField txtusername, txtto, txtsubject, txtcc, txtbcc, txtfile;
	public JTextArea txtmess;
	public JButton btnsend, btndinhkem;
	public JPasswordField txtpass;
	public JPanel p1, p2;

	public view_sendmail() {
		this.setTitle("SendMail");
		this.setSize(800, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLayout(null);
		title = new JLabel("Send Mail");
		title.setFont(new Font("Serif", Font.BOLD, 40));
		title.setForeground(Color.RED);
		title.setBounds(305, 20, 200, 50);
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 5), "Send", TitledBorder.LEFT, TitledBorder.TOP,
				new Font("Serif", Font.BOLD, 20), Color.RED));
		p1.setBounds(140, 80, 500, 165);

		username = new JLabel("Username: ");
		username.setFont(new Font("Serif", Font.BOLD, 18));
		username.setForeground(Color.BLUE);
		username.setBounds(20, 40, 100, 30);
		p1.add(username);

		pass = new JLabel("PassWord: ");
		pass.setFont(new Font("Serif", Font.BOLD, 18));
		pass.setForeground(Color.BLUE);
		pass.setBounds(20, 95, 100, 30);
		p1.add(pass);

		txtusername = new JTextField("thuantqps31471@fpt.edu.vn");
		txtusername.setPreferredSize(new Dimension(300, 30));
		txtusername.setFont(new Font("Serif", Font.BOLD, 17));
		txtusername.setBounds(130, 40, 300, 30);
		p1.add(txtusername);

		txtpass = new JPasswordField();
		txtpass.setText("yipcomzrudwbstkj");
		txtpass.setPreferredSize(new Dimension(300, 30));
		txtpass.setFont(new Font("Serif", Font.BOLD, 17));
		txtpass.setBounds(130, 95, 300, 30);
		p1.add(txtpass);

		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 5), "Receive", TitledBorder.LEFT, TitledBorder.TOP,
				new Font("Serif", Font.BOLD, 20), Color.RED));
		p2.setBounds(140, 250, 500, 405);

		to = new JLabel("To: ");
		to.setFont(new Font("Serif", Font.BOLD, 18));
		to.setForeground(Color.BLUE);
		to.setBounds(20, 40, 50, 30);
		p2.add(to);

		txtto = new JTextField("binhtq7@fpt.edu.vn");
		txtto.setPreferredSize(new Dimension(300, 30));
		txtto.setFont(new Font("Serif", Font.BOLD, 17));
		txtto.setBounds(130, 40, 300, 30);
		p2.add(txtto);

		subject = new JLabel("Subject: ");
		subject.setFont(new Font("Serif", Font.BOLD, 18));
		subject.setForeground(Color.BLUE);
		subject.setBounds(20, 95, 100, 30);
		p2.add(subject);

		txtsubject = new JTextField();
		txtsubject.setPreferredSize(new Dimension(300, 30));
		txtsubject.setFont(new Font("Serif", Font.BOLD, 17));
		txtsubject.setBounds(130, 95, 300, 30);
		p2.add(txtsubject);

		mess = new JLabel("Message: ");
		mess.setFont(new Font("Serif", Font.BOLD, 18));
		mess.setForeground(Color.BLUE);
		mess.setBounds(20, 150, 100, 30);
		p2.add(mess);

		txtmess = new JTextArea(100, 0);
		JScrollPane js = new JScrollPane(txtmess);
		js.setPreferredSize(new Dimension(300, 80));
		txtmess.setFont(new Font("Serif", Font.BOLD, 17));
		js.setBounds(130, 150, 300, 80);
		p2.add(js);

		cc = new JLabel("CC: ");
		cc.setFont(new Font("Serif", Font.BOLD, 18));
		cc.setForeground(Color.BLUE);
		cc.setBounds(20, 250, 100, 30);
		p2.add(cc);

		bcc = new JLabel("BCC: ");
		bcc.setFont(new Font("Serif", Font.BOLD, 18));
		bcc.setForeground(Color.BLUE);
		bcc.setBounds(20, 300, 100, 30);
		p2.add(bcc);

		txtcc = new JTextField("binhtq7@fpt.edu.vn");
		txtcc.setPreferredSize(new Dimension(300, 30));
		txtcc.setFont(new Font("Serif", Font.BOLD, 17));
		txtcc.setBounds(130, 250, 300, 30);
		p2.add(txtcc);

		txtbcc = new JTextField("tqbinh@gmail.com");
		txtbcc.setPreferredSize(new Dimension(300, 30));
		txtbcc.setFont(new Font("Serif", Font.BOLD, 17));
		txtbcc.setBounds(130, 300, 300, 30);
		p2.add(txtbcc);

		btndinhkem = new JButton("Đính kèm");
		btndinhkem.setFont(new Font("Serif", Font.BOLD, 18));
		btndinhkem.setForeground(Color.BLUE);
		btndinhkem.setBounds(20, 350, 130, 30);
		p2.add(btndinhkem);

		txtfile = new JTextField();
		txtfile.setPreferredSize(new Dimension(250, 30));
		txtfile.setFont(new Font("Serif", Font.BOLD, 17));
		txtfile.setBounds(180, 350, 250, 30);
		p2.add(txtfile);

		btnsend = new JButton("Send");
		btnsend.setFont(new Font("Serif", Font.BOLD, 25));
		btnsend.setForeground(Color.BLUE);
		btnsend.setBounds(300, 680, 150, 40);

		ActionListener ac = new controller_sendemail(this);
		btnsend.addActionListener(ac);
		btndinhkem.addActionListener(ac);

		this.add(title);
		this.add(p1);
		this.add(p2);
		this.add(btnsend);

	}

}

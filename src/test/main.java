package test;

import javax.swing.UIManager;

import view.view_sendmail;

public class main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			view_sendmail v = new view_sendmail();
			v.setVisible(true);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

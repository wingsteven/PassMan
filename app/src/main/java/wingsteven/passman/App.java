package wingsteven.passman;

import java.awt.EventQueue;

public class App {
    static final String GREETING = "Welcome to PassMan, the passphrase manager!";

	public String getGreeting() {
        return GREETING;
    }

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmPassman.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

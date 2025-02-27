package wingsteven.passman;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.KeyEvent;

public class MainWindow {

	private JFrame frmPassman;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPassman = new JFrame();
		frmPassman.setTitle("Passman");
		frmPassman.setBounds(100, 100, 450, 300);
		frmPassman.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_4 = new JPanel();
		frmPassman.getContentPane().add(panel_4, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frmPassman.setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(fileMenu);
		
		JMenu newMenu = new JMenu("New");
		newMenu.setMnemonic(KeyEvent.VK_N);
		fileMenu.add(newMenu);
		
		JMenuItem newPassphrase = new JMenuItem("Passphrase");
		newPassphrase.setMnemonic(KeyEvent.VK_P);
		newMenu.add(newPassphrase);
		
		JMenuItem newVault = new JMenuItem("Vault");
		newVault.setMnemonic(KeyEvent.VK_V);
		newMenu.add(newVault);
		
		JMenuItem openVault = new JMenuItem("Open Vault");
		openVault.setMnemonic(KeyEvent.VK_O);
		fileMenu.add(openVault);
		
		JMenu optionsMenu = new JMenu("Options");
		optionsMenu.setMnemonic(KeyEvent.VK_O);
		menuBar.add(optionsMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		optionsMenu.add(mntmNewMenuItem_2);
	}

}

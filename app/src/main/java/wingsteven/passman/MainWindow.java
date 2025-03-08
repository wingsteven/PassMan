package wingsteven.passman;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.KeyEvent;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class MainWindow {

	JFrame frmPassman;

	/**
	 * Launch the application.
	 */
	

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
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.setMnemonic(KeyEvent.VK_X);
		fileMenu.add(exit);
		
		JMenu optionsMenu = new JMenu("Options");
		optionsMenu.setMnemonic(KeyEvent.VK_O);
		menuBar.add(optionsMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		optionsMenu.add(mntmNewMenuItem_2);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		frmPassman.getContentPane().add(panel, BorderLayout.CENTER);
		
		JButton generatePassphraseButton = new JButton("Generate Passphrase");
		panel.add(generatePassphraseButton);
		
		JButton createVaultButton = new JButton("Create Vault");
		panel.add(createVaultButton);
		
		JButton openVaultButton = new JButton("Open Vault");
		panel.add(openVaultButton);
	}

}

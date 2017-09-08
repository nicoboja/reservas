
package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainWindows {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindows window = new MainWindows();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindows() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(65, 105, 170));
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnPersona = new JMenu("Personas");
		menuBar.add(mnPersona);
		
		JMenuItem mntmGestionar = new JMenuItem("Gestionar Personas");
		mnPersona.add(mntmGestionar);
		
		JMenu mnElementos = new JMenu("Elementos");
		menuBar.add(mnElementos);
		
		JMenuItem mntmGestionarElementos = new JMenuItem("Gestionar Elementos");
		mnElementos.add(mntmGestionarElementos);
		
		JMenu mnReservas = new JMenu("Reservas");
		menuBar.add(mnReservas);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Gestionar Reservas");
		mnReservas.add(mntmNewMenuItem);
	}
}

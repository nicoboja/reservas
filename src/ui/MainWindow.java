package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;

public class MainWindow {

	private JFrame frame;
	private JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
					Login login = new Login();
					login.setVisible(true);
					login.setAlwaysOnTop(true);
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
		frame = new JFrame();
		frame.setBounds(100, 100, 678, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnuPersona = new JMenu("Persona");
		menuBar.add(mnuPersona);
		
		JMenuItem mnuGestionarPersonas = new JMenuItem("Gestionar Personas");
		mnuGestionarPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuABMCPersonaClick();
			}
		});
		mnuPersona.add(mnuGestionarPersonas);
		
		JMenu mnElementos = new JMenu("Elementos");
		menuBar.add(mnElementos);
		
		JMenuItem mntmGestionarElementos = new JMenuItem("Gestionar Elementos");
		mntmGestionarElementos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnuABMCElementoClick();
			}
		});
		mnElementos.add(mntmGestionarElementos);
		
		JMenu mnReservacs = new JMenu("Reservas");
		menuBar.add(mnReservacs);
		
		JMenuItem mntmGestionarReservas = new JMenuItem("Gestionar Reservas");
		mnReservacs.add(mntmGestionarReservas);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
	}

	protected void mnuABMCPersonaClick() {
		ABMCPersonaDesktop pd= new ABMCPersonaDesktop();
		desktopPane.add(pd);
		pd.setVisible(true);
	}
	protected void mnuABMCElementoClick() {
		ABMCElementoDesktop pd= new ABMCElementoDesktop();
		desktopPane.add(pd);
		pd.setVisible(true);
	}
}
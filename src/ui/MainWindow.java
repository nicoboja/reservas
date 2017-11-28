package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlers.CtrlABMPersona;
import entity.Persona;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainWindow {
	public int idPersona;
	private CtrlABMPersona ctrl=new CtrlABMPersona();
	
	private JFrame frame;
	private JDesktopPane desktopPane;
	private JTextField txtUsuario;
	private JPasswordField passField;
		
	JPanel panelLog = new JPanel();
	JMenu mnuPersona = new JMenu("Persona");
	JMenu mnElementos = new JMenu("Elementos");
	JMenu mnReservas = new JMenu("Reservas");
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
		
		
		mnuPersona.setEnabled(false);
		menuBar.add(mnuPersona);
		
		JMenuItem mnuGestionarPersonas = new JMenuItem("Gestionar Personas");
		mnuGestionarPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuABMCPersonaClick();
			}
		});
		mnuPersona.add(mnuGestionarPersonas);
		
		JMenuItem mntmListadoPersonas = new JMenuItem("Listado Personas");
		mntmListadoPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuListadoPersonaClick();
				
			}
		});
		mnuPersona.add(mntmListadoPersonas);
		
		mnElementos.setEnabled(false);
		menuBar.add(mnElementos);
		
		JMenuItem mntmGestionarElementos = new JMenuItem("Gestionar Elementos");
		mntmGestionarElementos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnuABMCElementoClick();
			}
		});
		mnElementos.add(mntmGestionarElementos);
		
		JMenuItem mntmTiposElementos = new JMenuItem("Tipos Elementos");
		
		mntmTiposElementos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnuABMCTiposElementosClick();
			}
		});
		mnElementos.add(mntmTiposElementos);
		
		mnReservas.setEnabled(false);
		menuBar.add(mnReservas);
		
		JMenuItem mntmGestionarReservas = new JMenuItem("Nueva Reserva");
		mntmGestionarReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mnuGestionarReservasClicked();
			}
		});
		
		mnReservas.add(mntmGestionarReservas);
		
		JMenuItem mntmReservasPendientes = new JMenuItem("Reservas Pendientes");
		mntmReservasPendientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mnuListadoReservasClick();
			}
		});
		
		mnReservas.add(mntmReservasPendientes);
		
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		panelLog.setBounds(121, 76, 423, 187);
		desktopPane.add(panelLog);
		panelLog.setLayout(null);
		
		JLabel lblIngresarAlSistema = new JLabel("Ingresar al Sistema");
		lblIngresarAlSistema.setBounds(152, 5, 119, 16);
		panelLog.add(lblIngresarAlSistema);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(113, 55, 219, 26);
		panelLog.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		passField = new JPasswordField();
		passField.setBounds(113, 93, 219, 26);
		panelLog.add(passField);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(27, 60, 61, 16);
		panelLog.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña");
		lblContrasea.setBounds(27, 98, 95, 16);
		panelLog.add(lblContrasea);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					log();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnIngresar.setBounds(215, 135, 117, 29);
		panelLog.add(btnIngresar);
		
	}

	protected void mnuGestionarReservasClicked() {
		ABMCReservaDesktop pd= new ABMCReservaDesktop((idPersona));
		desktopPane.add(pd);
		pd.setVisible(true);		
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

	protected void mnuABMCTiposElementosClick(){
		ABMCTipoElementoDesktop pd= new ABMCTipoElementoDesktop();
		desktopPane.add(pd);
		pd.setVisible(true);
	}
	protected void mnuListadoPersonaClick(){
		ListadoPersonas pd= new ListadoPersonas();
		desktopPane.add(pd);
		pd.setVisible(true);
	}
	protected void mnuListadoReservasClick(){
		ListadoReservas pd= new ListadoReservas(idPersona);
		desktopPane.add(pd);
		pd.setVisible(true);
	}
	protected void log() throws Exception {
		try {
			idPersona = ctrl.logueo(this.mapearDeForm());
			System.out.println(idPersona);
			if(idPersona!=-1){
				mnuPersona.setEnabled(true);
				mnReservas.setEnabled(true);
				mnElementos.setEnabled(true);
				panelLog.setVisible(false);
				
			}else{
				JOptionPane.showInternalMessageDialog(desktopPane, this, "Error en Usuario o Contraseña ", idPersona);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			JOptionPane.showInternalMessageDialog(desktopPane, this, "Error de Usuario o Pass ", idPersona);
		}
		 
	}
	
	private Persona mapearDeForm(){
		Persona p=new Persona();
		if(!this.txtUsuario.getText().isEmpty()){
		p.setUss(this.txtUsuario.getText());
		//System.out.println(p.getUss()+"mapeo");
		}
		if(!this.passField.getText().isEmpty()){
			p.setPass(this.passField.getText());
			//System.out.println(p.getPass()+"mapeo");
		}
		return p;
	}
}

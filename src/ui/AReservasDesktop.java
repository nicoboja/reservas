package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AReservasDesktop extends JFrame {

	private JPanel contentPane;
	private JTextField txtFechaInicio;
	private JTextField txtHoraInicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AReservasDesktop frame = new AReservasDesktop();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AReservasDesktop() {
		setTitle("Gestion de Reservas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipoDeElemento = new JLabel("Tipo de Elemento");
		lblTipoDeElemento.setBounds(32, 29, 90, 14);
		contentPane.add(lblTipoDeElemento);
		
		JLabel lblFechaInicio = new JLabel("Fecha de inicio");
		lblFechaInicio.setBounds(32, 63, 90, 14);
		contentPane.add(lblFechaInicio);
		
		JLabel lblHoraDeInicio = new JLabel("Hora de inicio");
		lblHoraDeInicio.setBounds(32, 96, 111, 14);
		contentPane.add(lblHoraDeInicio);
		
		txtFechaInicio = new JTextField();
		txtFechaInicio.setBounds(132, 60, 111, 20);
		contentPane.add(txtFechaInicio);
		txtFechaInicio.setColumns(10);
		
		txtHoraInicio = new JTextField();
		txtHoraInicio.setBounds(132, 93, 111, 20);
		contentPane.add(txtHoraInicio);
		txtHoraInicio.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(132, 26, 188, 20);
		contentPane.add(comboBox);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(231, 134, 89, 23);
		contentPane.add(btnAceptar);
	}
}

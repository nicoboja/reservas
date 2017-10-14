package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import controlers.CtrlABMReserva;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import entity.Reserva;
import entity.TipoElemento;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.Time;

public class ABMCReservaDesktop extends JInternalFrame {
	
	private CtrlABMReserva ctrl=new CtrlABMReserva();
	
	private JComboBox cboTipo;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JTextField txtCantHoras;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCReservaDesktop frame = new ABMCReservaDesktop();
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
	public ABMCReservaDesktop() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		cboTipo = new JComboBox();
		cboTipo.setBounds(161, 38, 139, 20);
		getContentPane().add(cboTipo);
		
		JLabel lblTipo = new JLabel("Tipo Elemento");
		lblTipo.setBounds(53, 41, 81, 14);
		getContentPane().add(lblTipo);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(53, 86, 46, 14);
		getContentPane().add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(53, 131, 46, 14);
		getContentPane().add(lblHora);
		
		JLabel lblCantidadHoras = new JLabel("Cantidad Horas");
		lblCantidadHoras.setBounds(53, 184, 98, 14);
		getContentPane().add(lblCantidadHoras);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(161, 83, 117, 20);
		getContentPane().add(txtFecha);
		txtFecha.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setBounds(161, 128, 73, 20);
		getContentPane().add(txtHora);
		txtHora.setColumns(10);
		
		txtCantHoras = new JTextField();
		txtCantHoras.setBounds(161, 181, 73, 20);
		getContentPane().add(txtCantHoras);
		txtCantHoras.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				aceptarClick();
			}
		});
		btnAceptar.setBounds(329, 183, 73, 23);
		getContentPane().add(btnAceptar);
		
		cargarListas();
	}
	
	private void cargarListas() {
		try {			
			this.cboTipo.setModel(new DefaultComboBoxModel(ctrl.getTipos().toArray()));
			this.cboTipo.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	private void aceptarClick(){
		Reserva r = this.mapearDeForm();
		try{
			ctrl.add(r);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}		
	}
	
	private Reserva mapearDeForm(){
		Reserva r=new Reserva();
		
		if (cboTipo.getSelectedIndex() != -1){
			r.setTipo((TipoElemento)this.cboTipo.getSelectedItem());
		}
		
		r.setFecha(Date.valueOf(this.txtFecha.getText()));
		r.setHora(Time.valueOf(this.txtHora.getText()));
		r.setCantHoras(Integer.parseInt(this.txtCantHoras.getText()));	
		
		return r;
		
	}		
}

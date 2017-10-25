package ui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import controlers.CtrlABMReserva;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import entity.Elemento;
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
	private JComboBox cboElemento;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JTextField txtCantHoras;
	private JButton btnAceptar;
	private JButton btnOk;
	private JTextField txtDetalle;

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
		cboTipo.setBounds(161, 23, 139, 20);
		getContentPane().add(cboTipo);
		
		JLabel lblTipo = new JLabel("Tipo Elemento");
		lblTipo.setBounds(53, 26, 81, 14);
		getContentPane().add(lblTipo);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(53, 106, 46, 14);
		getContentPane().add(lblFecha);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setBounds(263, 106, 37, 14);
		getContentPane().add(lblHora);
		
		JLabel lblCantidadHoras = new JLabel("Cantidad Horas");
		lblCantidadHoras.setBounds(53, 147, 98, 14);
		getContentPane().add(lblCantidadHoras);
		
		txtFecha = new JTextField();
		txtFecha.setEnabled(false);
		txtFecha.setBounds(142, 103, 89, 20);
		getContentPane().add(txtFecha);
		txtFecha.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setEnabled(false);
		txtHora.setBounds(300, 103, 53, 20);
		getContentPane().add(txtHora);
		txtHora.setColumns(10);
		
		txtCantHoras = new JTextField();
		txtCantHoras.setEnabled(false);
		txtCantHoras.setBounds(142, 144, 73, 20);
		getContentPane().add(txtCantHoras);
		txtCantHoras.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				aceptarClick();
			}
		});
		btnAceptar.setBounds(72, 236, 98, 23);
		getContentPane().add(btnAceptar);
		
		JLabel lblElemento = new JLabel("Elemento");
		lblElemento.setBounds(53, 66, 60, 14);
		getContentPane().add(lblElemento);
		
		cboElemento = new JComboBox();
		cboElemento.setEnabled(false);
		cboElemento.setBounds(161, 63, 139, 20);
		getContentPane().add(cboElemento);
		
		btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				okTipoClick();
			}
		});
		btnOk.setBounds(329, 22, 60, 23);
		getContentPane().add(btnOk);
		
		JLabel lblDetalle = new JLabel("Detalle");
		lblDetalle.setBounds(53, 193, 60, 14);
		getContentPane().add(lblDetalle);
		
		txtDetalle = new JTextField();
		txtDetalle.setEnabled(false);
		txtDetalle.setBounds(142, 190, 195, 20);
		getContentPane().add(txtDetalle);
		txtDetalle.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(248, 236, 89, 23);
		getContentPane().add(btnCancelar);
		
		cargarListaTipos();
	}
	
	private void cargarListaTipos() {
		try {			
			this.cboTipo.setModel(new DefaultComboBoxModel(ctrl.getTipos().toArray()));
			this.cboTipo.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	private void cargarListaElementos() {
		try {			
			this.cboElemento.setModel(new DefaultComboBoxModel(ctrl.getElementos().toArray()));
			this.cboElemento.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	

	private void okTipoClick() {
		cargarListaElementos();
		cboElemento.setEnabled(true);
		txtFecha.setEnabled(true);
		txtHora.setEnabled(true);
		txtCantHoras.setEnabled(true);
		txtDetalle.setEnabled(true);
		btnAceptar.setEnabled(true);	
		cboTipo.setEnabled(false);
		btnOk.setEnabled(false);
		
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
		
		if (cboElemento.getSelectedIndex() != -1){
			r.setElem((Elemento)this.cboElemento.getSelectedItem());
		}
		
		r.setFecha(Date.valueOf(this.txtFecha.getText()));
		r.setHora(Time.valueOf(this.txtHora.getText()));
		r.setCantHoras(Integer.parseInt(this.txtCantHoras.getText()));	
		r.setDetalle(this.txtDetalle.getText());
		return r;
		
	}		
}

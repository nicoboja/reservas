package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlers.CtrlABMElemento;

import entity.TipoElemento;
import entity.Elemento;


import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ABMCElementoDesktop extends JInternalFrame {

	private CtrlABMElemento ctrl=new CtrlABMElemento();
	
	private JPanel contentPane;
	private JTextField txtElemento;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnModificar;
	private JTextField txtId;
	private JComboBox cboTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCElementoDesktop frame = new ABMCElementoDesktop();
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
	public ABMCElementoDesktop() {
		setTitle("Gestion de Elementos");
		setMaximizable(true);
		setClosable(true);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 377, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblElemento = new JLabel("Nombre");
		lblElemento.setBounds(25, 85, 81, 14);
		
		txtElemento = new JTextField();
		txtElemento.setBounds(119, 82, 163, 20);
		txtElemento.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(187, 16, 95, 37);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarClick();
			}
		});
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(35, 222, 85, 23);
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarClick();
			}
		});
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(137, 222, 83, 23);
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				borrarClick();
			}
		});
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(230, 222, 85, 23);
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificarClick();
			}
		});
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(25, 27, 11, 14);
		
		txtId = new JTextField();
		txtId.setBounds(40, 24, 86, 20);
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		JLabel lblTipoElemento = new JLabel("Tipo Elemento");
		lblTipoElemento.setBounds(25, 140, 95, 14);
		
		cboTipo = new JComboBox();
		cboTipo.setBounds(119, 137, 163, 20);
		contentPane.setLayout(null);
		contentPane.add(btnAgregar);
		contentPane.add(lblId);
		contentPane.add(txtId);
		contentPane.add(btnBuscar);
		contentPane.add(btnBorrar);
		contentPane.add(btnModificar);
		contentPane.add(lblTipoElemento);
		contentPane.add(lblElemento);
		contentPane.add(cboTipo);
		contentPane.add(txtElemento);
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

	protected void buscarClick() {
		try {
			this.mapearAForm(ctrl.getByNombre(this.mapearDeForm()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
	}
	
	protected void agregarClick() {
		Elemento e = this.mapearDeForm();
		try{
			ctrl.add(e);
			JOptionPane.showMessageDialog(this, " Se cargo el elemento: "+ e.getNombre());
			this.limpiarForm();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
		this.txtId.setText(String.valueOf(e.getId()));		
	}
	
	protected void borrarClick(){
		try{
			ctrl.delete(this.mapearDeForm());
			JOptionPane.showMessageDialog(this, " Se borro el elemento");
			this.limpiarForm();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	protected void modificarClick(){
		try{
			ctrl.update(this.mapearDeForm());
			JOptionPane.showMessageDialog(this, " Se modifico el elemento");
			this.limpiarForm();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	private void mapearAForm(Elemento e){
		this.txtElemento.setText(e.getNombre());
		this.txtId.setText(String.valueOf(e.getId()));
		this.cboTipo.setSelectedItem(e.getTipoElem());
		
	}
	
	private Elemento mapearDeForm(){
		Elemento e = new Elemento();
		
		if(!this.txtId.getText().isEmpty()){
			e.setId(Integer.parseInt(this.txtId.getText()));
		}		
		e.setNombre(this.txtElemento.getText());

		
		if (cboTipo.getSelectedIndex() != -1){
			e.setTipoElem((TipoElemento)this.cboTipo.getSelectedItem());
		}
		return e;
	}
	
	public void showElemento(Elemento e){
		this.mapearAForm(e);
	}
	
	private void limpiarForm(){
		txtId.setText(null);
		txtElemento.setText(null);
		cboTipo.setSelectedIndex(-1);
	}
	
}

package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlers.CtrlABMElemento;
import controlers.CtrlABMTipoElemento;
import entity.Elemento;
import entity.TipoElemento;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class ABMCTipoElementoDesktop extends JFrame {
	
	private CtrlABMTipoElemento ctrl=new CtrlABMTipoElemento();

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCTipoElementoDesktop frame = new ABMCTipoElementoDesktop();
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
	public ABMCTipoElementoDesktop() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarClick();
			}
		});
		btnBuscar.setBounds(299, 54, 97, 25);
		contentPane.add(btnBuscar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarClick();
			}
		});
		btnAgregar.setBounds(23, 196, 97, 25);
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificarClick();
			}
		});
		btnModificar.setBounds(159, 196, 97, 25);
		contentPane.add(btnModificar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				borrarClick();
			}
		});
		btnBorrar.setBounds(299, 196, 97, 25);
		contentPane.add(btnBorrar);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setBounds(121, 26, 48, 22);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(74, 29, 18, 16);
		contentPane.add(lblId);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(121, 71, 116, 22);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(12, 74, 80, 16);
		contentPane.add(lblDescripcion);
	}
	
	protected void buscarClick() {
		try {
			this.mapearAForm(ctrl.getByNombre(this.mapearDeForm()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	protected void agregarClick() {
		TipoElemento te = this.mapearDeForm();
		try{
			ctrl.add(te);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
		this.txtId.setText(String.valueOf(te.getIdT()));		
	}
	
	protected void borrarClick(){
		try{
			ctrl.delete(this.mapearDeForm());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}
	
	protected void modificarClick(){
		try{
			ctrl.update(this.mapearDeForm());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}
	
	private void mapearAForm(TipoElemento te){
		
		this.txtId.setText(String.valueOf(te.getIdT()));
		this.txtDescripcion.setText(te.getDescripcion());
	}
	
	private TipoElemento mapearDeForm(){
		TipoElemento te=new TipoElemento();
		
		if(!this.txtId.getText().isEmpty()){
			te.setIdT(Integer.parseInt(this.txtId.getText()));
		}
	
		te.setDescripcion(this.txtDescripcion.getText());
		return te;
	}
	
	public void showElemento(TipoElemento te){
		this.mapearAForm(te);
	}
}
package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlers.CtrlABMElemento;
import entity.Elemento;
import entity.Persona;
import entity.TipoElemento;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;



public class ABMCElementoDesktop extends JInternalFrame {
	
	
	private CtrlABMElemento ctrl=new CtrlABMElemento();
	private Elemento currentElem=new Elemento();

	private JPanel contentPane;
	private JTextField txtIdElemento;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtIdElemento = new JTextField();
		txtIdElemento.setEnabled(false);
		txtIdElemento.setBounds(106, 26, 57, 22);
		contentPane.add(txtIdElemento);
		txtIdElemento.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(106, 67, 116, 22);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(106, 115, 116, 39);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JLabel lblIdElem = new JLabel("ID Elemento");
		lblIdElem.setBounds(12, 29, 82, 16);
		contentPane.add(lblIdElem);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 73, 56, 16);
		contentPane.add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(12, 126, 82, 16);
		contentPane.add(lblDescripcion);
		
		JLabel lblIdTipo = new JLabel("TipoElemento");
		lblIdTipo.setBounds(12, 170, 82, 16);
		contentPane.add(lblIdTipo);
		
		JButton btnBuscar = new JButton("BUSCAR");
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
		btnBuscar.setBounds(294, 25, 108, 25);
		contentPane.add(btnBuscar);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarClick();
			}
		});
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAgregar.setBounds(294, 73, 108, 25);
		contentPane.add(btnAgregar);
		
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.setBounds(294, 122, 108, 25);
		contentPane.add(btnBorrar);
		
		JButton btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnModificar.setBounds(294, 166, 108, 25);
		contentPane.add(btnModificar);
		
		cboTipo = new JComboBox();
		cboTipo.setBounds(106, 167, 116, 22);
		contentPane.add(cboTipo);
		cargarLista();
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
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage());
		}
		this.txtIdElemento.setText(String.valueOf(e.getIdE()));
		
	}
	
	protected void cargarLista(){
		try {
			this.cboTipo.setModel(new DefaultComboBoxModel(this.ctrl.getTipos().toArray()));
			this.cboTipo.setSelectedIndex(-1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error recuperando Tipos");
		}		
	}

	private Elemento mapearDeForm() {
		Elemento e=new Elemento();
		TipoElemento te=new TipoElemento();
		if(!this.txtIdElemento.getText().isEmpty()){
			e.setIdE(Integer.parseInt(this.txtIdElemento.getText()));
		}
		e.setNombre(this.txtNombre.getText());
		e.setDescrip(this.txtDescripcion.getText());
		//e.setTipoElem(te.setIdT(Integer.parseInt(this.txtIdTipoElem.getText())));
		return e;
			
	}
	
	private void mapearAForm(Elemento e){
		this.txtIdElemento.setText(String.valueOf(e.getIdE()));
		this.txtNombre.setText(e.getNombre());
		this.txtDescripcion.setText(e.getDescrip());	
		
	}
}

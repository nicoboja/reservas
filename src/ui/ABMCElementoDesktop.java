package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlers.CtrlABMElemento;
import entity.Elemento;
import entity.TipoElemento;

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

public class ABMCElementoDesktop extends JInternalFrame {

	private CtrlABMElemento ctrl=new CtrlABMElemento();
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnModificar;
	private JTextField txtIdElemento;
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
		setClosable(true);
		setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 329, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(15, 106, 37, 14);
		
		JLabel lblDescrip = new JLabel("Descripcion");
		lblDescrip.setBounds(15, 160, 55, 14);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(82, 103, 149, 20);
		txtNombre.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(82, 149, 149, 37);
		txtDescripcion.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(166, 55, 65, 23);
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarClick();
			}
		});
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 265, 93, 23);
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarClick();
			}
		});
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(115, 265, 82, 23);
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				borrarClick();
			}
		});
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(210, 265, 93, 23);
		btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				modificarClick();
			}
		});
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(32, 59, 20, 14);
		
		txtIdElemento = new JTextField();
		txtIdElemento.setBounds(70, 56, 47, 20);
		txtIdElemento.setEditable(false);
		txtIdElemento.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(15, 212, 20, 14);
		
		cboTipo = new JComboBox();
		cboTipo.setBounds(82, 209, 149, 20);
		contentPane.setLayout(null);
		contentPane.add(lblTipo);
		contentPane.add(cboTipo);
		contentPane.add(lblId);
		contentPane.add(lblDescrip);
		contentPane.add(txtDescripcion);
		contentPane.add(lblNombre);
		contentPane.add(txtNombre);
		contentPane.add(btnBuscar);
		contentPane.add(btnAgregar);
		contentPane.add(btnBorrar);
		contentPane.add(btnModificar);
		contentPane.add(txtIdElemento);
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
	
	protected void borrarClick(){
		
	}

	protected void modificarClick(){
		
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
		//TipoElemento te=new TipoElemento();
		if(!this.txtIdElemento.getText().isEmpty()){
			e.setIdE(Integer.parseInt(this.txtIdElemento.getText()));
		}
		e.setNombre(this.txtNombre.getText());
		e.setDescrip(this.txtDescripcion.getText());
		if (cboTipo.getSelectedIndex() != -1){
			e.setTipoElem((TipoElemento)this.cboTipo.getSelectedItem());
		}
		return e;			
	}

	private void mapearAForm(Elemento e){
		this.txtIdElemento.setText(String.valueOf(e.getIdE()));
		this.txtNombre.setText(e.getNombre());
		this.txtDescripcion.setText(e.getDescrip());		
		this.cboTipo.setSelectedItem(e.getTipoElem());
	}
}
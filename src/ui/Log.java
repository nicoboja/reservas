package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import controlers.CtrlABMPersona;
import controlers.CtrlABMTipoElemento;
import entity.Persona;
import entity.TipoElemento;

import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Log extends JDialog {
	private CtrlABMPersona ctrl=new CtrlABMPersona();

	private final JPanel contentPanel = new JPanel();
	private JTextField textUsuario;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Log dialog = new Log();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Log() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setAlwaysOnTop(true);
		setModal(true);
		setResizable(false);
		setType(Type.POPUP);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(204, 52, 130, 26);
		contentPanel.add(textUsuario);
		textUsuario.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(204, 107, 130, 26);
		contentPanel.add(pass);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(118, 57, 61, 16);
		contentPanel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(118, 112, 74, 16);
		contentPanel.add(lblContrasea);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton okButton = new JButton("Ingresar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//
						
							logueo();
					
					
					}
				});
				okButton.setBounds(163, 44, 95, 29);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cerrar();
				}
			});
			btnSalir.setBounds(255, 44, 117, 29);
			buttonPane.add(btnSalir);
		}
	}
	
	public void cerrar(){
		
	}
	private void logueo(){
		
		int idPers = -1;
		try {
			//idPers = ctrl.logueo(this.mapearDeForm());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(idPers!=-1){
			this.setVisible(false);
			
			
		}else{
			JOptionPane.showMessageDialog(this, "Error en Usuario o Contraseña ");
		}
		
		

	}

	
	private Persona mapearDeForm(){
		Persona p=new Persona();
		if(!this.textUsuario.getText().isEmpty()){
		p.setUss(this.textUsuario.getText());
		//System.out.println(p.getUss()+"mapeo");
		}
		if(!this.pass.getText().isEmpty()){
			p.setPass(this.pass.getText());
			//System.out.println(p.getPass()+"mapeo");
		}
		return p;
	}
}

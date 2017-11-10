package ui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;


import controlers.CtrlABMReserva;

import entity.Reserva;

import java.awt.Color;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import org.jdesktop.beansbinding.ObjectProperty;
import javax.swing.JLabel;

public class ListadoReservas extends JInternalFrame {
	
	private ArrayList<Reserva> res;
	CtrlABMReserva ctrl= new CtrlABMReserva();
	public int idPersona;
	/**
	 * Create the frame.
	 */
	public ListadoReservas() {
	
		setClosable(true);
		setBounds(100, 100, 507, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 483, 254);
		getContentPane().add(scrollPane);
		
		JLabel lblId = new JLabel("");
		scrollPane.setColumnHeaderView(lblId);
		
		try{
			this.res=ctrl.getAll();
		} catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	
		}
		initDataBindings();
	}
	protected void initDataBindings() {
	}
	
	public void setId(int id){
		idPersona = id;
	};
}

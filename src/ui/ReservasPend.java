package ui;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlers.CtrlABMReserva;


import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;

public class ReservasPend extends JInternalFrame {
	private CtrlABMReserva ctrl=new CtrlABMReserva();
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservasPend frame = new ReservasPend();
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
	public ReservasPend() {
		
		
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 414, 206);
		getContentPane().add(scrollPane);
		
		try {
			Object[][] data;
			String[] columns = {"ID","TIPO","ELEMENTO"};
			data = mapearAtabla();
			table = new JTable(data,columns);
			table.setModel(new DefaultTableModel());
			scrollPane.setViewportView(table);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		JButton btnRecargar = new JButton("Recargar");
		btnRecargar.setBounds(291, 19, 89, 23);
		getContentPane().add(btnRecargar);
		
		

	}
	private Object[][] mapearAtabla() throws Exception{
		Object[][] list = null;
		list = ctrl.getAllReservas();
		return list;
	}
	
}

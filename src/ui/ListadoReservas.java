package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

import javax.swing.JOptionPane;
import javax.swing.JInternalFrame;


import controlers.CtrlABMReserva;
import entity.Reserva;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

public class ListadoReservas extends JInternalFrame {
	
	private ArrayList<Reserva> res;
	CtrlABMReserva ctrl= new CtrlABMReserva();
	private int idPersona; 

	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public ListadoReservas(int per) {
		idPersona = per;
		setClosable(true);
		setBounds(100, 100, 507, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 483, 254);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		System.out.println("ID: "+idPersona);
		try{
			
			this.res=ctrl.getById(idPersona);
			/*System.out.println("ID: "+idPersona);
			System.out.println(this.res.get(0).getDetalle());*/
		} catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error .--",JOptionPane.ERROR_MESSAGE);
	
		}
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Reserva, List<Reserva>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, res, table);
		//
		BeanProperty<Reserva, Integer> reservaBeanProperty1 = BeanProperty.create("id");
		jTableBinding.addColumnBinding(reservaBeanProperty1).setColumnName("ID").setEditable(false);
		//
		BeanProperty<Reserva, Integer> reservaBeanProperty2 = BeanProperty.create("fecha");
		jTableBinding.addColumnBinding(reservaBeanProperty2).setColumnName("Fecha").setEditable(false);
		//
		BeanProperty<Reserva, Integer> reservaBeanProperty3 = BeanProperty.create("detalle");
		jTableBinding.addColumnBinding(reservaBeanProperty3).setColumnName("Detalle").setEditable(false);
		//
		BeanProperty<Reserva, Integer> reservaBeanProperty4 = BeanProperty.create("hora");
		jTableBinding.addColumnBinding(reservaBeanProperty4).setColumnName("Hora").setEditable(false);
		//
		BeanProperty<Reserva, Integer> reservaBeanProperty5 = BeanProperty.create("cantHoras");
		jTableBinding.addColumnBinding(reservaBeanProperty5).setColumnName("Cantidad Hs.").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}

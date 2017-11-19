package ui;

import java.util.ArrayList;
import java.util.List;

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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoReservas extends JInternalFrame {
	
	private ArrayList<Reserva> res;
	CtrlABMReserva ctrl= new CtrlABMReserva();
	private int idPersona; 

	private JTable table;
	
	/**
	 * Create the frame.
	 */
	public ListadoReservas(int per) {
		setTitle("Listado de Reservas Futuras");
		idPersona = per;
		setClosable(true);
		setBounds(100, 100, 723, 405);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 693, 298);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				btnCancelResv();
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(10, 310, 117, 29);
		getContentPane().add(btnCancelar);
		
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
		//
		BeanProperty<Reserva, Integer> reservaBeanProperty6 = BeanProperty.create("estado");
		jTableBinding.addColumnBinding(reservaBeanProperty6).setColumnName("Estado").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
	protected void btnCancelResv() {
		int indexResv=table.convertRowIndexToModel(table.getSelectedRow());
	//	System.out.println(indexResv);
		try {
			ctrl.cancelRes(this.res.get(indexResv));
			this.actualizar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void actualizar(){
		//this.hide();
		try{
			this.res=ctrl.getById(idPersona);
			this.initDataBindings();
		} catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error .--",JOptionPane.ERROR_MESSAGE);
	
		}
		
	};
}

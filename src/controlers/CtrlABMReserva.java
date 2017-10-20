package controlers;

import java.util.ArrayList;

import data.DataReserva;
import entity.Reserva;

public class CtrlABMReserva {
	private DataReserva dataRes = new DataReserva();
	
	
	
	

	public Object[][] getAllReservas() throws Exception{
		
		
		ArrayList<Reserva> reserv = new ArrayList<Reserva>();
		reserv = dataRes.getAllPendientes();
		System.out.println(reserv.get(1).getElemento());
		Object[][] datas = new Object[1][];
		
		for (int i = 1; i < reserv.size(); i++) {
			System.out.println("entra en for");
			
			datas[1][i] = reserv.get(i).getElemento();
			datas[1][i] = reserv.get(i).getTipo();
		}
		return datas;
	}


	
}

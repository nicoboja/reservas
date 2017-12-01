package controlers;

import java.util.ArrayList;

import data.DataElemento;
import data.DataReserva;
import data.DataTipoElemento;
import entity.Elemento;
import entity.Reserva;
import entity.TipoElemento;

public class CtrlABMReserva {
	
	private DataReserva dataRes=new DataReserva();
	private DataTipoElemento dataTipo=new DataTipoElemento();
	private DataElemento dataElem=new DataElemento();
	
	public void add(Reserva r) throws Exception{
		if(ValidaResPersona(r)==true){
			System.out.println("Validado 1");
			if(ValidaResFecha(r)==true){
				dataRes.add(r);
			}else {
				System.out.println("No hay disponibilidad en esa fecha/hora");
			}
		}else {
			System.out.println("Supero el numero de reservas pendientes maximo para ese tipo de elemento");
		}		
	}			

	public boolean ValidaResPersona(Reserva r)throws Exception{
		ArrayList<Reserva> resPer=new ArrayList <Reserva>();
		resPer=getByIdPer(r.getPer().getId());	
		
		System.out.println(resPer.size());
		int cant=0;
		boolean v=false;
		if(resPer.isEmpty()){
			v= true;
		}else {
			for (int i=0; i < resPer.size(); i++){
				System.out.println(resPer.get(i).getElem().getTipoElem().getIdT());
				if(resPer.get(i).getElem().getTipoElem().getIdT()==r.getElem().getTipoElem().getIdT()){
					cant=cant++;
				}			
			}
			System.out.println(r.getElem().getTipoElem().getCantMax());
			if(cant<r.getElem().getTipoElem().getCantMax()){
				v= true;
			}else{
				v= false;
			}
		}		
		return v;
	}
	
	public boolean ValidaResFecha(Reserva r)throws Exception{		
		ArrayList<Reserva> resFec=new ArrayList <Reserva>();
		resFec=getByFecha(r.getFecha());
		int n=0;
		boolean v=false;
		if (resFec.isEmpty()){
			v=true;
		}else if (r.getHora().getHours()+r.getCantHoras()<=resFec.get(0).getHora().getHours()){
			v= true; 
		}else {
			do {
				if (resFec.get(n).getHora().getHours()<=r.getHora().getHours()+r.getCantHoras()&&
						r.getHora().getHours()+r.getCantHoras()<=resFec.get(n+1).getHora().getHours()){
					v=true;
					n=resFec.size();
				}			    
			     n++;
			} while (n<resFec.size());				
		}
		return v;
	}

	public Reserva getById(Reserva r) throws Exception{
		return this.dataRes.getById(r);		
	}	
	public ArrayList<Reserva> getByIdPer(int idP) throws Exception{
		return dataRes.getById(idP);		
	}	
	public ArrayList<Reserva> getByFecha(java.sql.Date fec) throws Exception{
		return dataRes.getByFecha(fec);		
	}	
	public void delete(Reserva r) throws Exception{
		dataRes.delete(r);
	}	
	public ArrayList<TipoElemento> getTipos() throws Exception{
		return dataTipo.getAll();
	}
	
	public void update(Reserva r)throws Exception{
		dataRes.update(r);
	}
	public ArrayList<Elemento> getByTipo(int t) throws Exception{
		return dataElem.getByTipo(t);
	}
	public ArrayList<Elemento> getElementos() throws Exception{
		return dataElem.getAll();
	}
	public void cancelRes(Reserva r) throws Exception {
		dataRes.cancelRes(r);
	}
}
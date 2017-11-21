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
		ArrayList<Reserva> res=new ArrayList <Reserva>();
		int cant=0;
		res=getByIdPer(r.getPer().getId());		
		if (res.isEmpty()){
			if(r.getElem().getTipoElem().getTiempoMax()<=r.getCantHoras()){
			dataRes.add(r);
			}			
		}else{		
			for (int i=0; i < res.size(); i++){
				if(res.get(i).getElem().getTipoElem().getIdT()==r.getElem().getTipoElem().getIdT()){
					cant=cant++;
				}			
			}
			if(cant<r.getElem().getTipoElem().getCantMax() &&
					r.getElem().getTipoElem().getTiempoMax()<=r.getCantHoras()){
				dataRes.add(r);			
			}	
		}	
	}	

	public Reserva getById(Reserva r) throws Exception{
		return this.dataRes.getById(r);		
	}	
	public ArrayList<Reserva> getByIdPer(int idP) throws Exception{
		return dataRes.getByIdPer(idP);		
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
	public ArrayList<Elemento> getByTipo(TipoElemento tipo) throws Exception{
		return dataElem.getByTipo(tipo);
	}
	public ArrayList<Elemento> getElementos() throws Exception{
		return dataElem.getAll();
	}
}
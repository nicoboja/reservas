package controlers;

import java.util.ArrayList;

import data.DataCategoria;
import data.DataPersona;
import entity.Categoria;
import entity.Persona;

public class CtrlABMPersona {
	public int idPer = -1;

	private DataPersona dataPer;
	private DataCategoria dataCat;
	
	private ArrayList<Persona> pers;
	
	public CtrlABMPersona(){
		dataPer = new DataPersona();
		dataCat = new DataCategoria();
		pers= new ArrayList<Persona>();
	}
	
	public void add(Persona p) throws Exception{
		dataPer.add(p);
	}
	
	public void delete(Persona p)throws Exception{
		dataPer.remove(p);		
	}
	
	public Boolean logueo(Persona p) throws Exception{
		Boolean rta = false;
		Persona pdata = new Persona();
		pdata = this.getByUss(p);
		System.out.println(pdata.getUss()+" "+pdata.getPass()+" de BD");
		System.out.println(p.getUss()+" "+p.getPass()+" de mapeo");
		if(pdata.equalsUss(p)){
			rta = true;
			System.out.println("VERDADERO");
			
			idPer = pdata.getId();
		}
		
		return rta;
		
		
	}
	public int getIdP(){
		return idPer;
	}
	
	
	
	public Persona getByUss(Persona p) throws Exception{
		return dataPer.getByUss(p);
	}
	
//	public Persona getByUss(String uss)throws Exception{
//		Persona p=new Persona();
//		p.setUss(uss);
//		return getByUss(p);
//	}
	
	

	public void update(Persona p)throws Exception{
		dataPer.update(p);
	}
	
	public Persona getByDni(Persona p) throws Exception{
		return this.dataPer.getByDni(p);
	}
	
	public Persona getByDni(String dni)throws Exception{
		Persona p=new Persona();
		p.setDni(dni);
		return getByDni(p);
	}
	
/*	public Persona getByNombreApellido(Persona p){
		for (int i=0; i < this.pers.size(); i++){
			if(pers.get(i).getNombre().equalsIgnoreCase(p.getNombre())
				&& pers.get(i).getApellido().equalsIgnoreCase(p.getApellido())) {
				return pers.get(i);		
			}
		}
		return null; 
	}*/
	
	public ArrayList<Persona> getAll()throws Exception{
		return dataPer.getAll();
	}
	
	public ArrayList<Categoria> getCategorias() throws Exception{
		return dataCat.getAll();
	}
}

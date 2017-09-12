package controlers;


import java.sql.SQLException;
import java.util.ArrayList;

import data.DataElemento;
import entity.Elemento;
import entity.TipoElemento;

public class CtrlABMElemento {
	
	private DataElemento dataElem=new DataElemento();
	
	public void add(Elemento e) throws Exception{
		dataElem.add(e);
	}
	
	public ArrayList<Elemento> getAll()throws Exception{
		return dataElem.getAll();
	}
	
	public Elemento getByNombre(Elemento e) throws Exception{
		return this.dataElem.getByNombre(e);		
	}
	
	public void delete(Elemento e) throws Exception{
		dataElem.delete(e);
	}
	
}

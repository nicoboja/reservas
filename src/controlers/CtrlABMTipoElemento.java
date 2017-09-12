package controlers;

import java.util.ArrayList;

import data.DataTipoElemento;
import entity.Elemento;
import entity.TipoElemento;

public class CtrlABMTipoElemento {
	
	private DataTipoElemento dataTipoElem=new DataTipoElemento();
	
	public TipoElemento getByNombre(TipoElemento te) throws Exception{
		return this.dataTipoElem.getByNombre(te);		
	}

	public ArrayList<TipoElemento> getAll()throws Exception{
		return dataTipoElem.getAll();
	}

}

package entity;

public class Elemento {
	
	private int idE;
	private String nombre;
	private String descrip;
	private TipoElemento tipoE;
	
	public TipoElemento getTipoElem() {
		return tipoE;
	}
	public void setTipoElem(TipoElemento idT) {
		this.tipoE = idT;
	}
	public int getIdE() {
		return idE;
	}
	public void setIdE(int idV) {
		this.idE = idV;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	
	
	
	

}

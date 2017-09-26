package entity;

public class Elemento {
	

	private int id;
	private String nombre;
	private String descrip;
	private TipoElemento tipo;
	
	public TipoElemento getTipoElem() {
		return tipo;
	}
	public void setTipoElem(TipoElemento tipo) {
		this.tipo = tipo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

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
	
	public Elemento(int id, String nombre, String descrip, TipoElemento tipo) {
		
		this.id = id;
		this.nombre = nombre;
		this.descrip = descrip;
		this.tipo = tipo;
	}
	
	public Elemento(){}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descrip == null) ? 0 : descrip.hashCode());
		result = prime * result + id;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Elemento))
			return false;
		Elemento other = (Elemento) obj;
		if (descrip == null) {
			if (other.descrip != null)
				return false;
		} else if (!descrip.equals(other.descrip))
			return false;
		if (id != other.id)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	};
	
	
	
}

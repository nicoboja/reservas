package entity;

public class TipoElemento {

	private int idT;
	private String descripcion;
	private int diasMaxAnt;
	private int cantMax;
	
	
	public int getIdT() {
		return idT;
	}
	public void setIdT(int idT) {
		this.idT = idT;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getDiasMaxAnt() {
		return diasMaxAnt;
	}
	public void setDiasMaxAnt(int diasMaxAnt) {
		this.diasMaxAnt = diasMaxAnt;
	}
	public int getCantMax() {
		return cantMax;
	}
	public void setCantMax(int cantMax) {
		this.cantMax = cantMax;
	}
	
	@Override
	public String toString(){
		return this.getDescripcion();
	}
	
	@Override
	public boolean equals(Object o){
		return (o instanceof TipoElemento && ((TipoElemento)o).getIdT()==this.getIdT());
	}
	
	@Override
	public int hashCode(){
		return ((Integer)this.getIdT()).hashCode();
	}
	
	
}

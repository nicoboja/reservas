package entity;

import java.sql.Date;
import java.sql.Time;


public class Reserva {
	private int id;
	private java.sql.Date fecha;//= new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private java.sql.Time hora;
	private String detalle;
	private Elemento elem;
	private Persona per;
	private int CantHoras;
	
	
	public int getCantHoras() {
		return CantHoras;
	}
	public void setCantHoras(int cantHoras) {
		CantHoras = cantHoras;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public Elemento getElem() {
		return elem;
	}
	public void setElem(Elemento elem) {
		this.elem = elem;
	}
	public Persona getPer() {
		return per;
	}
	public void setPer(Persona per) {
		this.per = per;
	}
	
}

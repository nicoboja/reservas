package entity;

public class Persona {
	
	public int getIdP() {
		return idP;
	}
	public void setIdP(int idP) {
		this.idP = idP;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public boolean isInhabilitado() {
		return inhabilitado;
	}
	public void setInhabilitado(boolean inhabilitado) {
		this.inhabilitado = inhabilitado;
	}
	
	private int idP;
	private String dni;
	private String nombre;
	private String apellido;
	private String usuario;
	private String pass;
	private boolean inhabilitado;
	

}

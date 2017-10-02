package entity;

public class Persona {
	private int id;
	private String nombre;
	private String apellido;
	private String dni;
	private boolean habilitado;
	private Categoria categoria;
	private String pass;
	private String uss;
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUss() {
		return uss;
	}

	public void setUss(String uss) {
		this.uss = uss;
	}

	
	
	public Categoria getCategoria(){
		return categoria;
	}
	
	public void setCategoria(Categoria categoria){
		this.categoria=categoria;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id=id;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public Persona (String dni, String nombre, String apellido, boolean habilitado){
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setHabilitado(habilitado);
	}
	
	public Persona(){}
	
	@Override
	public boolean equals(Object p){
		return (p instanceof Persona) &&
			 (((Persona)p).getDni().equals(this.getDni()));
					

	}
	
	public boolean equalsUss(Object p){
		return (p instanceof Persona) &&
			 (((Persona)p).getUss().equals(this.getUss()));
	}

}






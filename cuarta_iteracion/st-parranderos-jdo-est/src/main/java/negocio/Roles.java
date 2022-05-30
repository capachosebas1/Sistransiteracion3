package negocio;

public class Roles implements VORoles {
	
	private long id;
	private String nombre;
	
	public Roles() {
		this.setId(0);
		this.setNombre("");
	}
	public Roles(long id , String nombre) {
		this.setId(id);
		this.setNombre(nombre);
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString () {
		return "Roles [id="+this.id+",nombre="+this.nombre+"]";	
	}
	

}

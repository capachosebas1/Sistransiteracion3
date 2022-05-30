package negocio;

public class Convencion implements VOConvencion {
	
	private long id;
	
	private String nombre;
	
	private String descripcion;
	
	public Convencion() {
		this.setDescripcion("");
		this.setId(0);
		this.setNombre("");
	}
	
	public Convencion(long id,String nombre,String des) {
		this.setDescripcion(des);
		this.setId(id);
		this.setNombre(nombre);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String toString () {
		return "Tabla_convencion [id=" + this.id +",nombre="+ this.nombre +",descripcion=" + this.descripcion + "]";
	}

}

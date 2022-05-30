package negocio;

public class Servicio implements VOServicio{
	private long id;
	private String nombre;
	private String descripcion;
	private String estado;
	private long cupo;
	
	public Servicio() {
		this.setCupo(0);
		this.setDescripcion("");
		this.setEstado("");
		this.setId(0);
		this.setNombre("");
	}
	public Servicio(long cupo,String descripcion, String estado, String nombre, long id) {
		this.setCupo(cupo);
		this.setDescripcion(descripcion);
		this.setEstado(estado);
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
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the cupo
	 */
	public long getCupo() {
		return cupo;
	}
	/**
	 * @param cupo the cupo to set
	 */
	public void setCupo(long cupo) {
		this.cupo = cupo;
	}
	
	public String toStrign() {
		return "Tabla_servicios[id_servicio="+this.id+",nombre_servicio="+this.nombre+",descripcion_servicio="+this.descripcion+",estado_servicio="+this.estado+",cupo="+this.cupo+"]";
	}
	

}

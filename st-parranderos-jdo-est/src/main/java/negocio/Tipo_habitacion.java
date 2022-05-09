package negocio;

public class Tipo_habitacion implements VOTipo_habitacion {

	private String id;
	private String nombre;
	private String descripcion;
	private long numero_camas;
	
	public Tipo_habitacion() {
		this.setDescripcion("");
		this.setId("");
		this.setNombre("");
		this.setNumero_camas(0);
		
	}
	
	public Tipo_habitacion(String des, String id, String nombre, long numero_camas) {
		this.setDescripcion(des);
		this.setId(id);
		this.setNombre(nombre);
		this.setNumero_camas(numero_camas);
		
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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
	 * @return the numero_camas
	 */
	public long getNumero_camas() {
		return numero_camas;
	}

	/**
	 * @param numero_camas the numero_camas to set
	 */
	public void setNumero_camas(long numero_camas) {
		this.numero_camas = numero_camas;
	}
	
	public String toString() {
		return "Tabla_tipo_habitacion [id_tipo_habitacion="+this.id+",nombre="+this.nombre+",descripcion="+this.descripcion+",numero_camas="+this.numero_camas+"]";
	}
}

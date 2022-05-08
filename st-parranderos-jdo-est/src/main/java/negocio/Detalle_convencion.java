package negocio;

public class Detalle_convencion implements VODetalle_convencion{
	
	private long id;
	private long id_convencio;
	private long id_servicio;
	private long valor;
	
	public Detalle_convencion() {
		this.setId(0);
		this.setId_convencio(0);
		this.setId_servicio(0);
		this.setValor(0);
	}
	public Detalle_convencion(long id, long id_c, long id_s, long valor) {
		this.setId(id);
		this.setId_convencio(id_c);
		this.setId_servicio(id_s);
		this.setValor(valor);
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
	 * @return the id_convencio
	 */
	public long getId_convencio() {
		return id_convencio;
	}
	/**
	 * @param id_convencio the id_convencio to set
	 */
	public void setId_convencio(long id_convencio) {
		this.id_convencio = id_convencio;
	}
	/**
	 * @return the id_servicio
	 */
	public long getId_servicio() {
		return id_servicio;
	}
	/**
	 * @param id_servicio the id_servicio to set
	 */
	public void setId_servicio(long id_servicio) {
		this.id_servicio = id_servicio;
	}
	/**
	 * @return the valor
	 */
	public long getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(long valor) {
		this.valor = valor;
	}
	
	public String toString () {
		return "Tabla_detalle_convencion [id_detalles_convencion=" + this.id + ",id_convencio="+ this.id_convencio+",id_servicio="+ this.id_servicio + ",valor=" + this.valor + "]";
		
	}
	
	

}

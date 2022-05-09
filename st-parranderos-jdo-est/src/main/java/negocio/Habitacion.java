package negocio;

public class Habitacion {
	private long id;
	private long tipo;
	private long numero;
	private String disponibilidad;
	private long valor;
	
	public Habitacion() {
		this.setDisponibilidad("");
		this.setId(0);
		this.setNumero(0);
		this.setTipo(0);
		this.setValor(0);
	
		
	}
	public Habitacion(String dis, long id, long numero, long tipo, long valor) {
		this.setDisponibilidad(dis);
		this.setId(id);
		this.setNumero(numero);
		this.setTipo(tipo);
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
	 * @return the tipo
	 */
	public long getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(long tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the disponibilidad
	 */
	public String getDisponibilidad() {
		return disponibilidad;
	}
	/**
	 * @param disponibilidad the disponibilidad to set
	 */
	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	/**
	 * @return the numero
	 */
	public long getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(long numero) {
		this.numero = numero;
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
	public String toString() {
		return "Tabla_Habitacion [ID_HABITACION="+this.id+",TIPO_HABITACION="+this.tipo+",NUMERO_HABITACION="+this.numero+",DISPONIBILIDAD="+this.disponibilidad+",VALOR="+this.valor+"]";
	}

}

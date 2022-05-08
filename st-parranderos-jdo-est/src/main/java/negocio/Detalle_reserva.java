package negocio;

import java.sql.Date;

public class Detalle_reserva implements VODetalle_reserva {
	private long id;
	private long id_reserva;
	private long id_servicio;
	private Date fecha_inicio;
	private Date fecha_fin;
	private long valor;
	
	public Detalle_reserva() {
		this.setFecha_fin(null);
		this.setFecha_inicio(null);
		this.setId(0);
		this.setId_reserva(0);
		this.setId_servicio(0);
		this.setValor(0);
	}
	
	public Detalle_reserva(long id, long id_r, long id_s, long valor, Date fecha_i, Date fecha_f) {
		this.setFecha_fin(fecha_f);
		this.setFecha_inicio(fecha_i);
		this.setId(id);
		this.setId_reserva(id_r);
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
	 * @return the id_reserva
	 */
	public long getId_reserva() {
		return id_reserva;
	}

	/**
	 * @param id_reserva the id_reserva to set
	 */
	public void setId_reserva(long id_reserva) {
		this.id_reserva = id_reserva;
	}

	/**
	 * @return the fecha_inicio
	 */
	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	/**
	 * @param fecha_inicio the fecha_inicio to set
	 */
	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
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

	/**
	 * @return the fecha_fin
	 */
	public Date getFecha_fin() {
		return fecha_fin;
	}

	/**
	 * @param fecha_fin the fecha_fin to set
	 */
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	
	public String toString() {
		return "Tabla_detalle_reserva [id_detalle_reserva="+this.id+",id_reserva="+this.id_reserva+",id_servicio="+this.id_servicio+",valor="+this.valor+",fecha_inicio="+this.fecha_inicio+",fecha_fin="+this.fecha_fin+"]";
	}

}

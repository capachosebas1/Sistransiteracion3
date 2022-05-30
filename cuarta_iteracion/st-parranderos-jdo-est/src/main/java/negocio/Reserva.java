package negocio;

import java.sql.Date;

public class Reserva implements VOReserva {
	private long id;
	private long id_cliente;
	private long id_habitacion;
	private Date fecha_reserva;
	private Date fecha_check_in;
	private Date fecha_check_out;
	private long id_convencion;
	
	public Reserva() {
		this.setFecha_check_in(null);
		this.setFecha_check_out(null);
		this.setFecha_reserva(null);
		this.setId(0);
		this.setId_cliente(0);
		this.setId_convencion(0);
		this.setId_habitacion(0);
	}
	public Reserva(Date fecha_check_in, Date fecha_check_out, Date fecha_reserva, long id , long id_cl, long id_c, long id_h) {
		this.setFecha_check_in(fecha_check_in);
		this.setFecha_check_out(fecha_check_out);
		this.setFecha_reserva(fecha_reserva);
		this.setId(id);
		this.setId_cliente(id_cl);
		this.setId_convencion(id_c);
		this.setId_habitacion(id_h);
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
	 * @return the id_cliente
	 */
	public long getId_cliente() {
		return id_cliente;
	}
	/**
	 * @param id_cliente the id_cliente to set
	 */
	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}
	/**
	 * @return the id_habitacion
	 */
	public long getId_habitacion() {
		return id_habitacion;
	}
	/**
	 * @param id_habitacion the id_habitacion to set
	 */
	public void setId_habitacion(long id_habitacion) {
		this.id_habitacion = id_habitacion;
	}
	/**
	 * @return the fecha_reserva
	 */
	public Date getFecha_reserva() {
		return fecha_reserva;
	}
	/**
	 * @param fecha_reserva the fecha_reserva to set
	 */
	public void setFecha_reserva(Date fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}
	/**
	 * @return the fecha_check_in
	 */
	public Date getFecha_check_in() {
		return fecha_check_in;
	}
	/**
	 * @param fecha_check_in the fecha_check_in to set
	 */
	public void setFecha_check_in(Date fecha_check_in) {
		this.fecha_check_in = fecha_check_in;
	}
	/**
	 * @return the id_convencion
	 */
	public long getId_convencion() {
		return id_convencion;
	}
	/**
	 * @param id_convencion the id_convencion to set
	 */
	public void setId_convencion(long id_convencion) {
		this.id_convencion = id_convencion;
	}
	/**
	 * @return the fecha_check_out
	 */
	public Date getFecha_check_out() {
		return fecha_check_out;
	}
	/**
	 * @param fecha_check_out the fecha_check_out to set
	 */
	public void setFecha_check_out(Date fecha_check_out) {
		this.fecha_check_out = fecha_check_out;
	}
	public String toString(){
		return "Tabla_reserva [id_reserva="+this.id+",id_cliente="+this.id_cliente+",id_habitacion="+this.id_habitacion+",fecha_reserva="+this.fecha_reserva+",fecha_check_in="+this.fecha_check_in+",fecha_check_out="+this.fecha_check_out+",id_convenciom="+this.id_convencion+"]";
	}
}

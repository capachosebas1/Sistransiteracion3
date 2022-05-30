package negocio;

import java.sql.Date;

public interface VOReserva {
	public long getId();
	public long getId_cliente();
	public long getId_habitacion();
	public Date getFecha_reserva();
	public Date getFecha_check_in();
	public Date getFecha_check_out();
	public long getId_convencion();
	public String toString();

}

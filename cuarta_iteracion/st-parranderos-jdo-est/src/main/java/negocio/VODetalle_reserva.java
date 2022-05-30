package negocio;

import java.sql.Date;

public interface VODetalle_reserva {
	public long getId();
	public long getId_reserva();
	public long getId_servicio();
	public Date getFecha_inicio();
	public Date getFecha_fin();
	public long getValor();
	public String toString();

}

package persistencia;

import java.sql.Date;
import java.util.List;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Detalle_convencion;
import negocio.Detalle_reserva;
import negocio.Reserva;




public class SQLDetalle_reserva {
	private final static String SQL = PersistenciaHotelAndes.SQL;

	private PersistenciaHotelAndes pp;

	public SQLDetalle_reserva (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	public List<Detalle_reserva> darDetalle_ReservasPorId_ReservayRango (PersistenceManager pm, long reserva, Date inicial , Date fin)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaDetalle_reserva()+ " tc WHERE tc.ID_RESERVA= ? AND  tc.FECHA_INICIO => ? AND tc.FECHA_INICIO <= ?");
		q.setResultClass(Reserva.class);
		q.setParameters(reserva,inicial,fin);
		
		return (List<Detalle_reserva>) q.executeList();
	}
	public List<Detalle_reserva> darDetalle_ReservasPorId_ServicioyRango (PersistenceManager pm, long servicio, Date inicial , Date fin)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaDetalle_reserva()+ " tc WHERE tc.ID_SERVICIO= ? AND  tc.FECHA_INICIO => ? AND tc.FECHA_INICIO <= ?");
		q.setResultClass(Reserva.class);
		q.setParameters(servicio,inicial,fin);
		
		return (List<Detalle_reserva>) q.executeList();
	}
	
}

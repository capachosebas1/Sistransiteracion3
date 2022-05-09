package persistencia;

import java.util.List;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Detalle_convencion;
import negocio.Habitacion;


public class SQLHabitacion {
	
	private final static String SQL = PersistenciaHotelAndes.SQL;

	private PersistenciaHotelAndes pp;

	public SQLHabitacion (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	public List<Habitacion> darHabitacionPorId (PersistenceManager pm, long id)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaBar()+ " tc WHERE tc.ID_HABITACION= ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(id);
		
		return (List<Habitacion>) q.executeList();
	}
	public long actulizarDisponibilidad (PersistenceManager pm, long id)
	{
	    Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaBar () + " SET DISPONIBILIDAD = 'A'  WHERE ID_HABITACION = ?");
	    q.setParameters(id);
	    return (long) q.executeUnique();
	}
}
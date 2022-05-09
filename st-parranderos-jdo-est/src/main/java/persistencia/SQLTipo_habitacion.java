package persistencia;

import java.util.List;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Detalle_convencion;
import negocio.Habitacion;
import negocio.Reserva;
import negocio.Tipo_habitacion;


public class SQLTipo_habitacion {
	
	private final static String SQL = PersistenciaHotelAndes.SQL;

	private PersistenciaHotelAndes pp;

	public SQLTipo_habitacion (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	public List<Tipo_habitacion> darTipo_porid (PersistenceManager pm, String id)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaHabitacion()+ " tc WHERE tc.ID_TIPO_HABITACION= ?");
		q.setResultClass(Tipo_habitacion.class);
		q.setParameters(id);
		
		return (List<Tipo_habitacion>) q.executeList();
	}
	

}


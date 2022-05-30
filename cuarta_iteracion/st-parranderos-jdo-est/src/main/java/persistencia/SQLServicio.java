package persistencia;

import java.util.List;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Reserva;
import negocio.Servicio;






class SQLServicio
{
private final static String SQL = PersistenciaHotelAndes.SQL;

private PersistenciaHotelAndes pp;

public SQLServicio (PersistenciaHotelAndes pp)
{
	this.pp = pp;
}
public long actulizarEstado (PersistenceManager pm, long id)
{
    Query q = pm.newQuery(SQL, "UPDATE " + pp.darTablaServicios() + " SET ESTADO_SERVICIO = 'A'  WHERE ID_SERVICIO = ?");
    q.setParameters(id);
    return (long) q.executeUnique();
}
public List<Servicio> darServicioPorId (PersistenceManager pm, long id)
{
	Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaServicios()+ " tc WHERE tc.ID_SERVICIO= ?");
	q.setResultClass(Reserva.class);
	q.setParameters(id);
	
	return (List<Servicio>) q.executeList();
}
}

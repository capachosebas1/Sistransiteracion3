package persistencia;

import java.util.List;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;






class SQLConvencion
{
private final static String SQL = PersistenciaHotelAndes.SQL;

private PersistenciaHotelAndes pp;

public SQLConvencion (PersistenciaHotelAndes pp)
{
	this.pp = pp;
}

public long eliminarConvencionPorId (PersistenceManager pm, long nombre)
{
    Query q = pm.newQuery(SQL, "DELETE FROM " + pp.darSeqConvencion() + " WHERE nombre = ?");
    q.setParameters(nombre);
    return (long) q.executeUnique();
}

	
}


package persistencia;

import java.util.List;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import negocio.Reserva;






class SQLReserva
{
private final static String SQL = PersistenciaHotelAndes.SQL;

private PersistenciaHotelAndes pp;

public SQLReserva (PersistenciaHotelAndes pp)
{
	this.pp = pp;
}
public List<Reserva> darReservasPorId_Convencion (PersistenceManager pm, long convenio)
{
	Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaBar()+ " tc WHERE tc.id_convensiom= ?");
	q.setResultClass(Reserva.class);
	q.setParameters(convenio);
	
	return (List<Reserva>) q.executeList();
}
}
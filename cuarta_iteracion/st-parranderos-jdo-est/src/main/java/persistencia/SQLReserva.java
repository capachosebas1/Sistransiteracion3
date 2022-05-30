package persistencia;

import java.sql.Date;
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
	Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTabla_reserva()+ " tc WHERE tc.id_convensiom= ?");
	q.setResultClass(Reserva.class);
	q.setParameters(convenio);
	
	return (List<Reserva>) q.executeList();
}

public List<Reserva> darReservasPorId_Usuario (PersistenceManager pm, long usuario)
{
	Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTabla_reserva()+ " tc WHERE tc.ID_CLIENTE= ?");
	q.setResultClass(Reserva.class);
	q.setParameters(usuario);
	
	return (List<Reserva>) q.executeList();
}
public List<Reserva> darReservasPorId_HabitacionyRango (PersistenceManager pm, long habitacion,Date inicial, Date fin)
{
	Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaTabla_reserva()+ "  WHERE ID_HABITACION= ? AND FECHA_CHECK_IN >= ? AND FECHA_CHECK_IN <= ?");
	q.setResultClass(Reserva.class);
	q.setParameters(habitacion,inicial,fin);
	
	return (List<Reserva>) q.executeList();
}
}
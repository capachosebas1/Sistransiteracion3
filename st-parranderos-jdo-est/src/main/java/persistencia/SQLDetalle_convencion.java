package persistencia;

import java.util.List;


import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Detalle_convencion;


public class SQLDetalle_convencion {
	
	private final static String SQL = PersistenciaHotelAndes.SQL;

	private PersistenciaHotelAndes pp;

	public SQLDetalle_convencion (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	public List<Detalle_convencion> darDetallesPorConvencion (PersistenceManager pm, long convenio)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pp.darTablaDetalle_convencion()+ " tc WHERE tc.id_convencio= ?");
		q.setResultClass(Detalle_convencion.class);
		q.setParameters(convenio);
		
		return (List<Detalle_convencion>) q.executeList();
	}

}

package persistencia;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLTabla_reserva {
    /* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Cadena que representa el tipo de consulta que se va a realizar en las sentencias de acceso a la base de datos
	 * Se renombra acá para facilitar la escritura de las sentencias
	 */
	private final static String SQL = PersistenciaHotelAndes.SQL;

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia general de la aplicación
	 */
	private PersistenciaHotelAndes pp;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * Constructor
	 * @param pp - El Manejador de persistencia de la aplicación
	 */
	public SQLTabla_reserva (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}

    /**
	 * Crea y ejecuta la sentencia SQL para adicionar un GUSTAN a la base de datos de Parranderos
	 * @param pm - El manejador de persistencia
	 * @param idBebedor - El identificador del bebedor
	 * @param idBebida - El identificador de la bebida
	 * @return EL número de tuplas insertadas
	 */
	public long CheckOut (PersistenceManager pm, long ID_cliente, long ID_Reserva , Date  Fecha_check_out) 
	{
	    Query q = pm.newQuery(SQL, "UPDATE " + pp.darTabla_reserva () + " SET Fecha_check_out = ? WHERE ID_cliente = ? AND ID_Reserva = ?");
	    q.setParameters(ID_cliente,  ID_Reserva ,  Fecha_check_out);
	    return (long) q.executeUnique();            
	}


}

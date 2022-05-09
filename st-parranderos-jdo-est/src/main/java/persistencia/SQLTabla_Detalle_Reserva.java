package persistencia;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLTabla_Detalle_Reserva {
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
	public SQLTabla_Detalle_Reserva (PersistenciaHotelAndes pp)
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
	public long adicionarDetalleServicio(PersistenceManager pm, long idBebedorID_Detalle_Reserva, long ID_Reserva,long ID_Servicio, Date Fecha_Inicio, Date Fecha_FIN, long Valor) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pp.darTablaDetalle_reserva() + "(idBebedorID_Detalle_Reserva,  ID_Reserva,ID_Servicio, Fecha_Inicio,  Fecha_FIN,  Valor) values (?, ?)");
        q.setParameters(idBebedorID_Detalle_Reserva,  ID_Reserva,ID_Servicio, Fecha_Inicio,  Fecha_FIN,  Valor);
        return (long) q.executeUnique();
	}


}

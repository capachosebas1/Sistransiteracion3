/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad	de	los	Andes	(Bogotá	- Colombia)
 * Departamento	de	Ingeniería	de	Sistemas	y	Computación
 * Licenciado	bajo	el	esquema	Academic Free License versión 2.1
 * 		
 * Curso: isis2304 - Sistemas Transaccionales
 * Proyecto: Parranderos Uniandes
 * @version 1.0
 * @author Germán Bravo
 * Julio de 2018
 * 
 * Revisado por: Claudia Jiménez, Christian Ariza
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

/**
 * Clase que encapsula los métodos que hacen acceso a la base de datos para el concepto BAR de Parranderos
 * Nótese que es una clase que es sólo conocida en el paquete de persistencia
 * 
 * @author Germán Bravo
 */
class SQLUtil
{
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
	public SQLUtil (PersistenciaHotelAndes pp)
	{
		this.pp = pp;
	}
	
	/**
	 * Crea y ejecuta la sentencia SQL para obtener un nuevo número de secuencia
	 * @param pm - El manejador de persistencia
	 * @return El número de secuencia generado
	 */
	public long nextval (PersistenceManager pm)
	{
        Query q = pm.newQuery(SQL, "SELECT "+ pp () + ".nextval FROM DUAL");
        q.setResultClass(Long.class);
        long resp = (long) q.executeUnique();
        return resp;
	}

	/**
	 * Crea y ejecuta las sentencias SQL para cada tabla de la base de datos - EL ORDEN ES IMPORTANTE 
	 * @param pm - El manejador de persistencia
	 * @return Un arreglo con 7 números que indican el número de tuplas borradas en las tablas GUSTAN, SIRVEN, VISITAN, BEBIDA,
	 * TIPOBEBIDA, BEBEDOR y BAR, respectivamente
	 */
	public long [] limpiarParranderos (PersistenceManager pm)
	{
        Query qConvencion = pm.newQuery(SQL, "DELETE FROM " + pp.darSeqConvencion());          
        Query qDetalle_c = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaDetalle_convencion());
        Query qDetalle_reserva = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaDetalle_reserva());
        Query qHabitacion = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaHabitacion());
        Query qReserva = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaReserva());
        Query qServicio = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaServicio());
        Query qDetalle_r = pm.newQuery(SQL, "DELETE FROM " + pp.darTablaTabla_Detalle_Reserva());

        long gustanEliminados = (long) qConvencion.executeUnique ();
        long sirvenEliminados = (long) qDetalle_c.executeUnique ();
        long visitanEliminadas = (long) qDetalle_reserva.executeUnique ();
        long bebidasEliminadas = (long) qHabitacion.executeUnique ();
        long tiposBebidaEliminados = (long) qReserva.executeUnique ();
        long bebedoresEliminados = (long) qServicio.executeUnique ();
        long baresEliminados = (long) qDetalle_r.executeUnique ();
        return new long[] {gustanEliminados, sirvenEliminados, visitanEliminadas, bebidasEliminadas, 
        		tiposBebidaEliminados, bebedoresEliminados, baresEliminados};
	}

}

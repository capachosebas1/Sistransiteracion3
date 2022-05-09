package persistencia;

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


import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import negocio.Detalle_convencion;
import negocio.Reserva;
import uniandes.isis2304.parranderos.negocio.Bar;
import uniandes.isis2304.parranderos.negocio.Bebedor;
import uniandes.isis2304.parranderos.negocio.Bebida;
import uniandes.isis2304.parranderos.negocio.Gustan;
import uniandes.isis2304.parranderos.negocio.Sirven;
import uniandes.isis2304.parranderos.negocio.TipoBebida;
import uniandes.isis2304.parranderos.negocio.Visitan;

/**
 * Clase para el manejador de persistencia del proyecto Parranderos
 * Traduce la información entre objetos Java y tuplas de la base de datos, en ambos sentidos
 * Sigue un patrón SINGLETON (Sólo puede haber UN objeto de esta clase) para comunicarse de manera correcta
 * con la base de datos
 * Se apoya en las clases SQLBar, SQLBebedor, SQLBebida, SQLGustan, SQLSirven, SQLTipoBebida y SQLVisitan, que son 
 * las que realizan el acceso a la base de datos
 * 
 * @author Germán Bravo
 */
public class PersistenciaHotelAndes 
{
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(PersistenciaHotelAndes.class.getName());
	
	/**
	 * Cadena para indicar el tipo de sentencias que se va a utilizar en una consulta
	 */
	public final static String SQL = "javax.jdo.query.SQL";

	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * Atributo privado que es el único objeto de la clase - Patrón SINGLETON
	 */
	private static PersistenciaHotelAndes instance;
	
	/**
	 * Fábrica de Manejadores de persistencia, para el manejo correcto de las transacciones
	 */
	private PersistenceManagerFactory pmf;
	
	/**
	 * Arreglo de cadenas con los nombres de las tablas de la base de datos, en su orden:
	 * Secuenciador, tipoBebida, bebida, bar, bebedor, gustan, sirven y visitan
	 */
	private List <String> tablas;
	
	/**
	 * Atributo para el acceso a las sentencias SQL propias a PersistenciaParranderos
	 */
	private SQLUtil sqlUtil;
	
	/**
	 * Atributo para el acceso a la tabla TIPOBEBIDA de la base de datos
	 */
	private SQLConvencion sqlConvencion;
	
	/**
	 * Atributo para el acceso a la tabla BEBIDA de la base de datos
	 */
	private SQLDetalle_convencion sqlDetalle_convencion;
	
	/**
	 * Atributo para el acceso a la tabla BAR de la base de datos
	 */
	private SQLDetalle_reserva sqlDetalle_reserva;
	
	/**
	 * Atributo para el acceso a la tabla BEBIDA de la base de datos
	 */
	private SQLHabitacion sqlHabitacion;
	
	/**
	 * Atributo para el acceso a la tabla GUSTAN de la base de datos
	 */
	private SQLReserva sqlReserva;
	
	/**
	 * Atributo para el acceso a la tabla SIRVEN de la base de datos
	 */
	private SQLServicio sqlServicio;
	
	/**
	 * Atributo para el acceso a la tabla VISITAN de la base de datos
	 */
	private SQLTabla_Detalle_Reserva sqlTabla_Detalle_Reserva;

	private SQLTabla_reserva sqlTabla_reserva;

	private SQLTipo_habitacion sqlTipo_habitacion;
	
	/* ****************************************************************
	 * 			Métodos del MANEJADOR DE PERSISTENCIA
	 *****************************************************************/

	/**
	 * Constructor privado con valores por defecto - Patrón SINGLETON
	 */
	private PersistenciaHotelAndes ()
	{
		pmf = JDOHelper.getPersistenceManagerFactory("HotelAndes");		
		crearClasesSQL ();
		
		// Define los nombres por defecto de las tablas de la base de datos
		tablas = new LinkedList<String> ();
		tablas.add ("HotelAndes_sequence");
		tablas.add ("CLIENTE");
		tablas.add ("TABLA_CONVENCION");
		tablas.add ("TABLA_DETALLE_CONVENCION");
		tablas.add ("TABLA_DETALLE_RESERVA");
		tablas.add ("TABLA_HABITACION");
		tablas.add ("ORDERS");
		tablas.add ("PERSONS");
		tablas.add ("TABLA_RESERVA");
		tablas.add ("TABLA_SERVICIOS");
		tablas.add ("TABLA_TIPO_HABITACION");
}

	/**
	 * Constructor privado, que recibe los nombres de las tablas en un objeto Json - Patrón SINGLETON
	 * @param tableConfig - Objeto Json que contiene los nombres de las tablas y de la unidad de persistencia a manejar
	 */
	private PersistenciaHotelAndes (JsonObject tableConfig)
	{
		crearClasesSQL ();
		tablas = leerNombresTablas (tableConfig);
		
		String unidadPersistencia = tableConfig.get ("unidadPersistencia").getAsString ();
		log.trace ("Accediendo unidad de persistencia: " + unidadPersistencia);
		pmf = JDOHelper.getPersistenceManagerFactory (unidadPersistencia);
	}

	/**
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
	 */
	public static PersistenciaHotelAndes getInstance ()
	{
		if (instance == null)
		{
			instance = new PersistenciaHotelAndes ();
		}
		return instance;
	}
	
	/**
	 * Constructor que toma los nombres de las tablas de la base de datos del objeto tableConfig
	 * @param tableConfig - El objeto JSON con los nombres de las tablas
	 * @return Retorna el único objeto PersistenciaParranderos existente - Patrón SINGLETON
	 */
	public static PersistenciaHotelAndes getInstance (JsonObject tableConfig)
	{
		if (instance == null)
		{
			instance = new PersistenciaHotelAndes (tableConfig);
		}
		return instance;
	}

	/**
	 * Cierra la conexión con la base de datos
	 */
	public void cerrarUnidadPersistencia ()
	{
		pmf.close ();
		instance = null;
	}
	
	/**
	 * Genera una lista con los nombres de las tablas de la base de datos
	 * @param tableConfig - El objeto Json con los nombres de las tablas
	 * @return La lista con los nombres del secuenciador y de las tablas
	 */
	private List <String> leerNombresTablas (JsonObject tableConfig)
	{
		JsonArray nombres = tableConfig.getAsJsonArray("tablas") ;

		List <String> resp = new LinkedList <String> ();
		for (JsonElement nom : nombres)
		{
			resp.add (nom.getAsString ());
		}
		
		return resp;
	}
	
	/**
	 * Crea los atributos de clases de apoyo SQL
	 */
	private void crearClasesSQL ()
	{
		sqlConvencion = new SQLConvencion(this);
		sqlDetalle_convencion = new SQLDetalle_convencion(this);
		sqlDetalle_reserva = new SQLDetalle_reserva(this);
		sqlHabitacion = new SQLHabitacion(this);
		sqlReserva = new SQLReserva(this);
		sqlServicio = new SQLServicio (this);
		sqlTabla_Detalle_Reserva = new SQLTabla_Detalle_Reserva(this);
		sqlTabla_reserva = new SQLTabla_reserva(this);
		sqlTipo_habitacion = new SQLTipo_habitacion(this);		
		sqlUtil = new SQLUtil(this);
	}

	public String darSeqParranderos ()
	{
		return tablas.get (0);
	}

	/**
	 * @return La cadena de caracteres con el nombre del secuenciador de parranderos
	 */
	public String darTablaConvencion ()
	{
		return tablas.get (1);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de TipoBebida de parranderos
	 */
	public String darTablaDetalle_convencion ()
	{
		return tablas.get (2);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bebida de parranderos
	 */
	public String darTablaDetalle_reserva ()
	{
		return tablas.get (3);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bar de parranderos
	 */
	public String darTablaHabitacion ()
	{
		return tablas.get (4);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Bebedor de parranderos
	 */
	public String darTablaReserva ()
	{
		return tablas.get (5);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Gustan de parranderos
	 */
	public String darTablaServicio ()
	{
		return tablas.get (6);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Sirven de parranderos
	 */
	public String darTablaTabla_Detalle_Reserva ()
	{
		return tablas.get (7);
	}

	/**
	 * @return La cadena de caracteres con el nombre de la tabla de Visitan de parranderos
	 */
	public String darTablaTabla_reserva ()
	{
		return tablas.get (8);
	}

	public String darTablaTipo_habitacion ()
	{
		return tablas.get (9);
	}
	public String darsqlUtil ()
	{
		return tablas.get (10);
	}
	
	/**
	 * Transacción para el generador de secuencia de Parranderos
	 * Adiciona entradas al log de la aplicación
	 * @return El siguiente número del secuenciador de Parranderos
	 */
	private long nextval ()
	{
        long resp = sqlUtil.nextval (pmf.getPersistenceManager());
        log.trace ("Generando secuencia: " + resp);
        return resp;
    }
	
	/**
	 * Extrae el mensaje de la exception JDODataStoreException embebido en la Exception e, que da el detalle específico del problema encontrado
	 * @param e - La excepción que ocurrio
	 * @return El mensaje de la excepción JDO
	 */
	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}



	public long req13(long idconvencion) {
		
			PersistenceManager pm = pmf.getPersistenceManager();
	        Transaction tx=pm.currentTransaction();
	        try
	        {
	            tx.begin();
	            long resp = sqlConvencion.eliminarConvencionPorId(pm, idconvencion);
	            tx.commit();

	            return resp;
	        }
	        catch (Exception e)
	        {
//	        	e.printStackTrace();
	        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
	            return -1;
	        }
	        finally
	        {
	            if (tx.isActive())
	            {
	                tx.rollback();
	            }
	            pm.close();
	        }
		}
	public long req14(long idConvencion) {
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp2=0;
            List<Reserva> listaR= sqlReserva.darReservasPorId_Convencion(pm, idConvencion);
            for (int i=0; i < listaR.size(); i++) {
            	long idhabitacion = listaR.get(i).getId_habitacion();
            	long resp1 = sqlHabitacion.actulizarDisponibilidad(pm, idhabitacion);
            	resp2+=resp1;
            }
            List<Detalle_convencion> listaD= sqlDetalle_convencion.darDetallesPorConvencion(pm, idConvencion);
            for (int i=0; i < listaD.size(); i++) {
            	long idServicio = listaD.get(i).getId_servicio();
            	long resp1 = sqlServicio.actulizarEstado(pm, idServicio);
            	resp2+=resp1;
            }
           
            tx.commit();

            return resp2;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
	}
	public long RFC5(long id_usuario,Date inicio, Date fin) {
		List<Reserva> res = sqlReserva.darReservasPorId_Usuario(pmf.getPersistenceManager(), id_usuario);
		return id_usuario;
		
	}
}


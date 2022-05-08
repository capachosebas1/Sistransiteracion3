package negocio;


public class Cliente implements VOCliente {

	private long id;
	
	private String nombre;
	
	public Cliente() {
		this.id=0;
		this.nombre="";
	}
	public Cliente(long id, String nombre) {
		this.id=id;
		this.nombre=nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString () {
		return "Cliente [id=" + this.id + ",nombre=" + this.nombre + "]";
		
	}
}

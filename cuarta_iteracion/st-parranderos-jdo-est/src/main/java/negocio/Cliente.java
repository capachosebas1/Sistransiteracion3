package negocio;


public class Cliente implements VOCliente {

	private long id;
	
	private long id_usuario;
	
	public Cliente() {
		this.id=0;
		this.id_usuario=0;
	}
	public Cliente(long id, long id_u) {
		this.id=id;
		this.id_usuario=id_u;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId_usuario() {
		return this.id_usuario;
	}

	public void setNombre(Long id_u) {
		this.id_usuario = id_u;
	}
	
	public String toString () {
		return "Cliente [id_cliente=" + this.id + ",id_usuario=" + this.id_usuario + "]";
		
	}
}

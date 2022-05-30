package negocio;


public class Usuario implements VOUsuario {
	
	private String nombre;
	private long id;
	private String tipo_doc;
	private long num_doc;
	private String correo;
	
	public String getNombre() {
		return this.nombre;
	}
	public String getTipo_doc() {
		return this.tipo_doc;
	
	}
	public String getCorreo() {
		return this.correo;
	}
	public long getId() {
		return this.id;
	}
	public long getNum_doc() {
		return this.num_doc;
	}
	
	
	
	public void  setNombre(String nombre) {
		this.nombre=nombre;
	}
	public void getTipo_doc(String tipo) {
		this.tipo_doc=tipo;
	
	}
	public void getCorreo(String correo) {
		this.correo=correo;
	}
	public void getId(long id ) {
		this.id=id;
	}
	public void getNum_doc(long num_doc) {
		this.num_doc=num_doc;
	}
	
	
	
	public Usuario() {
		this.correo="";
		this.id=0;
		this.nombre="";
		this.num_doc=0;
		this.tipo_doc="";
	}
	public Usuario(String correo, String nombre, long id, long num_doc, String tipo_doc) {
		this.correo=correo;
		this.id=id;
		this.nombre=nombre;
		this.num_doc=num_doc;
		this.tipo_doc=tipo_doc;
	}
	
	public String toString () {
		return "Usuario [id="+this.id+",nombre="+this.nombre+",correo="+this.correo+",num_doc="+this.num_doc+",tipo_doc="+this.tipo_doc+"]";

	}

}

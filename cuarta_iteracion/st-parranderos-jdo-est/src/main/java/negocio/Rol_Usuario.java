package negocio;

public class Rol_Usuario implements VORol_Usuario {
	
	private long id;
	private long id_usuario;
	private long id_rol;
	
	public Rol_Usuario() {
		this.id=0;
		this.id_rol=0;
		this.id_usuario=0;
	}
	
	public Rol_Usuario(long id, long id_rol, long id_usuario) {
		this.id=id;
		this.id_rol=id_rol;
		this.id_usuario=id_usuario;
		
	}
	public String  toString() {
		return "Rol_Usuario [id="+this.id+",id_rol="+this.id_rol+",id_usuario="+this.id_usuario+"]";	
	}
	public long getId() {
		return this.id;
	}
	public long getId_usuario() {
		return this.id_usuario;
	}
	public long getId_rol() {
		return this.id_rol;
	}
	
	public void setId(long id) {
		this.id=id;
	}
	public void  setId_usuario(long id) {
		this.id_usuario=id;
	}
	public void setId_rol(long id) {
		this.id_rol=id;
	}
	
	
	

}


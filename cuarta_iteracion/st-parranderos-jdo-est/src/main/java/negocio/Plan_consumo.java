package negocio;

public class Plan_consumo implements VOPlan_consumo{
	private long id;
	private String descripcion;
	private long valor;
	private int descuento;
	
	public Plan_consumo() {
		this.setDescripcion("");
		this.setDescuento(0);
		this.setId(0);
		this.setValor(0);
	}
	public Plan_consumo(String descripcion, long id, long valor, int decuento) {
		this.setDescripcion(descripcion);
		this.setDescuento(decuento);
		this.setId(id);
		this.setValor(valor);
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the valor
	 */
	public long getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(long valor) {
		this.valor = valor;
	}
	/**
	 * @return the descuento
	 */
	public int getDescuento() {
		return descuento;
	}
	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	
	public String toString() {
		return "Plan_consumo [id="+this.id+",descripcion="+this.descripcion+",valor="+this.valor+",descuento="+this.descuento+"]";
		
	}
	
	
}

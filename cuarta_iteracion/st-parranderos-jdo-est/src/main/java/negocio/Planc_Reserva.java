package negocio;

public class Planc_Reserva  {
	
	private long id;
	private long plan_c;
	private long reserva;
	

	public Planc_Reserva() {
		this.id=0;
		this.plan_c=0;
		this.reserva=0;
	}
	public Planc_Reserva(long id, long plan_c, long reserva) {
		this.id=id;
		this.plan_c=plan_c;
		this.reserva=reserva;
	
	}
	public long getId() {
		return id;
	}
	public long getPlan_c() {
		return this.plan_c;
	}
	public long getReserva() {
		return this.reserva;
	}
	public void setId(long id) {
		this.id=id;
	}
	public void setPlan_c(long Plan_c) {
		this.plan_c=Plan_c;
	}
	public void setReserva(long reserva) {
		this.reserva=reserva;
	}
	
	public String toString() {
		return "Planc_Reserva [id="+this.id+",id_plan_c="+this.plan_c+",id_reserva="+this.reserva+"]";
		
	}
	
}

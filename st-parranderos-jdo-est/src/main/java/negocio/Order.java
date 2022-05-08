package negocio;

public class Order implements VOOrder{
	private long id;
	private long ordernumber;
	private long personid;
	
	public Order() {
		this.setId(0);
		this.setOrdernumber(0);
		this.setPersonid(0);
	}
	
	public Order(long id, long ordernumber, long personid) {
		this.setId(id);
		this.setOrdernumber(ordernumber);
		this.setPersonid(personid);
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
	 * @return the ordernumber
	 */
	public long getOrdernumber() {
		return ordernumber;
	}

	/**
	 * @param ordernumber the ordernumber to set
	 */
	public void setOrdernumber(long ordernumber) {
		this.ordernumber = ordernumber;
	}

	/**
	 * @return the personid
	 */
	public long getPersonid() {
		return personid;
	}

	/**
	 * @param personid the personid to set
	 */
	public void setPersonid(long personid) {
		this.personid = personid;
	}
	
	public String toString () {
		return "Orders [Orderid="+this.id+",Ordernumber="+this.ordernumber+",personid="+this.personid+"]";
		
	}
	

}

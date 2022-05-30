package negocio;

public class Person implements VOPerson {
	private long id;
	private String lastname;
	private String fristname;
	private String adress;
	private String city;
	
	public Person() {
		this.setAdress("");
		this.setCity("");
		this.setFristname("");
		this.setId(0);
		this.setLastname("");
	}
	public Person(String ad, String city, String fr, String ls, long id ) {
		this.setAdress(ad);
		this.setCity(city);
		this.setFristname(fr);
		this.setId(id);
		this.setLastname(ls);
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
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the fristname
	 */
	public String getFristname() {
		return fristname;
	}
	/**
	 * @param fristname the fristname to set
	 */
	public void setFristname(String fristname) {
		this.fristname = fristname;
	}
	/**
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}
	/**
	 * @param adress the adress to set
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	public String toString() {
		return "Persons [Personid="+this.id+",Lastname="+this.lastname+",firstname="+this.fristname+",address="+this.adress+",city="+this.city+"]";
	}

}

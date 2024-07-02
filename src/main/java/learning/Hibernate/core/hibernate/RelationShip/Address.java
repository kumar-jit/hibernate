package learning.Hibernate.core.hibernate.RelationShip;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	private String city;
	private int pin;
	
	@OneToOne
	private User user;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address(int id, String city, int pin, User user) {
		super();
		this.id = id;
		this.city = city;
		this.pin = pin;
		this.user = user;
	}
	
	
	
}

package learning.Hibernate.core.hibernate.RelationShip;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	private String city;
	private int pin;
	
	@ManyToMany
	@JoinTable(name = "ad_join_table", 
				joinColumns = {
						@JoinColumn(name= "ad_id")
				}, 
				inverseJoinColumns = {
						@JoinColumn(name="u_id")
				}
			 )
	private List<User> user;
	
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
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public Address(int id, String city, int pin, List<User> user) {
		super();
		this.id = id;
		this.city = city;
		this.pin = pin;
		this.user = user;
	}
	
	
	
}

package learning.Hibernate.core.hibernate.RelationShip;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class relationApp {
	public static void main(String[] args) {
		 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		 
		 Address address = new Address();
		 address.setCity("Tarakes");
		 address.setPin(71241);
		 
		 Address address2 = new Address();
		 address2.setCity("Howrah");
		 address2.setPin(74100);
		 
		 Address address3 = new Address();
		 address3.setCity("Kolkata");
		 address3.setPin(98130);
		 
		 List<Address> addList = new ArrayList<Address>();
		 addList.add(address);
		 addList.add(address2);
		 addList.add(address3);
		 
		 User user = new User();
		 user.setName("Kumarjit");
		 user.setEmail("kum@gaml");
		 user.setAge(3);
		 user.setAdress(addList);
		 
		 User user2 = new User();
		 user.setName("sunil");
		 user.setEmail("suniol@gaml");
		 user.setAge(5);
		 user.setAdress(addList);
		 
		 List<User> userList = new ArrayList<User>();
		 userList.add(user2);
		 userList.add(user);
		 
		 List<User> userList2 = new ArrayList<User>();
		 userList2.add(user);
		 
		 address2.setUser(userList2);
		 address.setUser(userList);
		 address3.setUser(userList);
		 
		 Session session = sessionFactory.getCurrentSession();
		 
	       Transaction tx = session.beginTransaction();
	       
	        session.save(user);
	        session.save(user2);
	        session.save(address);
	        session.save(address2);
	        session.save(address3);

	       tx.commit();
	       
	       
	       
	       session.close();
	       
		 
	       session = sessionFactory.openSession();
	       User u = session.get(User.class, 1);
	       
	       System.out.println("only user display----------------------------------------------------------------");
	       	
	       System.out.println("calling address");
	       
	       u.getAdress().size();
	       
	       session.close();
		 
	}
}

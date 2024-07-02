package learning.Hibernate.core.hibernate.RelationShip;

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
		 
		 User user = new User();
		 user.setName("Kumarjit");
		 user.setEmail("kum@gaml");
		 user.setAge(3);
		 user.setAdress(address);
		 
		 address.setUser(user);
		 
		 Session session = sessionFactory.getCurrentSession();
		 
	       Transaction tx = session.beginTransaction();
	       
	        session.save(user);
	        session.save(address);

	       tx.commit();

	       session.close();
		 
		 
	}
}

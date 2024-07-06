package learning.Hibernate.core.hibernate.RelationShip;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import learning.Hibernate.core.hibernate.Student;


public class hibernateCachePractice {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session1 =  sessionFactory.openSession();
		Criteria c = session1.createCriteria(Student.class);
		c.add(Restrictions.eq("city","tarakeswar"));
		List<Student> s = c.list();
		
		
		
		System.out.println(s);
		System.out.println("-------------------------------------------------------------------");
		session1.close();
		
		
		Session session2 =  sessionFactory.openSession();
		System.out.println("-------------------------------------------------------------------");
		Student s2 = session2.get(Student.class, 1);
		System.out.println(s2);
	}

}

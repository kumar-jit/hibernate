package learning.Hibernate.core.hibernate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {  

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // student object
        Student st = new Student();
        st.setStudentId(2);
        st.setName("Kumarjit");
        st.setCity("Tarakeswar");
	    
	   Address1 ad = new Address1();
	   
	   ad.setCity("Tarakeswar");
	   ad.setStreet("tarakeswar Road");
	   ad.setAddedDate(new Date());
       ad.setOpen(true);
       ad.setX(12.33);
       
       // Read a image
       FileInputStream fs = new FileInputStream("src/main/java/img1.jpg");	// read the file
       byte[] fileByteData = new byte[fs.available()];	// create the byte array based on file size
       fs.read(fileByteData);				// insert the binary data to the array
       ad.setImage(fileByteData);	
       
       
       //how to perform the query
   		// get the session
       Session session = sessionFactory.getCurrentSession();
       //start the session
       Transaction tx = session.beginTransaction();
       // save the changes
//        session.save(st);
        session.save(ad);
       // modify in the DB
       tx.commit();
       // close the session
       session.close();
       
       
       
       
       
       
//       SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//       Session se = sessionFactory.openSession();
//       Student student1 = (Student)se.get(Student.class,1);
//       System.out.println(student1);
//       se.close();
//       sessionFactory.close();
       
       
//       SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
       Session se = sessionFactory.openSession();
       Student student2 = (Student)se.load(Student.class,2);
       System.out.println(student2);
       se.close();
       sessionFactory.close();
    }
}

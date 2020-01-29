package com.telusko.DemoHib;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("unchecked")
	public static void main( String[] args )
    {	
    	/*
        Alien telusko = new Alien();
        
        AlienName an = new AlienName();
        an.setfName("Shahrukh");
        an.setmName("Manzoor");
        an.setlName("Tramboo");
        
    	//Alien telusko = null;
    	
//        telusko.setAid(102);
//        telusko.setAname("Shahrukh");
//        telusko.setColor("White");
        
        telusko.setAid(101);
        telusko.setColor("Green");
        telusko.setAname(an);
        
        */
    	
    	/*
    	Laptop laptop = new Laptop();
    	laptop.setlId(101);
    	laptop.setlName("Dell");
    	
    	Student s = new Student();
    	s.setName("Navin");
    	s.setRollNo(1);
    	s.setMarks(50);
    	//s.setLaptop(laptop);
    	s.getLaptop().add(laptop);
        
    	laptop.getStudent().add(s);
    	
    	*/
    	
    	//Alien a = null;
    	
    	
    	
        
        //Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Laptop.class);
        
        //Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);

    	Configuration con = new Configuration().configure().addAnnotatedClass(Laptop.class);
    	
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        
        SessionFactory sf =  con.buildSessionFactory(reg);
        
        Session session = sf.openSession();
        
//        int b = 60;
        
        //Transaction tx = session.beginTransaction();
        
        session.beginTransaction();
        
        /*
        Query q1 = session.createQuery("from Alien where aid=101");
        q1.setCacheable(true);
        
        a = (Alien) q1.uniqueResult();
        
        //a = (Alien) session.get(Alien.class,101);
        System.out.println(a);
        */
        
//        a = (Alien) session.get(Alien.class,102);
//        System.out.println(a);
        
        //HQL
//        Random r = new Random();
//        
//        for(int i = 1; i<=50 ;i++) {
//        	Student s = new Student();
//        	s.setRollNo(i);
//        	s.setName("Name " + i);
//        	s.setMarks(r.nextInt(100));
//        	session.save(s);
//        }
        
       // Query q = session.createQuery("from Student where rollno = 7");
        
        //List<Student> students = q.list();
        
//        Query q = session.createQuery("select rollNo,name,marks from Student s where s.marks>60");
        
//        Query q = session.createQuery("select sum(marks) from Student s where s.marks> :b");	
//        q.setParameter("b", b);
        
//        Object[] student = (Object[]) q.uniqueResult();
        
//        Student student = (Student) q.uniqueResult();
        
//        System.out.println(student);
        
//        for(Student s : students) {
//        	System.out.println(s);
//        }
       //////////////////////////////////////////////// 
//        for(Object o : student) {
//        	System.out.println(o);
//        }
        
        //or
       // System.out.println(student[0] + " : " + student[1] + " : " + student[2]);
        
        //////////////////////////////////////////////
        
//        List<Object[]> students = (List<Object[]>) q.list();
        
//        Long marks = (Long) q.uniqueResult();
        
//        for(Object[] student : students) {
//        	System.out.println(student[0] + " : " + student[1] + " : " + student[2]);
//        }
        
//        	System.out.println(marks);
        
        //////////////////////////////////////////////
        
//        SQLQuery query = session.createSQLQuery("select * from student where marks > 60");
//        query.addEntity(Student.class);
//        List<Student> students = query.list();
        
//        SQLQuery query = session.createSQLQuery("select name,marks from student where marks > 60");
//        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
//        List students = query.list();
//        
//        for(Object o : students) {
//        	Map m = (Map) o;
//        	System.out.println(m.get("name") + " : " + m.get("marks"));
//        }
        
        //////////////////////////////////////////////
        
        /*
         * 
         * 			Object Persistance Lifecycle
         * 			
         * 
         * 				new						garbage
         * 		[--] ------------ Transient ----------- [--] 
         * 			\			  /					   /  /
         * 			 \			 /					  /	 /
         * 			  \		    /					 /	/
         * 			   \	   /					/  /	
         * 			   Persistent ---------- Removed  /
         * 					|						 /
         * 					|					   	/	
         * 					|					   /	
         * 				Detached-------------------
         * 
         * 
         */
        
        
//        Laptop l = new Laptop(); 
//        l.setlId(107);
//        l.setBrand("Lenovo");
//        l.setPrice("700");
//        
//        session.save(l);
//        l.setPrice("750");
        
        //session.delete(l); //to remove
        
        //////////////////////////////////////////////
        
//        Laptop lap = (Laptop) session.get(Laptop.class, 102); //it hits database
        
        Laptop lap = (Laptop) session.load(Laptop.class, 102); //it gives you proxy object. it will hit later
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println(lap);
        
//        if data is not found load will throw ObjectNotFound exception which can be handled, get just throw null
        
        //////////////////////////////////////////////
        session.getTransaction().commit();
        
//        session.evict(l);
//        l.setPrice("600");
        
        session.close();
        
        ///////////////////////////////////////////////
        /*
        Session session2 = sf.openSession();
        
        //Transaction tx = session.beginTransaction();
        
        session2.beginTransaction();
        
        Query q2 = session2.createQuery("from Alien where aid=101");
        q2.setCacheable(true);
        
        a = (Alien) q2.uniqueResult();
        
//        a = (Alien) session2.get(Alien.class,101);
        System.out.println(a);
        
        session2.getTransaction().commit();
        session2.close();
       
        */
        
//        Alien a1 = (Alien) session.get(Alien.class, 1);
//        System.out.println(a1.getAname());
        
        
//        Collection<Laptop> laps = a1.getLaps();
//        
//        for(Laptop l : laps) {
//        	System.out.println(l);
//        }
        
//        telusko = (Alien)session.get(Alien.class, 102);
        
        //session.save(telusko);
        
        /*
        session.save(laptop);
        session.save(s);
        */
        
        
        //tx.commit();
        
        //System.out.println(telusko);;
    }
}

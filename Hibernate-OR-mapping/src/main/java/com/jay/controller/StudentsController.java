package com.jay.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jay.Entiry.Address;
import com.jay.Entiry.Certificate;
import com.jay.Entiry.Studentlogin;
import com.jay.Entiry.Students;
import com.jay.HibernateUtil.HibernateUtil;

public class StudentsController {
	
	static Session session=HibernateUtil.getSession();
	Transaction transaction=null;
	
	public static void main(String[] a) {
		
		StudentsController st=new StudentsController();
		//Save Data
		Address address=st.saveAddress("Manipur", "Manipur", "Manipur", "844116");
		Studentlogin slid=st.saveStudentlogin("jayparak","123678");
		/*	st.saveStudent("Jp", "Praksh kumar", 1234,address,slid); */
		
		//user without mapped with xml file
		//st.addUser(1, "jp", "jp");
		
		HashSet set1 = new HashSet();
	      set1.add(new Certificate("MCA"));
	      set1.add(new Certificate("MBA"));
	      set1.add(new Certificate("PMP"));
		
	    st.saveStudent("Jaya", " Kumari", 785,address,slid,set1);
		
	    System.out.println("List of Students");
		st.listStudent();
		
	/*	st.updateStudent(1, 20000);
		
	    System.out.println("List of Students After Update");
		st.listStudent(); */
		
		//st.deleteEmployee(2);
		
		session.close(); 
	}
	
	private void saveStudent(String fname,String lname,int fee,Address ad,Studentlogin slogin,Set set1) {
		try {
			transaction = session.beginTransaction();
			Students data=new Students(fname,lname,fee,ad,slogin);
			data.setCertificate(set1);
			session.save(data);
			transaction.commit();
			System.out.println("Records inserted sucessessfully");
		}catch(HibernateException ex) {
			ex.printStackTrace();
		}
	}
	private Address saveAddress(String streetname,String cityname,String statename,String zip) {
		Address data=new Address(streetname, cityname, statename, zip);
		try {
			transaction = session.beginTransaction();
			
			session.save(data);
			transaction.commit();
			System.out.println("Records inserted sucessessfully");
			
		}catch(HibernateException ex) {
			ex.printStackTrace();
		}
		return data;  
	}
	
	private Studentlogin saveStudentlogin(String susername,String password) {
		Studentlogin data=new Studentlogin(susername,password);
		try {
			transaction = session.beginTransaction();
	
			session.save(data);
	        transaction.commit();
	        System.out.println("Records inserted sucessessfully");
	      
		}catch(HibernateException ex) {
			ex.printStackTrace();
		}
		  return data;  
	}
	
	   /* Method to list all the employees detail */
	   private void listStudent( ){
	 
	      try {
	    	 transaction = session.beginTransaction();
	         List<Students> student = session.createQuery("FROM Students").list(); 
	         for (Iterator<Students> iterator = student.iterator(); iterator.hasNext();){
	            Students rec = (Students) iterator.next(); 
	            System.out.print("First Name: " + rec.getFirst_name()); 
	            System.out.print("  Last Name: " + rec.getLast_name()); 
	            System.out.println("  Fee: " + rec.getFee());
	            Address add = rec.getAddressid();
	            System.out.println("Address ");
	            System.out.println("\tStreet: " +  add.getStreet_name());
	            System.out.println("\tCity: " + add.getCity_name());
	            System.out.println("\tState: " + add.getState_name());
	            System.out.println("\tZipcode: " + add.getZipcode());
	            Studentlogin slid=rec.getStudentlogin();
	            System.out.println("Student Login ");
	            System.out.println("\tUsername: " +  slid.getSusername());
	            System.out.println("\tPassword: " + slid.getSpassword());
	            Set certificates=rec.getCertificate();
	            for (Iterator iterator2 = certificates.iterator(); iterator2.hasNext();){
	               Certificate certName = (Certificate) iterator2.next(); 
	               System.out.println("Certificate: " + certName.getName()); 
	            }

	         }
	         transaction.commit();
	      } catch (HibernateException e) {
	         if (transaction!=null) transaction.rollback();
	         e.printStackTrace(); 
	      } 
	   }
	   
	   /* Method to update fee for an student */
	   private void updateStudent(Integer sid, int fee ){	      
	      try {
	    	 transaction = session.beginTransaction();
	         Students student = (Students)session.get(Students.class, sid); 
	         student.setFee(fee); 
	         session.update(student);
	         transaction.commit();
	      } catch (HibernateException e) {
	         if (transaction!=null) transaction.rollback();
	         e.printStackTrace(); 
	      } 
	        
	   }
	   
	   /* Method to delete an employee from the records */
	   public void deleteEmployee(Integer sid){
	      
	      try {
	    	 transaction = session.beginTransaction();
	         Students student = (Students)session.get(Students.class, sid); 
	         session.delete(student); 
	         transaction.commit();
	      } catch (HibernateException e) {
	         if (transaction!=null) transaction.rollback();
	         e.printStackTrace(); 
	      }
	   }
	   
}

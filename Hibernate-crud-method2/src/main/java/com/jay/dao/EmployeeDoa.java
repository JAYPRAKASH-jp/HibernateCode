package com.jay.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jay.entity.Book;
import com.jay.entity.Employee;
import com.jay.utility.HibernateUtil;

public class EmployeeDoa {
	
	
	public void saveEmp(String emp_address,String emp_name,String emp_emp_mobile_nos){
        Session session = HibernateUtil.getSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Employee data=new Employee();
            
            data.setEmp_address(emp_address);
            data.setEmp_mobile_nos(emp_emp_mobile_nos);
            data.setEmp_name(emp_name);
            
            session.save(data);
            transaction.commit();
            System.out.println("Records inserted sucessessfully");
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
	
    public List<Employee> getemp(){
    	Session session = HibernateUtil.getSession(); 
        Query query = session.createQuery("from Employee");
        List<Employee> emp =  query.list();
        session.close();
        return emp;
    }
}

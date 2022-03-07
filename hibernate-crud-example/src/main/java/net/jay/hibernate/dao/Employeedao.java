package net.jay.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import net.jay.hibernate.model.Employee;
import net.jay.hibernate.util.Hibernateutil;

public class Employeedao {
	public void saveInstructor(Employee instructor) {
		Transaction transaction = null;
		try (Session session = Hibernateutil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(instructor);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}

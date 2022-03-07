package net.jay.hibernate;

import net.jay.hibernate.dao.Employeedao;
import net.jay.hibernate.model.Employee;

public class App {
public static void main(String[] aargs) {
	
	Employeedao emp=new Employeedao();
	
	Employee employee=new Employee("Jay","Bihar","90897897");
	
	emp.saveInstructor(employee);
}
}

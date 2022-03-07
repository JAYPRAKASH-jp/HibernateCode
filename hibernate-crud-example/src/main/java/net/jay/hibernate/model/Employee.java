package net.jay.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="emp_name")
	private String emp_name;
	@Column(name="emp_address")
	private String emp_address;
	@Column(name="emp_mobile_nos")
	private String emp_mobile_nos;
	
	
	
	public Employee(String emp_name, String emp_address, String emp_mobile_nos) {
		super();
		this.emp_name = emp_name;
		this.emp_address = emp_address;
		this.emp_mobile_nos = emp_mobile_nos;
	}
	
	
	
	public Employee() {
		super();
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_address() {
		return emp_address;
	}
	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}
	public String getEmp_mobile_nos() {
		return emp_mobile_nos;
	}
	public void setEmp_mobile_nos(String emp_mobile_nos) {
		this.emp_mobile_nos = emp_mobile_nos;
	}
	
	
}

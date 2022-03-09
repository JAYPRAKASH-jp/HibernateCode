package com.jay.Entiry;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="students")
public class Students {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String first_name; 
	private String last_name;
	private int fee;
	private Address addressid;
	private Studentlogin studentlogin;
	private Set certificate;
	
	





	public Set getCertificate() {
		return certificate;
	}


	public void setCertificate(Set certificate) {
		this.certificate = certificate;
	}


	public Studentlogin getStudentlogin() {
		return studentlogin;
	}


	public void setStudentlogin(Studentlogin studentlogin) {
		this.studentlogin = studentlogin;
	}


	public Address getAddressid() {
		return addressid;
	}


	public void setAddressid(Address addressid) {
		this.addressid = addressid;
	}



	public Students() {
		super();
	}

	




	public Students(String first_name, String last_name, int fee, Address addressid, Studentlogin studentlogin) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.fee = fee;
		this.addressid = addressid;
		this.studentlogin = studentlogin;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	
	
}

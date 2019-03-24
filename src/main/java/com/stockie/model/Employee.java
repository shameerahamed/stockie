package com.stockie.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Shameer Ahamed
 * 
 */
@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = -723583058586873479L;

	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EMP_ID")
	//@SequenceGenerator(name = "SEQ_EMP_ID", sequenceName = "SEQ_EMP_ID", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "emp_id")
	private Long empId;

	@Column(name = "emp_name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "salary")
	private Long salary;

	@Column(name = "age")
	private Integer age;

	@Column(name = "email_address")
	private String email;

	@Column(name = "phone_no")
	private Long phoneNo;

	@Column(name = "designation")
	private String designation;

	@Column(name = "dob")
	private String dob;

	@Column(name = "doj")
	private String doj;

	
	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

}

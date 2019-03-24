package com.stockie.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * @author ShameerAhamed
 *
 */
@Entity
/*    */ @Table(name="CUSTOMER")
public class Customer {
	@Id
/*    */   @GeneratedValue(strategy=GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CUST_ID")
	//@SequenceGenerator(name = "SEQ_CUST_ID", sequenceName = "SEQ_CUST_ID",allocationSize=1)
	@Column(name = "cust_id")
	private Long custId;

	@Column(name = "custname")
	private String custName;

	@Column(name="address")
	private String address;

	@Column(name = "phone_no")
	private long phoneNo;

	@Column(name = "e_mail")
	private String email;

	@Column(name = "reg_date")
	private String regDate;

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

}

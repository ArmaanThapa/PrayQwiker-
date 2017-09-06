package com.qwikr.webapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_del")
public class Orderdetail {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "o_Id")
	private long o_id;
	@Column(name = "orderId")
	private String orderId;
	@Column(name = "userName")
	private String userName;
	@Column(name = "emailId")
	private String emailId;
	@Column(name = "mobileno")
	private String mobileno;
	@Column(name = "totalpayment")
	private long totalpayment;

	@Column(name = "date")
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Column(name = "transactionId")
	private String transactionId;
	@Column(name = "transactionStatus")
	@Enumerated(EnumType.STRING)
	private Statuss transactionStatus;
	@Column(name = "PGuserMobileNumber")
	private String PGuserMobileNumber;
	@Column(name = "PGUserName")
	private String PGUserName;
	@Column(name = "PGUserEmail")
	private String PGUserEmail;

	public long getO_id() {
		return this.o_id;
	}

	public void setO_id(long o_id) {
		this.o_id = o_id;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileno() {
		return this.mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public long getTotalpayment() {
		return this.totalpayment;
	}

	public void setTotalpayment(long totalpayment) {
		this.totalpayment = totalpayment;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Statuss getTransactionStatus() {
		return this.transactionStatus;
	}

	public Statuss setTransactionStatus(Statuss status) {
		return this.transactionStatus = status;
	}

	public String getPGuserMobileNumber() {
		return this.PGuserMobileNumber;
	}

	public void setPGuserMobileNumber(String pGuserMobileNumber) {
		this.PGuserMobileNumber = pGuserMobileNumber;
	}

	public String getPGUserName() {
		return this.PGUserName;
	}

	public void setPGUserName(String pGUserName) {
		this.PGUserName = pGUserName;
	}

	public String getPGUserEmail() {
		return this.PGUserEmail;
	}

	public void setPGUserEmail(String pGUserEmail) {
		this.PGUserEmail = pGUserEmail;
	}
}

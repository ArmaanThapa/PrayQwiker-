package com.qwikr.webapi.dto;

public class MerchantResponse 
{
	private String sucess;
	private String orderID;
	private String description;
	private String additionalInfo;
	
	public String getSucess() {
		return sucess;
	}
	public void setSucess(String sucess) {
		this.sucess = sucess;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdditionalInfo() {
		return additionalInfo;
	}
	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

}

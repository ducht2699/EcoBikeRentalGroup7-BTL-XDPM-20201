/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.group7.ecobikerentalgroup7.Entity;


public class PaymentMethod {
	
	private int methodId;
	
	private String cardholderName; //tên chủ thẻ
	
	private String cardNumber; // số thẻ
	
	private String issuingBank; // ngân h
	
	private String expirationDate; //ngày hết hạn
	
	private String securityCode; // mã bảo mật
	
	private float remainingAmount; // số tiền còn lại trong thẻ
	
	private int userId;
	
	public PaymentMethod() {
		
	}

	public PaymentMethod(int methodId, String cardholderName, String cardNumber, String issuingBank,
			String expirationDate, String securityCode, float remainingAmount, int userId) {
		super();
		this.methodId = methodId;
		this.cardholderName = cardholderName;
		this.cardNumber = cardNumber;
		this.issuingBank = issuingBank;
		this.expirationDate = expirationDate;
		this.securityCode = securityCode;
		this.remainingAmount = remainingAmount;
		this.userId = userId;
	}

	public int getMethodId() {
		return methodId;
	}

	public void setMethodId(int methodId) {
		this.methodId = methodId;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getIssuingBank() {
		return issuingBank;
	}

	public void setIssuingBank(String issuingBank) {
		this.issuingBank = issuingBank;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public float getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(float remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
    
}

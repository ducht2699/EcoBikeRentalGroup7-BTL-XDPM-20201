/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.group7.ecobikerentalgroup7.Entity;


public class Transaction {
	
	private int transactionId;
	private int bikeId;
	private int userId;
	private int paymentMethodId;
    private String startTime, endTime;
    private int status; // trạng thái(0: đã trả xe, 1: đang thuê)
    private String description; // mô tả
    private float deposit; // tiền cọc(đã trả xe thì giả lại tiền cọc)

    public Transaction() {
    	
    }

	public Transaction(int transactionId, int bikeId, int userId, int paymentMethodId, String startTime, String endTime,
			int status, String description, float deposit) {
		super();
		this.transactionId = transactionId;
		this.bikeId = bikeId;
		this.userId = userId;
		this.paymentMethodId = paymentMethodId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
		this.description = description;
		this.deposit = deposit;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(int paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getDeposit() {
		return deposit;
	}

	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.group7.ecobikerentalgroup7.Entity;

public class PaymentMethod {

    private int methodID;

    private String cardholderName; //tên chủ thẻ

    private String cardNumber; // số thẻ

    private String issuingBank; // ngân h

    private String expirationDate; //ngày hết hạn

    private int securityCode; // mã bảo mật

    private float remainingAmount; // số tiền còn lại trong thẻ

    private int virtual_acount_id;

    private int userId;

    public PaymentMethod() {

    }

    public PaymentMethod(int methodID, String cardholderName, String cardNumber, String issuingBank, String expirationDate, int securityCode, float remainingAmount, int virtual_acount_id, int userId) {
        this.methodID = methodID;
        this.cardholderName = cardholderName;
        this.cardNumber = cardNumber;
        this.issuingBank = issuingBank;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
        this.remainingAmount = remainingAmount;
        this.virtual_acount_id = virtual_acount_id;
        this.userId = userId;
    }
    
    

    public int getVirtual_acount_id() {
        return virtual_acount_id;
    }

    public void setVirtual_acount_id(int virtual_acount_id) {
        this.virtual_acount_id = virtual_acount_id;
    }

    public int getMethodID() {
        return methodID;
    }

    public void setMethodID(int methodID) {
        this.methodID = methodID;
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

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
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

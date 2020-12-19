package com.hust.group7.ecobikerentalgroup7.Entity;

public class Cost {
	private String type; // loại xe 
	private float deposit; //tiền cọc
	private float _30mFirst; // 30 phút đầu
	private float _15mLater; // mỗi 15 phút sau
	
	public Cost() {}
	
	public Cost(String type, float deposit, float _30mFirst, float _15mLater) {
		super();
		this.type = type;
		this.deposit = deposit;
		this._30mFirst = _30mFirst;
		this._15mLater = _15mLater;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getDeposit() {
		return deposit;
	}

	public void setDeposit(float deposit) {
		this.deposit = deposit;
	}

	public float get_30mFirst() {
		return _30mFirst;
	}

	public void set_30mFirst(float _30mFirst) {
		this._30mFirst = _30mFirst;
	}

	public float get_15mLater() {
		return _15mLater;
	}

	public void set_15mLater(float _15mLater) {
		this._15mLater = _15mLater;
	}
	
}

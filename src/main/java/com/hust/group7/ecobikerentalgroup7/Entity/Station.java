/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hust.group7.ecobikerentalgroup7.Entity;


public class Station {
	
	private int stationId;
	private String name;
	private String address;
	private int numberOfDocks;
	private float distance; // khoảng cách đi đến bãi xe(mét)
	private float time; // thời gian đi đến bãi xe(phút)
	private int numberOfBikes; //số xe trong bãi
	private int numberOfEbikes; // số xe điện trong bãi
	private int numberOfTwinBikes; // số xe đôi trong bãi
	private int numberOfEmptyDocks; // số chỗ trống trong bãi
	
	public Station() {
		// TODO Auto-generated constructor stub
	}

	public Station(int stationId, String name, String address, int numberOfDocks, float distance, float time,
			int numberOfBikes, int numberOfEbikes, int numberOfTwinBikes, int numberOfEmptyDocks) {
		super();
		this.stationId = stationId;
		this.name = name;
		this.address = address;
		this.numberOfDocks = numberOfDocks;
		this.distance = distance;
		this.time = time;
		this.numberOfBikes = numberOfBikes;
		this.numberOfEbikes = numberOfEbikes;
		this.numberOfTwinBikes = numberOfTwinBikes;
		this.numberOfEmptyDocks = numberOfEmptyDocks;
	}

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
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

	public int getNumberOfDocks() {
		return numberOfDocks;
	}

	public void setNumberOfDocks(int numberOfDocks) {
		this.numberOfDocks = numberOfDocks;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public int getNumberOfBikes() {
		return numberOfBikes;
	}

	public void setNumberOfBikes(int numberOfBikes) {
		this.numberOfBikes = numberOfBikes;
	}

	public int getNumberOfEbikes() {
		return numberOfEbikes;
	}

	public void setNumberOfEbikes(int numberOfEbikes) {
		this.numberOfEbikes = numberOfEbikes;
	}

	public int getNumberOfTwinBikes() {
		return numberOfTwinBikes;
	}

	public void setNumberOfTwinBikes(int numberOfTwinBikes) {
		this.numberOfTwinBikes = numberOfTwinBikes;
	}

	public int getNumberOfEmptyDocks() {
		return numberOfEmptyDocks;
	}

	public void setNumberOfEmptyDocks(int numberOfEmptyDocks) {
		this.numberOfEmptyDocks = numberOfEmptyDocks;
	}
	
}

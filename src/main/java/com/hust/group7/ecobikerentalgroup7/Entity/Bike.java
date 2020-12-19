package com.hust.group7.ecobikerentalgroup7.Entity;

public class Bike {
    private int bikeId;//id
    private String name;//tên
    private String type;//loại xe
    private float weight;//cân nặng(kg)
    private String licensePlate; // biển xe
    private String manufacturingDate; // ngày sản xuất
    private String producer;//hãng sx
    private String barcode; // mã vạch
    private int status; // trạng thái(0: chưa thuê, 1: đã thuê)
    private int stationId; // id bãi xe
    private String image; //ảnh
    private Cost cost; // giá tiền
    
    public Bike() {}

	public Bike(int bikeId, String name, String type, float weight, String licensePlate, String manufacturingDate,
			String producer, String barcode, int status, int stationId, String image, Cost cost) {
		super();
		this.bikeId = bikeId;
		this.name = name;
		this.type = type;
		this.weight = weight;
		this.licensePlate = licensePlate;
		this.manufacturingDate = manufacturingDate;
		this.producer = producer;
		this.barcode = barcode;
		this.status = status;
		this.stationId = stationId;
		this.image = image;
		this.cost = cost;
	}

	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}
    
    
    
}

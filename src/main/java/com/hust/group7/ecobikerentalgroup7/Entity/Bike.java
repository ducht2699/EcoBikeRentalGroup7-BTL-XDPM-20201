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
    private String bateryPercentage; //dung lượng pin hiện tại (%)
	private String loadCycles; // Số lần sạc
	private String timeRemaining; // Thời gian hết pin (giờ)
    
    public Bike() {}
    public Bike(String name, String type, float weight, String licensePlate, String manufacuringDate,String producer, String barcode,String bateryPercentage, int stationId, String image){
    	super();
    	this.name = name;
		this.type = type;
		this.weight = weight;
		this.licensePlate = licensePlate;
		this.manufacturingDate = manufacuringDate;
		this.producer = producer;
		this.barcode = barcode;
		this.bateryPercentage = bateryPercentage;
		this.stationId = stationId;
		this.image = image;
    }

	public Bike(int bikeId, String name, String type, float weight, String licensePlate, String manufacturingDate,
			String producer, String barcode, int status, int stationId, String image, Cost cost,
			String bateryPercentage, String loadCycles, String timeRemaining) {
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
		this.bateryPercentage = bateryPercentage;
		this.loadCycles = loadCycles;
		this.timeRemaining = timeRemaining;
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
	public String getBateryPercentage() {
		return bateryPercentage;
	}

	public void setBateryPercentage(String bateryPercentage) {
		this.bateryPercentage = bateryPercentage;
	}

	public String getLoadCycles() {
		return loadCycles;
	}

	public void setLoadCycles(String loadCycles) {
		this.loadCycles = loadCycles;
	}

	public String getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(String timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

    
    
}

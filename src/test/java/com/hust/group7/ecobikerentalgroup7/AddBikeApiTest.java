package com.hust.group7.ecobikerentalgroup7;


import static org.junit.Assert.assertTrue;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import com.hust.group7.ecobikerentalgroup7.Entity.Bike;
import com.hust.group7.ecobikerentalgroup7.api.BikeApi;

public class AddBikeApiTest  {
	private static DataBase db;
	static  int tmp;
	
	@Test
	public void testGetAllBike() throws SQLException {
		db = new DataBase();
		ArrayList<Bike> list = BikeApi.getAllBikes();
		
		
		assertTrue("No data", list.size() > 0);
	}
	public static int getQuanlityBike() throws SQLException {
		ArrayList<Bike> list = BikeApi.getAllBikes();
		return list.size();
	}
	
	public static int addBike(Bike bike) throws SQLException {
		db = new DataBase();
	
		BikeApi.addBike(bike.getName(), bike.getType(), bike.getWeight(), bike.getLicensePlate(), bike.getManufacturingDate(),  bike.getProducer(),
				bike.getBateryPercentage(), bike.getBarcode(), bike.getStationId(), bike.getImage());
		
		ArrayList<Bike> list = BikeApi.getAllBikes();
		return list.size();
	}
	
	@Test
	public void testAddBike() throws SQLException {
		db = new DataBase();
		Bike bike = new Bike("X","Bike",20,"a","2020-12-19","as","bs","cs",1,"image");
		tmp = getQuanlityBike();
		int afterAdd = addBike(bike);
		System.out.println("tmp: "+ tmp);
		System.out.println("bike: "+ afterAdd);
		assertTrue("Eror in add bike API!", afterAdd == (tmp +1));
	}
	
}

package com.hust.group7.ecobikerentalgroup7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import com.hust.group7.ecobikerentalgroup7.Entity.Bike;
import com.hust.group7.ecobikerentalgroup7.api.BikeApi;

public class AddBikeApiTest {
	private static DataBase db;
	private static int tmp;
	
	@Test
	public void testGetAllBike() throws SQLException {
		db = new DataBase();
		ArrayList<Bike> list = BikeApi.getAllBikes();
		tmp = list.size();
		System.out.println(tmp);
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
		System.out.println(addBike(bike));
		assertTrue("Eror in add bike API!", addBike(bike) > tmp);
	}
	
}

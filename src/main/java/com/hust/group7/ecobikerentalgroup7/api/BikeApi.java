package com.hust.group7.ecobikerentalgroup7.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hust.group7.ecobikerentalgroup7.DataBase;
import com.hust.group7.ecobikerentalgroup7.Entity.Bike;
import com.hust.group7.ecobikerentalgroup7.Entity.Cost;

public class BikeApi {

	public static ArrayList<Bike> getAllBikes() throws SQLException {
		Statement statement =DataBase.connectionStatic.createStatement();
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		String sqlString = "select * from bikes left join cost on bikes.type=cost.bike_type";
		ResultSet rs = statement.executeQuery(sqlString);
		while (rs.next()) {
			Bike bike = new Bike(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getFloat("weight"),
					rs.getString("license_plate"), rs.getString("manuafacturing_date"), rs.getString("producer"),
					rs.getString("barcode"), rs.getInt("status"), rs.getInt("station_id"), rs.getString("image"),
					new Cost(rs.getString("bike_type"), rs.getFloat("deposit"), rs.getFloat("30m_first"),
							rs.getFloat("15m_later")),
					rs.getString("batery_percentage"), rs.getString("load_cycles"), rs.getString("time_remaining"));
			bikes.add(bike);
		}
		return bikes;
	}
	
	public static ArrayList<Bike> getAllBikesInStation(int stationId) throws SQLException {
		Statement statement = DataBase.connectionStatic.createStatement();
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		String sqlString = "select * from bikes, cost where station_id = '" + stationId + "' and bikes.type=cost.bike_type";
		ResultSet rs = statement.executeQuery(sqlString);
		while (rs.next()) {
			Bike bike = new Bike(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getFloat("weight"),
					rs.getString("license_plate"), rs.getString("manuafacturing_date"), rs.getString("producer"),
					rs.getString("barcode"), rs.getInt("status"), rs.getInt("station_id"), rs.getString("image"),
					new Cost(rs.getString("bike_type"), rs.getFloat("deposit"), rs.getFloat("30m_first"),
							rs.getFloat("15m_later")),
					rs.getString("batery_percentage"), rs.getString("load_cycles"), rs.getString("time_remaining"));
			bikes.add(bike);
		}
		return bikes;
	}
	public static void updateBike(Integer bikeId, String name, String type, Integer weight, String license_plate, String date, String producer, String battery, String loadCycles, String timeRemaining, String barcode, Integer status, Integer stationId, String image) throws SQLException{
		 String sqlString = "UPDATE `tkxdpm`.`bikes` SET `name` = '" + name + "', `type` = '" + type + "', `weight` = '" + weight + "', `license_plate` = '" + license_plate
                 + "', `manuafacturing_date` = '" + date + "', `producer` = '" + producer + "', `batery_percentage` = '" + battery + "', `load_cycles` = '" + loadCycles
                 + "', `time_remaining` = '" + timeRemaining + "', `barcode` = '" + barcode + "', `status` = '" + status + "', `station_id` = '" + stationId
                 + "' WHERE (`id` = '" + bikeId + "')";
		 System.out.println(sqlString);
		 Statement statement = DataBase.connectionStatic.createStatement();
		 statement.executeUpdate(sqlString, Statement.RETURN_GENERATED_KEYS);
	     ResultSet rs = statement.getGeneratedKeys();
	}
	public static void addBike( String name, String type, float weight, String license_plate, String date, String producer, String battery, String barcode, Integer stationId, String image) throws SQLException{
		 String sqlString ="INSERT INTO `bikes` (`id`, `name`, `type`, `weight`, `license_plate`, `manuafacturing_date`, `producer`, `batery_percentage`, `load_cycles`, `time_remaining`, `barcode`,`status`, `station_id`, `image`) VALUES\n"
                 + "(null, '" + name
                 + "','" + type
                 + "',' " + weight
                 + "', '" + license_plate
                 + "', '" + date
                 + "', '" + producer
                 + "', '" + battery
                 + "',null, null, '" + barcode
                 + "', 0,'" + stationId
                 + "', '" + image + "')";
		 System.out.println(sqlString);
		 Statement statement = DataBase.connectionStatic.createStatement();
		 statement.executeUpdate(sqlString, Statement.RETURN_GENERATED_KEYS);
	     ResultSet rs = statement.getGeneratedKeys();
	}
	public static int getBikeAvailable(int stationId) throws SQLException {
		Statement statement = DataBase.connectionStatic.createStatement();
		String sqlString = "select count(*) as numberOfAvailableBikes from bikes where station_id='" + stationId
				+ "' and status='0'";
		ResultSet rs = statement.executeQuery(sqlString);
		if(rs.next()) return rs.getInt("numberOfAvailableBikes");
		return 0;
		
	}
	
	
	public static Bike getBikeById(int id) throws SQLException {
		Statement statement =DataBase.connectionStatic.createStatement();
		String sqlString = "select * from bikes, cost where id="+ id+" and bikes.type=cost.bike_type";
		ResultSet rs = statement.executeQuery(sqlString);
		Bike bike = new Bike(rs.getInt("id"), rs.getString("name"), rs.getString("type"), rs.getFloat("weight"),
				rs.getString("license_plate"), rs.getString("manuafacturing_date"), rs.getString("producer"),
				rs.getString("barcode"), rs.getInt("status"), rs.getInt("station_id"), rs.getString("image"),
				new Cost(rs.getString("bike_type"), rs.getFloat("deposit"), rs.getFloat("30m_first"),
						rs.getFloat("15m_later")),
				rs.getString("batery_percentage"), rs.getString("load_cycles"), rs.getString("time_remaining"));
		return bike;
	}
}

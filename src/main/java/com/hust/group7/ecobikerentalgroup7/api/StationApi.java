package com.hust.group7.ecobikerentalgroup7.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hust.group7.ecobikerentalgroup7.DataBase;
import com.hust.group7.ecobikerentalgroup7.Entity.Station;

public class StationApi {
	public static ArrayList<Station> getAllStations() throws SQLException {
		Statement statement = DataBase.connectionStatic.createStatement();
		ArrayList<Station> stations = new ArrayList<Station>();
		String sqlString = "select * from stations";
        ResultSet rs = statement.executeQuery(sqlString);
        System.out.println(rs);
        while (rs.next()) {
        	Statement statement1 = DataBase.connectionStatic.createStatement();
        	ResultSet rsNumberOfBikes = statement1.executeQuery("select count(*) as numberOfBikes from bikes where type='Bike' and station_id="+ rs.getInt("id"));
        	int numberOfBikes = 0,numberOfEBikes = 0,numberOfTwinBikes = 0,numberOfEmptyDocks;
        	if(rsNumberOfBikes.next()) {
        		
        		numberOfBikes = rsNumberOfBikes.getInt("numberOfBikes");
        	}
        	Statement statement2 =DataBase.connectionStatic.createStatement();
        	ResultSet rsNumberOfEBikes = statement2.executeQuery("select count(*) as numberOfEBikes from bikes where type='EBike' and station_id="+ rs.getInt("id"));
        	if(rsNumberOfEBikes.next()) {
        		
        		numberOfEBikes = rsNumberOfEBikes.getInt("numberOfEBikes");
        	}
        	Statement statement3 =DataBase.connectionStatic.createStatement();
        	ResultSet rsNumberOfTwinBikes = statement3.executeQuery("select count(*) as numberOfTwinBikes from bikes where type='Bike' and station_id="+ rs.getInt("id"));
        	if(rsNumberOfTwinBikes.next()) {
        		
        		numberOfTwinBikes = rsNumberOfTwinBikes.getInt("numberOfTwinBikes");
        	}
        	int numberOfDocks = rs.getInt("number_of_docks");
        	numberOfEmptyDocks = numberOfDocks - (numberOfBikes+numberOfEBikes+numberOfTwinBikes); 
        	System.out.println(numberOfBikes);
        	System.out.println(numberOfEBikes);
        	System.out.println(numberOfTwinBikes);
        	System.out.println(numberOfEmptyDocks);
            Station s = new Station(rs.getInt("id"), rs.getString("name"), rs.getString("address"), numberOfDocks, rs.getFloat("distance_to_walk"), rs.getFloat("time_to_walk"), numberOfBikes, numberOfEBikes, numberOfTwinBikes, numberOfEmptyDocks);
            stations.add(s);
        }
        return stations;
    }
	public static void updateStation(Integer stationId, String stationName, String stationAddress, Integer numberOfDocks, Float distanceToWalk, Float timeToWalk) throws SQLException{
		 String sqlString = "update stations set name='"+stationName+"', address='"+stationAddress+"', number_of_docks='"+numberOfDocks+"', distance_to_walk='"+distanceToWalk+"', time_to_walk='"+timeToWalk+"' where id="+stationId;
		 System.out.println(sqlString);
		 Statement statement = DataBase.connectionStatic.createStatement();
		 statement.executeUpdate(sqlString, Statement.RETURN_GENERATED_KEYS);
	     ResultSet rs = statement.getGeneratedKeys();
	}
	
	public static void addStation(Integer stationId, String stationName, String stationAddress, Integer numberOfDocks, Float distanceToWalk, Float timeToWalk) throws SQLException{
		 String sqlString = "insert into stations values ('"+stationId+"','"+stationName+"','"+stationAddress+"','"+numberOfDocks+"','"+distanceToWalk+"','"+timeToWalk;
		 System.out.println(sqlString);
		 Statement statement = DataBase.connectionStatic.createStatement();
		 statement.executeUpdate(sqlString, Statement.RETURN_GENERATED_KEYS);
	     ResultSet rs = statement.getGeneratedKeys();
	}
}

package com.hust.group7.ecobikerentalgroup7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.hust.group7.ecobikerentalgroup7.Entity.Station;
import com.hust.group7.ecobikerentalgroup7.api.StationApi;

public class StationApiTest {

	private static DataBase db;

	@Test
	public void testGetAllStation() throws SQLException {
		db = new DataBase();
		ArrayList<Station> list = StationApi.getAllStations();
		assertEquals("Error in get station api", list.size(), 3);
	}

	public static String updateStationAddress(Station station, String address) throws SQLException {
		db = new DataBase();
		String newAddress;
		StationApi.updateStation(station.getStationId(), station.getName(), address, station.getNumberOfDocks(),
				station.getDistance(), station.getTime());

		newAddress = StationApi.getAllStations().get(0).getAddress();
		return newAddress;
	}

	@Test
	public void testUpdateBook() throws SQLException {
		db = new DataBase();
		ArrayList<Station> list = StationApi.getAllStations();
		assertTrue("No data", list.size() > 0);

		Station station = list.get(0);
		String newAddress = "Tạ Quang Bửu";

		assertEquals("Eror in update station API!", updateStationAddress(station, newAddress), newAddress);
	}
}

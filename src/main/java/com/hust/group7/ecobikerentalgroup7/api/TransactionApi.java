package com.hust.group7.ecobikerentalgroup7.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hust.group7.ecobikerentalgroup7.DataBase;
import com.hust.group7.ecobikerentalgroup7.Entity.Bike;
import com.hust.group7.ecobikerentalgroup7.Entity.Cost;
import com.hust.group7.ecobikerentalgroup7.Entity.Transaction;

public class TransactionApi {
	public static Transaction getTransactionById(int userId) throws SQLException {
		Transaction transaction=new Transaction();
		Statement statement = DataBase.connectionStatic.createStatement();
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		String sqlGetTransaction = "SELECT * FROM transactions WHERE user_id = '" + userId + "'";
		ResultSet rs = statement.executeQuery(sqlGetTransaction);
		while (rs.next()) {
			transaction = new Transaction();
			transaction.setTransactionId(rs.getInt("id"));
			transaction.setBikeId(rs.getInt("bike_id"));
			transaction.setUserId(rs.getInt("user_id"));
			transaction.setStartTime(rs.getString("start_time"));
			transaction.setEndTime(rs.getString("end_time"));
			transaction.setPaymentMethodId(rs.getInt("payment_method_id"));
			transaction.setStatus(rs.getInt("status"));
			transaction.setDescription(rs.getString("description"));
			transaction.setDeposit(rs.getFloat("deposit"));
		}
		return transaction;
	}
}

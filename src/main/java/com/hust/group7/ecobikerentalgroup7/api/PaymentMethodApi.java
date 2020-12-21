package com.hust.group7.ecobikerentalgroup7.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hust.group7.ecobikerentalgroup7.DataBase;
import com.hust.group7.ecobikerentalgroup7.Entity.PaymentMethod;

public class PaymentMethodApi {
	public ArrayList<PaymentMethod> getAllPaymentMethods() throws SQLException {
		Statement statement = DataBase.connectionStatic.createStatement();
		ArrayList<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();
		String sqlString = "select * from payment_method";
		ResultSet rs = statement.executeQuery(sqlString);
		while (rs.next()) {
			PaymentMethod paymentMethod = new PaymentMethod(rs.getInt("id"), rs.getString("cardholder_name"),rs.getString("card_number"), rs.getString("issuing_bank"), rs.getString("expiration_date"), rs.getInt("security_code"), rs.getFloat("remaining_amount"),rs.getInt("virtual_acount_id") , rs.getInt("user_id"));
			paymentMethods.add(paymentMethod);
		}
		return paymentMethods;
	}
}

package com.hust.group7.ecobikerentalgroup7.api;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.hust.group7.ecobikerentalgroup7.DataBase;
import com.hust.group7.ecobikerentalgroup7.MainEntry;
import com.hust.group7.ecobikerentalgroup7.Entity.PaymentMethod;
import com.hust.group7.ecobikerentalgroup7.boundary.AddPayentMethodScreen;

public class PaymentMethodApi {
	public static ArrayList<PaymentMethod> getAllPaymentMethods() throws SQLException {
		Statement statement = DataBase.connectionStatic.createStatement();
		ArrayList<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();
		String sqlString = "select * from payment_methods";
		ResultSet rs = statement.executeQuery(sqlString);
		while (rs.next()) {
			PaymentMethod paymentMethod = new PaymentMethod();
			paymentMethod.setMethodID(rs.getInt("payment_id"));
			paymentMethod.setMethodID(rs.getInt("virtual_account_id"));
			paymentMethod.setMethodID(rs.getInt("user_id"));
			paymentMethods.add(paymentMethod);
		}
		return paymentMethods;
	}
	public static boolean addPaymentMethod(String issuingBank, String cardCode, String nameOwner, int cvvCode, String dateExpired, int userID) throws SQLException {
		Statement statement = DataBase.connectionStatic.createStatement();
		boolean check = false;
		String sqlString = "SELECT * FROM virtual_accounts";
        ResultSet rs = statement.executeQuery(sqlString);
        while (rs.next()) {
            if (issuingBank.equals(rs.getString("issuing_bank"))
                    && cardCode.equals(rs.getString("card_number"))
                    && nameOwner.equals(rs.getString("card_holder_name"))
                    && cvvCode == rs.getInt("cvv")
                    && dateExpired.equals(rs.getDate("expiration_date").toString())) {
            	
                sqlString = "insert into payment_methods values (null, " + rs.getInt("account_id") + ", " + userID + ")";
                statement.executeUpdate(sqlString, Statement.RETURN_GENERATED_KEYS);
                check = true;
                break;
            } else {
                check = false;
            }
        }
		
		
        return check;
	}
}

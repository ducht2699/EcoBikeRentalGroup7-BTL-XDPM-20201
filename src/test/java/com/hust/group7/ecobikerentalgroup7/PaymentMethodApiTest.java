package com.hust.group7.ecobikerentalgroup7;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hust.group7.ecobikerentalgroup7.Entity.Bike;
import com.hust.group7.ecobikerentalgroup7.api.BikeApi;
import com.hust.group7.ecobikerentalgroup7.api.PaymentMethodApi;


class PaymentMethodApiTest {

	private DataBase db;
	public PaymentMethodApiTest() throws SQLException {
		// TODO Auto-generated constructor stub
		db = new DataBase();
	}

	    

	    @BeforeEach
	    public void setUp() throws SQLException {
	        System.out.println("------BEFORE EACH----");
	        
	        
	    }
	    
	    @AfterEach
	    public void tearDown() {
	        System.out.println("------AFTER EACH----");
	    }
	    
	    public static int getCurCount() {
	    	int size = 0;
	    	try {
				size = PaymentMethodApi.getAllPaymentMethods().size();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return size;
	    }
	    
	    public static int addMethod(String issuingBank, String cardCode, String nameOwner, int cvvCode, String dateExpired, int userID) throws SQLException {
	    	PaymentMethodApi.addPaymentMethod(issuingBank, cardCode, nameOwner, cvvCode, dateExpired, userID);
	    	return PaymentMethodApi.getAllPaymentMethods().size();
		}

	@Test
	void testAddPaymentMethod() throws SQLException {
		System.out.println("TEST ADD PAYMENT METHOD");
		int currentSize = getCurCount();
		int afterAdd = addMethod("Vietinbank", "123456789", "HOANG TRUNG DUC", 123, "2025-10-10", 1);
		int afterAddFalse = addMethod("Vieinbank", "123456789", "HOANG TRUNG DUC", 123, "2025-10-10", 1);
		System.out.println("first : "+ currentSize);
		System.out.println("method after add 1: "+ afterAdd);
		System.out.println("method after add 2: "+ afterAddFalse);
		assertTrue("Eror in add payment method API!", afterAdd == (currentSize +1));
		assertTrue("Eror in add payment method API!", afterAddFalse == (currentSize + 1));
        
	}

}

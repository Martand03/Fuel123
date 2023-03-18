package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Client {
	
public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			@SuppressWarnings("unused")
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dd","root","Martandsql@03");
		    System.out.println("Connected");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in code");
		}
	}
}

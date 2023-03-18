package com.project.example;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;


public class Employee1 {
	final static String INSERT_STRING="insert into tblemployee(id,name,city,salary) values(?,?,?,?)";
    final static String DELETE_STRING="delete from tblemployee where id=?";
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, ClassNotFoundException,SQLException {
		
		
		Properties properties=new Properties();
		FileInputStream f1=new FileInputStream("C:\\Users\\marta\\super30\\MavenProject1\\src\\main\\java\\db.properties");
		properties.load(f1);
		
		
		String driverString=properties.getProperty("driver");
		String connectionString=properties.getProperty("connectionstring");
		String userString=properties.getProperty("user");
		String passwordString=properties.getProperty("password");
		Class.forName(driverString);
		
		
		Connection connection=DriverManager.getConnection(connectionString,userString,passwordString);
		System.out.println("connected");
		
		Scanner s1=new Scanner(System.in);
		
		
	
		
		
		System.out.println("Enter 1 to insert and 2 to delete");
		int ch=s1.nextInt();
		switch(ch)
		{
		case 1:
			System.out.println("Enter id");
            int id=s1.nextInt();
			System.out.println("Enter name");
			String nameString=s1.next();
			System.out.println("Enter city");
			String cityString=s1.next();
			System.out.println("Enter salary");
			float salary=s1.nextFloat();
			PreparedStatement pStatement=connection.prepareStatement(INSERT_STRING);
			pStatement.setInt(1, id);
			pStatement.setString(2,nameString);
			pStatement.setString(3, cityString);
			pStatement.setFloat(4, salary);
			pStatement.executeUpdate();
			break;
			
		case 2:
			
			System.out.println("Enter id to delete");
			int id1=s1.nextInt();
			PreparedStatement pStatement2=connection.prepareStatement(DELETE_STRING);
			pStatement2.setInt(1,id1);
	        pStatement2.executeUpdate();
			break;
		
		}
		
		
		
		
		
	}
}

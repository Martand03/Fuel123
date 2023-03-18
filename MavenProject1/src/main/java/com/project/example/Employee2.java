package com.project.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Employee2 {
	
	final static String INSERT_STRING="insert into emp(id,name,city,salary) values(?,?,?,?)";
    //final static String DELETE_STRING="delete from emp where id=?";
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException{
		Properties psProperties=new Properties();
		
		FileInputStream f1=new FileInputStream("C:\\Users\\marta\\super30\\MavenProject1\\src\\main\\java\\db.properties");
		
		psProperties.load(f1);
		
		String driverString=psProperties.getProperty("driver");
		String connectioString=psProperties.getProperty("connectionstring");
		String userString=psProperties.getProperty("user");
		String passString=psProperties.getProperty("password");
		
		Class.forName(driverString);
		Connection connection=DriverManager.getConnection(connectioString,userString,passString);
		System.out.println("Connected");
		
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter id");
		int id=scanner.nextInt();
		System.out.println("Enter name");
		String nameString=scanner.next();
		System.out.println("Enter city");
		String cityString=scanner.next();
		System.out.println("Enter salary");
		float salary=scanner.nextFloat();
		//System.out.println("Enter id to delete");
       //		int id1=scanner.nextInt();
		
		
		PreparedStatement pStatement=connection.prepareStatement(INSERT_STRING);
		pStatement.setInt(1, id);
		pStatement.setString(2, nameString);
		pStatement.setString(3, cityString);
		pStatement.setFloat(4, salary);
		pStatement.executeUpdate();
		
		
//		PreparedStatement pStatement2=connection.prepareStatement(INSERT_STRING);
//		pStatement2.executeUpdate();
	
		
		
	}
}

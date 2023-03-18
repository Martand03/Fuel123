package com.project.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;






public class Employee {

final static String INSERT_STRING="insert into tblemployee(id,name,city,salary) values (101,'martand','pune',143520)";
final static String INSERT1_STRING="insert into tblemployee(id,name,city,salary) values (102,'martand','mumbai',143520)";
final static String DELETE_STRING="delete from tblemployee where id=101";
final static String INSERT2_STRING="insert into tblemployee(id,name,city,salary) values (103,'Laxman','ayodhya',143520)";
final static String INSERT3_STRING="insert into tblemployee(id,name,city,salary) values (104,'parshuram','prayagraj',143520)";
final static String INSERT4_STRING="insert into tblemployee(id,name,city,salary) values (105,'Bhim','kashi',143520)";
final static String SELECT_STRING="select id,name from tblemployee";
final static String UPDATE_STRING="update tblemployee set name='Ram' where id=102";
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/proj","root","Martandsql@03");
			System.out.println("HEllO");
			Statement statement=connection.createStatement();
			statement.executeUpdate(INSERT_STRING);
			statement.executeUpdate(INSERT1_STRING);
			System.out.println("Data inserted");
			statement.executeUpdate(DELETE_STRING);
			System.out.println("Data deleted");
			statement.executeUpdate(UPDATE_STRING);
			System.out.println("Data Updated");
			statement.executeUpdate(INSERT2_STRING);
			statement.executeUpdate(INSERT3_STRING);
			statement.executeUpdate(INSERT4_STRING);


			ResultSet resultset=statement.executeQuery(SELECT_STRING);
			while(resultset.next())
			{
				System.out.println(resultset.getInt(1)+" "+resultset.getString(2));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("class not found");
		}
		catch (SQLException e) {
			// TODO: handle exception
			System.out.println("SQL Exception");
		}
	}
}

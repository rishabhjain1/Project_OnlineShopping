package ShoppingDatabase;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;

public class DatabaseOperations {
	private String DB_URL = "jdbc:mysql://localhost:3306/INVENTORY";
	private String USER = "root";
	private String PASS = "itsmyroot";
	//private Connection conn;
	
	public void getMobileBrands() {
		try {
			//System.out.println(USER);
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			//System.out.println("Connection: "+conn);		
			java.sql.Statement stmDha = conn.createStatement();
			String query = "SELECT BRAND FROM SMARTPHONES1 GROUP BY BRAND";
			ResultSet rs =  stmDha.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getString("BRAND")+" ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getMobileModels(String brand) {
		try {
			//System.out.println(USER);
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			//System.out.println("Connection: "+conn);		
			java.sql.Statement stmDha = conn.createStatement();
			String query = "SELECT PRODUCT_NAME FROM SMARTPHONES1 WHERE BRAND =" + brand+"GROUP BY PRODUCT_NAME";
			ResultSet rs =  stmDha.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getString("PRODUCT_NAME")+" ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getModelDetails(String brand, String model) {
		try {
			//System.out.println(USER);
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			//System.out.println("Connection: "+conn);		
			java.sql.Statement stmDha = conn.createStatement();
			String query = "SELECT * FROM SMARTPHONES1 WHERE BRAND =" + brand+"AND PRODUCT_NAME="+model;
			ResultSet rs =  stmDha.executeQuery(query);
			while (rs.next()) {
				System.out.print(rs.getString("BRAND")+" ");
				System.out.print(rs.getString("PRODUCT_NAME")+" ");
				System.out.print(rs.getInt("PRICE")+" ");
				System.out.print(rs.getString("COLOUR")+" ");
				System.out.println(rs.getBoolean("EMI")+" ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

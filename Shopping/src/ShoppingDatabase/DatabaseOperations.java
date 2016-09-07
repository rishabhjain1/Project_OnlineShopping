package ShoppingDatabase;

import java.beans.Statement;
import java.sql.*;

public class DatabaseOperations {
	private String DB_URL = "jdbc:mysql://localhost:3306/INVENTORY";
	private String USER = "root";
	private String PASS = "itsmyroot";
	
	
	//private Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
	
	public void getCategory() {
		System.out.println("Categories availible: ");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			//System.out.println("Connection:"+conn);
			
			java.sql.Statement stmt = conn.createStatement();
			String query = "SELECT DISTINCT CATEGORY FROM CATEGORY";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString("CATEGORY")+" ");
			}
			
		} catch(SQLException e1){
			
		} catch (ClassNotFoundException e2) {
			
		}
	}
	
	// Method to get SubCategories	
	public void getSubCategory(String category) {
		System.out.println("Sub Categories in " + category+ "are: ");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			//System.out.println("Connection:"+conn);
			//category = "\'"+category+"\'";
			java.sql.Statement stmt = conn.createStatement();
			String query = "SELECT SUB_CATEGORY FROM CATEGORY WHERE CATEGORY ="+category;
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString("SUB_CATEGORY")+" ");
			}
			
		} catch(SQLException e1) {
			
		} catch(ClassNotFoundException e2) {
			
		}
	}
	
	// Method to getBrands
	public void getBrands(String sub_category) {
		try {
			System.out.println("Brands availible in "+sub_category);
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			//System.out.println("Connection: "+conn);		
			
			java.sql.Statement stmt= conn.createStatement();
			String query = "SELECT DISTINCT BRAND FROM "+sub_category;
			ResultSet rs =  stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getString("BRAND")+" ");
			}
			
		} catch (SQLException e1) {
			//e.printStackTrace();
		} catch (ClassNotFoundException e2) {
			
		}
	}
		
	public void getBrandDetails(String sub_category,String brand) {
		try {
			System.out.println(brand);
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			//System.out.println("Connection: "+conn);		
			java.sql.Statement stmt = conn.createStatement();
			String query = "SELECT * FROM " + sub_category+ " WHERE BRAND =" + brand;
			ResultSet rs =  stmt.executeQuery(query);
			while (rs.next()) {
				System.out.print(rs.getInt("PID")+" ");
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

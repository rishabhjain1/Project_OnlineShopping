package ShoppingDatabase;

import java.beans.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class DatabaseOperations {
	private String DB_URL = "jdbc:mysql://localhost:3306/INVENTORY";
	private String USER = "root";
	private String PASS = "itsmyroot";
	
	
	//private Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
	
	public void getCategory() {
		System.out.println("Categories available: ");
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
				
				System.out.printf("%5d %-10s %-10s %-7d %-10s %-2b\n", rs.getInt("PID"), rs.getString("BRAND"), rs.getString("PRODUCT_NAME"), rs.getInt("PRICE"), rs.getString("COLOUR"), rs.getBoolean("EMI"));
				
				//System.out.print(rs.getInt("PID")+" ");
				//System.out.print(rs.getString("BRAND")+" ");
				//System.out.print(rs.getString("PRODUCT_NAME")+" ");
				//System.out.print(rs.getInt("PRICE")+" ");
				//System.out.print(rs.getString("COLOUR")+" ");
				//System.out.println(rs.getBoolean("EMI")+" ");
			}
		} catch (SQLException e1) {
			//e.printStackTrace();
		} catch (ClassNotFoundException e2) {
			
		}
	}		
	
	// method to purchase item
	public void PurchaseItem(String sub_category, int pid, int quantity) {
		try {
			System.out.println("Welcome to purchase");
			int tmpQuantity;
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			//System.out.println("Connection: "+conn);		
			java.sql.Statement stmt = conn.createStatement();
			String query = "SELECT QUANTITY FROM " + sub_category+ " WHERE PID =" + pid;
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			tmpQuantity = rs.getInt(1);
			
			if (tmpQuantity >= quantity){
				System.out.println("Purchase is successfull");
				setNcheckQuantity(sub_category, pid, quantity);
			}
			else {
				System.out.println("Quantity is not appropriate: " );
				System.out.println("Availible quantity: "+tmpQuantity);
				System.out.println("Enter New quantity");
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				quantity = Integer.parseInt(reader.readLine());
				this.PurchaseItem(sub_category, pid, quantity);
			}
						
		} catch (SQLException e1) {
			//e.printStackTrace();
		} catch (ClassNotFoundException e2) {
			
		} catch (IOException e3) {
			
		}
		
	}
	
	// to update the quantity after purchase
	private void setNcheckQuantity(String sub_category, int pid, int quantity) {
		int tmpQuantity;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			//System.out.println("Connection: "+conn);		
			java.sql.Statement stmt = conn.createStatement();
			String query = "SELECT QUANTITY FROM " + sub_category+ " WHERE PID =" + pid;
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			tmpQuantity = rs.getInt(1);
			//System.out.println("Before:"+tmpQuantity);
			tmpQuantity = tmpQuantity - quantity;
			//System.out.println("After:"+tmpQuantity);
			String query1 = "UPDATE "+sub_category +" SET QUANTITY ="+tmpQuantity +" WHERE PID="+ pid;
			//System.out.println(query1);
			stmt.executeUpdate(query1);
			
			
		} catch (SQLException e1) {
			//e.printStackTrace();
		} catch (ClassNotFoundException e2) {
			
		}
	}
			
}

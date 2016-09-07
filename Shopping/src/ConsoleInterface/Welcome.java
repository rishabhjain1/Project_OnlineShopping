package ConsoleInterface;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

import ShoppingDatabase.DatabaseOperations;

public class Welcome {
			
	public static void main(String[] args) {
		System.out.println("Welcome MSCI Mobile Shopping Portal");
		DatabaseOperations DB_Ops = new DatabaseOperations();
		System.out.println("Available Brands:");
		DB_Ops.getMobileBrands();
		
		String brand;
		System.out.println("Enter brand name:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
	        String str = reader.readLine();
	        brand="\'"+ str +"\' ";
	        DB_Ops.getMobileModels(brand);	
	        String model;
			System.out.println("Enter model name:");
			String str1 = reader.readLine();
	        model="\'"+ str1+"\' ";
	        DB_Ops.getModelDetails(brand, model);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }		
	
	}
}

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
		
		// SOP the categories
		DB_Ops.getCategory();
		System.out.println("");
		
//		String category = reader;
//		DB_Ops.getSubCategory(category);
		
//		System.out.println("Available Brands:");
//		DB_Ops.getMobileBrands();
		
		String brand;
		String category;
		String sub_category;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			// SOP THE SUBCATEGORIES
			System.out.println("Choose one of above categories: ");
			String str = reader.readLine();
			category = "\'"+ str +"\' ";
			DB_Ops.getSubCategory(category);
			System.out.println("");
			
			// SOP THE BRANDNAMES
	        System.out.println("Enter sub category:");
	        String str1 = reader.readLine();
	        sub_category= str1;
	        DB_Ops.getBrands(sub_category);
	        
	        //DB_Ops.getMobileModels(brand);	
	        //String model;
			//System.out.println("Enter model name:");
			//String str2 = reader.readLine();
	        //model="\'"+ str2+"\' ";
	        //DB_Ops.getModelDetails(brand, model);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }		
	
	}
}

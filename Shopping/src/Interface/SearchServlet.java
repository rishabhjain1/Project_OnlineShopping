package Interface;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ShoppingDatabase.DBSession;
@WebServlet("/SearchServlet")
public class SearchServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public SearchServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out =response.getWriter();
		String search = request.getParameter("search");
		/* request.getRequestDispatcher("/Search.html").include(request,response);*/
			 
			try {
				DBSession dbConnection = new DBSession();
				String query = "SELECT DISTINCT PRODUCTS.PID, PRODUCT_NAME,PRICE FROM PRODUCTS JOIN PRODUCT_CATEGORY ON PRODUCTS.PID=PRODUCT_CATEGORY.PID WHERE PRODUCT_NAME LIKE '%"+search+"%'OR CATEGORY LIKE '%"+search+"%'";
				ResultSet rs = dbConnection.runQuery(query);
				out.print("<html><head><meta charset=ISO-8859-1><title>Insert title here</title></head><body>");
				out.print("<table><tr><th>Product Name</th><th>Price</th></tr>");
				
				while(rs.next()) {
					String productName = rs.getString("PRODUCT_NAME");
					int price=rs.getInt("PRICE");
					int pid=rs.getInt("PRODUCTS.PID");
					out.print("<tr><td><a href = /Shopping/SpecificationServlet?p="+pid+">"+productName+"</a></td><td> "+price+"</td><td> </td></tr>");
					}
					dbConnection.close();
					out.print("</table>");
				} catch (ClassNotFoundException e) {
					out.print("HI");
					e.printStackTrace();
				} catch (SQLException e) {
					out.print("I");
					e.printStackTrace();
				}
		}
}

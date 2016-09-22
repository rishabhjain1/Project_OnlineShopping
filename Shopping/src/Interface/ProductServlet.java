package Interface;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ShoppingDatabase.DBSession;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductServlet() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		int price = Integer.parseInt(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String productName = request.getParameter("name");
		request.getRequestDispatcher("/category.html").include(request,response);
		try {
			DBSession dbConnection = new DBSession();
			String query = "SELECT MAX(PID) FROM PRODUCTS";
			ResultSet rs=dbConnection.runQuery(query);
			rs.next();
			int pid = rs.getInt(1);
			String query1 = "INSERT INTO PRODUCTS (PID,PRODUCT_NAME,PRICE,QUANTITY) VALUES  ("+pid+", '"+productName+"',"+price+","+quantity+")";
			dbConnection.runQuery(query1);
			out.println("<script type=\"text/javascript\">");
	        out.print("alert('"+productName+" added to database');");
	        out.println("</script>");
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
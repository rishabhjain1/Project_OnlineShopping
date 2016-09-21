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
import javax.servlet.http.HttpSession;

import ShoppingDatabase.*;
@WebServlet("/BillServlet")
public class BillServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public BillServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		int billNo = Integer.parseInt(request.getParameter("p"));
		int totalAmount = Integer.parseInt(request.getParameter("a"));
		HttpSession session=request.getSession(false);  
		String ID = (String)session.getAttribute("UserID");
		try {
			
			DBSession dbConnection = new DBSession();
			String query1= "SELECT DISTINCT DATE, TIME FROM PURCHASE_HISTORY WHERE BILL_NO="+billNo;
			ResultSet rs1 = dbConnection.runQuery(query1);
			rs1.next();
			String Date = rs1.getString("DATE");
			String Time = rs1.getString("TIME");
			String query = "SELECT PRODUCT_NAME, PURCHASE_HISTORY.PRICE, PURCHASE_HISTORY.quantity, DATE, TIME FROM PURCHASE_HISTORY JOIN PRODUCTS WHERE PURCHASE_HISTORY.PID=PRODUCTS.PID AND BILL_NO="+billNo;
			ResultSet rs = dbConnection.runQuery(query);
			DBOps Db = new DBOps();
			String html = Db.HTML(ID);
			int i=1;
			out.print(html);
			out.print("<center><table><tr><th colspan=5><h3>Shopping Spree Pvt Ltd.</h3></th></tr>"+
					  "<tr><td colspan=3>Name:"+ID+"<br>Bill No: "+billNo+"</td><td colspan=2>Date:"+Date+"<br>Time:"+Time+"</td></tr>"+
					  "<tr><th>S No.</th><th>Product Name</th><th>Price</th><th>Quantity</th><th>Amount</th></tr>");
			while(rs.next()) {
				String productName = rs.getString("PRODUCT_NAME");
				int price=rs.getInt("PURCHASE_HISTORY.PRICE");
				int quantity=rs.getInt("PURCHASE_HISTORY.quantity");
				int amount=price*quantity;
				out.print("<tr><td>" +  i+ "</td><td>" +productName+"</td><td>" +price+"</td><td>" +quantity+"</td><td>" +amount+"</td></tr>");
				i++;
			}
			out.print("<tr><td colspan=3></td><td colspan=1>Total Amount</td><td>"+totalAmount+"</td></tr>"+
					  "</table><center></body></html>");
			dbConnection.close();
			
		}catch (ClassNotFoundException e) {
			out.print("HI");
			e.printStackTrace();
		} catch (SQLException e) {
			out.print("I");
			e.printStackTrace();
		}
	}
}
			
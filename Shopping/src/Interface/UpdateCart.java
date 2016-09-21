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
@WebServlet("/UpdateCart")
public class UpdateCart  extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public UpdateCart() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		PrintWriter out =response.getWriter();
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		HttpSession session=request.getSession(false);
		String ID = (String)session.getAttribute("UserID");
		String search = request.getParameter("search");
		String user=ID;
		if(search != null){
			request.setAttribute("search",search);
			RequestDispatcher rd=request.getRequestDispatcher("/SearchServlet");
	        rd.include(request,response);
		}
			DBOps db = new DBOps();
			try {
				int count =db.getQuantity(pid, user);
				if(count>0){
					try {
					int result;
					result = db.PurchaseItem(pid,quantity);
					if (result==-1){
						db.updateCart(pid,user,quantity);
						out.print("<center><h3>Product already in cart, Quantity updated</h3></center>");
						}
					else
						out.print("<center><h3>enter quantity less than "+ result+"</h3></center>");
					}
					catch (NumberFormatException | ClassNotFoundException | SQLException e) {
							
							e.printStackTrace();
						}
				}
				
				else{
					try {
						int result;
						result = db.PurchaseItem(pid,quantity);
						if (result==-1){
							db.insertCart(pid,user,quantity);
							out.print("<center><h3>Product added to cart</h3></center>");
							}
						else
							out.print("enter quantity less than "+ result);
					} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
						
						e.printStackTrace();
					}
				}
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
			if(search == null){
				RequestDispatcher rd=request.getRequestDispatcher("/CartServlet");
		        rd.forward(request,response);
			}
		}
	}
		
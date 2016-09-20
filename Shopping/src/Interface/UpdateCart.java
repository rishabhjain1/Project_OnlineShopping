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
		String search = request.getParameter("search");
		String user="rishabh";
		if(search != null){
			request.setAttribute("search",search);
			RequestDispatcher rd=request.getRequestDispatcher("/SearchServlet");
	        rd.include(request,response);
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("/CartServlet");
	        rd.include(request,response);
		}
			DBOps db = new DBOps();
			try {
				int count =db.getCart(pid, user);
				if(count>0){
					try {
					int result;
					result = db.PurchaseItem(pid,quantity);
					if (result==-1){
						db.updateCart(pid,user,quantity);
						out.print("product already in cart, Quantity updated");
						}
					else
						out.print("enter quantity less than "+ result);
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
							out.print("purchase sucessful");
							}
						else
							out.print("enter quantity less than "+ result);
					} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
						
						e.printStackTrace();
					}
				}
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
		
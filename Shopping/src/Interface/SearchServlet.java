package Interface;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ShoppingDatabase.DBOps;
@WebServlet("/SearchServlet")
public class SearchServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public SearchServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		HttpSession session=request.getSession(false);
		String ID;
			if(session != null){
			ID = (String)session.getAttribute("UserID");
			} 
			else{
			ID = "Guest";
			}
			DBOps Db = new DBOps();
			try {
				Db.search(request, response, search,ID);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
}

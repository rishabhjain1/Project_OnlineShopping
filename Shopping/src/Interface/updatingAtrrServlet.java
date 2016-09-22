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

@WebServlet("/updatingAtrrServlet")
public class updatingAtrrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public updatingAtrrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		int pid = Integer.parseInt(request.getParameter("pid"));
		request.getRequestDispatcher("/AddNew.html").include(request,response);
		out.print("<div id ='updating-attr-form'>");
		out.print("<form action ='AttributeServlet' method = 'POST'>");
		out.print("<input type='hidden' id='pidIn' name='pid' value = "+pid+"> "
				+ "<label for= 'attIn'>ATTRIBUTE NAME</label>" +"<br>"+"<br>"
				+ "<input type='text' id='attIn' name='att_name' value = 'attribute name'> "
				+ "<label for= 'attValIn'>ATTRIBUTE VALUE</label>" +"<br>"+"<br>"
				+ "<input type='text' id='attValIn' name='att_value' value = 'attribute value'> "
				+ "<input type='submit' value='Submit' id ='up-form-submit'>"
				);		
		out.print("</form>");
		out.print("</div>");
			
	}
}

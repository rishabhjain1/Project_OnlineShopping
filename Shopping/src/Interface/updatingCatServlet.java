package Interface;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatingCatServlet")
public class updatingCatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public updatingCatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		int pid = Integer.parseInt(request.getParameter("pid"));
		request.getRequestDispatcher("/AddNew.html").include(request,response);
		out.print("<div id ='updating-cat-form'>");
		out.print("<form action ='CategoryServlet' method = 'POST'>");
		out.print("<input type='hidden' id='pidIn' name='pid' value = "+pid+"> "
				+ "<label for= 'category'>CATEGORY</label>" +"<br>"+"<br>"
				+ "<input type='text' id='category' name='category' value = 'category name'> "
				+ "<input type='submit' value='Submit' id ='up-form-submit'>"
				);		
		out.print("</form>");
		out.print("</div>");
	}
}
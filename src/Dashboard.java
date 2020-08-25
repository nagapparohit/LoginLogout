

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		String userid = null;
		RequestDispatcher rd = null;
		if(session != null) {
			userid = (String) session.getAttribute("userid");
			if(userid!=null) {
				out.println("<h1>user id obtained from session : "+userid+"</h1><br>");
				out.println("<a href='logout'>Logout from session</a><br>");
			}else {
				out.println("<h1>No user id obtained from session </h1><br>");
				rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
			
		}else{
			out.println("<h1>session is null</h1>");
			rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

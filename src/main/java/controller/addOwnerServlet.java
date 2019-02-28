package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Owner;

/**
 * Servlet implementation class addOwner
 */
@WebServlet("/addOwnerServlet")
public class addOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addOwnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		Owner o = new Owner(fname, lname, city, state);
		OwnerHelper dao = new OwnerHelper();
		dao.insertOwner(o);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Owner;
import model.Pet;

/**
 * Servlet implementation class editOwnerServlet
 */
@WebServlet("/editOwnerServlet")
public class editOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editOwnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OwnerHelper o = new OwnerHelper();
		
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Owner ownerToUpdate = o.searchForOwnerById(tempId);
		ownerToUpdate.setFname(fname);
		ownerToUpdate.setLname(lname);
		ownerToUpdate.setCity(city);
		ownerToUpdate.setState(state);
		
		o.updateOwner(ownerToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllOwnersServlet").forward(request, response);
	}

}

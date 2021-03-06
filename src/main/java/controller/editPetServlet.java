package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pet;

/**
 * Servlet implementation class editPetServlet
 */
@WebServlet("/editPetServlet")
public class editPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editPetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PetHelper ph = new PetHelper();
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String name = request.getParameter("name");
		String animal = request.getParameter("animal");
		String breed = request.getParameter("breed");
		LocalDate purchaseDate;
		try {
			purchaseDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			purchaseDate = LocalDate.now();
		}
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Pet petToUpdate = ph.searchForPetById(tempId);
		petToUpdate.setName(name);
		petToUpdate.setAnimal(animal);
		petToUpdate.setBreed(breed);
		petToUpdate.setPurchaseDate(purchaseDate);
		
		ph.updatePet(petToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllPetsServlet").forward(request, response);
	
	}

}

package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Owner;
import model.Pet;

/**
 * Servlet implementation class addPetServlet
 */
@WebServlet("/addPetServlet")
public class addPetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OwnerHelper ph = new OwnerHelper();
				
		request.setAttribute("allItems", ph.showAllOwners());
		
		if(ph.showAllOwners().isEmpty()) {
			request.setAttribute("allItems", " ");
		}
		
		getServletContext().getRequestDispatcher("/add-pet.jsp").forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		OwnerHelper o = new OwnerHelper();
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String name = request.getParameter("name");
		String animal = request.getParameter("animal");
		String breed = request.getParameter("breed");
		int owner_id = Integer.parseInt(request.getParameter("owner"));
		Owner owner = o.searchForOwnerById(owner_id);
		LocalDate purchaseDate;
		try {
			purchaseDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			purchaseDate = LocalDate.now();
		}
		
		Pet petToAdd = new Pet(name, animal, breed, purchaseDate, owner);
		PetHelper dao = new PetHelper();
		dao.addPet(petToAdd);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request,  response);
	}

}

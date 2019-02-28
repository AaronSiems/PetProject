package controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pet;

/**
 * Servlet implementation class deleteOwnerServlet
 */
@WebServlet("/deleteOwnerServlet")
public class deleteOwnerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteOwnerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OwnerHelper o = new OwnerHelper();
		
		request.setAttribute("allItems", o.showAllOwners());
		
		if(o.showAllOwners().isEmpty()) {
			request.setAttribute("noItems", "Nothing to delete here");
		}
		
		getServletContext().getRequestDispatcher("/delete-owner.jsp").forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OwnerHelper o = new OwnerHelper();
		PetHelper p = new PetHelper();
		List<Pet> petList = p.showAllPets();
		int owner_id = Integer.parseInt(request.getParameter("id"));
		for (Pet pet: petList)
		{
			if(pet.getOwner() == null)
			{
				continue;
			}
			else if (pet.getOwner().getId() == owner_id)
			{
				System.out.println(pet.getName());
				pet.setNullOwner();
				p.updatePet(pet);
			}
		}
		
		
		o.deleteOwner(o.searchForOwnerById(owner_id));
		
		getServletContext().getRequestDispatcher("/index.html").forward(request,  response);
	}

}

package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Pet;

public class PetHelper {
	
	//make sure the end of this line matches what the persistence.xml file's name is
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("petProject");
	
	
	public void addPet(Pet toAdd) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	
	

	public void cleanUp() {
		emfactory.close();
	}
	
}

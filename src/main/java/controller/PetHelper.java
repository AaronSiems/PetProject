package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Pet;

public class PetHelper {
	
	//make sure the end of this line matches what the persistence.xml file's name is
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("petProject");
	
	
	public void addPet(Pet toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public Pet searchForPetById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Pet found = em.find(Pet.class, idToEdit);
		em.close();
		return found;
	}

	public void updatePet(Pet toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public void deletePet(Pet toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Pet> typedQuery = em.createQuery("select ch from Pet ch where ch.name = :selectedName and ch.animal = :selectedAnimal and ch.breed = :selectedBreed and ch.purchaseDate = :selectedDate", Pet.class);		
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedAnimal", toDelete.getAnimal());
		typedQuery.setParameter("selectedBreed", toDelete.getBreed());
		typedQuery.setParameter("selectedDate", toDelete.getPurchaseDate());
		
		typedQuery.setMaxResults(1);
		
		Pet result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Pet> showAllPets() {
		EntityManager em = emfactory.createEntityManager();
		List<Pet> allItems = em.createQuery("SELECT i FROM Pet i").getResultList();
		return allItems;
	}

	public void cleanUp() {
		emfactory.close();
	}
	
}

package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import model.Owner;

public class OwnerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("PetProject");
	
	public void insertOwner(Owner o) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Owner> showAllOwners(){
		EntityManager em = emfactory.createEntityManager();
		List<Owner> allOwners = em.createQuery("SELECT i FROM Owner i").getResultList();
		return allOwners;
	}
	
	public void deleteOwner(Owner toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select o from Owner o where o.fname = :selectedFname and o.lname = :selectedLname and o.city = :selectedCity and o.state = :selectedState", Owner.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedFname", toDelete.getFname());
		typedQuery.setParameter("selectedLname", toDelete.getLname());
		typedQuery.setParameter("selectedCity", toDelete.getCity());
		typedQuery.setParameter("selectedState", toDelete.getState());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		Owner result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public Owner searchForOwnerById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Owner found = em.find(Owner.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateOwner(Owner toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Owner> searchForOwnerByCity(String city) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select o from Owner o where o.city = :selectedCity", Owner.class);
		typedQuery.setParameter("selectedCity", city);
		
		List<Owner> foundOwners = typedQuery.getResultList();
		em.close();
		return foundOwners;
	}
	
	public List<Owner> searchForOwnerByState(String state) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select o from Owner o where o.state = :selectedState", Owner.class);
		typedQuery.setParameter("selectedState", state);
		
		List<Owner> foundOwners = typedQuery.getResultList();
		em.close();
		return foundOwners;
	}
	
	public List<Owner> searchForOwnerByFname(String fname) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select o from Owner o where o.fname = :selectedFname", Owner.class);
		typedQuery.setParameter("selectedFname", fname);
		
		List<Owner> foundOwners = typedQuery.getResultList();
		em.close();
		return foundOwners;
	}
	
	public List<Owner> searchForOwnerByLname(String lname) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Owner> typedQuery = em.createQuery("select o from Owner o where o.lname = :selectedLname", Owner.class);
		typedQuery.setParameter("selectedLname", lname);
		
		List<Owner> foundOwners = typedQuery.getResultList();
		em.close();
		return foundOwners;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}

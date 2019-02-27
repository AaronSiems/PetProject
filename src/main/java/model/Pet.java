package model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pet")
public class Pet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="animal")
	private String animal;
	
	@Column(name="breed")
	private String breed;
	
	@Column(name="purchaseDate")
	private LocalDate purchaseDate;
	
	@Column(name="owner_id")
	private int ownerID;
	
	
	
	//all fields constructor
	public Pet(int id, String name, String animal, String breed, LocalDate purchaseDate, int ownerID) {
		super();
		this.id = id;
		this.name = name;
		this.animal = animal;
		this.breed = breed;
		this.purchaseDate = purchaseDate;
		this.ownerID = ownerID;
	}

	
	//super constructor
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	//getters and setters below this point
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(int ownerID) {
		this.ownerID = ownerID;
	}
	
	
	

}

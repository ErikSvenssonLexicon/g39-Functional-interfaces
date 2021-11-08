package se.lexicon.g39_functional_interfaces.model;

import java.time.LocalDate;

public class Person {
	
	private int id;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	
	public Person(int id, String firstName, String lastName, LocalDate birthDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}
	
	
	
	
	
	

}

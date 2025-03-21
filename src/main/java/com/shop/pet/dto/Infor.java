package com.shop.pet.dto;

public class Infor {
	//회원 이름 & 이메일, 펫 이름 & 성별 & 품종 & 몸무게 & 나이
	private String name, email, petName, gender, species;
	private double weight;
	private int age;
	
	public Infor(String name, String email, String petName, String gender, String species, double weight, int age) {
		super();
		this.name = name;
		this.email = email;
		this.petName = petName;
		this.gender = gender;
		this.species = species;
		this.weight = weight;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Infor [name=" + name + ", email=" + email + ", petName=" + petName + ", gender=" + gender + ", species="
				+ species + ", weight=" + weight + ", age=" + age + "]";
	}

	public Infor() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}

package com.telusko.DemoHib;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {
	@Id
	private int lId;
	private String brand;
	private String price;
	
	@ManyToOne
	private Alien alien;
	
//	@ManyToOne()
//	private Student student;
	
	//@ManyToMany
	//private List<Student> student = new ArrayList<>();
	
	public int getlId() {
		return lId;
	}
	public void setlId(int lId) {
		this.lId = lId;
	}
//	public String getlName() {
//		return lName;
//	}
//	public void setlName(String lName) {
//		this.lName = lName;
//	}
//	public List<Student> getStudent() {
//		return student;
//	}
//	public void setStudent(List<Student> student) {
//		this.student = student;
//	}
	public Alien getAlien() {
		return alien;
	}
	public void setAlien(Alien alien) {
		this.alien = alien;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Laptop [lId=" + lId + ", brand=" + brand + ", price=" + price +  "]";
	}
	
	
	
//	
//	public Student getStudent() {
//		return student;
//	}
//	public void setStudent(Student student) {
//		this.student = student;
//	}
//	
	
	
	
	
	
}

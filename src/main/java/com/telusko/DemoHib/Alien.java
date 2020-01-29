package com.telusko.DemoHib;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="alien_table")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Alien {  // POJO
	
	@Id
	private int aid;
	private String aname;
	
	//@Transient
	//private AlienName aname;
	
	//@Column(name="alien_color")
	private String color;
	
//	@OneToMany(mappedBy = "alien",fetch=FetchType.EAGER)
//	private Collection<Laptop> laps = new ArrayList<>();
	
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
//	public AlienName getAname() {
//		return aname;
//	}
//	public void setAname(AlienName aname) {
//		this.aname = aname;
//	}
	
	
	
	public String getColor() {
		return color;
	}
//	public Collection<Laptop> getLaps() {
//		return laps;
//	}
//	public void setLaps(Collection<Laptop> laps) {
//		this.laps = laps;
//	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", color=" + color + "]";
	}
	
	
	
}

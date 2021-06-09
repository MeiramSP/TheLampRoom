package kz.saparov.room.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rooms")
public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private Long id;
	
	@Column(name="room_name", length = 150)
	private String name;
	
	@Column(name="ligth_on")
	private boolean ligthOn;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_code", nullable = false)
	private Country country;
	
	public Room() {}
	
	public Room(Long id, String name, boolean ligthOn, Country country) {
		this.id = id;
		this.name = name;
		this.ligthOn = ligthOn;
		this.country = country;
	}

	public Long getId() { return id; }
	
	public void setId(Long id) { this.id = id; }
	
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }
	
	public boolean isLigthOn() { return ligthOn; }
	
	public void setLigthOn(boolean ligthOn) { this.ligthOn = ligthOn; }
	
	public Country getCountry() { return country; }

	public void setCountry(Country country) { this.country = country; }
	
	@Override
	public String toString() {
		return "Room [id=" + id + ", country=" + country + ", name=" + name + ", ligthOn=" + ligthOn + "]";
	}
}

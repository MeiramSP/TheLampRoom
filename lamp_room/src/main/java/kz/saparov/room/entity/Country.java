package kz.saparov.room.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="countries")
public class Country {
	@Id
	@Column(name="country_code", length = 5)
	private String code;
	
	@Column(name="country_name", length = 100)
	private String name;
	
	@OneToMany(mappedBy = "country", cascade=CascadeType.ALL)
	private Set<Room> rooms = new HashSet<>();
	
	public Country() {}
	
	public Country(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	@JsonProperty("country_code")
	public String getCode() { return code; }
	
	public void setCode(String code) { this.code = code; }
	
	@JsonProperty("country")
	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }
	
	public Set<Room> getRooms() { return rooms; }

	public void setRooms(Set<Room> rooms) { this.rooms = rooms; }

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
}

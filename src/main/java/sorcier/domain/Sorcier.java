package sorcier.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//import org.apache.commons.lang3.builder.EqualsBuilder;
//import org.apache.commons.lang3.builder.HashCodeBuilder;

@Entity
public class Sorcier {
	
	private Sorcier() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="sorcerer")
	private Sorcerer sorcerer;
	
	@Column
	private String message;
	
	@Column
	private Date postedTime;
//	private Double latitude;
//	private Double longitude;
	
//	public Sorcier(String message, Date postedTime) {
//		this(message, postedTime, null, null);
//	}
	
	public Sorcier(
		Long id, Sorcerer sorcerer, String message, Date postedTime/*-, Double longitude, Double latitude -*/) {
	
		this.id = id;
		this.sorcerer = sorcerer;
		this.message = message;
		this.postedTime = postedTime;
//		this.longitude = longitude;
//		this.latitude = latitude;		
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public Date getPostedTime() {
		return this.postedTime;
	}
	
	public Sorcerer getSorcerer() {
		return this.sorcerer;
	}
	
//	public Double getLongitude() {
//		return longitude;
//	}
	
//	public Double getLatitude() {
//		return latitude;
//	}
	
//	@Override
//	public boolean equals(Object that) {
//		return EqualsBuilder.reflectionEquals(this, that, "id", "postedTime");
//	}
	
//	@Override
//	public int hashCode() {
//		return HashCodeBuilder.reflectionHashCode(this, "id", "postedTime");
//	}	
}
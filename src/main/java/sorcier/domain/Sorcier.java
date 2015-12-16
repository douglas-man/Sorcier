package sorcier.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Sorcier {
	private final Long id;
	private final String message;
	private final Date postedTime;
	private Double latitude;
	private Double longitude;
	
	public Sorcier(String message, Date postedTime) {
		this(message, postedTime, null, null);
	}
	
	public Sorcier(
		String message, Date postedTime, Double longitude, Double latitude) {
	
		this.id = null;
		this.message = message;
		this.postedTime = postedTime;
		this.longitude = longitude;
		this.latitude = latitude;		
	}
	
	public long getId() {
		return id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Date getTime() {
		return postedTime;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	
	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "id", "postedTime");
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id", "postedTime");
	}
	
}
package Entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "location")
@NamedQueries({
@NamedQuery(name = "Location.getLocationById", query =
		"select L from Location L where L.id= :id"),
@NamedQuery(name = "Location.deleteLocationById", query =
		"delete from Location L where L.id = :id")
})
public class Location
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(optional = false)
	@JoinColumn(name = "trip_id", nullable = false)
	private Trip trip_id;
	@OneToMany(mappedBy = "location_id")
	private Collection<Audio> Audios;
	
	@OneToMany(mappedBy = "location_id")
	private Collection<Image> Images;
	
	@OneToMany(mappedBy = "location_id")
	private Collection<Video> Videos;
	
	@OneToMany(mappedBy = "location_id")
	private Collection<Text> Texts;
	
	@OneToMany(mappedBy = "location_id")
	private Collection<CountryLogo> CountryLogos;
	
	@Column (name ="location_name")
	private String locationName;
	private String city;
	private String country;
//	 @Temporal(TemporalType.DATE)
	@Column (name ="date_started")
	private String dateStarted;
//	 @Temporal(TemporalType.DATE)
	@Column (name ="date_ended")
	private String datEnded;
	
	public Location()
	{
		
	}

	public Location(int id, Trip trip_id)
	{
		super();
		this.id = id;
		this.trip_id = trip_id;
	}
	
	public Location(String locationName, String dateStarted, String datEnded)
	{
	
		
		this.locationName = locationName;
		this.dateStarted = dateStarted;
		this.datEnded = datEnded;
	}
	
	public Location(Trip trip_id, String locationName, String country, String city, String dateStarted, String datEnded)
	{
	
		this.trip_id = trip_id;
		this.locationName = locationName;
		this.city = city;
		this.country= country;
		this.dateStarted = dateStarted;
		this.datEnded = datEnded;
	}

	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}

	/**
	 * @return the trip_id
	 */
	public Trip getTrip_id()
	{
		return trip_id;
	}

	/**
	 * @param trip_id the trip_id to set
	 */
	public void setTrip_id(Trip trip_id)
	{
		this.trip_id = trip_id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "location [id=" + id + ", trip_id=" + trip_id + "]";
	}

	/**
	 * @return the locationName
	 */
	public String getLocationName()
	{
		return locationName;
	}

	/**
	 * @return the locationLong
	 */
	public String getCity()
	{
		return city;
	}

	/**
	 * @return the locationLat
	 */
	public String getCountry()
	{
		return country;
	}

	/**
	 * @return the dateStarted
	 */
	public String getDateStarted()
	{
		return dateStarted;
	}

	/**
	 * @return the datEnded
	 */
	public String getDatEnded()
	{
		return datEnded;
	}

	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName)
	{
		this.locationName = locationName;
	}

	/**
	 * @param locationLong the locationLong to set
	 */
	public void setCity(String city)
	{
		this.city = city;
	}

	/**
	 * @param locationLat the locationLat to set
	 */
	public void setCountry(String country)
	{
		this.country = country;
	}

	/**
	 * @param dateStarted the dateStarted to set
	 */
	public void setDateStarted(String dateStarted)
	{
		this.dateStarted = dateStarted;
	}

	/**
	 * @param datEnded the datEnded to set
	 */
	public void setDatEnded(String datEnded)
	{
		this.datEnded = datEnded;
	}

	
	
	
	
	
 
}

package Entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "location")
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
	@Column (name ="location_long")
	private String locationLong;
	@Column (name ="location_lat")
	private String locationLat;
	 @Temporal(TemporalType.DATE)
	@Column (name ="date_started")
	private String dateStarted;
	 @Temporal(TemporalType.DATE)
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
	
	
	
	
 
}

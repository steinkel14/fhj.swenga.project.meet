package at.fh.swenga.project.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;



@Entity
@Table(name = "Activity")
public class Activity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@ManyToOne(cascade = CascadeType.PERSIST)
	private User owner;
	
	@ManyToMany(mappedBy="activities", fetch=FetchType.EAGER)
	private List<User> users;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	Subcategory subcategory;
	
	private String location; // Wie Subcategory?
	// Zus�tzlich f�r zocken Kommunikationskanal?
	private Date date;
	private String title;
	private String text;
	private boolean closed;
	private int restriction ; // Count der Teilnehmer f�r limitierte Activit�ten
	private boolean deprecated; // In der Datenbank behalten selbst nach ablauf 
								// damit Bewertungen durchgef�hrt werden k�nnen
								// �berpr�fen mit Systdatetime? 
	private String subcategoryString; // Falls eine Andere Activity; Also nicht in Liste vorhanden
	
	@Version
	long version;
	
	public Activity() {
		super();
	}

	
	public Activity(String location, Date date, String title, String text,
			boolean closed, int restriction, boolean deprecated) {
		super();	
		this.location = location;
		this.date = date;
		this.title = title;
		this.text = text;
		this.closed = closed;
		this.restriction = restriction;
		this.deprecated = deprecated;
		//this.subcategoryString = subcategoryString;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Subcategory getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public int getRestriction() {
		return restriction;
	}

	public void setRestriction(int restriction) {
		this.restriction = restriction;
	}

	public boolean isDeprecated() {
		return deprecated;
	}

	public void setDeprecated(boolean deprecated) {
		this.deprecated = deprecated;
	}

	public String getSubcategoryString() {
		return subcategoryString;
	}

	public void setSubcategoryString(String subcategoryString) {
		this.subcategoryString = subcategoryString;
	}
	
	
	
}
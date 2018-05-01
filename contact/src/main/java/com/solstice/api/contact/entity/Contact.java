package com.solstice.api.contact.entity;


import javax.persistence.*;


@Entity
@NamedQueries({ @NamedQuery(query = "FROM Contact cnt WHERE cnt.email LIKE :value or cnt.phonenumber LIKE :value", name = "Contact.searchContactsByEmailorPhone"),
	@NamedQuery(query = "FROM Contact cnt WHERE cnt.city LIKE :value or cnt.state LIKE :value", name = "Contact.searchContactsByCityOrState")})
public class Contact {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String firstname;
    
    private String lastname;

    private String email;
    
    private String phonenumber;
    
    @Column(name="image",columnDefinition="TEXT")
    private String image;
    
    private String city;
    
    private String state;
    
    private String country;
    
    private String zip;
    
    private String address;

    public Contact() {
	}
    
    public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Contact(Long id, String firstname, String lastname, String email, String phonenumber, String image, String city, 
			String state, String country, String zip) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.image = image;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}

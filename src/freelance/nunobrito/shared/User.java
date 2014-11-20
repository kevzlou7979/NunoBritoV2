package freelance.nunobrito.shared;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String firstName = "";
	private String lastName = "";
	private String email = "";
	private String password = "";
	private String gender = "";
	private String profilePic = "";
	private String country = "";
	private String facebookUrl = "";
	private Date postingDate = new Date();
	
	public User() {

	}

	public User(String firstName, String lastName, String email,
			String password, String gender, String profilePic, String country, String facebookUrl) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.profilePic = profilePic;
		this.country = country;
		this.facebookUrl = facebookUrl;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFacebookUrl() {
		return facebookUrl;
	}

	public void setFacebookUrl(String facebookUrl) {
		this.facebookUrl = facebookUrl;
	}

	public Date getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}

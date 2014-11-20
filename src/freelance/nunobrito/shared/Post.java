package freelance.nunobrito.shared;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private Long userId;
	private String message;
	private String imagePath;
	private Date postDate = new Date();

	public Post() {

	}

	public Post(Long userId, String message, String imagePath) {
		super();
		this.userId = userId;
		this.message = message;
		this.imagePath = imagePath;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

}

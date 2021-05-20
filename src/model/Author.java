package model;

public class Author {
	private int authorId;
	private String firstName;
	private String lastName;
	private String aboutAuthor;

	public Author() {
		super();
	}

	public Author(int authorId) {
		super();
		this.authorId = authorId;
	}

	public Author(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Author(int authorId, String firstName, String lastName) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Author(String firstName, String lastName, String aboutAuthor) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.aboutAuthor = aboutAuthor;
	}

	public Author(int authorId, String firstName, String lastName, String aboutAuthor) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.aboutAuthor = aboutAuthor;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
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

	public String getAboutAuthor() {
		return aboutAuthor;
	}

	public void setAboutAuthor(String aboutAuthor) {
		this.aboutAuthor = aboutAuthor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aboutAuthor == null) ? 0 : aboutAuthor.hashCode());
		result = prime * result + authorId;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Author other = (Author) obj;
		if (aboutAuthor == null) {
			if (other.aboutAuthor != null)
				return false;
		} else if (!aboutAuthor.equals(other.aboutAuthor))
			return false;
		if (authorId != other.authorId)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + ", aboutAuthor="
				+ aboutAuthor + "]";
	}

}

package model;

public class Book extends Author {
	private int bookId;
	private String bookName;
	private String bookUrl;
	private String bookSummary;

	public Book() {
		super();
	}

	public Book(String bookName) {
		super();
		this.bookName = bookName;
	}

	public Book(int bookId) {
		super();
		this.bookId = bookId;
	}

	public Book(String bookName, String bookUrl, String bookSummary) {
		super();
		this.bookName = bookName;
		this.bookUrl = bookUrl;
		this.bookSummary = bookSummary;
	}

	public Book(int bookId, String bookName, String bookUrl, String bookSummary) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookUrl = bookUrl;
		this.bookSummary = bookSummary;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookUrl() {
		return bookUrl;
	}

	public void setBookUrl(String bookUrl) {
		this.bookUrl = bookUrl;
	}

	public String getBookSummary() {
		return bookSummary;
	}

	public void setBookSummary(String bookSummary) {
		this.bookSummary = bookSummary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + bookId;
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((bookSummary == null) ? 0 : bookSummary.hashCode());
		result = prime * result + ((bookUrl == null) ? 0 : bookUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookId != other.bookId)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (bookSummary == null) {
			if (other.bookSummary != null)
				return false;
		} else if (!bookSummary.equals(other.bookSummary))
			return false;
		if (bookUrl == null) {
			if (other.bookUrl != null)
				return false;
		} else if (!bookUrl.equals(other.bookUrl))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookUrl=" + bookUrl + ", bookSummary="
				+ bookSummary + "]";
	}

}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Author;
import model.Book;

public class LibraryDAO {

	private String jdbcURL = "jdbc:mysql://localhost/library?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
	private String jdbcName = "root";
	private String jdbcPass = "root";

	private final String SELECT_AUTHOR = "SELECT * FROM author WHERE first_name = ? AND last_name = ?";
	private final String SELECT_AUTHOR_BY_ID = "SELECT * FROM author WHERE id = ?";
	private final String SELECT_BOOK_BY_ID = "SELECT * FROM books WHERE id = ?";

	private final String INSERT_AUTHOR = "INSERT INTO author(first_name, last_name, about_author) VALUES(?, ?, ?)";
	private final String SELECT_BOOK = "SELECT * FROM books WHERE book_name= ? ";
	private final String INSERT_BOOK = "INSERT INTO books(book_name, book_url, about_book) VALUES(?, ?, ?)";
	private final String INSERT_ID_AUTHOR_BOOK = "INSERT INTO author_book(author_id, book_id) VALUES(?, ?)";
	private final String ALL_AUTHOR = "SELECT * FROM author";

	private final String ALL_BOOKS_FROM_ONE_AUTHOR = "SELECT * FROM  books JOIN author_book ON books.id= author_book.book_id WHERE author_book.author_id=?";
	private final String UPDATE_ONE_AUTHOR = "UPDATE author SET id = ?, first_name=?, last_name=?, about_author=? WHERE id=?";
	private final String UPDATE_ONE_BOOK = "UPDATE books SET id = ?, book_name=?, book_url=?, about_book=? WHERE id=?";

	private final String SEARCH_BOOK_WITH_LIKE = "SELECT * FROM books WHERE book_name LIKE '%?%' ";

	private final String DELETE_ALL_BOOKS_FROM_ONE_AUTHOR = "DELETE books FROM books JOIN author_book ON books.id = author_book.book_id WHERE author_book.author_id = ?";
	private final String DELETE_AUTHOR = "DELETE FROM author WHERE id = ?";
	private final String DELETE_BOOK = "DELETE FROM books WHERE id = ?";

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcName, jdbcPass);
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return connection;
	}

	public boolean ifExistAuthor(Author author) {
		Connection connection = getConnection();

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(SELECT_AUTHOR);
			ps.setString(1, author.getFirstName());
			ps.setString(2, author.getLastName());
			ResultSet rs = ps.executeQuery();

			if (rs.next() == true) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public int getIdAuthor(Author author) {
		Connection connection = getConnection();
		int id = 0;
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(SELECT_AUTHOR);
			ps.setString(1, author.getFirstName());
			ps.setString(2, author.getLastName());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return id;
	}

	public Author getAuthorById(int id) {
		Connection connection = getConnection();
		Author author = new Author();

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(SELECT_AUTHOR_BY_ID);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int idAuthor = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String aboutAuthor = rs.getString("about_author");
				author = new Author(idAuthor, firstName, lastName, aboutAuthor);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return author;
	}

	public Book getBookById(int id) {
		Connection connection = getConnection();
		Book book = new Book();

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(SELECT_BOOK_BY_ID);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int bookId = rs.getInt("id");
				String bookName = rs.getString("book_name");
				String bookUrl = rs.getString("book_url");
				String bookSummary = rs.getString("about_book");
				book = new Book(bookId, bookName, bookUrl, bookSummary);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return book;
	}

	public void insertAuthor(Author author) {
		Connection connection = getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(INSERT_AUTHOR);
			ps.setString(1, author.getFirstName());
			ps.setString(2, author.getLastName());
			ps.setString(3, author.getAboutAuthor());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertBook(Book book) {
		Connection connection = getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(INSERT_BOOK);
			ps.setString(1, book.getBookName());
			ps.setString(2, book.getBookUrl());
			ps.setString(3, book.getBookSummary());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int getIdBook(Book book) {
		Connection connection = getConnection();
		int id = 0;
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(SELECT_BOOK);
			ps.setString(1, book.getBookName());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				id = rs.getInt("id");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return id;
	}

	public void insertAutorBook(int authorId, int bookId) {
		Connection connection = getConnection();
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(INSERT_ID_AUTHOR_BOOK);
			ps.setInt(1, authorId);
			ps.setInt(2, bookId);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Author> allAuthor() {
		ArrayList<Author> arrAuthor = new ArrayList<>();
		Connection connection = getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(ALL_AUTHOR);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				arrAuthor.add(new Author(id, firstName, lastName));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return arrAuthor;
	}

	public ArrayList<Book> allBookFromOneAuthor(int authorId) {
		ArrayList<Book> arrBook = new ArrayList<>();
		Connection connection = getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(ALL_BOOKS_FROM_ONE_AUTHOR);
			ps.setInt(1, authorId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String bookName = rs.getString("book_name");
				String bookUrl = rs.getString("book_url");
				String aboutBook = rs.getString("about_book");
				arrBook.add(new Book(id, bookName, bookUrl, aboutBook));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return arrBook;
	}

	public void updateOneAuthor(int id, Author author) {
		Connection connection = getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(UPDATE_ONE_AUTHOR);
			ps.setInt(1, author.getAuthorId());
			ps.setString(2, author.getFirstName());
			ps.setString(3, author.getLastName());
			ps.setString(4, author.getAboutAuthor());
			ps.setInt(5, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateOneBook(int id, Book book) {
		Connection connection = getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(UPDATE_ONE_BOOK);
			ps.setInt(1, book.getBookId());
			ps.setString(2, book.getBookName());
			ps.setString(3, book.getBookUrl());
			ps.setString(4, book.getBookSummary());
			ps.setInt(5, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Book searchBookWithLike(String part) {
		Connection connection = getConnection();
		Book book = new Book();

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(SEARCH_BOOK_WITH_LIKE);
			ps.setString(1, part);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int bookId = rs.getInt("id");
				String bookName = rs.getString("book_name");
				String bookUrl = rs.getString("book_url");
				String bookSummary = rs.getString("about_book");
				book = new Book(bookId, bookName, bookUrl, bookSummary);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return book;
	}

	public void deleteAllBooksFronOneAuthor(Author author) {
		Connection connection = getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(DELETE_ALL_BOOKS_FROM_ONE_AUTHOR);
			ps.setInt(1, author.getAuthorId());
			ps.executeUpdate();
		} catch (SQLException e) {

		}
	}

	public void deleteAuthor(Author author) {
		Connection connection = getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(DELETE_AUTHOR);
			ps.setInt(1, author.getAuthorId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteBook(Book book) {
		Connection connection = getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(DELETE_BOOK);
			ps.setInt(1, book.getBookId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

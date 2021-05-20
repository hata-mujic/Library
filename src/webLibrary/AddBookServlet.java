package webLibrary;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LibraryDAO;
import model.Author;
import model.Book;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddBookServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LibraryDAO libraryDAO = new LibraryDAO();

		String bookName = request.getParameter("bookName");
		String bookUrl = request.getParameter("bokUrl");
		String aboutBook = request.getParameter("aboutBook");
		libraryDAO.insertBook(new Book(bookName, bookUrl, aboutBook));
		int idBook = libraryDAO.getIdBook(new Book(bookName));

		String[] firstName = request.getParameterValues("firstName");
		String[] lastName = request.getParameterValues("lastName");
		String[] aboutAuthor = request.getParameterValues("aboutAuthor");
		int idAuthor = 0;

		for (int i = 0; i < firstName.length; i++) {
			Author author = new Author(firstName[i], lastName[i], aboutAuthor[i]);

			if (libraryDAO.ifExistAuthor(author) == true) {
				idAuthor = libraryDAO.getIdAuthor(author);
			} else {
				libraryDAO.insertAuthor(author);
				idAuthor = libraryDAO.getIdAuthor(author);

			}
			libraryDAO.insertAutorBook(idAuthor, idBook);

		}
		response.sendRedirect("allAuthor");
	}

}

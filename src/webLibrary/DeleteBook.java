package webLibrary;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LibraryDAO;
import model.Book;

/**
 * Servlet implementation class DeleteBook
 */
@WebServlet("/deleteBook")
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteBook() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		LibraryDAO libraryDAO = new LibraryDAO();
		libraryDAO.deleteBook(new Book(id));

		response.sendRedirect("allAuthor");
	}
}

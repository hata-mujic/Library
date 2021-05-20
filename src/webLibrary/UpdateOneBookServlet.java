package webLibrary;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LibraryDAO;
import model.Book;

@WebServlet("/updateOneBook")
public class UpdateOneBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateOneBookServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LibraryDAO libraryDAO = new LibraryDAO();

		int id = Integer.valueOf(request.getParameter("id"));
		int idNew = Integer.valueOf(request.getParameter("idNew"));
		String bookName = request.getParameter("bookName");
		String bookUrl = request.getParameter("bookUrl");
		String bookSummary = request.getParameter("bookSummary");

		libraryDAO.updateOneBook(id, new Book(idNew, bookName, bookUrl, bookSummary));

		response.sendRedirect("allAuthor");
	}

}

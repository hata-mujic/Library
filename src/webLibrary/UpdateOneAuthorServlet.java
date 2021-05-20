package webLibrary;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LibraryDAO;
import model.Author;

@WebServlet("/updateOneAuthor")
public class UpdateOneAuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateOneAuthorServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LibraryDAO libraryDAO = new LibraryDAO();
		int id = Integer.valueOf(request.getParameter("id"));
		int idNew = Integer.valueOf(request.getParameter("idNew"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String aboutAuthor = request.getParameter("aboutAuthor");

		libraryDAO.updateOneAuthor(id, new Author(idNew, firstName, lastName, aboutAuthor));

		request.setAttribute("idObj", idNew);
		RequestDispatcher rd = request.getRequestDispatcher("allBooksFromOneAuthorObject");
		rd.forward(request, response);
	}

}

package webLibrary;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LibraryDAO;
import model.Author;

@WebServlet("/allAuthor")
public class AllAuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AllAuthorServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Author> arrAuthor = new ArrayList<>();
		LibraryDAO libraryDAO = new LibraryDAO();

		arrAuthor = libraryDAO.allAuthor();
		request.setAttribute("allAuthor", arrAuthor);

		RequestDispatcher rd = request.getRequestDispatcher("main-page-with-author.jsp");
		rd.forward(request, response);

	}

}

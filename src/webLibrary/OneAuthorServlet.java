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

@WebServlet("/oneAuthor")
public class OneAuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OneAuthorServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LibraryDAO libraryDAO = new LibraryDAO();
		int id = Integer.valueOf(request.getParameter("id"));

		Author author = libraryDAO.getAuthorById(id);
		request.setAttribute("author", author);

		RequestDispatcher rd = request.getRequestDispatcher("one-author.jsp");
		rd.forward(request, response);
	}

}

package webLibrary;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LibraryDAO;
import model.Book;

@WebServlet("/oneBook")
public class OneBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OneBookServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LibraryDAO libraryDAO = new LibraryDAO();
		int id = Integer.valueOf(request.getParameter("id"));

		Book book = libraryDAO.getBookById(id);
		request.setAttribute("book", book);

		RequestDispatcher rd = request.getRequestDispatcher("one-book.jsp");
		rd.forward(request, response);
	}

}

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
import model.Book;

@WebServlet("/allBooksFromOneAuthorObject")
public class AllBooksFromOneAuthorObjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AllBooksFromOneAuthorObjectServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LibraryDAO libraryDAO = new LibraryDAO();

		int authorId = (int) request.getAttribute("idObj");

		ArrayList<Book> arrBook = libraryDAO.allBookFromOneAuthor(authorId);
		Author author = libraryDAO.getAuthorById(authorId);

		request.setAttribute("arrBook", arrBook);
		request.setAttribute("author", author);

		RequestDispatcher rd = request.getRequestDispatcher("all-books-from-one-author.jsp");
		rd.forward(request, response);
	}

}

package webUser;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.CheckUser;
import dao.UserDAO;
import model.User;

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArrayList<User> arrUser = new ArrayList<>();
	UserDAO userDAO = new UserDAO();
	CheckUser checkUser = new CheckUser();

	public UserServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		switch (action) {
		case "/loginUser":
			loginUser(request, response);
			break;
		case "/insertUser":
			insertUser(request, response);
			break;
		case "/printUsers":
			printUsers(request, response);
			break;
		case "/printOneUser":
			printOneUser(request, response);
			break;
		case "/printOneForUpdateUser":
			printOneForUpadateUser(request, response);
			break;
		case "/updateUser":
			updateUser(request, response);
			break;
		case "/deleteUser":
			deleteUser(request, response);
			break;
		default:
			logoutUser(request, response);
		}
	}

	private void loginUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String password = request.getParameter("pass");

		int admin = userDAO.ifAdmin(uname);

		if (userDAO.loginUser(new User(uname, password)) == true) {
			HttpSession session = request.getSession();
			session.setAttribute("uname", uname);
			session.setAttribute("admin", admin);

			RequestDispatcher rd = request.getRequestDispatcher("allAuthor");
			rd.forward(request, response);

		} else {
			response.sendRedirect("index.jsp");
		}
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String rpass = request.getParameter("rpass");

		Date dob = Date.valueOf(request.getParameter("dob"));

		if (checkUser.isValidPassword(pass) == true && userDAO.ifUserExist(uname) == false
				&& checkUser.isEqualPassword(pass, rpass) == true) {
			userDAO.insertUser(new User(fname, lname, uname, pass, dob));

			int admin = userDAO.ifAdmin(uname);

			HttpSession session = request.getSession();
			session.setAttribute("uname", uname);
			session.setAttribute("admin", admin);

			RequestDispatcher rd = request.getRequestDispatcher("allAuthor");
			rd.forward(request, response);

		} else {
			response.sendRedirect("register-form.jsp");
		}

	}

	private void printUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		arrUser = userDAO.printUser();
		request.setAttribute("list", arrUser);

		RequestDispatcher rd = request.getRequestDispatcher("list-of-users.jsp");
		rd.forward(request, response);
	}

	private void printOneUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String uname = String.valueOf(session.getAttribute("uname"));
		User user = userDAO.printOneUser(uname);

		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("my-profile.jsp");
		rd.forward(request, response);
	}

	private void printOneForUpadateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String uname = String.valueOf(session.getAttribute("uname"));
		User user = userDAO.printOneUser(uname);

		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("update-my-profile.jsp");
		rd.forward(request, response);
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String rpass = request.getParameter("rpass");
		Date dob = Date.valueOf(request.getParameter("dob"));

		if (checkUser.isValidPassword(pass) == true && checkUser.isEqualPassword(pass, rpass) == true) {
			userDAO.updateUser(new User(fname, lname, uname, pass, dob));

			RequestDispatcher rd = request.getRequestDispatcher("printOneUser");
			rd.forward(request, response);
		} else {
			response.sendRedirect("printOneUser");
		}
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		userDAO.deleteUser(new User(username));

		response.sendRedirect("printUsers");
	}

	private void logoutUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("uname");
		session.invalidate();
		response.sendRedirect("index.jsp");
	}

}

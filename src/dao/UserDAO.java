package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.User;

public class UserDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost/library?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
	private String jdbcName = "root";
	private String jdbcPass = "root";

	private final String IF_EXIST_USER = "SELECT * FROM user WHERE user_name=?";
	private final String INSERT_USER = "INSERT INTO user(first_name, last_name, user_name, password, date_of_birth) VALUES(?,?,?,?,?)";
	private final String LOGIN_USER = "SELECT * FROM user WHERE user_name=? AND password=?";
	private final String PRINT_USERS = "SELECT * FROM user";
	private final String PRINT_ONE_USER = "SELECT * FROM user WHERE user_name=?";
	private final String UPDATE_USER = "UPDATE user SET first_name=?, last_name=?, password=?, date_of_birth=? WHERE user_name=?";
	private final String ADMIN_USER = "SELECT admin FROM user WHERE user_name=?";
	private final String DELETE_USER = "DELETE FROM user WHERE user_name=?";

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

	public boolean ifUserExist(String uname) {
		Connection connection = getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(IF_EXIST_USER);
			ps.setString(1, uname);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public void insertUser(User user) {

		Connection connection = getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_USER);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUserName());
			ps.setString(4, user.getPassword());
			ps.setDate(5, user.getDob());

			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public boolean loginUser(User user) {
		Connection connection = getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(LOGIN_USER);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<User> printUser() {
		ArrayList<User> arrUser = new ArrayList<>();
		Connection connection = getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(PRINT_USERS);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				String uname = rs.getString("user_name");
				String pass = rs.getString("password");
				Date dob = rs.getDate("date_of_birth");
				arrUser.add(new User(fname, lname, uname, pass, dob));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return arrUser;
	}

	public User printOneUser(String sessionUname) {
		User user = null;
		Connection connection = getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(PRINT_ONE_USER);
			ps.setString(1, sessionUname);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				String uname = rs.getString("user_name");
				String password = rs.getString("password");
				Date dob = rs.getDate("date_of_birth");
				user = new User(fname, lname, uname, password, dob);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public void updateUser(User user) {
		Connection connection = getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(UPDATE_USER);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getPassword());
			ps.setDate(4, user.getDob());
			ps.setString(5, user.getUserName());
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public int ifAdmin(String uname) {

		Connection connection = getConnection();
		int admin = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(ADMIN_USER);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				admin = rs.getInt("admin");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return admin;
	}

	public void deleteUser(User user) {
		Connection connection = getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(DELETE_USER);
			ps.setString(1, user.getUserName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

package assessment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/loginPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session = request.getSession();
		String user = request.getParameter("uname");
		String pwd = request.getParameter("psw");
		Connection con;
		List<Truck> trucks = new ArrayList<Truck>();
		
		try {
			con = DatabaseConnection.initializeDatabase();
			String sql_query = "SELECT username, password, company, email FROM customers WHERE username=? AND password=?";
			PreparedStatement ps = con.prepareStatement(sql_query);
			ps.setString(1, user);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				String company = rs.getString(3);
				String email = rs.getString(4);
				session.setAttribute("username", user);
				request.setAttribute("psw", pwd);
				session.setAttribute("company", company);
				session.setAttribute("email", email);
				
				sql_query = "SELECT id, location FROM trucks WHERE owner=?";
				ps = con.prepareStatement(sql_query);
				ps.setString(1, user);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					Truck truck = new Truck();
					truck.setId(rs.getInt("id"));
					truck.setLocation(rs.getString("location"));
					trucks.add(truck);
				}
				
				session.setAttribute("trucklist", trucks);
				request.getRequestDispatcher("/WEB-INF/userPage.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/WEB-INF/wrongCred.jsp").forward(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

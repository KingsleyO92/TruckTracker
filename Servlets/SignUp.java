package assessment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/signup")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/signUpPage.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("username");
		String pwd = request.getParameter("password");
		String comp = request.getParameter("company");
		String email = request.getParameter("email");
		Connection con;
		
		try {
			con = DatabaseConnection.initializeDatabase();
			String sql_query = "INSERT INTO customers (username, password, company, email) VALUES (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql_query);
			ps.setString(1, user);
			ps.setString(2, pwd);
			ps.setString(3, comp);
			ps.setString(4, email);
			int row = ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/signUpConfirmation.jsp").forward(request, response);
	}

}

package assessment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class AddNewTruck
 */

@WebServlet("/addnewtruck")
public class AddNewTruck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewTruck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/addTruck.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession session = request.getSession();
		String username = request.getParameter("owner");
		String location = request.getParameter("location");
		Connection con;
		List<Truck> trucks = new ArrayList<Truck>();
		
		try {
			con = DatabaseConnection.initializeDatabase();
			String sql_query = "INSERT INTO trucks (owner,location) VALUES (?,?)";
			PreparedStatement ps = con.prepareStatement(sql_query);
			ps.setString(1, username);
			ps.setString(2, location);
			
			int row = ps.executeUpdate();
			
			sql_query = "SELECT id, location FROM trucks WHERE owner=?";
			ps = con.prepareStatement(sql_query);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Truck truck = new Truck();
				truck.setId(rs.getInt("id"));
				truck.setLocation(rs.getString("location"));
				trucks.add(truck);
			}
			
			Login.session.setAttribute("trucklist", trucks);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/userPage.jsp").forward(request, response);
	}

}

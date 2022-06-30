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
 * Servlet implementation class AddNewRoute
 */
@WebServlet("/addnewroute")
public class AddNewRoute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewRoute() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/addroute.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpSession session = request.getSession();
		String truckid = request.getParameter("truckid");
		String routetaken = request.getParameter("route");
		Connection con;
		List<Route> routes = new ArrayList<Route>();
		//Login.session.setAttribute("truckid", truckid);
		
		try {
			con = DatabaseConnection.initializeDatabase();
			String sql_query = "INSERT INTO routes (truckid,route) VALUES (?,?)";
			PreparedStatement ps = con.prepareStatement(sql_query);
			ps.setInt(1, Integer.parseInt(truckid));
			ps.setString(2, routetaken);
			
			int row = ps.executeUpdate();
			
			sql_query = "SELECT id, route, time FROM routes WHERE truckid=?";
			ps = con.prepareStatement(sql_query);
			ps.setString(1, truckid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Route route = new Route();
				route.setId(rs.getInt("id"));
				route.setRoute(rs.getString("route"));
				route.setTime(rs.getString("time"));
				routes.add(route);
			}
			
			Login.session.setAttribute("routeslist", routes);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/routeslisting.jsp").forward(request, response);
	}

}

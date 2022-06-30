package assessment;

public class Route {
	int id;
	String time;
	String route;
	
	public Route() {
		
	}
	
	public void setId(int idnumber) {
		this.id=idnumber;
	}
	
	public int getId() {
		return id;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setRoute(String routetaken) {
		this.route=routetaken;
	}
	
	public String getRoute() {
		return route;
	}
	
}

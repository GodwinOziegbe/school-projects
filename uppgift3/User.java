package uppgift3;

public class User {
	private String current= null;
	private String mytime= null;

	public User(String dateString, String time) {
		this.current= dateString;
		this.mytime= time;
		
	}
	
	public String getDatetime() {
		return current;
	}
	
	public void setDatetime(String dateString) {
		this.current = dateString;
	  }
	
	public void setTime(String time) {
		this.mytime = time;
	  }
	
	public String getTime() {
		return mytime;
	}

	
	
}

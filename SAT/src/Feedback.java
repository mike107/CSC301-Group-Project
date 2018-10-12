
public class Feedback {
	
	private String Feedback;
	private int Rating;
	private String CourseID;
	private String SessionID; 
    private String To;
    private String From;
	
	public Feedback() {
		
	}
	
	public void setFeedback(String msg) {
		this.Feedback = msg;
	}
	
	public String getFeedback() {
		return this.Feedback;
	}
	
	public void setRating(int rating) {
		this.Rating = rating;
	}
	
	public int getRating() {
		return this.Rating;
	}
	
	public void setCourseID(String id) {
		this.CourseID = id;
	}
	
	public String getCourseID() {
		return this.CourseID;
	}
	
	public void setSessionID(String id) {
		this.SessionID = id;
	}
	
	public String getSessionID() {
		return this.SessionID;
	}
	
	public void setTo(String recipent) {
		this.To = recipent;
	}
	
	public String getTo() {
		return this.To;
	}
	
	public void setFrom(String writer) {
		this.From = writer;
	}
	
	public String getFrom() {
		return this.From;
	}
	
	
	
	

}

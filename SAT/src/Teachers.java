
public class Teachers {
	
	private String courseID;
	private String TeacherEmail;
	private String accessCode;
	private String sessionID;
	private String url;

	public Teachers() {
	
	}
	public void setCourseID(String newCourseID) {
		this.courseID = newCourseID;
	}
	public String getCourseID() {
		return this.courseID;
	}
	public void setSessionID(String newSessionID) {
		this.sessionID = newSessionID;
	}
	public String getSessionID() {
		return this.sessionID;
	}
	public void setTeacherEmail(String newTeacherEmail) {
		this.TeacherEmail = newTeacherEmail;
	}
	public String getTeacherEmail() {
			return this.TeacherEmail;
	}
	public void setAccessCode(String newAccessSession) {
		this.accessCode = newAccessSession;
	}
	public String getAccessCode() {
		return this.accessCode;
	}
	public String getUrl() {
		return this.url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	
	
	

}


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;




import com.backendless.BackendlessUser;


/**
 * Defaults class used to store constants for server side information or constants shared throughout the app.
 *
 */
public class Defaults {
	  
	private static BackendlessUser user;
	public static String courseSelected;
	public static List<Map> teachersTable;
	public static int index;
	public static String selectedCourse;
	public static String selectedSessionID;
	public static String accessCode;
	public static String sessionID;
	public static String courseId;
	public static Teachers uploadedTeacher;
	
	/**
	 * Stores AccessCode, CourseID, SessionID for teacher view
	 */
	public static Teachers new_session_teacher;
	
	
	public static void setUser(BackendlessUser user) {
		Defaults.user = user;	
	}
	
	public static BackendlessUser getUser() {
		return Defaults.user;
	}
	
	public static int setX = 570;
	public static int setY = 479;
	
	
	public static final String APPLICATION_ID = "1C207F3E-7C68-B8A0-FF03-90516BDD9F00";
	public static final String API_KEY = "03C9BD49-D56B-29AD-FFF7-CBE81131D600";
	
	  //Backendless.initApp(Defaults.APPLICATION_ID,  Defaults.API_KEY ); // Use this to initialize backendless in project
}
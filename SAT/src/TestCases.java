import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.prefs.Preferences;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.exceptions.BackendlessException;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;
import com.backendless.Backendless;

public class TestCases {
	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Backendless.initApp(Defaults.APPLICATION_ID,  Defaults.API_KEY);
		for(int i = 0; i < 10; i++) {
			//fillAttendance();
			//fillFeedback();
		}
		System.out.println("Completed");
	}
	
	
	static void fillAttendance() {
		  HashMap attendance = new HashMap();
		  attendance.put("courseID", "CSC301" );
		  attendance.put("sessionID", "L4" );
		  attendance.put("studentEmail",String.format("bob%s@gmail.com",count));
		  count++;
		  Map savedContact = Backendless.Persistence.of( "Attendance" ).save( attendance );
		  
	}
	
	static void fillFeedback() {
		Random rn = new Random();
		
		int user = 1 + rn.nextInt(100 - 1 + 1);
		  HashMap feedback = new HashMap();
		  feedback.put("CourseID", "CSC301" );
		  feedback.put("SessionID", "L4" );
		  feedback.put("From",String.format("bob%s@gmail.com",user));
		  feedback.put("To","karan_bhagat@icloud.com");
		  
		  
		  int rating = 1 + rn.nextInt(5 - 1 + 1);
		  feedback.put("Rating",rating);
		  count++;
		  Map savedContact = Backendless.Persistence.of( "Feedback" ).save( feedback );
	}
}

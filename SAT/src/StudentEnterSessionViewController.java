import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.prefs.Preferences;

import javax.swing.JOptionPane;
import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.exceptions.BackendlessException;

import weborb.util.log.Log;

public class StudentEnterSessionViewController {

	StudentEnterSessionView view;


	//	public static void main(String[] args) {
	//		SignUpView window = new SignUpView();
	//		SignUpController controller = new SignUpController(window);
	//
	//	}


	public StudentEnterSessionViewController(StudentEnterSessionView view) {
		this.view = view;

		try {
			this.view.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.view.joinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchView(e);
			}
		});
		this.view.joinLastSessionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Preferences prefs = Preferences.userNodeForPackage(StudentEnterSessionViewController.class);

				view.accessCodeTextField.setText(prefs.get("LastSession", ""));


			}
		});

	}

	public void switchView(ActionEvent e) {



		if (!(this.view.accessCodeTextField.getText().isEmpty())) {
			String whereClause = "accessCode = '" + this.view.accessCodeTextField.getText().toString() + "'";

			List<Map> teacherMap = BackendlessManager.getDataFromBackendless(whereClause, "Teachers");


			if (teacherMap.size() > 0) {
				String courseID = (String)teacherMap.get(0).get("courseID");
				String sessionID = (String)teacherMap.get(0).get("sessionID");
				String studentEmail = Defaults.getUser().getEmail();

				String studentClause = String.format("courseID = '%s' and sessionID = '%s' and studentEmail = '%s'",courseID, sessionID,studentEmail);

				List<Map> attendanceMap = BackendlessManager.getDataFromBackendless(studentClause, "Attendance");

				if (attendanceMap.size() > 0) {
					this.view.frame.dispose();
					StudentFeedbackView view = new StudentFeedbackView();
					StudentFeedbackViewController vc = new StudentFeedbackViewController(view);
					Defaults.teachersTable = teacherMap;
					Defaults.courseId = courseID;
					Defaults.sessionID = sessionID;
					
					
					Defaults.index = 0;
					return;
				} else {
					Attendance attendance = new Attendance();
					attendance.setCourseID(courseID);
					attendance.setSessionID(sessionID);
					Defaults.courseId = courseID;
					attendance.setStudentEmail(studentEmail);
					Backendless.Data.of(Attendance.class).save(attendance);
					Defaults.sessionID = sessionID;
					Preferences prefs = Preferences.userNodeForPackage(StudentEnterSessionViewController.class);
					prefs.put("LastSession", view.accessCodeTextField.getText()); // key, value for key
					this.view.frame.dispose();
					StudentFeedbackView view = new StudentFeedbackView();
					StudentFeedbackViewController vc = new StudentFeedbackViewController(view);
					
					Defaults.teachersTable = teacherMap;
					Defaults.index = 0;
					return;
				}

			}
			

		}
		
		JOptionPane.showMessageDialog(null, "Incorrect access code. Please try again." , "Error", JOptionPane.ERROR_MESSAGE);
	}
}

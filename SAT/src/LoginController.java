import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

public class LoginController {
	// do not forget to call Backendless.initApp in the app initialization code
	private LoginView view;


	public static void main(String[] args) {

		LoginView window = new LoginView();

		LoginController controller = new LoginController(window);
	}
	/**
	 *  Preferences prefs = Preferences.userNodeForPackage(Example.class);
        prefs.put(FRUIT, favoriteFruit); // key, value for key
	 * 
	 *  Preferences prefs = Preferences.userNodeForPackage(Example.class);
	 *  return prefs.get(FRUIT, "default");
	 * 
	 */
	public LoginController(LoginView view) {
		Backendless.initApp(Defaults.APPLICATION_ID,  Defaults.API_KEY);
	       
		this.view = view;
		try {
			this.view.frame.setVisible(true);

		}	catch (Exception e) {
			e.printStackTrace();
		}


		Preferences prefs = Preferences.userNodeForPackage(LoginController.class);
		String email = prefs.get("email", ""); //key, default value
		String password = prefs.get("password", "");
		Boolean flag = prefs.getBoolean("remeberUser", false);


		if(flag) {
			this.view.rememberLastUserCheckBox.setSelected(true);
			this.view.email.setText(email);
			this.view.passwordTextField.setText(password);
		}

		this.view.loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginButton(e);
			}
		});

		this.view.signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signupButton(e);
			}
		});

		this.view.resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton(e);
			}
		});

		this.view.cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cancelButton(e);

			}
		});

		this.view.forgotPasswordButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				forgotPassword(e);

			}

		});

		this.view.registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerButton(e);
			}
		});

		this.view.cancelSUButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSUButton(e);
			}
		});

		

		


	}

	/**
	 * TODO: Add code to update user password here
	 * Variables connected to view
	 *  	- emailCPTextField : User email
	 *  - oldPasswordTextField : Users password (current password)
	 *  - newPasswordTextField : Users new password (wants to change to password)
	 *  - confirmPasswordTextField : Users new password (wants to change to password) confirmation text field
	 *  
	 * @param e
	 */


	private void forgotPassword(ActionEvent e) {
		new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				slideToReset(e);
			}
		}).start();
	}


	private void forgotPasswordButton(ActionEvent e) {
		new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				slideToForgotPassword(e);
			}
		}).start();
	}


	private void slideToChangePassword(ActionEvent e) {
		this.view.welcomeViewPanel.setLocation(this.view.welcomeViewPanel.getX() - 3, 6);
	
		this.view.forgotPasswordPanel.setLocation(this.view.forgotPasswordPanel.getX() - 3, 6);
		if (this.view.forgotPasswordPanel.getX() == -420) {
			((Timer) e.getSource()).stop();

		}
	}

	private void slideToForgotPassword(ActionEvent e) {
		this.view.welcomeViewPanel.setLocation(this.view.welcomeViewPanel.getX() + 3, 6);
		this.view.forgotPasswordPanel.setLocation(this.view.forgotPasswordPanel.getX() + 3, 6);
		if (this.view.welcomeViewPanel.getX() == -420) {
			((Timer) e.getSource()).stop();

		}
	}

	private void slideToReset(ActionEvent e) {
		this.view.welcomeViewPanel.setLocation(this.view.welcomeViewPanel.getX() - 3, 6);
		this.view.forgotPasswordPanel.setLocation(this.view.forgotPasswordPanel.getX() - 3, 6);
		
		if (this.view.welcomeViewPanel.getX() == -420) {
			((Timer) e.getSource()).stop();

		}
	}
	private void slide(ActionEvent e) {
		this.view.welcomeViewPanel.setLocation(this.view.welcomeViewPanel.getX() + 3, 6);
		this.view.forgotPasswordPanel.setLocation(this.view.forgotPasswordPanel.getX() + 3, 6);

		if (this.view.welcomeViewPanel.getX() == 6) {
			((Timer) e.getSource()).stop();

		}
	}



	private void slideToRegister(ActionEvent e) {
		this.view.welcomeViewPanel.setLocation(6, this.view.welcomeViewPanel.getY() - 3);
		this.view.registerPanel.setLocation(6,this.view.registerPanel.getY() - 3);
		if (this.view.welcomeViewPanel.getY() == -435) {
			((Timer) e.getSource()).stop();

		}
	}

	private void slideToLogin(ActionEvent e) {
		this.view.welcomeViewPanel.setLocation(6, this.view.welcomeViewPanel.getY() + 3);
		this.view.registerPanel.setLocation(6,this.view.registerPanel.getY() + 3);
		if (this.view.welcomeViewPanel.getY() == 6) {
			((Timer) e.getSource()).stop();

		}
	}

	private void slideToLoginFromChange(ActionEvent e) {
		this.view.welcomeViewPanel.setLocation(this.view.welcomeViewPanel.getX() + 3, 6);
		this.view.forgotPasswordPanel.setLocation(this.view.forgotPasswordPanel.getX() + 3, 6);
	
		if (this.view.welcomeViewPanel.getX() == 6) {
			((Timer) e.getSource()).stop();

		}
	}


	private void signupButton(ActionEvent e) {

		new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				slideToRegister(e);
			}
		}).start();


		/**
		 * OLD CODE FOR POP UP SIGN UP VIEW WINDOW
		 */
		//		this.view.frame.dispose();
		//
		//		SignUpView signUpWindow = new SignUpView();
		//		SignUpController signUpController = new SignUpController(signUpWindow);

	}
	private void cancelSUButton(ActionEvent e) {
		new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				slideToLogin(e);
			}
		}).start();
	}

	private void cancelButton(ActionEvent e) {
		new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				slide(e);
			}
		}).start();

	}
	private void resetButton(ActionEvent e) {
		try
		{
			Backendless.UserService.restorePassword(this.view.resetEmailTextField.getText());
			JOptionPane.showMessageDialog(null, "Please check your inbox for further instructions." , "Email Sent", JOptionPane.PLAIN_MESSAGE);

		}
		catch( BackendlessException exception )
		{
			// password recovery failed, to get the error code, call exception.getFault().getCode()
			JOptionPane.showMessageDialog(null, exception.getDetail() , "Error", JOptionPane.PLAIN_MESSAGE);

		}



	}
	
	
	private void loginButton(ActionEvent e) {
		BackendlessUser user;
		Attendance attend = new Attendance();
		try {
			Socket socket = new Socket("www.google.ca", 80);
		
		try {
			
			if (view.passwordTextField.getPassword().length == 0) {

				JOptionPane.showMessageDialog(null, "Please provide a password." , "Error", JOptionPane.PLAIN_MESSAGE);

			} else {
				//String userEmail = view.emailTextField.getText();
				char [] userPassword = view.passwordTextField.getPassword();
				String password = "";
				for (int i = 0; i < userPassword.length; i++) {
					password += userPassword[i];
				}


				user = Backendless.UserService.login(this.view.email.getText(), password);
				Defaults.setUser(user);
				
				System.out.println("LOGIN CONTROLLER 1: " + user);
				boolean isAdmin = (boolean) user.getProperty("admin");

				//	attend.setCourseID("CSC301");
				//	attend.setStudentEmail(this.view.email.getText());

				String whereClause = "courseID = 'CSC301' and studentEmail = '" + this.view.email.getText() + "'"; 
				DataQueryBuilder queryBuilder = DataQueryBuilder.create();
				queryBuilder.setWhereClause( whereClause );

				List<Attendance> result = Backendless.Data.of( Attendance.class ).find( queryBuilder );

				if (isAdmin) {

					Defaults.setUser(user);
					
					System.out.println("Defualt.getUser: " + Defaults.getUser().getEmail());
					System.out.println("LOGIN CONTROLLER 2: " + Defaults.getUser().getEmail());
					
					this.view.frame.dispose();

					TeacherHomeView mainView = new TeacherHomeView();
					TeacherAndAttendanceController teacherViewController = new TeacherAndAttendanceController(mainView);

				}else {


					this.view.frame.dispose();
					Defaults.setUser(user);
					
					StudentEnterSessionView sview = new StudentEnterSessionView();
					StudentEnterSessionViewController studentViewController = new StudentEnterSessionViewController(sview);
				}

				Preferences prefs = Preferences.userNodeForPackage(LoginController.class);

				if(this.view.rememberLastUserCheckBox.isSelected()) {
					prefs.put("email", this.view.email.getText()); // key, value for key
					prefs.put("password", password);
					prefs.putBoolean("remeberUser", true);

				}else {
					prefs.putBoolean("remeberUser", false);
				}



			}
		} catch( BackendlessException exception ) {
			// login failed, to get the error code, call exception.getFault().getCode()
			//System.out.println(exception.getDetail());
			JOptionPane.showMessageDialog(null, exception.getDetail(), "error", JOptionPane.ERROR_MESSAGE);
			this.view.passwordTextField.setText("");
			}
		}
		catch( BackendlessException|IOException exception) {
		JOptionPane.showMessageDialog(null, "No Internet Connection", "Error", JOptionPane.PLAIN_MESSAGE);
		this.view.passwordTextField.setText("");
		}
		



	}

	private void registerButton(ActionEvent e) {
		Backendless.initApp(Defaults.APPLICATION_ID,  Defaults.API_KEY );
		Boolean isAdmin = false;


		if (view.signUpPasswordTextField.getPassword().length == 0) {

			JOptionPane.showMessageDialog(null, "Please provide a password." , "Error", JOptionPane.PLAIN_MESSAGE);
		} else {
			String userEmail = view.emailTextField.getText();
			char [] userPassword = view.signUpPasswordTextField.getPassword();
			String password = "";
			for (int i = 0; i < userPassword.length; i++) {
				password += userPassword[i];
			}
			System.out.println(this.view.signUpPasswordTextField.getPassword());


			if (this.view.teacherRadioButton.isSelected()) {
				isAdmin = true;

			} else if (this.view.studentRadioButton.isSelected()) {
				isAdmin = false;
			}



			BackendlessUser user = new BackendlessUser();
			user.setProperty( "email", userEmail);
			user.setPassword(password);
			user.setProperty("admin", isAdmin);
			user.setProperty("name", view.nameTextField.getText());

			try{
				user = Backendless.UserService.register(user);
				if (isAdmin == true) {
					/**
					 * TODO: CODE COMMENTED OUT
					 */
					//					Teachers teacher = new Teachers();
					//					teacher.setCourseID("CSC301Lec101");
					//					teacher.setTeacherEmail(userEmail);
					//
					//					Backendless.Data.of(Teachers.class).save(teacher);


				}else {
					/**
					 * TODO: REMOVE CODE ?
					 */
					//					Students student = new Students();
					//					student.setCourseID("CSC301Lec101");
					//					student.setStudentEmail(userEmail);
					//					Backendless.Data.of(Students.class).save(student);

				}
				this.view.frame.dispose();

				LoginView view = new LoginView();
				LoginController loginController = new LoginController(view);

				this.slideToLogin(e);


			}
			catch( BackendlessException exception )
			{
				JOptionPane.showMessageDialog(null, exception.getDetail() , "Error", JOptionPane.PLAIN_MESSAGE);


			}

		}

	}


	public void updateAttendance()
	{
		HashMap attendance_record = new HashMap();
		attendance_record.put( "courseID", "CSC301" );
		attendance_record.put( "studentEmail", this.view.email.getText());
		Map savedContact = Backendless.Persistence.of("Attendance").save(attendance_record);
	}

}
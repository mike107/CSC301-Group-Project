import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;


import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.exceptions.BackendlessException;


import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.exceptions.BackendlessException;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Cursor;

import java.awt.Desktop;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Menu;

import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class LoginView {

	JFrame frame;
	JTextField email;
	JPasswordField passwordTextField;
	JButton loginButton;
	JButton signupButton;
	JPanel forgotPasswordPanel;
	JPanel welcomeViewPanel;
	JTextField resetEmailTextField;
	JButton resetButton;
	JButton cancelButton;
	JCheckBox rememberLastUserCheckBox;
	JLabel forgotPasswordLabel;
	JPanel registerPanel;
	JTextField nameTextField;
	JTextField emailTextField;
	JPasswordField signUpPasswordTextField;
	JButton registerButton;
	JRadioButton teacherRadioButton;
	JRadioButton studentRadioButton;
	JButton cancelSUButton;
	JButton forgotPasswordButton;

	private static final String QUESTION = "Question?";
	private static final String DELETECOURSE = "Delete%20Course";
	private static final String DELETESESSION = "Delete%20Session";
	private static final String REMOVESTUDENT = "Remove%20Student";
	private static final String DELETEACCOUNT = "Delete%20Account";
	private static final String OTHER = "Issue%20Type:%20";

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					LoginView window = new LoginView();
	//					window.frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 420, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		welcomeViewPanel = new JPanel();
		welcomeViewPanel.setForeground(Color.WHITE);
		welcomeViewPanel.setBorder(null);
		welcomeViewPanel.setBackground(Color.WHITE);
		welcomeViewPanel.setBounds(6, 6, 407, 446);
		frame.getContentPane().add(welcomeViewPanel);
		welcomeViewPanel.setLayout(null);

		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
		lblWelcome.setBounds(6, 30, 395, 26);
		welcomeViewPanel.add(lblWelcome);
		System.setProperty("apple.laf.useScreenMenuBar", "true");


//		Application myApplication = Application.getApplication();

		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem question, deleteCourse, deleteSession, removeStudent, deleteAccount, other;
		//Create the menu bar.
		menuBar = new JMenuBar();





		//Build the first menu.
		menu = new JMenu("Support");
		question = new JMenuItem("Question");
		question.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchMail(e, question.getText());
			}
		});


		deleteCourse = new JMenuItem("Delete Course");
		deleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchMail(e, deleteCourse.getText());
			}
		});


		removeStudent = new JMenuItem("Remove Student");
		removeStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchMail(e, removeStudent.getText());
			}
		});

		deleteAccount = new JMenuItem("Delete Account");
		deleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchMail(e, deleteAccount.getText());
			}
		});



		other = new JMenuItem("Other");
		other.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchMail(e, other.getText());
			}
		});

		menu.add(question);
		menu.add(deleteCourse);
		menu.add(removeStudent);
		menu.add(deleteAccount);
		menu.add(other);

		//menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
				"The only menu in this program that has menu items");
		menuBar.add(menu);


//		myApplication.setDefaultMenuBar(menuBar);





		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblEmail.setBounds(33, 114, 55, 16);
		welcomeViewPanel.add(lblEmail);

		email = new JTextField();
		email.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		email.setToolTipText("Email");
		email.setBounds(29, 142, 331, 26);
		welcomeViewPanel.add(email);
		email.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblPassword.setBounds(33, 197, 98, 16);
		welcomeViewPanel.add(lblPassword);
		passwordTextField = new JPasswordField();
		passwordTextField.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		passwordTextField.setBounds(29, 225, 331, 26);
		welcomeViewPanel.add(passwordTextField);
		passwordTextField.setColumns(10);

		loginButton = new JButton("Login");
		loginButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		loginButton.setBounds(114, 390, 117, 29);
		welcomeViewPanel.add(loginButton);

		signupButton = new JButton("Sign Up");
		signupButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));


		signupButton.setBounds(243, 390, 117, 29);
		welcomeViewPanel.add(signupButton);



		forgotPasswordButton = new JButton("Forgot Password?");
		forgotPasswordButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));
		forgotPasswordButton.setForeground(new Color(0, 153, 255));
		forgotPasswordButton.setBounds(134, 263, 136, 29);
		forgotPasswordButton.setBorder(null);
		forgotPasswordButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		welcomeViewPanel.add(forgotPasswordButton);

		rememberLastUserCheckBox = new JCheckBox("Remember Me");
		rememberLastUserCheckBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		rememberLastUserCheckBox.setBounds(134, 304, 136, 23);
		welcomeViewPanel.add(rememberLastUserCheckBox);

		forgotPasswordPanel = new JPanel();
		forgotPasswordPanel.setForeground(Color.WHITE);
		forgotPasswordPanel.setBorder(null);
		forgotPasswordPanel.setBackground(Color.WHITE);
		forgotPasswordPanel.setBounds(423, 0, 407, 452);
		frame.getContentPane().add(forgotPasswordPanel);
		forgotPasswordPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Forgot Password");
		lblNewLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 22, 395, 34);
		forgotPasswordPanel.add(lblNewLabel);

		resetEmailTextField = new JTextField();
		resetEmailTextField.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		resetEmailTextField.setBounds(44, 178, 331, 26);
		forgotPasswordPanel.add(resetEmailTextField);
		resetEmailTextField.setColumns(10);

		JLabel lblEmail_1 = new JLabel("Email");
		lblEmail_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		lblEmail_1.setBounds(48, 150, 331, 16);
		forgotPasswordPanel.add(lblEmail_1);

		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));

		resetButton.setBounds(258, 390, 117, 29);
		forgotPasswordPanel.add(resetButton);

		cancelButton = new JButton("Back");
		cancelButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));

		cancelButton.setBounds(129, 390, 117, 29);
		forgotPasswordPanel.add(cancelButton);


		registerPanel = new JPanel();
		registerPanel.setBackground(Color.WHITE);
		registerPanel.setBounds(6, 464, 407, 370);
		frame.getContentPane().add(registerPanel);
		registerPanel.setLayout(null);

		JLabel label = new JLabel("Full Name");
		label.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		label.setBounds(44, 44, 98, 16);
		registerPanel.add(label);

		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		nameTextField.setColumns(10);
		nameTextField.setBounds(44, 73, 331, 26);
		registerPanel.add(nameTextField);

		JLabel label_1 = new JLabel("Email");
		label_1.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		label_1.setBounds(44, 111, 61, 16);
		registerPanel.add(label_1);

		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		emailTextField.setColumns(10);
		emailTextField.setBounds(40, 139, 331, 26);
		registerPanel.add(emailTextField);

		JLabel label_2 = new JLabel("Password");
		label_2.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		label_2.setBounds(44, 177, 74, 16);
		registerPanel.add(label_2);

		signUpPasswordTextField = new JPasswordField();
		signUpPasswordTextField.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		signUpPasswordTextField.setBounds(40, 200, 331, 26);
		registerPanel.add(signUpPasswordTextField);

		teacherRadioButton = new JRadioButton("Teacher");
		teacherRadioButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		teacherRadioButton.setBounds(40, 238, 87, 23);
		registerPanel.add(teacherRadioButton);

		studentRadioButton = new JRadioButton("Student");
		studentRadioButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		studentRadioButton.setSelected(true);
		studentRadioButton.setBounds(40, 269, 98, 23);
		registerPanel.add(studentRadioButton);

		ButtonGroup group = new ButtonGroup();
		group.add(teacherRadioButton);
		group.add(studentRadioButton);

		studentRadioButton.setSelected(true);

		registerButton = new JButton("Create");
		registerButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		registerButton.setBounds(254, 238, 117, 29);
		registerPanel.add(registerButton);

		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
		lblSignUp.setBounds(6, 6, 395, 26);
		registerPanel.add(lblSignUp);

		cancelSUButton = new JButton("Back");
		cancelSUButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));

		cancelSUButton.setBounds(254, 268, 117, 29);
		registerPanel.add(cancelSUButton);
		/*
		password = new JTextField();
		password.setBounds(60, 241, 331, 26);
		frame.getContentPane().add(password);
		password.setColumns(10);
		 */
	}


	private void launchMail(ActionEvent e, String text) {
		String subject = LoginView.OTHER;

		if (text.equals("Question")) {
			subject = LoginView.QUESTION;
		} else if (text.equals("Delete Course")){
			subject = LoginView.DELETECOURSE;
		} else if (text.equals("Delete Session")) {
			subject = LoginView.DELETESESSION;
		}else if (text.equals("Delete Account")) {
			subject = LoginView.DELETEACCOUNT;
		}else if (text.equals("Remove Student")) {
			subject = LoginView.REMOVESTUDENT;
		} else if (text.equals("Other")) {
			subject = LoginView.OTHER;
		}


		


	}


}
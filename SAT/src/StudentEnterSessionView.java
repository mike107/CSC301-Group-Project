import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;

public class StudentEnterSessionView {

	JFrame frame;
	JTextField accessCodeTextField;
	JButton joinButton;
	JButton joinLastSessionButton;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public StudentEnterSessionView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 440, 270);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Enter Access Code");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
		lblNewLabel.setBounds(6, 34, 428, 27);
		frame.getContentPane().add(lblNewLabel);
		
		accessCodeTextField = new JTextField();
		accessCodeTextField.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		accessCodeTextField.setBounds(48, 73, 338, 27);
		frame.getContentPane().add(accessCodeTextField);
		accessCodeTextField.setColumns(10);
		
		joinButton = new JButton("Join");
		joinButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
	
		
		joinButton.setBounds(269, 213, 117, 29);
		frame.getContentPane().add(joinButton);
		
		 joinLastSessionButton = new JButton("Join Last Session?");
		 joinLastSessionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		joinLastSessionButton.setForeground(new Color(0, 153, 255));
		joinLastSessionButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));
		joinLastSessionButton.setBorder(null);
		
		
		joinLastSessionButton.setBounds(155, 112, 140, 27);
		frame.getContentPane().add(joinLastSessionButton);
	}
}

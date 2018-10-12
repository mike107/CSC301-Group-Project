import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JList;

public class StudentFeedbackView {

	JFrame frame;
	JButton oneStarButton;
	JButton twoStarButton;
	JButton threeStarButton;
	JButton fourStarButton;
	JButton fiveStarButton;
	
	JLabel suggestionOneLabel;
	JLabel suggestionTwoLabel;
	JLabel suggestionThreeLabel;
	JButton submitButton;
	
	JTextPane feedbackText;
	JButton btnDownload;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFeedbackView window = new StudentFeedbackView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentFeedbackView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 440, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblSessionFeedback = new JLabel("Session Feedback");
		lblSessionFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		lblSessionFeedback.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
		lblSessionFeedback.setBounds(6, 30, 428, 27);
		frame.getContentPane().add(lblSessionFeedback);
		
		JLabel lblNewLabel = new JLabel("Suggestions");
		lblNewLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 13));
		lblNewLabel.setBounds(16, 185, 418, 16);
		frame.getContentPane().add(lblNewLabel);
		
		suggestionOneLabel = new JLabel("I enjoyed the diagrams, but I would like it if they were explained better.");
		suggestionOneLabel.setForeground(new Color(0, 0, 0));
		suggestionOneLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));
		suggestionOneLabel.setBounds(17, 213, 396, 16);
		suggestionOneLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(suggestionOneLabel);
		
		suggestionTwoLabel = new JLabel("One suggestion would be if we could have more class discussion.");
		suggestionTwoLabel.setForeground(new Color(0, 0, 0));
		suggestionTwoLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));
		suggestionTwoLabel.setBounds(16, 235, 396, 27);
		suggestionTwoLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(suggestionTwoLabel);
		
		suggestionThreeLabel = new JLabel("I feel that the concepts were a bit harder to understand this lecture.");
		suggestionThreeLabel.setForeground(new Color(0, 0, 0));
		suggestionThreeLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 12));
		suggestionThreeLabel.setBounds(16, 263, 396, 27);
		suggestionThreeLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(suggestionThreeLabel);
		
		submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		submitButton.setBounds(317, 343, 117, 29);
		frame.getContentPane().add(submitButton);
		
		
		oneStarButton = new JButtonTag("",1);
		oneStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/unselectedRating24.png")));
		oneStarButton.setBorder(null);
		oneStarButton.setForeground(Color.WHITE);
		oneStarButton.setBounds(16, 343, 32, 32);
		frame.getContentPane().add(oneStarButton);
		
		twoStarButton = new JButtonTag("",2);
		twoStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/unselectedRating24.png")));
		twoStarButton.setBorder(null);
		twoStarButton.setForeground(Color.WHITE);
		twoStarButton.setBounds(46, 343, 32, 32);
		frame.getContentPane().add(twoStarButton);
		
		threeStarButton = new JButtonTag("",3);
		threeStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/unselectedRating24.png")));
		threeStarButton.setBorder(null);
		threeStarButton.setForeground(Color.WHITE);
		threeStarButton.setBounds(76, 343, 32, 32);
		frame.getContentPane().add(threeStarButton);
		
		fourStarButton = new JButtonTag("",4);
		fourStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/unselectedRating24.png")));
		fourStarButton.setBorder(null);
		fourStarButton.setForeground(Color.WHITE);
		fourStarButton.setBounds(106, 343, 32, 32);
		frame.getContentPane().add(fourStarButton);
		
		fiveStarButton = new JButtonTag("",5);
		fiveStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/unselectedRating24.png")));
		fiveStarButton.setBorder(null);
		fiveStarButton.setForeground(Color.WHITE);
		fiveStarButton.setBounds(136, 343, 32, 32);
		frame.getContentPane().add(fiveStarButton);
		
		feedbackText = new JTextPane();
		feedbackText.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		feedbackText.setBounds(16, 69, 407, 104);
		feedbackText.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		frame.getContentPane().add(feedbackText);
		
		btnDownload = new JButton("Download");
		btnDownload.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		btnDownload.setBounds(215, 343, 100, 29);
		frame.getContentPane().add(btnDownload);
		
	}
}

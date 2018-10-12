import java.awt.EventQueue;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.Persistence;
import com.backendless.exceptions.BackendlessException;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AttendanceView {
	JFrame frame;
	JLabel TitleLabel;
	JTextArea tArea;
	JTable table;
	DefaultTableModel model;
	JLabel count;
	private JPanel panel;
	JLabel accessCode;
	JLabel sessionID;
	JLabel courseID;
	JButton uploadFilesButton;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public AttendanceView() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 475, 489);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(false);
		TitleLabel = new JLabel("Currently Present:");
		TitleLabel.setBounds(145, 49, 118, 16);
		frame.getContentPane().add(TitleLabel);
		frame.setLocationRelativeTo(null);
		
		/*JButton refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("pressed");
				//presentStudent();
			}
		});
		refreshButton.setBounds(334, 392, 117, 29);*/
		//frame.getContentPane().add(refreshButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 77, 426, 343);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		model = new DefaultTableModel();
		table.setModel(model);
		model.addColumn("Emails:");

		count = new JLabel("");
		count.setBounds(260, 49, 61, 16);
		frame.getContentPane().add(count);

		panel = new JPanel();
		panel.setBounds(25, 6, 426, 29);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));




		courseID = new JLabel("Course ID:");
		courseID.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		panel.add(courseID);

		sessionID = new JLabel("Session ID:");
		sessionID.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		panel.add(sessionID);

		accessCode = new JLabel("Access Code:");
		accessCode.setFont(new Font("Lucida Grande", Font.BOLD, 11));
		panel.add(accessCode);
		
		
		uploadFilesButton = new JButton("Upload Files");
		uploadFilesButton.setBounds(334, 432, 117, 29);
		frame.getContentPane().add(uploadFilesButton);
	}
}

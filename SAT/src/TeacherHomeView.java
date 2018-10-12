import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.exceptions.BackendlessException;

import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import com.backendless.persistence.DataQueryBuilder;

import java.awt.event.ItemListener;

import java.awt.event.ItemEvent;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;

import org.jfree.chart.JFreeChart; 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class TeacherHomeView {

	JFrame frame;
	JTextField sessionIDTextField;
	String[] courseID = new String[1];
	JTable sessionTable;
	JTable feedbackTable;
	JScrollPane feedbackScrollPane;
	JComboBox coursesComboBox;
	JPanel TeacherAnalytics;
	JPanel graphbox;
	JLabel graphLabel;

	JLabel avgRatingLable;
	JLabel attendanceLabel;
	JComboBox coursesSessionComboBox; 
	JButton exportButton;
	JButton createSessionButton;
	JButton refreshButton;
	private JButton btnNewButton;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public TeacherHomeView() {
		Backendless.initApp(Defaults.APPLICATION_ID,  Defaults.API_KEY ); // Use this to initialize backendless in project


		initialize();


		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 950, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		tabbedPane.setBackground(UIManager.getColor("Button.background"));
		tabbedPane.setBounds(0, 0, 950, 578);
		frame.getContentPane().add(tabbedPane);

		JPanel CreateSession = new JPanel();
		CreateSession.setBackground(Color.WHITE);
		tabbedPane.addTab("Create Session", null, CreateSession, null);
		CreateSession.setLayout(null);

		JLabel CourseID = new JLabel("Course ID");
		CourseID.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		CourseID.setBounds(273, 88, 152, 40);
		CreateSession.add(CourseID);



		

		coursesSessionComboBox = new JComboBox();
		coursesSessionComboBox.setEditable(true);
		coursesSessionComboBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		coursesSessionComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		
		coursesSessionComboBox.setBounds(269, 140, 331, 35);
		CreateSession.add(coursesSessionComboBox);

		JLabel SessionID = new JLabel("Session ID");
		SessionID.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		SessionID.setBounds(273, 234, 161, 40);
		CreateSession.add(SessionID);

		createSessionButton = new JButton("Create");
		
		createSessionButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		createSessionButton.setBounds(806, 497, 117, 29);
		CreateSession.add(createSessionButton);

		sessionIDTextField = new JTextField();
		sessionIDTextField.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		sessionIDTextField.setBounds(269, 279, 331, 35);
		CreateSession.add(sessionIDTextField);
		sessionIDTextField.setColumns(10);

		TeacherAnalytics = new JPanel();
		TeacherAnalytics.setBackground(Color.WHITE);
		tabbedPane.addTab("Teacher Analytics", null, TeacherAnalytics, null);
		
		TeacherAnalytics.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 929, 35);
		TeacherAnalytics.add(panel);
		panel.setLayout(null);
		
		JLabel instruction = new JLabel("Note: Please use only 2-3 characters for Session ID.");
		instruction.setHorizontalAlignment(SwingConstants.CENTER);
		instruction.setFont(new Font("Helvetica Neue", Font.PLAIN, 13));
		instruction.setBounds(266, 319, 339, 55);
		instruction.setForeground(Color.GRAY);
		CreateSession.add(instruction);
		
		btnNewButton = new JButton("?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Desktop desktop;
				if (Desktop.isDesktopSupported() 
						&& (desktop = Desktop.getDesktop()).isSupported(Desktop.Action.MAIL)) {
					URI mailto;
					try {
						mailto = new URI("mailto:uoftsatapp@gmail.com?subject=Issue%20Type:%20");
						desktop.mail(mailto);
					} catch (URISyntaxException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
				
					JOptionPane.showMessageDialog(null, "Mail client not supported. Please try again." , "Error", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 153, 255));
		btnNewButton.setBounds(6, 494, 33, 33);
		CreateSession.add(btnNewButton);



		// Courses Combo Box
		coursesComboBox = new JComboBox();
		coursesComboBox.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		

		coursesComboBox.setBounds(6, 6, 126, 23);


		panel.add(coursesComboBox);
		exportButton = new JButton("Export");
		exportButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		exportButton.setBounds(164, 3, 117, 29);
		
		panel.add(exportButton);

		avgRatingLable = new JLabel("");
		avgRatingLable.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		avgRatingLable.setBounds(300, 9, 200, 16);
		panel.add(avgRatingLable);

		attendanceLabel = new JLabel("");
		attendanceLabel.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		attendanceLabel.setBounds(500, 9, 200, 16);
		panel.add(attendanceLabel);
		
		refreshButton = new JButton("Refresh");
		refreshButton.setFont(new Font("Helvetica Neue", Font.PLAIN, 14));
		refreshButton.setBounds(772, 3, 94, 29);
		panel.add(refreshButton);


		sessionTable = new JTable();
		sessionTable.setShowGrid(false);
		sessionTable.setRowSelectionAllowed(false);
		sessionTable.setShowHorizontalLines(false);
		//sessionTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		sessionTable.setBounds(10, 47, 112, 381);
		

		JScrollPane scrollpane = new JScrollPane(sessionTable);
		scrollpane.setBounds(10, 47, 112, 479);
		scrollpane.setBorder(new LineBorder(new Color(0, 0, 0)));

		TeacherAnalytics.add(scrollpane);
		
		feedbackTable = new FeedbackTable();
		//feedbackTable = new JTable();
		//feedbackTable.setDefaultRenderer(Feedback.class, new FeedbackCellRenderer());
		//feedbackTable.setShowHorizontalLines(true);
		feedbackScrollPane = new JScrollPane(feedbackTable);
		feedbackScrollPane.setBounds(716, 46, 207, 480);
		feedbackScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		feedbackScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		TeacherAnalytics.add(feedbackScrollPane);

		graphbox = new JPanel();
		graphbox.setBounds(134, 47, 570, 479);
		TeacherAnalytics.add(graphbox);
		graphbox.setLayout(null);

		graphLabel = new JLabel("");
		graphLabel.setBounds(0, 0, 564, 372);
		graphbox.add(graphLabel);
	}
	
	class FeedbackTable extends JTable {

		private static final long serialVersionUID = 1L;
		
		public FeedbackTable() {
			super();
			this.setDefaultRenderer(Feedback.class, new FeedbackCellRenderer());
			this.setShowHorizontalLines(true);
		}
		
		@SuppressWarnings("serial")
		private class FeedbackTableModel extends DefaultTableModel {

			private final int columnCount = 1;
			List<Feedback> data;
			
			public FeedbackTableModel(List<Feedback> data) {
				this.data = data;
			}
			
			public Class<?> getColumnClass(int colIndex) {
				return Feedback.class;
			}
			
			public int getColumnCount() {
				return columnCount;
			}
			
			public String getColumnName(int colIndex) {
				return "Feedback";
			}
			
			public int getRowCount() {
				return (data == null) ? 0 : data.size();
			}
			
			public Object getValueAt(int rowIndex, int columnIndex) {
				return data.get(rowIndex); 
			}
			
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}
		}

		private class FeedbackCellRenderer extends JTextArea implements TableCellRenderer {
			
			private static final long serialVersionUID = 1L;

			public FeedbackCellRenderer() {
				this.setLineWrap(true);
				this.setWrapStyleWord(true);
				this.setEditable(false);
			}

			@Override
			public Component getTableCellRendererComponent(
					JTable table, Object value, 
					boolean isSelected, boolean hasFocus, 
					int row, int column) {
				Feedback feedback = (Feedback)value;
				this.setText(formatFeedback(feedback));
				
				/* Adjust height of table cell to display feedback */
				this.setSize(table.getColumnModel().getColumn(column).getWidth(), Short.MAX_VALUE);
				// table.setRowHeight(row, this.getPreferredSize().height);
				// System.out.println("infinite loop");
				
				return this;
			}
			
			private String formatFeedback(Feedback feedback) {
				try {
					String message = "";
					if (feedback.getFeedback() == null) {
						message = "";
					} else {
						message = feedback.getFeedback();
					}
					String result = "";
					result += "Session: " + feedback.getSessionID() + "\n";
					result += "From: " + feedback.getFrom() + "\n";
					result += "\n";
					result += message;
					result += "\n";
					return result;
				} catch(NullPointerException e) {
					return "";
				}
			}
		}
		
		public void displayFeedback(List<Feedback> feedbackList) throws IllegalArgumentException {
			if(feedbackList == null) {
				throw new IllegalArgumentException();
			}
			this.setModel(new FeedbackTableModel(feedbackList));
			this.updateRowHeights();
			this.repaint();
		}
		
		private void updateRowHeights() {
			for(int row = 0; row < this.getRowCount(); row++) {
				Component comp = this.prepareRenderer(this.getCellRenderer(row, 0), row, 0);
				this.setRowHeight(row, (int)comp.getPreferredSize().getHeight());
			}
		}
		
	}
	
}


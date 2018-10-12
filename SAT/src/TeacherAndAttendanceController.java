

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.security.auth.Refreshable;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.DefaultComboBoxModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.backendless.Backendless;

import com.backendless.exceptions.BackendlessException;
import com.backendless.files.BackendlessFile;
import com.backendless.persistence.DataQueryBuilder;

public class TeacherAndAttendanceController {
	Thread show;
	private AttendanceView view;
	private TeacherHomeView mainView;
	private boolean isInterrupted = false;
	String bCourse,bSession = "";

	private boolean sessionClosed = true;


	JFreeChart barChart;

	Teachers new_session_teacher;
	JOptionPane newpane = new JOptionPane();
	/**
	 * Launch the application.
	 */


	public TeacherAndAttendanceController(TeacherHomeView mainView) {
		this.mainView = mainView;
		mainView.frame.setVisible(true);

		//	System.out.println("---");




		this.mainView.coursesComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				coursesComboBoxItemStateChanged(e);

			}
		});

		System.out.println("BEFORE: " + Defaults.getUser().getEmail());

		String whereClause = String.format("TeacherEmail = '%s'", Defaults.getUser().getEmail());
		DataQueryBuilder queryBuilder = DataQueryBuilder.create();
		queryBuilder.setWhereClause( whereClause );
		queryBuilder.setPageSize(100);

		List<Map> teacherCoursesMap = Backendless.Persistence.of("Teachers").find(queryBuilder);
		List<String> teacherCourses = new ArrayList<String>();


		for (int i = 0; i < teacherCoursesMap.size(); i++) {

			String teacher = (String) teacherCoursesMap.get(i).get("TeacherEmail");

			String course = (String) teacherCoursesMap.get(i).get("courseID");


			if (!teacherCourses.contains(course)) {
				teacherCourses.add(course);

			}

		}


		if (teacherCourses.isEmpty()) {
			this.mainView.coursesSessionComboBox.addItem("");
			this.mainView.coursesSessionComboBox.setSelectedItem("");
			Defaults.courseSelected = (String)this.mainView.coursesSessionComboBox.getSelectedItem();
		} else {
			//this.mainView.coursesSessionComboBox.setModel(teacherCourses);
			for (int i = 0; i < teacherCourses.size(); i++) {

				this.mainView.coursesSessionComboBox.addItem(teacherCourses.get(i));
				this.mainView.coursesComboBox.addItem(teacherCourses.get(i));

			}
			this.mainView.coursesSessionComboBox.setSelectedItem(this.mainView.coursesSessionComboBox.getItemAt(0));
			Defaults.courseSelected = (String)this.mainView.coursesSessionComboBox.getSelectedItem();
		}

		this.mainView.createSessionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createSession(e);

			}
		});


		this.mainView.exportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				export(e);

			}
		});

		this.mainView.refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh(e);

			}
		});


		// Program Initializes

		/* Initialize teacher feedback table */
		try {
			((TeacherHomeView.FeedbackTable)this.mainView.feedbackTable)
			.displayFeedback(fetchCourseFeedback(this.mainView.coursesComboBox.getSelectedItem().toString()));
		} catch(IllegalArgumentException | NullPointerException e) {
			//Do nothing
		}

	}

	/**
	 * Get all feedback for the currently selected course
	 * @return A list of Feedback objects with the CourseID of the currently selected course
	 */
	private List<Feedback> fetchCourseFeedback(String courseID) throws IllegalArgumentException {
		if(courseID == null) {
			throw new IllegalArgumentException();
		}

		String whereClause = String.format("CourseID = '%s'", courseID);

		DataQueryBuilder queryBuilder = DataQueryBuilder.create();
		queryBuilder.setWhereClause(whereClause);
		queryBuilder.setSortBy("created DESC");
		queryBuilder.setPageSize(100);

		List<Feedback> result = Backendless.Data.of(Feedback.class).find(queryBuilder);
		
		/* Remove empty feedback messages */
		List<Feedback> empty = new ArrayList<Feedback>();
		for(Feedback feedback : result) {
			if(feedback.getFeedback() == null) {
				empty.add(feedback);
			}
		}
		result.removeAll(empty);
		
		return result;
	}

	public void export(ActionEvent e) {
		String destination = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "/SAT Analytics/";
		File tempDir = new File(destination);
		if (!tempDir.exists()) {


			try{
				tempDir.mkdir();


			} 
			catch(SecurityException se){

			}
		}
		try {
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			File saveImage = new File(destination + this.mainView.coursesComboBox.getSelectedItem().toString() + timeStamp + ".jpeg");

			ChartUtilities.saveChartAsJPEG(saveImage,barChart, 1920 , 1080);
			JOptionPane.showMessageDialog(null, "Location: " + destination , "Graph Saved", JOptionPane.PLAIN_MESSAGE);
		}catch(IOException | NullPointerException exception){
			JOptionPane.showMessageDialog(null, "An error occured trying to save the graph. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void coursesComboBoxItemStateChanged(ItemEvent e) {
		System.out.println("Item State Changed " + this.mainView.coursesComboBox.getSelectedItem().toString());
		update(this.mainView.coursesComboBox.getSelectedItem().toString());
	}

	public void upload(ActionEvent e) {
		FileNameExtensionFilter filter = new FileNameExtensionFilter(null, "zip");
		final JFileChooser fc = new JFileChooser();
		fc.setFileFilter(filter);
		int returnVal = fc.showOpenDialog(TeacherAndAttendanceController.this.mainView.frame);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			String fileFullName = file.getPath() + file.getName();
			try {
				BackendlessFile uploadedFile = Backendless.Files.upload(file, "/myfiles/"+Defaults.new_session_teacher.getCourseID()+"/"+Defaults.new_session_teacher.getSessionID(),true);System.out.println( "File has been uploaded. File URL is - " + uploadedFile.getFileURL() );
				Defaults.uploadedTeacher.setUrl(uploadedFile.getFileURL());
				System.out.println(uploadedFile.getFileURL());
				Teachers teacher = Backendless.Data.of(Teachers.class).save(Defaults.uploadedTeacher);
				//Defaults.uploadedTeacher = teacher;





			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {

		}
	}

	public void createSession(ActionEvent e) {
		//frame.dispose();

		String course = (String) this.mainView.coursesSessionComboBox.getSelectedItem();
		String session =  this.mainView.sessionIDTextField.getText();

		if(((DefaultComboBoxModel)this.mainView.coursesComboBox.getModel()).getIndexOf(course) == -1) {
			this.mainView.coursesComboBox.addItem(course);
		}

		if(session.length() <= 3 && session.trim().length() > 0 && course.trim().length() > 0 && BackendlessManager.queryBackendFor(course, session)) {
			String accessCode = generate_rand_session();
			System.out.println("ACCESS CODE: "+ accessCode);
			/*
			 * Send to database with required fields
			 * */
			new_session_teacher = new Teachers();

			new_session_teacher.setSessionID(this.mainView.sessionIDTextField.getText());
			new_session_teacher.setAccessCode(accessCode);

			new_session_teacher.setTeacherEmail(Defaults.getUser().getEmail());
			System.out.println("NEW SESSION EMAIL: " + Defaults.getUser().getEmail());
			new_session_teacher.setCourseID(course);

			Defaults.new_session_teacher = new_session_teacher;
			Teachers teacher = Backendless.Data.of(Teachers.class).save(new_session_teacher);
			Defaults.uploadedTeacher = teacher;
			sessionClosed = false;
			view = new AttendanceView();
			view.frame.setVisible(true);
			this.view.frame.setDefaultCloseOperation(this.view.frame.DO_NOTHING_ON_CLOSE);

			this.view.frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					//show.interrupt();
					int dialogResult = JOptionPane.showConfirmDialog(null, 
							"Are you sure you want to close session: " + teacher.getSessionID(), "Close Session?", 
							JOptionPane.YES_NO_OPTION);

					if(dialogResult == JOptionPane.YES_OPTION){
						Long result = Backendless.Persistence.of( Teachers.class ).remove( teacher );
						new_session_teacher.setCourseID("");
						teacher.setAccessCode("");
						teacher.setUrl("");
						Backendless.Data.of(Teachers.class).save(teacher);
						try {
							Backendless.Files.remove("/myfiles/"+bCourse+"/"+bSession);
						}catch (BackendlessException ex) {

						}
						System.out.println("DELETED RESULT: "+ result);
						isInterrupted = true;
						sessionClosed = true;
						view.frame.dispose();
					}
					else {
						return;
					}



				}
			});
			this.mainView.frame.setDefaultCloseOperation(this.mainView.frame.DO_NOTHING_ON_CLOSE);
			this.mainView.frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					//show.interrupt();
					if (!sessionClosed) {
						int dialogResult = JOptionPane.showConfirmDialog(null, 
								"Are you sure you want to close session: " + teacher.getSessionID(), "Close Session?", 
								JOptionPane.YES_NO_OPTION);
						if(dialogResult == JOptionPane.YES_OPTION){
							Long result = Backendless.Persistence.of( Teachers.class ).remove( teacher );
							new_session_teacher.setCourseID("");
							teacher.setUrl("");
							teacher.setAccessCode("");
							teacher.setUrl("");
							Backendless.Data.of(Teachers.class).save(teacher);
							try {
								Backendless.Files.remove("/myfiles/"+bCourse+"/"+bSession);
							}catch (BackendlessException ex) {

							}
							System.out.println("DELETED RESULT: "+ result);
							isInterrupted = true;



							view.frame.dispose();
							mainView.frame.dispose();
						}
						else {
							return;
						}

					} else {
						mainView.frame.dispose();
					}

				}
			});



			this.view.uploadFilesButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					upload(e);
				}			
			});

			this.view.courseID.setText("Course ID: " + new_session_teacher.getCourseID() + "  ");
			this.view.sessionID.setText("Session ID: " + new_session_teacher.getSessionID() + "  ");
			this.view.accessCode.setText("Access Code: " + new_session_teacher.getAccessCode() + "  ");
			bCourse = new_session_teacher.getCourseID();
			bSession = new_session_teacher.getSessionID();
			this.mainView.coursesSessionComboBox.addItem(course);
			presentStudent();


		}else {
			JOptionPane.showMessageDialog(null, "Enter a different course ID or session ID", "Error", JOptionPane.ERROR_MESSAGE);
		}

		//	TeacherViewController teacherController = new TeacherViewController(view);


	}



	public void presentStudent() {

		Backendless.initApp(Defaults.APPLICATION_ID,  Defaults.API_KEY);
		show = new Thread() {
			public void run(){
				try {
					while(!isInterrupted) {

						String whereClause = "sessionID = '" + mainView.sessionIDTextField.getText() +"'" + " and courseID = '"+ mainView.coursesSessionComboBox.getSelectedItem().toString() + "'";

						DataQueryBuilder queryBuilder = DataQueryBuilder.create();
						queryBuilder.setWhereClause( whereClause );
						queryBuilder.setPageSize(100);
						List<Map> attendance = Backendless.Data.of("Attendance").find(queryBuilder);

						view.model.setRowCount(0);
						view.count.setText("" + attendance.size());
						for (int i = 0; i < attendance.size();i++) {

							view.model.addRow(new Object[] {attendance.get(i).get("studentEmail")});

						}

						//System.out.println("THREAD RUNNING");

						sleep(5000);

					}
					show.interrupt();
				} catch (InterruptedException | BackendlessException exception) {
					System.out.println(((BackendlessException) exception).getDetail());
					JOptionPane.showMessageDialog(null, "An error occured connecting to server. Please restart the application and try again.", "Error", JOptionPane.ERROR_MESSAGE);

					//System.exit(0);
					//view.frame.dispose();


				}
			}
		};
		show.start();
		isInterrupted = false;
		//show.interrupt();

	}



	public Comparator<Map<String, String>> compare = new Comparator<Map<String, String>>() {
		public int compare(Map<String, String> m1, Map<String, String> m2) {

			return m1.get("sessionID").compareTo(m2.get("sessionID"));
		}
	};

	/**
	 * Setup all items from start
	 * Updates all items when ComboBox value changes
	 * 
	 * @param course
	 */
	private void update(String course) {
		List<Map> result = getSessions(course);
	

		Defaults.selectedCourse = this.mainView.coursesComboBox.getSelectedItem().toString();
		graph(result, course);
		System.out.println("OVER HERE-------------: " + result.size());

		sessionTable(result);

		/* Update teacher feedback table */
		try {
			((TeacherHomeView.FeedbackTable)this.mainView.feedbackTable)
			.displayFeedback(fetchCourseFeedback(course));
		} catch(IllegalArgumentException e) {
			//Do nothing
		}

		List<Map> ratings = getRatings(course);
		updateRatings(ratings);

		List<Map> attendance = getAttendance(course);

		updateAttendance(attendance, result.size());
	}

	private String generate_rand_session() {
		String legalCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		int length = legalCharacters.length();
		int i = 0;
		String sessionCode = "";
		while(i< 6) { //the code is how length 6
			Random rand = new Random();
			int randomPos = rand.nextInt(54);
			sessionCode += legalCharacters.charAt(randomPos);
			i++;
		}

		return sessionCode;
	}

	private void graph(List<Map> result, String course) {



		DefaultCategoryDataset bar_chart_dataset = new DefaultCategoryDataset();


		try {
			List<Map> attendance = BackendlessManager.getDataFromBackendless("courseID = '"+course+"'", "Attendance");
			List<Map> feedback =  BackendlessManager.getDataFromBackendless("CourseID = '"+course+"'", "Feedback");



			for (int i = 0; i < result.size(); i++) {

				int attendanceSize = BackendlessManager.queryBackendFor("sessionID", (String)result.get(i).get("sessionID"), attendance);
				bar_chart_dataset.addValue(attendanceSize, "Students" , (Comparable) result.get(i).get("sessionID"));

				int averageRating = BackendlessManager.queryBackendForRatingPer((String)result.get(i).get("sessionID"), feedback);
				bar_chart_dataset.addValue(averageRating, "Average Rating" , (Comparable) result.get(i).get("sessionID"));


			}


			barChart = ChartFactory.createBarChart3D(
					"Attendance Tracking",             
					"Sessions",             
					"Attendance",             
					bar_chart_dataset,            
					PlotOrientation.VERTICAL,             
					true, true, false);

			String destination = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "/SAT_TEMP/";
			File tempDir = new File(destination);

			// if the directory does not exist, create it
			if (!tempDir.exists()) {


				try{
					tempDir.mkdir();

				} 
				catch(SecurityException se){

				}

			}else {
				String[]entries = tempDir.list();
				for(String file: entries){
					File currentFile = new File(tempDir.getPath(),file);
					currentFile.delete();
				}
			}



			int width = Defaults.setX;    /* Width of the image */
			int height = Defaults.setY;   /* Height of the image */
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			String location = destination + timeStamp + ".jpeg";
			File lineChart = new File(location); 
			try {

				ChartUtilities.saveChartAsJPEG(lineChart ,barChart, width, height);
				this.mainView.graphLabel.repaint();
				this.mainView.graphLabel.setIcon(new ImageIcon( location));
				this.mainView.graphLabel.setBounds(0, 0, Defaults.setX, Defaults.setY);
				this.mainView.graphLabel.repaint();


			}catch(IOException e) {
				System.out.println(e.getMessage());
			}

		}
		catch (Exception ex) {

		}


	}

	private void sessionTable(List<Map> result) {
		TableModel dataModel = new AbstractTableModel() {
			public int getColumnCount() { return 1; }
			public int getRowCount() { return result.size();	}
			public String getColumnName(int index) {return "Sessions";}
			public Object getValueAt(int row, int col) { return result.get(row).get("sessionID"); }

		};
		this.mainView.sessionTable.setSelectionBackground(null);
		this.mainView.sessionTable.setFocusable(false);
		this.mainView.sessionTable.setModel(dataModel);
		this.mainView.sessionTable.repaint();
	}

	private List<Map> getSessions(String course) {
		List<Map> result = null;
		try {
			String whereClause = String.format("courseID = '%s'", course);
			DataQueryBuilder queryBuilder = DataQueryBuilder.create();
			queryBuilder.setWhereClause( whereClause );
			queryBuilder.setPageSize(100);
			queryBuilder.setSortBy("created");

			result = Backendless.Data.of( "Teachers" ).find(queryBuilder);

		}
		catch (BackendlessException e) {

		}
		return result;
	}

	private List<Map> getRatings(String course){
		return 	BackendlessManager.getDataFromBackendless("courseID = '"+course+"'", "Feedback");
	}

	public void updateRatings(List<Map> rating) {
		int sumRating = 0;

		for(int i = 0; i < rating.size(); i++) {
			sumRating += (int)rating.get(i).get("Rating");
		}

		if(rating.size() == 0) {
			this.mainView.avgRatingLable.setText("Average Rating: " + 0);
		}else {
			int avgRating = sumRating / rating.size();
			this.mainView.avgRatingLable.setText("Average Rating: " + avgRating);
		}
	}

	public List<Map> getAttendance(String course){
		return 	BackendlessManager.getDataFromBackendless("courseID = '"+course+"'", "Attendance");
	}

	public void updateAttendance(List<Map> attendance, int size) {
		if (size == 0) {
			this.mainView.attendanceLabel.setText("Average Attendance: " + attendance.size());
		} else {
			this.mainView.attendanceLabel.setText("Average Attendance: " + attendance.size()/size);

		}
	}

	public void refresh(ActionEvent e) {
		try {
			update(this.mainView.coursesComboBox.getSelectedItem().toString());
		}catch(NullPointerException ex) {

		}
	}

}

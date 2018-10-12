import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import com.backendless.Backendless;
import com.backendless.exceptions.BackendlessException;

public class StudentFeedbackViewController {

	StudentFeedbackView view;
	int rating;

	public StudentFeedbackViewController(StudentFeedbackView view) {
		Backendless.initApp(Defaults.APPLICATION_ID,  Defaults.API_KEY );
		this.view = view;
		try {
			this.view.frame.setVisible(true);

		}	catch (Exception e) {
			e.printStackTrace();
		}


		this.view.oneStarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ratingController(e);
			}
		});
		this.view.twoStarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ratingController(e);
			}
		});
		this.view.threeStarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ratingController(e);
			}
		});
		this.view.fourStarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ratingController(e);
			}
		});
		this.view.fiveStarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ratingController(e);
			}
		});

		this.view.suggestionOneLabel.addMouseListener(new MouseAdapter()   {   

			public void mouseClicked(MouseEvent e)   
			{   
				suggestionController(e); 
			}   
		});
		this.view.suggestionTwoLabel.addMouseListener(new MouseAdapter()   {   

			public void mouseClicked(MouseEvent e)   
			{   
				suggestionController(e); 
			}   
		});
		this.view.suggestionThreeLabel.addMouseListener(new MouseAdapter()   {   

			public void mouseClicked(MouseEvent e)   
			{   
				suggestionController(e); 
			}   
		});

		this.view.submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitController(e);
			}
		});
		
		this.view.btnDownload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				download(e);
			}
		});

	}
	
	private void download(ActionEvent e) {
		String cid = (String)Defaults.teachersTable.get(Defaults.index).get("courseID");
		String sid = (String)Defaults.teachersTable.get(Defaults.index).get("sessionID");
		
		String whereClause = String.format("courseID = '%s' and sessionID = '%s'",cid,sid);
		
		List<Map> teacherTable = BackendlessManager.getDataFromBackendless(whereClause, "Teachers");
		
		URL website;
		try {
			website = new URL((String)teacherTable.get(0).get("url"));

		    String fileName = website.toString().substring(website.toString().lastIndexOf('/') + 1, website.toString().length());
		    String destination = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "/SAT Downloads/";
			File tempDir = new File(destination);
			if (!tempDir.exists()) {
				try{
					tempDir.mkdir();
				} 
				catch(SecurityException se){

				}
			}
		    Path targetPath = new File(FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+"/SAT Downloads/"+cid+sid+".zip").toPath();
			JOptionPane.showMessageDialog(null, "Location: " + destination , " files downloaded.", JOptionPane.PLAIN_MESSAGE);
		    Files.copy(website.openStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "There are no files to download." , "OK", JOptionPane.PLAIN_MESSAGE);
			System.out.println("No files");
			//e1.printStackTrace();
		}

	}

	private void submitController(ActionEvent e) {
		String msg = this.view.feedbackText.getText();

		String whereClause = String.format("CourseID = '%s' and SessionID = '%s' and From = '%s'", Defaults.courseId,Defaults.sessionID, Defaults.getUser().getEmail());
		System.out.println(Defaults.getUser().getEmail());
		System.out.println(Defaults.courseId);
		System.out.println(Defaults.sessionID);
		
		List<Map> feedbackMap = BackendlessManager.getDataFromBackendless(whereClause, "Feedback");
		
		    
		
		
		
		try {
			if((msg.isEmpty() && this.rating != 0) || (!(msg.isEmpty()) && this.rating != 0)) {
				boolean feedbackSent = false;
				
				if (feedbackMap.size() > 0) {
					JOptionPane.showMessageDialog(null, "You have already submitted a feedback!", "Invalid", JOptionPane.PLAIN_MESSAGE);
					
				}else {
					
					Feedback feedback = new Feedback();
					feedback.setFeedback(msg);
					feedback.setRating(this.rating);
					feedback.setFrom(Defaults.getUser().getEmail());
					feedback.setTo((String)Defaults.teachersTable.get(Defaults.index).get("TeacherEmail"));
					feedback.setCourseID(Defaults.courseId);

					feedback.setSessionID((String)Defaults.teachersTable.get(Defaults.index).get("sessionID"));
					Backendless.Data.of(Feedback.class).save(feedback);
					JOptionPane.showMessageDialog(null, "Feedback sent!", "Message", JOptionPane.PLAIN_MESSAGE);
					this.view.frame.dispose();
				}
			}else {
				JOptionPane.showMessageDialog(null, "Please provide a rating!", "Error", JOptionPane.PLAIN_MESSAGE);
			}
		}catch (BackendlessException exception ) {

			JOptionPane.showMessageDialog(null, exception.getDetail() , "Error", JOptionPane.PLAIN_MESSAGE);
		}


	}


	private void suggestionController(MouseEvent e) {
		JLabel label = (JLabel) e.getSource();

		this.view.feedbackText.setText(label.getText());

	}

	private void ratingController(ActionEvent e) {
		JButtonTag ratingButton = (JButtonTag) e.getSource();

		this.rating = ratingButton.tag;

		if (ratingButton.tag == 1) {
			this.view.oneStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/selectedRating24.png")));
			this.view.twoStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/unselectedRating24.png")));
			this.view.threeStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/unselectedRating24.png")));
			this.view.fourStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/unselectedRating24.png")));
			this.view.fiveStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/unselectedRating24.png")));

		}
		if (ratingButton.tag == 2) {
			this.view.oneStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/selectedRating24.png")));
			this.view.twoStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/selectedRating24.png")));
			this.view.threeStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/unselectedRating24.png")));
			this.view.fourStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/unselectedRating24.png")));
			this.view.fiveStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/unselectedRating24.png")));
		}

		if (ratingButton.tag == 3) {
			this.view.oneStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/selectedRating24.png")));
			this.view.twoStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/selectedRating24.png")));
			this.view.threeStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/selectedRating24.png")));
			this.view.fourStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/unselectedRating24.png")));
			this.view.fiveStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/unselectedRating24.png")));
		}
		if (ratingButton.tag == 4) {
			this.view.oneStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/selectedRating24.png")));
			this.view.twoStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/selectedRating24.png")));
			this.view.threeStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/selectedRating24.png")));
			this.view.fourStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/selectedRating24.png")));
			this.view.fiveStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/unselectedRating24.png")));
		}
		if (ratingButton.tag == 5) {
			this.view.oneStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/selectedRating24.png")));
			this.view.twoStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/selectedRating24.png")));
			this.view.threeStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/selectedRating24.png")));
			this.view.fourStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/selectedRating24.png")));
			this.view.fiveStarButton.setIcon(new ImageIcon(StudentFeedbackView.class.getResource("/Assets/selectedRating24.png")));
		}

		this.view.oneStarButton.setBorder(null);


		this.view.twoStarButton.setBorder(null);

		this.view.threeStarButton.setBorder(null);


		this.view.fourStarButton.setBorder(null);


		this.view.fiveStarButton.setBorder(null);
	}





}

package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import timeTableController.TimeTableController;
import userController.UserController;

import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class TeacherView extends JPanel implements ActionListener {
	private static String teacherLogin = null;
	private MainFrame mainFrame;
	private UserController userController;	
	private TimeTableController timeTableController;

	public TeacherView(MainFrame parent, String login, UserController userController, TimeTableController tTController) {
		this.mainFrame = parent;
		teacherLogin = login;
		this.userController=userController;
		this.timeTableController=tTController;
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setLocationRelativeTo(null);
		
		/*this.mainFrame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);*/
		
		JButton Book = new JButton("Book a Time Slot");
		JButton Unbook = new JButton("Book a Time Slot");
		
		Book.setActionCommand("Book");
		Unbook.setActionCommand("Unbook");
		Unbook.addActionListener(this);
		Book.addActionListener(this);
		
		Book.setBounds(230, 97, 132, 41);
		add(Book);
		
		Unbook.setBounds(88, 97, 132, 41);
		add(Unbook);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		  if(action.equals("Unbook")){
			  mainFrame.setContentPane(new TeacherUnbook(mainFrame, teacherLogin, userController, timeTableController));
		  }

			  if(action.equals("Book")){
				  mainFrame.setContentPane(new TeacherBook(mainFrame, teacherLogin, userController, timeTableController));
			  }	
	}
		

}

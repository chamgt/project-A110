package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import timeTableController.TimeTableController;
import userController.UserController;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerListModel;
import javax.swing.JButton;

public class TeacherUnbook extends JPanel implements ActionListener {
	private JSpinner spinnerTable = new JSpinner();
	private JSpinner spinnerIDBooking = new JSpinner();
	private UserController userController;	
	private TimeTableController timeTableController;
	private String LoginUser;

	public TeacherUnbook(MainFrame parent, String Login, UserController userController, TimeTableController tTController) {
		parent.setTitle("Unbook a Time Slot");
		this.LoginUser = Login;
		this.userController=userController;
		this.timeTableController=tTController;
		parent.setBounds(100, 100, 450, 300);
		parent.setLocationRelativeTo(null);
		parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(170, 169, 82, 23);
		add(btnConfirm);
		btnConfirm.setActionCommand("btnConfirm");
		btnConfirm.addActionListener(this);		
		
		JLabel lblIdTable = new JLabel("ID Table :");
		lblIdTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdTable.setBounds(120, 44, 62, 14);
		add(lblIdTable);
		

		spinnerTable.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerTable.setBounds(209, 42, 29, 20);
		add(spinnerTable);
		
		JLabel lblIdBooking = new JLabel("ID Booking :");
		lblIdBooking.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdBooking.setBounds(114, 96, 68, 14);
		add(lblIdBooking);
		

		spinnerIDBooking.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerIDBooking.setBounds(209, 94, 29, 20);
		add(spinnerIDBooking);
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		  if(action.equals("btnConfirm")){
			  Integer IDTable = ((Integer)spinnerTable.getValue());
			  Integer IDBooking = ((Integer)spinnerIDBooking.getValue());
			  
			  timeTableController.removeBook(IDTable, IDBooking);
			  }
	}
}

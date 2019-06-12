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

public class TeacherBook extends JPanel implements ActionListener {

	private JSpinner spinnerRoom = new JSpinner();
	private JSpinner spinnerBegin = new JSpinner();
	private JSpinner spinnerEnd = new JSpinner();
	private JSpinner spinnerTable = new JSpinner();
	private JSpinner spinnerIDBooking = new JSpinner();
	private UserController userController;	
	private TimeTableController timeTableController;
	private String LoginUser;

	public TeacherBook(MainFrame parent, String Login, UserController userController, TimeTableController tTController) {
		parent.setTitle("Book a Time Slot");
		this.LoginUser = Login;
		this.userController=userController;
		this.timeTableController=tTController;
		parent.setBounds(100, 100, 450, 300);
		parent.setLocationRelativeTo(null);
		parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JLabel lblIdRoom = new JLabel("ID Room :");
		lblIdRoom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdRoom.setBounds(44, 23, 55, 15);
		add(lblIdRoom);
		
		
		spinnerRoom.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerRoom.setBounds(103, 21, 31, 20);
		add(spinnerRoom);
		
		
		spinnerBegin.setModel(new SpinnerDateModel(new Date(1559368800000L), null, null, Calendar.DAY_OF_YEAR));
		spinnerBegin.setBounds(125, 69, 113, 20);
		add(spinnerBegin);
		
		JLabel lblDateEnd = new JLabel("Date End :");
		lblDateEnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateEnd.setBounds(44, 119, 59, 15);
		add(lblDateEnd);
		
		
		
		spinnerEnd.setModel(new SpinnerDateModel(new Date(1559372400000L), null, null, Calendar.DAY_OF_YEAR));
		spinnerEnd.setBounds(125, 117, 113, 20);
		add(spinnerEnd);
		
		JLabel lblDateBegin = new JLabel("Date Begin :");
		lblDateBegin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateBegin.setBounds(44, 71, 68, 15);
		add(lblDateBegin);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(170, 169, 82, 23);
		add(btnConfirm);
		btnConfirm.setActionCommand("btnConfirm");
		btnConfirm.addActionListener(this);		
		
		JLabel lblIdTable = new JLabel("ID Table :");
		lblIdTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdTable.setBounds(170, 23, 62, 14);
		add(lblIdTable);
		

		spinnerTable.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerTable.setBounds(227, 21, 29, 20);
		add(spinnerTable);
		
		JLabel lblIdBooking = new JLabel("ID Booking :");
		lblIdBooking.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdBooking.setBounds(285, 24, 68, 14);
		add(lblIdBooking);
		

		spinnerIDBooking.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinnerIDBooking.setBounds(363, 21, 29, 20);
		add(spinnerIDBooking);
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		  if(action.equals("btnConfirm")){
			  Integer IDTable = ((Integer)spinnerTable.getValue());
			  Integer IDBooking = ((Integer)spinnerIDBooking.getValue());
			  Date DateBegin = ((Date)spinnerBegin.getValue());
			  Date DateEnd = ((Date)spinnerEnd.getValue());
			  Integer IDRoom = ((Integer)spinnerRoom.getValue());
			  
			  timeTableController.addBooking(IDTable, IDBooking, LoginUser, DateBegin, DateEnd, IDRoom);
			  System.out.println("It's done");
			  }
	}
}

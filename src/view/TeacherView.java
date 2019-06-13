package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

import timeTableController.TimeTableController;
import userController.UserController;

import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;

public class TeacherView extends JPanel implements ActionListener {
	private MainFrame mainFrame;
	private JTable table;
	private Vector<String> entetes = new Vector<String>();
	private int numberWeek;
	private JPanel panel;
	private JLabel lblWeek;
	private JComboBox<String> txtGroup;
	private Integer groupId;

	public TeacherView(MainFrame parent) {
		this.mainFrame = parent;
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setLocationRelativeTo(null);

		/*
		 * this.mainFrame.setBounds(100, 100, 450, 300);
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * frame.getContentPane().setLayout(null);
		 */
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 105, 111, 123, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 23, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JButton Book = new JButton("Book a Time Slot");

		Book.setActionCommand("Book");
		Book.addActionListener(this);

		Component horizontalGlue = Box.createHorizontalGlue();
		GridBagConstraints gbc_horizontalGlue = new GridBagConstraints();
		gbc_horizontalGlue.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalGlue.gridx = 0;
		gbc_horizontalGlue.gridy = 1;
		add(horizontalGlue, gbc_horizontalGlue);

		JLabel lblScheduleOfThe = new JLabel("Schedule of the goupe :");
		GridBagConstraints gbc_lblScheduleOfThe = new GridBagConstraints();
		gbc_lblScheduleOfThe.insets = new Insets(0, 0, 5, 5);
		gbc_lblScheduleOfThe.gridx = 1;
		gbc_lblScheduleOfThe.gridy = 1;
		add(lblScheduleOfThe, gbc_lblScheduleOfThe);

		String[] data = this.mainFrame.getUserController().groupsIdToString();

		txtGroup = new JComboBox<String>(data);
		txtGroup.setSelectedIndex(2);
		txtGroup.setMaximumRowCount(10);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		add(txtGroup, gbc_comboBox);
		txtGroup.setActionCommand("group");
		txtGroup.addActionListener(this);

		groupId = Integer.parseInt((txtGroup.getSelectedItem().toString()));

		Book.setBounds(230, 97, 132, 41);
		GridBagConstraints gbc_Book = new GridBagConstraints();
		gbc_Book.anchor = GridBagConstraints.NORTH;
		gbc_Book.insets = new Insets(0, 0, 5, 5);
		gbc_Book.gridx = 1;
		gbc_Book.gridy = 2;
		add(Book, gbc_Book);
		JButton Unbook = new JButton("Unbook a Time Slot");
		Unbook.setActionCommand("Unbook");
		Unbook.addActionListener(this);

		Unbook.setBounds(88, 97, 132, 41);
		GridBagConstraints gbc_Unbook = new GridBagConstraints();
		gbc_Unbook.insets = new Insets(0, 0, 5, 5);
		gbc_Unbook.anchor = GridBagConstraints.NORTH;
		gbc_Unbook.gridx = 2;
		gbc_Unbook.gridy = 2;
		add(Unbook, gbc_Unbook);

		entetes.add("Heures");
		entetes.add("MONDAY");
		entetes.add("TUESDAY");
		entetes.add("WEDNESDAY");
		entetes.add("THURSDAY");
		entetes.add("FRIDAY");

		Calendar actual = Calendar.getInstance();
		numberWeek = actual.get(Calendar.WEEK_OF_YEAR);

		JButton btnPreviousWeek = new JButton("Previous week");
		GridBagConstraints gbc_btnPreviousWeek = new GridBagConstraints();
		gbc_btnPreviousWeek.insets = new Insets(0, 0, 5, 5);
		gbc_btnPreviousWeek.gridx = 0;
		gbc_btnPreviousWeek.gridy = 3;
		add(btnPreviousWeek, gbc_btnPreviousWeek);
		btnPreviousWeek.setActionCommand("previous");
		btnPreviousWeek.addActionListener(this);

		lblWeek = new JLabel("Week :" + numberWeek+ " du groupe "+ groupId);
		GridBagConstraints gbc_lblWeek = new GridBagConstraints();
		gbc_lblWeek.gridwidth = 2;
		gbc_lblWeek.insets = new Insets(0, 0, 5, 5);
		gbc_lblWeek.gridx = 1;
		gbc_lblWeek.gridy = 3;
		add(lblWeek, gbc_lblWeek);

		JButton btnNextWeek = new JButton("Next week");
		GridBagConstraints gbc_btnNextWeek = new GridBagConstraints();
		gbc_btnNextWeek.insets = new Insets(0, 0, 5, 5);
		gbc_btnNextWeek.gridx = 3;
		gbc_btnNextWeek.gridy = 3;
		add(btnNextWeek, gbc_btnNextWeek);
		btnNextWeek.setActionCommand("next");
		btnNextWeek.addActionListener(this);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 3;
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		table = new JTable(displayBooks(), entetes);
		table.setFillsViewportHeight(true);
		panel.add(table);

	}

	@SuppressWarnings("deprecation")
	private Vector<Vector<String>> displayBooks() {
		Hashtable<Integer, Date> debut = new Hashtable<Integer, Date>();
		Hashtable<Integer, Date> fin = new Hashtable<Integer, Date>();
		
		mainFrame.getTimeTableController().getBookingsDate(groupId, debut, fin);
		
		Vector<String> row;
		Vector<Vector<String>> result = new Vector<Vector<String>>();
		result.add(entetes);
		for (int i = 0; i <= 24; i++) {
			row = new Vector<String>();
			row.setSize(15);
			row.set(0, i + ":00");

			for (Map.Entry<Integer, Date> entry : debut.entrySet()) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(entry.getValue());
				if (entry.getValue().getHours() == i && calendar.get(Calendar.WEEK_OF_YEAR) == numberWeek) {
					row.set(entry.getValue().getDay(),
							"Début :"+ entry.getValue().getHours()+":"+entry.getValue().getMinutes() + " ; Prof : "
									+ mainFrame.getTimeTableController().getTeacherLogin(groupId, entry.getKey())
									+ " salle: " + mainFrame.getTimeTableController().getRoom(groupId, entry.getKey()));
				}
			}
			for (Map.Entry<Integer, Date> entry : fin.entrySet()) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(entry.getValue());
				if (entry.getValue().getHours() == i && calendar.get(Calendar.WEEK_OF_YEAR) == numberWeek) {
					row.set(entry.getValue().getDay(),
							"Fin : " + entry.getValue().getHours()+":"+entry.getValue().getMinutes() + " ; Prof: "
									+ mainFrame.getTimeTableController().getTeacherLogin(groupId, entry.getKey())
									+ " salle: " + mainFrame.getTimeTableController().getRoom(groupId, entry.getKey()));
				}
			}
			result.add(row);
		}
		return (result);
	}
//		}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();

		if (action.equals("next")) {
			numberWeek = (numberWeek + 1) % 52;
			table = new JTable(displayBooks(), entetes);
			panel.removeAll();
			lblWeek.setText("Week : " + numberWeek +" du groupe : "+groupId);
			panel.add(table);
		} else if (action.equals("previous")) {
			numberWeek = (numberWeek - 1) % 52;
			table = new JTable(displayBooks(), entetes);
			panel.removeAll();
			lblWeek.setText("Week : " + numberWeek +" du groupe : "+groupId);
			panel.add(table);
		} else if (action.equals("Unbook")) {
			if (this.mainFrame.getTimeTableController().booksIdToString(groupId).length == 0) {

			} else {
				TeacherUnBook dialogUnBook = new TeacherUnBook(mainFrame, true, groupId);
				dialogUnBook.setVisible(true);
			}
		} else if (action.equals("group")) {
			groupId = Integer.parseInt((txtGroup.getSelectedItem().toString()));
			table = new JTable(displayBooks(), entetes);
			System.out.println(displayBooks());
			panel.removeAll();
			lblWeek.setText("Week : " + numberWeek +" du groupe : "+groupId);
			panel.add(table);

		}

		else if (action.equals("Book")) {
			TeacherBook dialogBook = new TeacherBook(mainFrame, true, groupId);
			dialogBook.setVisible(true);
		}
	}

}

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

public class StudentView extends JPanel implements ActionListener {
	private MainFrame mainFrame;
	private JTable table;
	private Vector<String> entetes = new Vector<String>();
	private int numberWeek;
	private JPanel panel;
	private JLabel lblWeek;
	private Integer groupId;

	public StudentView(MainFrame parent, Integer groupId) {
		this.mainFrame = parent;
		this.groupId = groupId;
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setLocationRelativeTo(null);

		/*
		 * this.mainFrame.setBounds(100, 100, 450, 300);
		 * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 * frame.getContentPane().setLayout(null);
		 */
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 105, 111, 123, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

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
		gbc_btnPreviousWeek.gridy = 0;
		add(btnPreviousWeek, gbc_btnPreviousWeek);
		btnPreviousWeek.setActionCommand("previous");
		btnPreviousWeek.addActionListener(this);

		lblWeek = new JLabel("Week :" + numberWeek+ " du groupe "+ groupId);
		GridBagConstraints gbc_lblWeek = new GridBagConstraints();
		gbc_lblWeek.gridwidth = 2;
		gbc_lblWeek.insets = new Insets(0, 0, 5, 5);
		gbc_lblWeek.gridx = 1;
		gbc_lblWeek.gridy = 0;
		add(lblWeek, gbc_lblWeek);

		JButton btnNextWeek = new JButton("Next week");
		GridBagConstraints gbc_btnNextWeek = new GridBagConstraints();
		gbc_btnNextWeek.insets = new Insets(0, 0, 5, 0);
		gbc_btnNextWeek.gridx = 3;
		gbc_btnNextWeek.gridy = 0;
		add(btnNextWeek, gbc_btnNextWeek);
		btnNextWeek.setActionCommand("next");
		btnNextWeek.addActionListener(this);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 3;
		gbc_panel.gridwidth = 4;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

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
							"Fin " + entry.getValue().getHours()+":"+entry.getValue().getMinutes() + " ; Prof: "
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
		}

	}

}

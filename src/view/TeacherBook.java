package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JComboBox;

public class TeacherBook extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtHourBegin;
	private JTextField txtHourEnd;
	private JTextField txtMinuteBegin;
	private JTextField txtMinuteEnd;
	private JComboBox<String> roomId;
	private MainFrame mainFrame;
	private Integer tableId;
	private JTextField txtMonth;
	private JTextField txtYear;
	private JTextField txtDay;
	SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");

	public TeacherBook(MainFrame parent, boolean modal, Integer tableId) {
		super(parent, modal);
		this.mainFrame = parent;
		this.tableId = tableId;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		{
			JLabel lblRoomId = new JLabel("Room ID");
			GridBagConstraints gbc_lblRoomId = new GridBagConstraints();
			gbc_lblRoomId.anchor = GridBagConstraints.EAST;
			gbc_lblRoomId.insets = new Insets(0, 0, 5, 5);
			gbc_lblRoomId.gridx = 1;
			gbc_lblRoomId.gridy = 1;
			contentPanel.add(lblRoomId, gbc_lblRoomId);
		}
		String[] data = this.mainFrame.getTimeTableController().roomsIdToString();
		{
			roomId = new JComboBox<String>(data);
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.gridwidth = 5;
			gbc_comboBox.insets = new Insets(0, 0, 5, 0);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 2;
			gbc_comboBox.gridy = 1;
			contentPanel.add(roomId, gbc_comboBox);
		}
		{
			JLabel lblDay = new JLabel("Day");
			GridBagConstraints gbc_lblDay = new GridBagConstraints();
			gbc_lblDay.anchor = GridBagConstraints.EAST;
			gbc_lblDay.insets = new Insets(0, 0, 5, 5);
			gbc_lblDay.gridx = 1;
			gbc_lblDay.gridy = 2;
			contentPanel.add(lblDay, gbc_lblDay);
		}
		{
			txtDay = new JTextField();
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.insets = new Insets(0, 0, 5, 5);
			gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_2.gridx = 2;
			gbc_textField_2.gridy = 2;
			contentPanel.add(txtDay, gbc_textField_2);
			txtDay.setColumns(10);
		}
		{
			JLabel lblMonth = new JLabel("Month");
			GridBagConstraints gbc_lblMonth = new GridBagConstraints();
			gbc_lblMonth.anchor = GridBagConstraints.EAST;
			gbc_lblMonth.insets = new Insets(0, 0, 5, 5);
			gbc_lblMonth.gridx = 3;
			gbc_lblMonth.gridy = 2;
			contentPanel.add(lblMonth, gbc_lblMonth);
		}
		{
			txtMonth = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 4;
			gbc_textField.gridy = 2;
			contentPanel.add(txtMonth, gbc_textField);
			txtMonth.setColumns(10);
		}
		{
			JLabel lblYear = new JLabel("Year");
			GridBagConstraints gbc_lblYear = new GridBagConstraints();
			gbc_lblYear.anchor = GridBagConstraints.EAST;
			gbc_lblYear.insets = new Insets(0, 0, 5, 5);
			gbc_lblYear.gridx = 5;
			gbc_lblYear.gridy = 2;
			contentPanel.add(lblYear, gbc_lblYear);
		}
		{
			txtYear = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 0);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 6;
			gbc_textField_1.gridy = 2;
			contentPanel.add(txtYear, gbc_textField_1);
			txtYear.setColumns(10);
		}
		{
			JLabel lblHourBegin = new JLabel("Hour Begin");
			GridBagConstraints gbc_lblHourBegin = new GridBagConstraints();
			gbc_lblHourBegin.anchor = GridBagConstraints.EAST;
			gbc_lblHourBegin.insets = new Insets(0, 0, 5, 5);
			gbc_lblHourBegin.gridx = 1;
			gbc_lblHourBegin.gridy = 3;
			contentPanel.add(lblHourBegin, gbc_lblHourBegin);
		}
		{
			txtHourBegin = new JTextField();
			GridBagConstraints gbc_txtHourBegin = new GridBagConstraints();
			gbc_txtHourBegin.insets = new Insets(0, 0, 5, 5);
			gbc_txtHourBegin.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHourBegin.gridx = 2;
			gbc_txtHourBegin.gridy = 3;
			contentPanel.add(txtHourBegin, gbc_txtHourBegin);
			txtHourBegin.setColumns(10);
		}

		{
			JLabel lblMinuteBegin = new JLabel("Minute Begin");
			GridBagConstraints gbc_lblMinuteBegin = new GridBagConstraints();
			gbc_lblMinuteBegin.anchor = GridBagConstraints.EAST;
			gbc_lblMinuteBegin.insets = new Insets(0, 0, 5, 5);
			gbc_lblMinuteBegin.gridx = 3;
			gbc_lblMinuteBegin.gridy = 3;
			contentPanel.add(lblMinuteBegin, gbc_lblMinuteBegin);
		}

		{
			txtMinuteBegin = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 4;
			gbc_textField.gridy = 3;
			contentPanel.add(txtMinuteBegin, gbc_textField);
			txtMinuteBegin.setColumns(10);
		}
		{
			JLabel lblHourEnd = new JLabel("Hour End");
			GridBagConstraints gbc_lblHourEnd = new GridBagConstraints();
			gbc_lblHourEnd.anchor = GridBagConstraints.EAST;
			gbc_lblHourEnd.insets = new Insets(0, 0, 5, 5);
			gbc_lblHourEnd.gridx = 1;
			gbc_lblHourEnd.gridy = 4;
			contentPanel.add(lblHourEnd, gbc_lblHourEnd);
		}
		{
			txtHourEnd = new JTextField();
			GridBagConstraints gbc_txtHourEnd = new GridBagConstraints();
			gbc_txtHourEnd.insets = new Insets(0, 0, 5, 5);
			gbc_txtHourEnd.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHourEnd.gridx = 2;
			gbc_txtHourEnd.gridy = 4;
			contentPanel.add(txtHourEnd, gbc_txtHourEnd);
			txtHourEnd.setColumns(10);
		}
		{
			JLabel lblMinuteEnd = new JLabel("Minute End");
			GridBagConstraints gbc_lblMinuteEnd = new GridBagConstraints();
			gbc_lblMinuteEnd.anchor = GridBagConstraints.EAST;
			gbc_lblMinuteEnd.insets = new Insets(0, 0, 5, 5);
			gbc_lblMinuteEnd.gridx = 3;
			gbc_lblMinuteEnd.gridy = 4;
			contentPanel.add(lblMinuteEnd, gbc_lblMinuteEnd);
		}
		{
			txtMinuteEnd = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 5);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 4;
			gbc_textField_1.gridy = 4;
			contentPanel.add(txtMinuteEnd, gbc_textField_1);
			txtMinuteEnd.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(this);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(this);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		if (action.equals("OK")) {
			Integer room = Integer.parseInt(roomId.getSelectedItem().toString());
			System.out.println(roomId.getSelectedItem().toString());
			String txtDateDeb = txtYear.getText() + txtMonth.getText() + txtDay.getText() + txtHourBegin.getText()
					+ txtMinuteBegin.getText();
			String txtDateFin = txtYear.getText() + txtMonth.getText() + txtDay.getText() + txtHourEnd.getText()
					+ txtMinuteEnd.getText();

			Date dateDeb = null;
			Integer bookId = this.mainFrame.getTimeTableController().getBookingsMaxId(this.tableId);

			try {
				dateDeb = format.parse(txtDateDeb);
			} catch (ParseException e) {
				//e.printStackTrace();
				JOptionPane.showMessageDialog(mainFrame, "The date format is incorrect.", "Date error",
						JOptionPane.ERROR_MESSAGE);

			}
			Date dateFin = null;
			try {
				dateFin = format.parse(txtDateFin);
			} catch (ParseException e1) {
				//e1.printStackTrace();
				JOptionPane.showMessageDialog(mainFrame, "The date format is incorrect.", "Date error",
						JOptionPane.ERROR_MESSAGE);
			}
			System.out.println(dateDeb);
			System.out.println(dateFin);
			this.mainFrame.getTimeTableController().addBooking(this.tableId, bookId, this.mainFrame.user_login, dateDeb,
					dateFin, room);
			JOptionPane.showMessageDialog(null, "The book has been added to group " + tableId.toString() +".");
			dispose();

		} else if (action.equals("Cancel")) {
			dispose();
		}
	}

}

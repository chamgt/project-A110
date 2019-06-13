package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;

public class AddRoom extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField roomId;
	private JTextField capacity;
	private MainFrame mainFrame;

	public AddRoom(MainFrame parent, boolean modal) {
		super(parent, modal);
		this.mainFrame = parent;
		setTitle("Add a room");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			Component verticalStrut = Box.createVerticalStrut(50);
			GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
			gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_verticalStrut.gridx = 2;
			gbc_verticalStrut.gridy = 0;
			contentPanel.add(verticalStrut, gbc_verticalStrut);
		}
		{
			Component horizontalStrut = Box.createHorizontalStrut(50);
			GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
			gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_horizontalStrut.gridx = 0;
			gbc_horizontalStrut.gridy = 1;
			contentPanel.add(horizontalStrut, gbc_horizontalStrut);
		}
		{
			JLabel lblRoomId = new JLabel("Room ID");
			GridBagConstraints gbc_lblRoomId = new GridBagConstraints();
			gbc_lblRoomId.insets = new Insets(0, 0, 5, 5);
			gbc_lblRoomId.anchor = GridBagConstraints.EAST;
			gbc_lblRoomId.gridx = 1;
			gbc_lblRoomId.gridy = 1;
			contentPanel.add(lblRoomId, gbc_lblRoomId);
		}
		{
			roomId = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 1;
			contentPanel.add(roomId, gbc_textField);
			roomId.setColumns(10);
		}
		{
			Component horizontalStrut = Box.createHorizontalStrut(50);
			GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
			gbc_horizontalStrut.insets = new Insets(0, 0, 5, 0);
			gbc_horizontalStrut.gridx = 3;
			gbc_horizontalStrut.gridy = 1;
			contentPanel.add(horizontalStrut, gbc_horizontalStrut);
		}
		{
			JLabel lblCapacity = new JLabel("Capacity");
			GridBagConstraints gbc_lblCapacity = new GridBagConstraints();
			gbc_lblCapacity.anchor = GridBagConstraints.EAST;
			gbc_lblCapacity.insets = new Insets(0, 0, 0, 5);
			gbc_lblCapacity.gridx = 1;
			gbc_lblCapacity.gridy = 2;
			contentPanel.add(lblCapacity, gbc_lblCapacity);
		}
		{
			capacity = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 0, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 2;
			contentPanel.add(capacity, gbc_textField);
			capacity.setColumns(10);
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
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(this);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		boolean testEntier1 = Pattern.matches("[0-9]+", roomId.getText());
		boolean testEntier2 = Pattern.matches("[0-9]+", capacity.getText());

		if (action.equals("OK")) {
			if (testEntier1 && testEntier2) {
				boolean creation = this.mainFrame.getTimeTableController().addRoom(Integer.parseInt(roomId.getText()),
						Integer.parseInt(capacity.getText()));
				if (creation) {
					JOptionPane.showMessageDialog(mainFrame, "The room is created");
					dispose();
				}
			} else {
				JOptionPane.showMessageDialog(mainFrame, "The room has not been created.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} else if (action.equals("Cancel")) {
			dispose();
		}

	}

}

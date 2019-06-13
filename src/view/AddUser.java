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
import java.util.regex.Pattern;

import javax.swing.JTextField;

public abstract class AddUser extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField newUserLogin;
	private JTextField password;
	private JTextField id;
	private JTextField surname;
	private JTextField firstname;
	protected MainFrame mainFrame;

	public AddUser(MainFrame mainFrame, boolean modal) {
		super(mainFrame, modal);
		this.mainFrame = mainFrame;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblLogin = new JLabel("Login");
			GridBagConstraints gbc_lblLogin = new GridBagConstraints();
			gbc_lblLogin.anchor = GridBagConstraints.EAST;
			gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
			gbc_lblLogin.gridx = 1;
			gbc_lblLogin.gridy = 1;
			contentPanel.add(lblLogin, gbc_lblLogin);
		}
		{
			newUserLogin = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 1;
			contentPanel.add(newUserLogin, gbc_textField);
			newUserLogin.setColumns(10);
		}
		{
			JLabel lblPassword = new JLabel("Password");
			GridBagConstraints gbc_lblPassword = new GridBagConstraints();
			gbc_lblPassword.anchor = GridBagConstraints.EAST;
			gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
			gbc_lblPassword.gridx = 1;
			gbc_lblPassword.gridy = 2;
			contentPanel.add(lblPassword, gbc_lblPassword);
		}
		{
			password = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 5);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 2;
			gbc_textField_1.gridy = 2;
			contentPanel.add(password, gbc_textField_1);
			password.setColumns(10);
		}
		{
			JLabel lblId = new JLabel("ID");
			GridBagConstraints gbc_lblId = new GridBagConstraints();
			gbc_lblId.anchor = GridBagConstraints.EAST;
			gbc_lblId.insets = new Insets(0, 0, 5, 5);
			gbc_lblId.gridx = 1;
			gbc_lblId.gridy = 3;
			contentPanel.add(lblId, gbc_lblId);
		}
		{
			id = new JTextField();
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.insets = new Insets(0, 0, 5, 5);
			gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_2.gridx = 2;
			gbc_textField_2.gridy = 3;
			contentPanel.add(id, gbc_textField_2);
			id.setColumns(10);
		}
		{
			JLabel lblSurname = new JLabel("Surname");
			GridBagConstraints gbc_lblSurname = new GridBagConstraints();
			gbc_lblSurname.anchor = GridBagConstraints.EAST;
			gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
			gbc_lblSurname.gridx = 1;
			gbc_lblSurname.gridy = 4;
			contentPanel.add(lblSurname, gbc_lblSurname);
		}
		{
			surname = new JTextField();
			GridBagConstraints gbc_textField_3 = new GridBagConstraints();
			gbc_textField_3.insets = new Insets(0, 0, 5, 5);
			gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_3.gridx = 2;
			gbc_textField_3.gridy = 4;
			contentPanel.add(surname, gbc_textField_3);
			surname.setColumns(10);
		}
		{
			JLabel lblFirstName = new JLabel("First name");
			GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
			gbc_lblFirstName.anchor = GridBagConstraints.EAST;
			gbc_lblFirstName.insets = new Insets(0, 0, 0, 5);
			gbc_lblFirstName.gridx = 1;
			gbc_lblFirstName.gridy = 5;
			contentPanel.add(lblFirstName, gbc_lblFirstName);
		}
		{
			firstname = new JTextField();
			GridBagConstraints gbc_textField_4 = new GridBagConstraints();
			gbc_textField_4.insets = new Insets(0, 0, 0, 5);
			gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_4.gridx = 2;
			gbc_textField_4.gridy = 5;
			contentPanel.add(firstname, gbc_textField_4);
			firstname.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}

	public abstract void add(String adminLogin, String newLogin, int id, String firstname, String surname, String pwd);

	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		System.out.println("test");
		boolean login = (newUserLogin.getText() != "");
		boolean surnameB = (surname.getText() != "");
		boolean firstnameB = (firstname.getText() != "");
		boolean passwordB = (password.getText() != "");
		boolean idB = Pattern.matches("[0-9]+", id.getText());
		System.out.println(login);
		if (action.equals("Cancel")) {
			dispose();
		} else if (action.equals("OK")) {
			if (login && surnameB && firstnameB && passwordB && idB) {
				add(mainFrame.user_login, newUserLogin.getText(), Integer.parseInt(id.getText()), firstname.getText(),
						surname.getText(), password.getText());
				dispose();
			} else {

				JOptionPane.showMessageDialog(mainFrame,
						"There is an error in the information you filled. Please check.", "Error",
						JOptionPane.ERROR_MESSAGE);
				dispose();
			}
		}
	}
}

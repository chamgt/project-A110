package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import net.miginfocom.swing.MigLayout;
import timeTableController.TimeTableController;
import userController.UserController;

public class LogIn extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private UserController userController;	
	private TimeTableController timeTableController;
	private JTextField txtUsername;
	private JPasswordField pswPassword;
	private MainFrame mainFrame;

	/**
	 * Create the dialog.
	 */
	public LogIn(MainFrame parent, boolean modal, UserController userController, TimeTableController tTController) {
		super(parent, modal);
		this.mainFrame = parent;
		this.userController=userController;
		this.timeTableController=tTController;
		setTitle("Connexion");
		setBounds(400, 200, 400, 150);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setToolTipText("Username");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		{
			JLabel lblUsername = new JLabel("Username");
			contentPanel.add(lblUsername, "cell 0 1,alignx trailing");
		}
		{
			txtUsername = new JTextField();
			txtUsername.setToolTipText("Username");
			contentPanel.add(txtUsername, "cell 1 1,growx,aligny center");
			txtUsername.setColumns(10);
		}
		{
			JLabel lblPassword = new JLabel("Password");
			contentPanel.add(lblPassword, "cell 0 2,alignx trailing");
		}
		{
			pswPassword = new JPasswordField();
			pswPassword.setToolTipText("Password");
			contentPanel.add(pswPassword, "cell 1 2,growx");
		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(this);
				getRootPane().setDefaultButton(okButton);
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
			String username = txtUsername.getText();
			String password = pswPassword.getText();
			mainFrame.user_login = username;
			System.out.println("user_login :" + mainFrame.user_login);
			System.out.println(username);
			System.out.println(password);
			System.out.println(mainFrame.getUserController().getUserClass(username, password));
			if (mainFrame.getUserController().getUserClass(username, password).equals("")) {
				JOptionPane.showMessageDialog(mainFrame, "Login or username incorrect.", "Login error",
						JOptionPane.ERROR_MESSAGE);
			} else if (mainFrame.getUserController().getUserClass(username, password).equals("Student")) {
				int group = mainFrame.getUserController().getStudentGroup(username);
				if (group == -1) {
					String msg = "You are now connected as " + mainFrame.getUserController().getUserName(username)
							+ "\n" + "You are not affected to a group, ask to an admin";
					JOptionPane.showMessageDialog(mainFrame, msg);
					dispose();
				} else {
					String msg = "You are now connected as " + mainFrame.getUserController().getUserName(username)
							+ "\n" + "You are in group " + group;
					JOptionPane.showMessageDialog(mainFrame, msg);
					dispose();
					mainFrame.setContentPane(new StudentView(mainFrame, group));
					mainFrame.setVisible(true);
				}

				System.out.println(group);
				dispose();
			} else if (mainFrame.getUserController().getUserClass(username, password).equals("Administrator")) {
				String msg = "Hello " + mainFrame.getUserController().getUserName(username) + "\n"
						+ "You are now connected as Administrator";
				JOptionPane.showMessageDialog(mainFrame, msg);
				mainFrame.setContentPane(new AdminView(mainFrame));
				mainFrame.setVisible(true);
				
			} else if (mainFrame.getUserController().getUserClass(username, password).equals("Teacher")) {
				String msg = "You are now connected as " + mainFrame.getUserController().getUserName(username);
				JOptionPane.showMessageDialog(mainFrame, msg);
				mainFrame.setContentPane(new TeacherView(mainFrame));
				mainFrame.setVisible(true);
			}

		}
		if (action.equals("Cancel")) {
			System.out.println("Cancel");
			dispose();
		}
		dispose();

	}
}

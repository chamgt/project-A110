package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;

public class AssociateStudentToGroup extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private MainFrame mainFrame;
	private JList<String> listGroup;
	private JList<String> listStudent;

	public AssociateStudentToGroup(MainFrame parent, boolean modal) {
		super(parent, modal);
		this.mainFrame = parent;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblGroupId = new JLabel("Group ID");
			GridBagConstraints gbc_lblGroupId = new GridBagConstraints();
			gbc_lblGroupId.insets = new Insets(0, 0, 5, 5);
			gbc_lblGroupId.gridx = 1;
			gbc_lblGroupId.gridy = 1;
			contentPanel.add(lblGroupId, gbc_lblGroupId);
		}
		{
			JLabel lblStudentLogin = new JLabel("Student Login");
			GridBagConstraints gbc_lblStudentLogin = new GridBagConstraints();
			gbc_lblStudentLogin.insets = new Insets(0, 0, 5, 5);
			gbc_lblStudentLogin.gridx = 3;
			gbc_lblStudentLogin.gridy = 1;
			contentPanel.add(lblStudentLogin, gbc_lblStudentLogin);
		}
		String[] dataGroup = this.mainFrame.getUserController().groupsIdToString();
		{
			listGroup = new JList<String>(dataGroup);
			GridBagConstraints gbc_list = new GridBagConstraints();
			gbc_list.insets = new Insets(0, 0, 0, 5);
			gbc_list.fill = GridBagConstraints.BOTH;
			gbc_list.gridx = 1;
			gbc_list.gridy = 2;
			contentPanel.add(listGroup, gbc_list);
		}
		String[] dataStudent = this.mainFrame.getUserController().studentsLoginToString();
		{
			listStudent = new JList<String>(dataStudent);
			GridBagConstraints gbc_list = new GridBagConstraints();
			gbc_list.insets = new Insets(0, 0, 0, 5);
			gbc_list.fill = GridBagConstraints.BOTH;
			gbc_list.gridx = 3;
			gbc_list.gridy = 2;
			contentPanel.add(listStudent, gbc_list);
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
			this.mainFrame.getUserController().associateStudToGroup(mainFrame.user_login,
					listStudent.getSelectedValue(), Integer.parseInt(listGroup.getSelectedValue()));
			JOptionPane.showMessageDialog(null, "Association succefully added");
			dispose();
		} else if (action.equals("Cancel")) {
			dispose();
		}
	}

}

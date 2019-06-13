package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class AddGroup extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField groupId;
	private MainFrame mainFrame;

	public AddGroup(MainFrame parent, boolean modal) {
		super(parent, modal);
		this.mainFrame = parent;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblGroupId = new JLabel("Group ID");
			GridBagConstraints gbc_lblGroupId = new GridBagConstraints();
			gbc_lblGroupId.insets = new Insets(0, 0, 0, 5);
			gbc_lblGroupId.anchor = GridBagConstraints.EAST;
			gbc_lblGroupId.gridx = 1;
			gbc_lblGroupId.gridy = 1;
			contentPanel.add(lblGroupId, gbc_lblGroupId);
		}
		{
			groupId = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 0, 5);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 1;
			contentPanel.add(groupId, gbc_textField);
			groupId.setColumns(10);
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
			boolean testEntier = Pattern.matches("[0-9]+", groupId.getText());
			if (testEntier) {
				this.mainFrame.getUserController().addGroup(mainFrame.user_login, Integer.parseInt(groupId.getText()));
				JOptionPane.showMessageDialog(null, "Group added");
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(mainFrame, "Group ID have to be an integer", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (action.equals("Cancel")) {
			dispose();
		}

	}

}

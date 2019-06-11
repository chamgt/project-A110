package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;

public class AdminView extends JPanel implements ActionListener {
	private MainFrame mainFrame;

	public AdminView(MainFrame parent) {
		this.mainFrame = parent;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		JPanel adminUsers = new JPanel();
		tabbedPane.addTab("Administrate Users", null, adminUsers, null);
		GridBagLayout gbl_adminUsers = new GridBagLayout();
		gbl_adminUsers.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_adminUsers.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_adminUsers.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_adminUsers.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		adminUsers.setLayout(gbl_adminUsers);
		
		Component verticalStrut = Box.createVerticalStrut(100);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.gridheight = 2;
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut.gridx = 5;
		gbc_verticalStrut.gridy = 0;
		adminUsers.add(verticalStrut, gbc_verticalStrut);
		
		JButton btnShowUsers = new JButton("Show users");
		GridBagConstraints gbc_btnShowUsers = new GridBagConstraints();
		gbc_btnShowUsers.insets = new Insets(0, 0, 5, 0);
		gbc_btnShowUsers.gridx = 5;
		gbc_btnShowUsers.gridy = 2;
		adminUsers.add(btnShowUsers, gbc_btnShowUsers);
		btnShowUsers.setActionCommand("showUsers");
		btnShowUsers.addActionListener(this);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(300);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.gridwidth = 5;
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 3;
		adminUsers.add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		JButton btnAddAStudent = new JButton("Add a student");
		GridBagConstraints gbc_btnAddAStudent = new GridBagConstraints();
		gbc_btnAddAStudent.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddAStudent.gridx = 5;
		gbc_btnAddAStudent.gridy = 3;
		adminUsers.add(btnAddAStudent, gbc_btnAddAStudent);
		
		JButton btnAddATeacher = new JButton("Add a teacher");
		GridBagConstraints gbc_btnAddATeacher = new GridBagConstraints();
		gbc_btnAddATeacher.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddATeacher.gridx = 5;
		gbc_btnAddATeacher.gridy = 4;
		adminUsers.add(btnAddATeacher, gbc_btnAddATeacher);
		
		JButton btnAddAnAdmin = new JButton("Add an admin");
		GridBagConstraints gbc_btnAddAnAdmin = new GridBagConstraints();
		gbc_btnAddAnAdmin.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddAnAdmin.gridx = 5;
		gbc_btnAddAnAdmin.gridy = 5;
		adminUsers.add(btnAddAnAdmin, gbc_btnAddAnAdmin);
		
		JButton btnRemoveUser = new JButton("Remove user");
		GridBagConstraints gbc_btnRemoveUser = new GridBagConstraints();
		gbc_btnRemoveUser.gridx = 5;
		gbc_btnRemoveUser.gridy = 6;
		adminUsers.add(btnRemoveUser, gbc_btnRemoveUser);
		
		JPanel adminGroups = new JPanel();
		tabbedPane.addTab("Administrate Groups", null, adminGroups, null);
		GridBagLayout gbl_adminGroups = new GridBagLayout();
		gbl_adminGroups.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_adminGroups.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_adminGroups.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_adminGroups.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		adminGroups.setLayout(gbl_adminGroups);
		
		JButton btnShowGroups = new JButton("Show groups");
		GridBagConstraints gbc_btnShowGroups = new GridBagConstraints();
		gbc_btnShowGroups.insets = new Insets(0, 0, 5, 0);
		gbc_btnShowGroups.gridx = 4;
		gbc_btnShowGroups.gridy = 3;
		adminGroups.add(btnShowGroups, gbc_btnShowGroups);
		btnShowGroups.setActionCommand("showGroups");
		btnShowGroups.addActionListener(this);
		
		JButton btnAddGroup = new JButton("Add group");
		GridBagConstraints gbc_btnAddGroup = new GridBagConstraints();
		gbc_btnAddGroup.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddGroup.gridx = 4;
		gbc_btnAddGroup.gridy = 4;
		adminGroups.add(btnAddGroup, gbc_btnAddGroup);
		
		JButton btnRemoveGroup = new JButton("Remove Group");
		GridBagConstraints gbc_btnRemoveGroup = new GridBagConstraints();
		gbc_btnRemoveGroup.insets = new Insets(0, 0, 5, 0);
		gbc_btnRemoveGroup.gridx = 4;
		gbc_btnRemoveGroup.gridy = 5;
		adminGroups.add(btnRemoveGroup, gbc_btnRemoveGroup);
		
		JButton btnAssociateStudentTo = new JButton("Associate student to a group");
		GridBagConstraints gbc_btnAssociateStudentTo = new GridBagConstraints();
		gbc_btnAssociateStudentTo.gridx = 4;
		gbc_btnAssociateStudentTo.gridy = 6;
		adminGroups.add(btnAssociateStudentTo, gbc_btnAssociateStudentTo);
		
		JPanel adminRooms = new JPanel();
		tabbedPane.addTab("Administrate Rooms", null, adminRooms, null);
		GridBagLayout gbl_adminRooms = new GridBagLayout();
		gbl_adminRooms.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_adminRooms.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_adminRooms.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_adminRooms.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		adminRooms.setLayout(gbl_adminRooms);
		
		JButton btnShowRooms = new JButton("Show rooms");
		GridBagConstraints gbc_btnShowRooms = new GridBagConstraints();
		gbc_btnShowRooms.insets = new Insets(0, 0, 5, 0);
		gbc_btnShowRooms.gridx = 5;
		gbc_btnShowRooms.gridy = 3;
		adminRooms.add(btnShowRooms, gbc_btnShowRooms);
		
		JButton btnAddRoom = new JButton("Add room");
		btnAddRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_btnAddRoom = new GridBagConstraints();
		gbc_btnAddRoom.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddRoom.gridx = 5;
		gbc_btnAddRoom.gridy = 4;
		adminRooms.add(btnAddRoom, gbc_btnAddRoom);
		
		JButton btnRemoveRoom = new JButton("Remove room");
		GridBagConstraints gbc_btnRemoveRoom = new GridBagConstraints();
		gbc_btnRemoveRoom.gridx = 5;
		gbc_btnRemoveRoom.gridy = 5;
		adminRooms.add(btnRemoveRoom, gbc_btnRemoveRoom);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		System.out.println(action);
		switch(action) {
		case "showUsers":
			System.out.println("ça marche");
			showUsers dialogShowUsers = new showUsers(mainFrame,true);
			dialogShowUsers.setVisible(true);
			break;
		}
	}

}

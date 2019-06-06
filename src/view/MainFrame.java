package view;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;

import timeTableController.TimeTableController;
import userController.UserController;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class MainFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private UserController userController;	
	private TimeTableController timeTableController;
	
	public MainFrame(UserController userController, TimeTableController tTController) {
		
		super("Welcome to My Time Table App");
		this.userController=userController;
		this.timeTableController=tTController;
		
		setSize(1200, 1000);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);

		JMenuItem mntmLogin = new JMenuItem("Log in");
		mnFichier.add(mntmLogin);
		mntmLogin.setActionCommand("LogIn");
		mntmLogin.addActionListener(this);

		JMenuItem mntmLogOut = new JMenuItem("Log out");
		mnFichier.add(mntmLogOut);
		mntmLogOut.setActionCommand("LogOut");
		mntmLogOut.addActionListener(this);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFichier.add(mntmExit);
		mntmExit.setActionCommand("Exit");
		mntmExit.addActionListener(this);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		if (action.equals("LogIn")) {
			System.out.println("Log in");
			LogIn dialogLogin = new LogIn(this, true);
			dialogLogin.setVisible(true);
		}
		if (action.equals("LogOut")) {
			System.out.println("Log Out");
		}
		if (action.equals("Exit")) {
			System.out.println("Exit");
		}
	}
	
	public UserController getUserController() {
		return userController;
	}
}

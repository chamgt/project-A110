package view;

public class addAdmin extends AddUser {

	public addAdmin(MainFrame mainFrame, boolean modal) {
		super(mainFrame, modal);
		setTitle("Add an Admin");
	}

	@Override
	public void add(String adminLogin, String newLogin, int id, String firstname, String surname,
			String pwd) {
		mainFrame.getUserController().addAdmin(adminLogin, newLogin, id, firstname, surname, pwd);
	}


}

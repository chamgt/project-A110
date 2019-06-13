package view;

public class AddAdmin extends AddUser {

	public AddAdmin(MainFrame mainFrame, boolean modal) {
		super(mainFrame, modal);
		setTitle("Add an Admin");
	}

	@Override
	public void add(String adminLogin, String newLogin, int id, String firstname, String surname,
			String pwd) {
		mainFrame.getUserController().addAdmin(adminLogin, newLogin, id, firstname, surname, pwd);
	}


}

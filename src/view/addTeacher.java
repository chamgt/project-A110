package view;

public class addTeacher extends AddUser {

	public addTeacher(MainFrame mainFrame, boolean modal) {
		super(mainFrame, modal);
		setTitle("Add a Teacher");
	}

	@Override
	public void add(String adminLogin, String newLogin, int id, String firstname, String surname,
			String pwd) {
		mainFrame.getUserController().addTeacher(adminLogin, newLogin, id, firstname, surname, pwd);
	}


}

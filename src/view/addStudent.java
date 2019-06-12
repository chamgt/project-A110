package view;

public class addStudent extends AddUser {
	
	public addStudent(MainFrame mainFrame, boolean modal) {
		super(mainFrame, modal);
		setTitle("Add a Student");
	}

	@Override
	public void add(String adminLogin, String newLogin, int id, String firstname, String surname,
			String pwd) {
		mainFrame.getUserController().addStudent(adminLogin, newLogin, id, firstname, surname, pwd);
	}

}

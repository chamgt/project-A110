package view;

public class RemoveUser extends Remove {
	public RemoveUser(MainFrame parent, boolean modal) {
		super(parent, modal);
	}

	@Override
	public String[] getData() {
		String[] data = this.mainFrame.getUserController().usersLoginToString();
		return data;
	}

	@Override
	public void remove(String value) {
		this.mainFrame.getUserController().removeUser(mainFrame.user_login, value);
	}

}

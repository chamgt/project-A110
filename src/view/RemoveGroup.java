package view;

public class RemoveGroup extends Remove {
	public RemoveGroup(MainFrame parent, boolean modal) {
		super(parent, modal);
	}

	@Override
	public String[] getData() {
		String[] data = this.mainFrame.getUserController().groupsIdToString();
		return data;
	}

	@Override
	public void remove(String value) {
		this.mainFrame.getUserController().removeGroup(mainFrame.user_login,Integer.parseInt(value));
	}

}

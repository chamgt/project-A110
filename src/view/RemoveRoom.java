package view;

public class RemoveRoom extends Remove {
	public RemoveRoom(MainFrame parent, boolean modal) {
		super(parent, modal);
	}

	@Override
	public String[] getData() {
		String[] data = this.mainFrame.getTimeTableController().roomsIdToString();
		return data;
	}

	@Override
	public void remove(String value) {
		this.mainFrame.getTimeTableController().removeRoom(Integer.parseInt(value));
	}

}


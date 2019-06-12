package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public abstract class Remove extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JList<String> list;
	protected MainFrame mainFrame;
	public abstract String[] getData();
	public abstract void remove(String value);

	public Remove(MainFrame parent,boolean modal) {
		super(parent,modal);
		this.mainFrame=parent;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		{
			list = new JList<String>(getData());
			contentPanel.add(list);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
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
		if (action.equals("Cancel")) {
			dispose();
		}		
		else if (action.equals("OK")) {
			if (this.list.getSelectedValue()!=null) {
				remove(this.list.getSelectedValue().toString());
			}
			JOptionPane.showMessageDialog(null, "Removed");
			dispose();
			
		}
	}

}

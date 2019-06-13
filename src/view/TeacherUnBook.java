package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Insets;
import javax.swing.JScrollBar;

public class TeacherUnBook extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private MainFrame mainFrame;
	private Integer tableId;
	private JList<String> bookId;

	public TeacherUnBook(MainFrame parent, boolean modal, Integer tableId) {
		super(parent, modal);
		this.mainFrame = parent;
		this.tableId = tableId;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblSelectABook = new JLabel("Select a book to remove");
			GridBagConstraints gbc_lblSelectABook = new GridBagConstraints();
			gbc_lblSelectABook.insets = new Insets(0, 0, 5, 5);
			gbc_lblSelectABook.gridx = 1;
			gbc_lblSelectABook.gridy = 1;
			contentPanel.add(lblSelectABook, gbc_lblSelectABook);
		}
		String[] data = this.mainFrame.getTimeTableController().booksIdToString(this.tableId);
		{
			bookId = new JList<String>(data);
			GridBagConstraints gbc_list = new GridBagConstraints();
			gbc_list.insets = new Insets(0, 0, 0, 5);
			gbc_list.fill = GridBagConstraints.BOTH;
			gbc_list.gridx = 1;
			gbc_list.gridy = 2;
			contentPanel.add(bookId, gbc_list);
		}
		{
			JScrollBar scrollBar = new JScrollBar();
			GridBagConstraints gbc_scrollBar = new GridBagConstraints();
			gbc_scrollBar.gridx = 2;
			gbc_scrollBar.gridy = 2;
			contentPanel.add(scrollBar, gbc_scrollBar);
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
		if (action.equals("OK")) {
			this.mainFrame.getTimeTableController().removeBook(this.tableId,
					Integer.parseInt(this.bookId.getSelectedValue()));
			JOptionPane.showMessageDialog(null, "The book has been removed from group " + tableId.toString() + ".");
			dispose();
		} else if (action.equals("Cancel")) {
			dispose();
		}
	}

}

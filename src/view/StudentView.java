package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;


public class StudentView extends JPanel implements ActionListener {
	public JButton PreviousWeek = new JButton("Previous");
	private JButton NextWeek = new JButton("Next");
	private JPanel contentPanel = new JPanel();
	private JLabel label;
	


	public StudentView(MainFrame parent, int group) {
		parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		parent.getContentPane().setLayout(new BorderLayout());
		parent.setBounds(100, 100, 475, 300);
		parent.setLocationRelativeTo(null);
		
		contentPanel.setBounds(225, 5, 0, 0);
		contentPanel.setLayout(new BorderLayout());
		contentPanel.setVisible(true);
		setLayout(null);
		add(contentPanel);
		
		PreviousWeek.setActionCommand("PreviousWeek");
		NextWeek.setActionCommand("NextWeek");
		NextWeek.addActionListener(this);
		
		
		label = new JLabel("The planning of the group "+group+" :");
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(143, 32, 186, 14);
		
		add(label);
		
		PreviousWeek.setBounds(22, 114, 118, 42);
		NextWeek.setBounds(310, 114, 118, 42);
		add(PreviousWeek);
		PreviousWeek.addActionListener(this);
		add(NextWeek);

	
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		  if(action.equals("PreviousWeek")){
			  System.out.println("Previous");
		  }

			  if(action.equals("NextWeek")){
				  System.out.println("Next");
			  }	
	}
}
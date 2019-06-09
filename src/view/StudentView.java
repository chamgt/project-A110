package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StudentView extends JPanel implements ActionListener {
	public JButton PreviousWeek = new JButton("Previous");
	private JButton NextWeek = new JButton("Next");
	private JPanel contentPanel = new JPanel();
	private JLabel label;
	


	public StudentView(MainFrame parent, int group) {
		parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		parent.setLocationRelativeTo(null);
		parent.setLayout(new BorderLayout());
		PreviousWeek.setActionCommand("PreviousWeek");
		NextWeek.setActionCommand("NextWeek");
		NextWeek.addActionListener(this);
		
		
		label = new JLabel("The planning of the group "+group);
		contentPanel.add(label);
		contentPanel.setBackground(Color.WHITE);
		add	(contentPanel);
		
		add(Box.createRigidArea(new Dimension(100,25)));
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout());
		
		contentPanel.setVisible(true);
		contentPanel.add(PreviousWeek, BorderLayout.WEST);
		PreviousWeek.addActionListener(this);
		contentPanel.add(NextWeek, BorderLayout.EAST);
		add(contentPanel);
		add(Box.createRigidArea(new Dimension(100,50)));
	
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
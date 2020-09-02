package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other
	// button reads "View Names".
	// When the add name button is clicked, display an input dialog that asks the
	// user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a
	// message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	ArrayList<String> names = new ArrayList<String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton b1 = new JButton();
	JButton b2 = new JButton();

	void start() {
		frame.add(panel);
		panel.add(b1);
		panel.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b1.setText("Add Name");
		b2.setText("View Names");
		names.add("Barry Sanders");
		names.add("Sandy Summers");
		names.add("Greg Ganders");
		names.add("Donny Doners");
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed =(JButton) e.getSource();
		if (buttonPressed.equals(b1)) {
		String addedName = JOptionPane.showInputDialog("Enter a name");
		names.add(addedName);
		}
		if (buttonPressed.equals(b1)) {
			for(int i = 0; i < names.size(); i++){
				String s = names.get(i);
				System.out.println(s);
			}
		}
	  }
}


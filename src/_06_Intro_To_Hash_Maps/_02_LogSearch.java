package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton b1 = new JButton();
	JButton b2 = new JButton();
	JButton b3 = new JButton();
	JButton b4 = new JButton();
	HashMap<Integer, String> ids = new HashMap<Integer, String>();

	public _02_LogSearch() {
		run();
	}

	void run() {
		frame.add(panel);
		frame.setTitle("ID Editor");
		b1.setText("Add");
		b2.setText("Search");
		b3.setText("View List");
		b4.setText("Remove ID");
		panel.add(b1);
		b1.addActionListener(this);
		panel.add(b2);
		b2.addActionListener(this);
		panel.add(b3);
		b3.addActionListener(this);
		panel.add(b4);
		b4.addActionListener(this);
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bc = (JButton) e.getSource();
		if (bc.equals(b1)) {
			int ID = Integer.parseInt(JOptionPane.showInputDialog("Enter ID number"));
			String name = JOptionPane.showInputDialog("Enter name");
			ids.put(ID, name);
		} else if (bc.equals(b2)) {
			if (!ids.isEmpty()) {
				int getID = Integer.parseInt(JOptionPane.showInputDialog("Search an ID number"));
				if (ids.containsKey(getID)) {
					JOptionPane.showMessageDialog(null, "The ID match this name: " + ids.get(getID));
				} else {
					JOptionPane.showMessageDialog(null, "This ID does not match any names");
				}
			} else {
				JOptionPane.showMessageDialog(null, "There are no ID's entered");
			}
		} else if (bc.equals(b3)) {
			for (Integer i : ids.keySet()) {
				for (String s : ids.values()) {
					JOptionPane.showMessageDialog(null, "ID: " + i + " Name: " + s);
				}
			}
		} else if (bc.equals(b4)) {
			int removeID = Integer.parseInt(JOptionPane.showInputDialog("Enter ID number"));
			if (ids.containsKey(removeID)) {
				ids.remove(removeID);
			}else {
				JOptionPane.showMessageDialog(null, "This is not a valid ID");
			}
		}
	}
}
/*
 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
 * an input dialog to ask the user to enter an ID number. After an ID is
 * entered, use another input dialog to ask the user to enter a name. Add this
 * information as a new entry to your HashMap.
 * 
 * Button 2: Search by ID When this button is clicked, use an input dialog to
 * ask the user to enter an ID number. If that ID exists, display that name to
 * the user. Otherwise, tell the user that that entry does not exist.
 * 
 * Button 3: View List When this button is clicked, display the entire list in a
 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
 * 
 * When this is complete, add a fourth button to your window. Button 4: Remove
 * Entry When this button is clicked, prompt the user to enter an ID using an
 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
 * the user that the ID is not in the list.
 *
 */
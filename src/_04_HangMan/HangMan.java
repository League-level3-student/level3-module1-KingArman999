package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	String number = JOptionPane.showInputDialog("How many words would you like to guess?");
	Stack<String> words = new Stack<String>();
	Stack<String> letters = new Stack<String>();
	String word;
	String underscore;
	int life = 6;
	int wordLength = 0;
	String labelText = "";
	public HangMan() {
		frame.add(label);
		int n = Integer.parseInt(number);
		for (int i = 0; i < n; i++) {
			if (words.size() <= n) {
				String random = Utilities.readRandomLineFromFile("dictionary.txt");
				words.add(random);
			}
		}
		convert();
		frame.setVisible(true);
		frame.pack();
	}

	public static void main(String[] args) {
		new HangMan();
	}

	void convert() {
		if (!words.isEmpty()) {
			word = words.pop();
			System.out.println(word);
		}
		wordLength = word.length();
		System.out.println(wordLength);
		for (int i = 0; i < wordLength; i++) {
		labelText+= "_ ";
		}
		label.setText(labelText);
		frame.pack();
		frame.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char keyPressed = e.getKeyChar();
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

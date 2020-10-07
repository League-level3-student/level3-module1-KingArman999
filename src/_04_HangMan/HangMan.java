package _04_HangMan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	JPanel panel = new JPanel();
	JLabel spaceLabel = new JLabel("          ");
	String number;
	Stack<String> words = new Stack<String>();
	Stack<String> wrongLetters = new Stack<String>();
	int r;
	String word;
	int life = 6;
	int wordLength = 0;
	String labelText = "";
	String keys;
	String again;
	int guessAmount;

	public HangMan() {
		newGame();
	}

	void resetFrame() {
		frame.add(panel);
		panel.add(label);
		panel.add(spaceLabel);
		frame.setTitle("Hang Man");
		frame.addKeyListener(this);
		label.addKeyListener(this);
		labelText = "";
		life = 6;
		wrongLetters.clear();
		convert();
		frame.setVisible(true);
		frame.pack();
	}

	void convert() {
		if (!words.isEmpty()) {
			word = words.pop();
		}
		wordLength = word.length();
		for (int i = 0; i < wordLength; i++) {
			labelText += "_ ";
		}
		label.setText(labelText);
		frame.pack();
		frame.repaint();
	}

	void newGame() {
		number = JOptionPane.showInputDialog("How many words would you like to guess?");
		guessAmount = Integer.parseInt(number);
		for (int i = 0; i <= guessAmount; i++) {
			if (words.size() < guessAmount) {
				String random = Utilities.readRandomLineFromFile("dictionary.txt");
				words.add(random);
			}
		}
		resetFrame();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char key = e.getKeyChar();
		String keyPressed = String.valueOf(key);
		if (word.contains(keyPressed)) {
			String newLabelText = "";
			for (int i = 0; i < wordLength; i++) {
				if (word.charAt(i) == key) {
					newLabelText += key;
				} else {
					newLabelText += labelText.charAt(i * 2);

				}
				newLabelText += " ";
			}

			labelText = newLabelText;
			label.setText(labelText);
			frame.repaint();
			if (!labelText.contains("_")) {
				if (guessAmount > 1) {
					JOptionPane.showMessageDialog(null, "Correct, next word.");
					guessAmount -= 1;
					frame.dispose();
					resetFrame();
				} else if (guessAmount == 1) {
					again = JOptionPane.showInputDialog(null, "You win! Would you like to play again? (y/n)");
					if (again.contains("y")) {
						frame.dispose();
						newGame();
					} else {
						System.exit(0);
					}
				}
			}

		} else {
			if (wrongLetters.contains(keyPressed)) {
				JOptionPane.showMessageDialog(null, "You can't guess a letter twice!");
				life += 1;
			}
			if (!word.contains(keyPressed)) {
				wrongLetters.add(keyPressed);
				life -= 1;
			}
			JOptionPane.showMessageDialog(null, "You have " + life + " live(s) left.");
		}

		if (life == 0) {
			if (guessAmount == 1) {
				System.out.println("The word was " + word);
				JOptionPane.showMessageDialog(null, "GAME OVER!");
				again = JOptionPane.showInputDialog("Would you like to play a new game? (y/n)");
				if (again.contains("y")) {
					frame.dispose();
					newGame();
				} else {
					frame.dispose();
				}
			} else if (guessAmount > 1) {
				System.out.println("The word was " + word);
				String keep = JOptionPane.showInputDialog("Would you like keep playing? (y/n)");
				if (keep.contains("y")) {
					guessAmount -= 1;
					frame.dispose();
					resetFrame();
				} else {
					System.exit(0);
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}

package _03_IntroToStacks;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.StyledEditorKit.ForegroundAction;
import javax.xml.stream.events.Characters;

public class _02_TextUndoRedo implements KeyListener {
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	Stack<String> strings = new Stack<String>();
	Stack<Characters> chars = new Stack<Characters>();

	public _02_TextUndoRedo() {
		frame.add(label);
		frame.setVisible(true);
		frame.addKeyListener(this);
		frame.pack();
	}

	public static void main(String[] args) {
		new _02_TextUndoRedo();
	}
	/*
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			strings.pop();
			label.remove(strings.size() - 1);
		}
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

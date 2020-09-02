package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton n = new JButton();
		JButton o = new JButton();
		JButton m = new JButton();
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		n.setText("For The Night");
		o.setText("Got it on Me");
		m.setText("You Better Move");
		n.addActionListener(this);
		o.addActionListener(this);
		m.addActionListener(this);
		frame.setTitle("IPod Shuffler");
		frame.add(panel);
		panel.add(n);
		panel.add(o);
		panel.add(m);
		frame.setVisible(true);
		frame.pack();	
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
	}
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Song night = new Song("For the Night.mp3");
		Song onMe = new Song("Got it on Me.mp3");
		Song move = new Song("You Better Move.mp3");
		JButton buttonPressed =(JButton) e.getSource();
		if (buttonPressed.equals(n)) {
			night.play();
		
		} else if (buttonPressed.equals(o)) {
			onMe.play();
	
		}else if (buttonPressed.equals(m)) {
			move.play();
		}
	}
}
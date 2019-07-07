package _04_HangMan;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import _02_Integer_Stack.Taco;

public class HangMan implements KeyListener {
	static JFrame f = new JFrame("Hangmam");
	static JLabel l = new JLabel();
	String display ="";
	int life = 10;
	static Stack<String> s = new Stack<String>();
	static String w = "";

	public static void main(String[] args) {

	 String display = "";
		String number = JOptionPane.showInputDialog("how many words do u want in hangman between 1 to 266?");
		int num = Integer.parseInt(number);
		Utilities u = new Utilities();

		for (int i = 0; i < num; i++) {

			String word = (u.readRandomLineFromFile("dictionary.txt"));
			if (s.contains(word)) {
				word = (u.readRandomLineFromFile("dictionary.txt"));
			}

			s.push(word);
		}

		f.setVisible(true);

		f.setPreferredSize(new Dimension(200, 200));

		for (int i = 0; i < w.length(); i++) {
			display = display + "_";
		}

		l.setText(display);

		f.add(l);
		f.pack();

	}

	void addkey() {
		l.addKeyListener(this);
		w = s.pop();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		String guess = JOptionPane.showInputDialog("guess  a letter");

		for (int i = 0; i < w.length(); i++) {
			if (guess.equals(w.charAt(i))) {
				display = display.substring(0, i) + guess + display.substring(i + 1);
				l.setText(display);
			} else {
				life--;
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

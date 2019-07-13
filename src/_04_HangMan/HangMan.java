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
	static JPanel p = new JPanel();
	static String display = "";
	 static int life ;
	static Stack<String> s = new Stack<String>();
	static String w = "";
	static JLabel lifeL = new JLabel();

	public static void main(String[] args) {

		
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
		w = s.pop();
		f.setVisible(true);

		f.setPreferredSize(new Dimension(200, 200));

		for (int i = 0; i < w.length(); i++) {
			display = display + "_";
		}

		l.setText(display);
		HangMan h = new HangMan();
		h.addkey();
		
		//lifeL.setText("no. of lives : "+life);
		p.add(l);
		p.add(lifeL);
		f.add(p);
		f.pack();

		
	}

	void addkey() {
		life=10;
		f.addKeyListener(this);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		char guess = e.getKeyChar();
		// JOptionPane.showInputDialog("guess a letter");

		for (int i = 0; i < w.length(); i++) {
			if (guess == (w.charAt(i))) {
				display = display.substring(0, i) + guess + display.substring(i + 1);
				l.setText(display);
			} else {
				life--;
			}
		}

		if (life == 0) {
			JOptionPane.showMessageDialog(null, "game over");
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (l.getText().equals(w)) {
			life=10;
			JOptionPane.showMessageDialog(null, " great! you solved the word! ");
			if(!s.isEmpty()){
				JOptionPane.showMessageDialog(null, "here's the new word");
			}
			else{
				JOptionPane.showMessageDialog(null, " good job! you are out of words. play the game again ");
				System.exit(0);
			
			}
			w = s.pop();
            display="";
			for (int i = 0; i < w.length(); i++) {
				display = display + "_";
			}

			l.setText(display);			
			
		}
	}

}

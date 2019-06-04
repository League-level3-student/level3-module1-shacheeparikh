package _04_HangMan;

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
	static JLabel label = new JLabel();
	static JLabel lifelabel = new JLabel();
	int life;
	static JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	static Stack<String> s = new Stack<String>();
	static String word = "";
	String w = "";

	public static void main(String[] args) throws IOException {
		// String number = JOptionPane.showInputDialog("how many words u want to
		// guess?");

		
		
		
		
		
		HangMan h = new HangMan();
		h.UI();
	}

	void UI() {
		Utilities u = new Utilities();

		life = 10;
		word = u.readRandomLineFromFile("dictionary.txt");
		System.out.println(word);
		s.push(word);

		frame.setVisible(true);
		frame.add(label);

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o'
					|| word.charAt(i) == 'u') {
				w = w + (word.charAt(i) + "");
			}

			else {
				w = w + ('_' + "");
			}
		}
		label.setText(w);

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int next = 1;
		life--;
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == e.getKeyChar()) {

				w = w.substring(0, i) + word.charAt(i) + w.substring(i + 1);

				System.out.println("hi");
				life++;

			}
			if (w.equals(word)) {
				JOptionPane.showMessageDialog(null, "you solved  the word....");
				next = JOptionPane.showConfirmDialog(null, "do you want a next word?");

				if (next == 0) {

					label.setText("   ");
					w = "";
					Utilities u = new Utilities();

					word = u.readRandomLineFromFile("dictionary.txt");

					System.out.println(word);
					s.push(word);

					for (int j = 0; j < word.length(); j++) {
						if (word.charAt(j) == 'a' || word.charAt(j) == 'e' || word.charAt(j) == 'i'
								|| word.charAt(j) == 'o' || word.charAt(j) == 'u') {
							w = w + (word.charAt(i) + "");
						}

						else {
							w = w + ('_' + "");
						}

					}
					label.setText(w);

				}

				else {

					break;
				}
			}
		}

		if (life == 0) {
			JOptionPane.showMessageDialog(null, "GAME OVER....");
		}

		label.setText(w);
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

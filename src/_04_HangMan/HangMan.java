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
	static JLabel label = new JLabel();
	static JLabel lifelabel = new JLabel();
	int life;
	static JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	static Stack<String> s = new Stack<String>();
	static String word = "";
	String w = "";

	public static void main(String[] args) throws IOException {

		String number = JOptionPane.showInputDialog("how many words u want to guess?");
		int n = Integer.parseInt(number);
		HangMan h = new HangMan();
		Utilities u = new Utilities();

		for (int i = 0; i < n; i++) {
			word = u.readRandomLineFromFile("dictionary.txt");
			s.push(word);
		}

		h.UI();
		frame.setVisible(true);
		frame.add(label);
		frame.setPreferredSize(new Dimension(500, 500));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	void UI() {
		Utilities u = new Utilities();

		frame.addKeyListener(this);

		life = 10;
		if (!s.isEmpty()) {
			word = s.pop();
			System.out.println(word);

			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o'
						|| word.charAt(i) == 'u') {
					w = w + (word.charAt(i) + "");
				} else {
					w = w + ('_' + "");
				}
			}
			label.setText(w);
		}
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
			} else {
				System.out.println("wrong try");
			}
			if (w.equals(word)) {
				JOptionPane.showMessageDialog(null, "you solved  the word....");
				next = JOptionPane.showConfirmDialog(null, "do you want a next word?");
				if (next == 0) {
					HangMan h = new HangMan();
					h.UI();
					// label.setText(w);
				} else {
					System.exit(0);

				}
			}
		}
		if (life == 0) {
			JOptionPane.showMessageDialog(null, "GAME OVER....");
			JOptionPane.showMessageDialog(null, "the word was " + word);
			// ask if they want to play again? give other word.
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

package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should
	 * look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last
	 * character is erased from the JLabel. Save that deleted character onto a
	 * Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is
	 * pressed, the top Character is popped off the Stack and added back to the
	 * JLabel.
	 * 
	 */
	String editor = "";
	Stack<Character> charStack = new Stack<Character>();

	public static void main(String[] args) {
		_02_TextUndoRedo t = new _02_TextUndoRedo();
		t.createUI();

	}

	static JLabel label = new JLabel();

	void createUI() {

		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		// panel.setVisible(true);
		label.setVisible(true);
		panel.add(label);
		frame.add(panel);
		frame.addKeyListener(this);
		frame.pack();
		JOptionPane.showMessageDialog(null, "z is the undo key");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("typed");

		// z is the undo key.
		if (e.getExtendedKeyCode() == 90 && !charStack.isEmpty())  {
			System.out.println("z typed");
			
			editor = editor+charStack.pop();
			label.setText(editor);
		}

		else if (e.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {

			charStack.push(editor.charAt(editor.length() - 1));

			editor = editor.substring(0, editor.length() - 1);

			label.setText(editor);

		}

		else {
			label.setText(editor + e.getKeyChar());
			editor = label.getText();

		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		// System.out.println("pressed");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

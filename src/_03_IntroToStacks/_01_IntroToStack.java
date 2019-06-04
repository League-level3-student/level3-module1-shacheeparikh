package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {

	public static void main(String[] args) {
		// 1. Create a Stack of Doubles
		// Don't forget to import the Stack class
		Stack<Double> doublStack = new Stack<Double>();
		// 2. Use a loop to push 100 random doubles between 0 and 100 to the
		// Stack.
		Random randy = new Random();

		for (int i = 0; i <= 100; i++) {
			Double r = randy.nextDouble() * 100;
			System.out.println(r);
			doublStack.push(r);
		}

		// 3. Ask the user to enter in two numbers between 0 and 100, inclusive.
		String number1 = JOptionPane.showInputDialog("enter a  number between 0 and 100, inclusive.");
		Double d1 = Double.parseDouble(number1);
		String number2 = JOptionPane.showInputDialog("enter a number between 0 and 100, inclusive.");
		Double d2 = Double.parseDouble(number2);

		System.out.println("poping elements between "+ number1+" and "+ number2);

		for (int i = 0; i < doublStack.size(); i++) {
			Double dpop = doublStack.pop();
			if (dpop > d1 && dpop < d2) {
				System.out.println(dpop);
			}
		}
		// 4. Pop all the elements off of the Stack. Every time a double is
		// popped that is
		// between the two numbers entered by the user, print it to the screen.

		// EXAMPLE:
		// NUM 1: 65
		// NUM 2: 75

		// Popping elements off stack...
		// Elements between 65 and 75:
		// 66.66876846
		// 74.51651681
		// 70.05110654
		// 69.21350456
		// 71.54506465
		// 66.47984807
		// 74.12121224
	}
}

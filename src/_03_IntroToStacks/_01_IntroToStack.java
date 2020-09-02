package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

import org.junit.experimental.theories.FromDataPoints;

public class _01_IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		Stack<Double> doubles = new Stack<Double>();
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		Random r = new Random();
		for (int i = 0; i < 101; i++) {
			doubles.push(r.nextDouble() * 100);
		}
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		String int1 = JOptionPane.showInputDialog("Enter a number 0 - 100");
		String int2 = JOptionPane.showInputDialog("Enter a number 0 - 100");
		int i1 = Integer.parseInt(int1);
		int i2 = Integer.parseInt(int2);
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		int high = 0;
		int low = 0;
		if (i1 > i2) {
			high = i1;
			low = i2;
		} else if (i2> i1) {
			low = i1;
			high = i2;		
		}
		System.out.println("These are the numbers between " + low +" and "+ high);
		while (!doubles.isEmpty()) {
			double num = doubles.pop();
			if (num>=low && num<=high) {
				
				System.out.println(num);
			}
		}
		
		
		//  EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}

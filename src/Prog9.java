/**
 * COSC 210 Assignment 9
 * Prog9.java
 * 
 * This program is a GUI for Pizzazz Pizza
 * 
 * @author Nathaniel Churchill
 *
 */
import java.awt.*;
import javax.swing.*;
public class Prog9 {

	public static void main(String[] args) {
		//creating the window
		PizzaGUI window = new PizzaGUI();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500,300);
		window.setVisible(true);
	}

}

/* Rifaat Kouaider
 * California State University, Northridge
 * 08/29/2019
 * ECE 320: Introduction to Logic Design
 * Individual Project
 * ALL RIGHTS RESERVED ©
 */

import java.util.Scanner;

public class LogicGates{

	/*NAND Gate: Only when both inputs are 1, the function returns 0*/
	public static int logic_NAND(int a, int b) {
		if (a == 1 && b == 1) {
			return 0;
		}
		else return 1;
	}

	/*Return the inverse of the input*/
	public static int inverter(int in) {
		if (in == 0) {
			return 1;
		}
		else return 0;
	}

	/*Main Start*/
	public static void main (String [] args){

		//Prompt user for input
		System.out.println("Enter the value of the binary digits 'wxyz' with NO spaces:");

		Scanner keyboard = new Scanner(System.in);

		//Input saved as a whole string
		String input = keyboard.nextLine();

		//Split input between digits
		String[] numbersStr = input.split("");

		//Create an array to save input as ints
		int [] numbers = new int [numbersStr.length];

		//Transform string to int and save in int array
		for (int i = 0; i < numbersStr.length; i++) {
			numbers[i] = Integer.parseInt(numbersStr[i]);
		}

		//NOTE: we know  that we have only 4 variables,
		//hence the array is an array of 4 in 'wxyz' order

		int gate1 = logic_NAND(inverter(numbers[2]),numbers[3]); //inv_y and z
		int gate2 = logic_NAND(numbers[0], numbers[0]) ;
		int gate3 = logic_NAND(numbers[1], numbers[1]);
		int gate4 = logic_NAND(gate2, gate3);
		int gate5 = logic_NAND(gate4, numbers[2]);

		System.out.println("-->  F = " + logic_NAND(gate1, gate5));
	}
}
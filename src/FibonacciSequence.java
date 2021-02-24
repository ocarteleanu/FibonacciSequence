/**
 * FibonacciSequence program compares the runtime efficiency of constructing 
 * Fibonacci sequences with iteration vs recursion methods. 
 * The program allows the user to enter an integer representing how long the sequence
 * generated will be. The program starts with the first two elements of the sequence. 
 * All the elements in the sequence are represented by long type variables so that 
 * the user can enter bigger numbers to create the sequence
 * The output of the program consists of displaying the last element of the sequence 
 * generated in both ways so that it can be verified that the sequences are the same 
 * and also displaying the runtime in nanoseconds for both methods
 * 
 * @author octavian
 * @version 1.0.0
 * @since 02/23/2021
 *
 */
import java.util.Scanner;

/**
 * FibonacciSequence class contains the variables and methods necessary 
 * to build Fibonacci sequences based on the user's input
 * The class offers the first two elements of the sequence to be generated, elementOne (0) and elementTwo(1). The 
 * type of the elements in the sequence is long to allow higher numbers to be entered by the user. The lastElement 
 * is the variable that will represent the last element of each generated sequence. The recursiveWayControl variable will
 * be used as a parameter in the recursive method. 	 
 */
public class FibonacciSequence {

	private static long elementOne = 0L;
	private static long elementTwo = 1L;
	private static long lastElement; 
	private static int recursiveWayControl = 0; 
	
	/**
	 * The iterativeWay method is used to create a Fibonacci sequence in an iterative fashion 
	 * by using a for loop, which will run until the number of iterations entered by the user is reached.
	 * This method print the value of the last element in the sequence created. 
	 * @param sequenceLength int type which controls how long the sequence will be
	 * @return the runtime in nanoseconds that is needed to create the sequence 
	 */
	
	public static long iterativeWay (int sequenceLength){
		long startIt = System.nanoTime();
		for (int i= 0; i <= sequenceLength ; i ++){
			lastElement = elementOne + elementTwo; 
			elementOne = elementTwo;
			elementTwo = lastElement;
		}
		long endIt = System.nanoTime();	
		System.out.println("The last element of the sequence is: " + lastElement);
		return (endIt - startIt);
	}

	/**
	 * The recursiveWay method calls the recursiveWayKernel method that uses the recursive fashion 
	 * to create a Fibonacci sequence based on the user input
	 * @param sequenceLength int type which controls how long the sequence will be
	 * @return the runtime in nanoseconds that is needed to create the sequence 
	 */
	public static long recursiveWay (int sequenceLength){
		long startIt = System.nanoTime();	
		recursiveWayKernel(recursiveWayControl, sequenceLength);
		long endIt = System.nanoTime();
		return (endIt - startIt);
	}
	
	/**
	 * The recursiveWayKernel is used to create a Fibonacci sequence in a recursive fashion
	 * It uses the user input and a variable that controls the number of recurrent executions
	 * It prints the last value of the generated sequence 
	 * @param recursiveVariable integer that will allow the execution of the method 
	 * until it reaches the user input value
	 * @param maxValueForRecursiveVariable integer that represents the user's input
	 */
	
	public static void recursiveWayKernel (int recursiveVariable, int maxValueForRecursiveVariable){
		lastElement = elementOne + elementTwo;
		elementOne = elementTwo;
		elementTwo = lastElement;
		if(recursiveVariable < maxValueForRecursiveVariable){
			recursiveWayKernel((recursiveVariable + 1), maxValueForRecursiveVariable);
		}
		else {
			System.out.println("The last element of the sequence is: " + lastElement);
		}
	}
	/**
	 * The main method allows the user to enter their integer value to create a
	 * Fibonacci sequence, and calls both the iterativeWay and recursiveWay methods that are used 
	 * to compare the runtime efficiency when creating the sequence
	 * @param args array of String type passed to the main method
	 * @throws InputMismatchException when the user doesn't input an integer
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int userChoice = 0;
		while (true){
		try{
			//the user is prompted to enter an integer that will dictate the length of the sequence
			Scanner thisScanner = new Scanner(System.in);
			System.out.println("Please enter an integer to create a Fibonacci sequence "
					+ "(The length of the sequence will be your number + 3): ");
			userChoice = thisScanner.nextInt();
		}
		catch(Exception e){
			//if the input is not an integer, the user gets an error message
			System.out.println("The number you entered is not an integer");
			continue;
		}
		System.out.println("The iterative fashion's runtime is: " 
		+ iterativeWay(userChoice) + " nanoseconds");
		//the elemetOne and elementTwo are reset to the initial values
		elementOne = 0L;
		elementTwo = 1L;
		System.out.println("The recursive fashion's runtime is: " + 
		recursiveWay(userChoice) + " nanoseconds");
		//the elemetOne and elementTwo are reset to the initial values
		elementOne = 0L;
		elementTwo = 1L;
	}
	}

}

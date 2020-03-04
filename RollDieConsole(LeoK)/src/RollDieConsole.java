/*
 * Created by: Leo Kay
 * Created on: 28-02-2020
 * Created for: ICS3U Programming
 * Daily Assignment – Day 9 - Roll Die Console
 * This program allows the user to choose a max value for a random number that is created
*/

import java.util.Scanner;
import java.util.Random;
public class RollDieConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variables
		int randomNum;
		int max;
		int min = 1;
		
		//add the keyboard scanner
		 Scanner keyboard = new Scanner(System.in);
		 System.out.println("Please enter the max value for a random number.");
		 
		 max = keyboard.nextInt();
		
		 //get the random number
		 randomNum = new Random().nextInt(((max-min) + 1) + min);	
		 
		 //print the random number
		 System.out.println("The random number is " + randomNum);
	}

}

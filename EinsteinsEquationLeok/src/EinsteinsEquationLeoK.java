/*
 * Created by: Leo Kay
 * Created on: 28-02-2020
 * Created for: ICS3U Programming
 * Daily Assignment – Day 5 - Einstein's Equation
 * This program is an e=mc^2 calculator, the user inputs the mass and it calculates the energy
*/

import java.util.Scanner;
public class EinsteinsEquationLeoK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Variables
		double mass;
		final double SPEED_OF_LIGHT = 2.998*Math.pow(10, 8);
		double energy;
		
		//get the mass
		Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter the mass of the object.");
        
        mass = keyboard.nextDouble();
        
        //Calculate the energy in J
        energy = mass*Math.pow(SPEED_OF_LIGHT, 2);
        
        //display the answer
        System.out.printf("The total energy the object could release is %6.3e J", energy);
	}

}

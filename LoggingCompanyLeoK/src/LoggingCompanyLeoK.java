import java.util.Scanner;
public class LoggingCompanyLeoK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Variables
	    final double LOG_MASS = 20;
	    final double MAX_MASS = 1100;
	    double log_length = 0;
	    double log_mass_after;
	    double number_of_logs;
	    
	    int choice;
        int one_meter = 1;
        int half_meter = 2;
        int quarter_meter = 3;
	    
	    //Get the log length
	    Scanner keyboard = new Scanner(System.in);
        System.out.println("What length of log would you like?");
        System.out.println("1: 1 meter");
        System.out.println("2: 0.5 meters");
        System.out.println("3: 0.25 meters");

        choice = keyboard.nextInt();

        if (choice == 1) {
            log_length = 1;
        } else if (choice == 2) {
            log_length = 0.5;
        } else if (choice == 3) {
            log_length = 0.25;
        } else if (choice > 3 || choice < 1) {
            System.out.println("Please select a proper number.");
            choice = -1;
        }
        
        //Calculate the number of logs that can go on the truck
        log_length = 1/log_length;
        log_mass_after = LOG_MASS/log_length;
        number_of_logs = MAX_MASS/log_mass_after;
        
        //display the answer
        if (choice == 1) {
        	System.out.println("The number of logs that can fit in the truck are " + number_of_logs + ".");
        } else if (choice == 2) {
        	System.out.println("The number of logs that can fit in the truck are " + number_of_logs + ".");
        } else if (choice == 3) {
        	System.out.println("The number of logs that can fit in the truck are " + number_of_logs + ".");
        } else if (choice > 3 || choice < 1) {
            System.out.println("Restart the program.");
            choice = -1;
        }
        }
        
	}

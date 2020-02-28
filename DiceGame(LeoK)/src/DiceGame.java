/*
 * Created by: Leo Kay
 * Created on: 28-02-2020
 * Created for: ICS3U Programming
 * Daily Assignment – Day 8 - Dice Game
 * This program allows the user to guess a number between 1 and 6 and tells them if they got it right or wrong
*/

import java.util.Random;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DiceGame {
	
	//variables
	int diceNum;
	int guess;
	int wrongGuesses;
	int max = 6;
	int min = 1;

	protected Shell shlDiceGameLeo;
	private Text txt_guess;
	
	public DiceGame() {
		diceNum = new Random().nextInt(((max-min) + 1) + min);
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DiceGame window = new DiceGame();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlDiceGameLeo.open();
		shlDiceGameLeo.layout();
		while (!shlDiceGameLeo.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlDiceGameLeo = new Shell();
		shlDiceGameLeo.setSize(450, 300);
		shlDiceGameLeo.setText("Dice Game by Leo Kay");
		
		Label lbl_request = new Label(shlDiceGameLeo, SWT.NONE);
		Label lbl_wrongGuesses = new Label(shlDiceGameLeo, SWT.NONE);
		Label lbl_answer = new Label(shlDiceGameLeo, SWT.NONE);
		
		lbl_request.setBounds(10, 10, 414, 15);
		lbl_request.setText("Guess a number between 1 and 6:");
		
		txt_guess = new Text(shlDiceGameLeo, SWT.BORDER);
		txt_guess.setBounds(175, 58, 76, 21);
		
		Button btn_guess = new Button(shlDiceGameLeo, SWT.NONE);
		btn_guess.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//get the number from the user
				try {
					guess = Integer.parseInt(txt_guess.getText());
				}
				catch (Exception exc) {
					MessageDialog.openError(shlDiceGameLeo, "Error", "Please enter a number bewteen 1 and 6");
					return;
				}
				//check to see if the guess is greater or less than the random number
				if (guess <= 0 || guess >= 7) {
					MessageDialog.openError(shlDiceGameLeo, "Error", "Bad number, please enter a number between 1 and 6");
					return;
				}
				//display the answer if they're right, add 1 to the amount wrong if they're wrong
				if (guess == diceNum) {
					lbl_answer.setText("The random number is: " + diceNum);
				}
				else {
					wrongGuesses = wrongGuesses + 1;
					lbl_wrongGuesses.setText("The number of wrong guesses are: " + wrongGuesses);
				}
			}
		});
		btn_guess.setBounds(176, 117, 75, 25);
		btn_guess.setText("Guess!");
		
		lbl_wrongGuesses.setBounds(10, 183, 414, 15);
		lbl_wrongGuesses.setText("The number of wrong guesses are:");
		
		lbl_answer.setBounds(10, 216, 414, 15);

	}
}

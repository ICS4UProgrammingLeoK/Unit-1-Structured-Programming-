/*
 * Created by: Leo Kay
 * Created on: 28-02-2020
 * Created for: ICS3U Programming
 * Daily Assignment – Day 10 - Rock, Paper, Scissors
 * This program is a rock paper scissors program that lets the user play against the computer
*/

import java.util.Random;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class RockPaperScissors {
	
	//variables
	int userChoice;
	int computerChoice;
	int min = 1;
	int max = 3;
	int userScore = 0;
	int computerScore = 0;

	protected Shell shlRockPaperScissors;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RockPaperScissors window = new RockPaperScissors();
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
		shlRockPaperScissors.open();
		shlRockPaperScissors.layout();
		while (!shlRockPaperScissors.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlRockPaperScissors = new Shell();
		shlRockPaperScissors.setSize(450, 300);
		shlRockPaperScissors.setText("Rock Paper Scissors by Leo Kay");
		
		Label lbl_playersChoice = new Label(shlRockPaperScissors, SWT.NONE);
		lbl_playersChoice.setBounds(10, 10, 414, 15);
		lbl_playersChoice.setText("Player's Choice:");
		
		Button rad_rock = new Button(shlRockPaperScissors, SWT.RADIO);
		Button rad_paper = new Button(shlRockPaperScissors, SWT.RADIO);
		Button rad_scissors = new Button(shlRockPaperScissors, SWT.RADIO);
		Button rad_computerRock = new Button(shlRockPaperScissors, SWT.RADIO);
		Button rad_computerPaper = new Button(shlRockPaperScissors, SWT.RADIO);
		Button rad_computerScissors = new Button(shlRockPaperScissors, SWT.RADIO);
		Label lbl_result = new Label(shlRockPaperScissors, SWT.NONE);
		Label lbl_playersScore = new Label(shlRockPaperScissors, SWT.NONE);
		Label lbl_computersScore = new Label(shlRockPaperScissors, SWT.NONE);
		Button btn_playAgain = new Button(shlRockPaperScissors, SWT.NONE);
		Button btn_play = new Button(shlRockPaperScissors, SWT.NONE);
		
		//disable the computer's buttons
		rad_computerRock.setEnabled(false);
		rad_computerPaper.setEnabled(false);
		rad_computerScissors.setEnabled(false);
		btn_playAgain.setEnabled(false);
		
		rad_rock.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			    //set the userchoice to 1
				userChoice = 1;
			}
		});
		rad_rock.setBounds(10, 53, 90, 16);
		rad_rock.setText("Rock");
		
		rad_paper.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Set the userchoice to 2
				userChoice = 2;
			}
		});
		rad_paper.setBounds(169, 53, 90, 16);
		rad_paper.setText("Paper");
		
		rad_scissors.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Set the userchoice to 3
				userChoice = 3;
			}
		});
		rad_scissors.setBounds(334, 53, 90, 16);
		rad_scissors.setText("Scissors");
		
		Label lblComputersChoice = new Label(shlRockPaperScissors, SWT.NONE);
		lblComputersChoice.setText("Computer's Choice:");
		lblComputersChoice.setBounds(10, 98, 414, 15);
		
		rad_computerRock.setText("Rock");
		rad_computerRock.setBounds(10, 134, 90, 16);
		
		rad_computerPaper.setText("Paper");
		rad_computerPaper.setBounds(169, 134, 90, 16);
		
		rad_computerScissors.setText("Scissors");
		rad_computerScissors.setBounds(334, 134, 90, 16);
		
		lbl_playersScore.setBounds(10, 208, 175, 15);
		lbl_playersScore.setText("Player's Score: ");
		
		lbl_computersScore.setText("Computer's Score: ");
		lbl_computersScore.setBounds(10, 236, 175, 15);
		
		btn_playAgain.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//reset everything except the scores
				rad_computerRock.setSelection(false);
				rad_computerPaper.setSelection(false);
				rad_computerScissors.setSelection(false);
				
				rad_rock.setEnabled(true);
				rad_paper.setEnabled(true);
				rad_scissors.setEnabled(true);
				
				btn_play.setEnabled(true);
				
				btn_playAgain.setEnabled(false);
			}
		});
		btn_playAgain.setBounds(311, 196, 102, 38);
		btn_playAgain.setText("Play Again");
		
		lbl_result.setBounds(10, 172, 249, 15);
		
		btn_play.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//new random number
				computerChoice = new Random().nextInt((max-min) + 1) + min;
				
				//display the computer's choice
				if (computerChoice == 1) {
					rad_computerRock.setSelection(true);
				}
				else if(computerChoice == 2) {
					rad_computerPaper.setSelection(true);
				}
				else if (computerChoice == 3) {
					rad_computerScissors.setSelection(true);
				}
				
				//disable the radio buttons
				rad_rock.setEnabled(false);
				rad_paper.setEnabled(false);
				rad_scissors.setEnabled(false);
				
				//Check who the winner is
				if (userChoice == computerChoice) {
					lbl_result.setText("Tie!");
				}
				else if (userChoice == 1 && computerChoice == 2) {
					lbl_result.setText("Computer Wins!");
					computerScore ++;
					lbl_computersScore.setText("Computer's Score: " + computerScore);
				}
				else if (userChoice == 2 && computerChoice == 3) {
					lbl_result.setText("Computer Wins!");
					computerScore ++;
					lbl_computersScore.setText("Computer's Score: " + computerScore);
				}
				else if (userChoice == 3 && computerChoice == 1) {
					lbl_result.setText("Computer Wins!");
					computerScore ++;
					lbl_computersScore.setText("Computer's Score: " + computerScore);
				}
				else if (userChoice == 2 && computerChoice == 1) {
					lbl_result.setText("You Win!");
					userScore ++;
					lbl_playersScore.setText("User's Score: " + userScore);
				}		
				else if (userChoice == 3 && computerChoice == 2) {
					lbl_result.setText("You Win!");
					userScore ++;
					lbl_playersScore.setText("User's Score: " + userScore);
				}
				else if (userChoice == 1 && computerChoice == 3) {
					lbl_result.setText("You Win!");
					userScore ++;
					lbl_playersScore.setText("User's Score: " + userScore);
				}
				
				//disable the play button
				btn_play.setEnabled(false);
				btn_playAgain.setEnabled(true);
			}
		});
		btn_play.setBounds(191, 198, 102, 36);
		btn_play.setText("Play");

	}
}

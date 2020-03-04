/*
 * Created by: Leo Kay
 * Created on: 28-02-2020
 * Created for: ICS3U Programming
 * Daily Assignment – Day 11 - Board Foot
 * This program calculates the third dimension in a board foot
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class BoardFootLeoK {

	protected Shell shlBoardFoot;
	private Text txt_firstInt;
	private Text txt_secondInt;
	int firstInt;
	int secondInt;
	int thirdInt;
	final int boardFoot = 144;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BoardFootLeoK window = new BoardFootLeoK();
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
		shlBoardFoot.open();
		shlBoardFoot.layout();
		while (!shlBoardFoot.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	//this function calculates and returns the third dimension of the board foot
	private int CalculateBoardFoot(int firstNumTemp, int secondNumTemp) {
		//variables
		int thirdNumTemp;
		
		//calculate the third dimension
		thirdNumTemp = (boardFoot / firstNumTemp) / secondNumTemp;
		
		//return the third dimension
		return thirdNumTemp;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlBoardFoot = new Shell();
		shlBoardFoot.setSize(450, 300);
		shlBoardFoot.setText("Board Foot by Leo Kay");
		
		Label lblEnterTheFirst = new Label(shlBoardFoot, SWT.NONE);
		Label lblEnterTheSecond = new Label(shlBoardFoot, SWT.NONE);
		Button btn_calculate = new Button(shlBoardFoot, SWT.NONE);
		Label lbl_answer = new Label(shlBoardFoot, SWT.NONE);
		
		lblEnterTheFirst.setBounds(10, 26, 142, 15);
		lblEnterTheFirst.setText("Enter the first dimension:");
		
		lblEnterTheSecond.setText("Enter the second dimension:");
		lblEnterTheSecond.setBounds(196, 26, 159, 15);
		
		txt_firstInt = new Text(shlBoardFoot, SWT.BORDER);
		txt_firstInt.setBounds(10, 62, 76, 21);
		
		txt_secondInt = new Text(shlBoardFoot, SWT.BORDER);
		txt_secondInt.setBounds(196, 62, 76, 21);
		
		btn_calculate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//try catch the first and second dimensions
				try {
					firstInt = Integer.parseInt(txt_firstInt.getText());
				}
				catch (Exception exc){
					MessageDialog.openError(shlBoardFoot, "Error", "Please enter a number.");
					return;
				}
				
				try {
					secondInt = Integer.parseInt(txt_secondInt.getText());
				}
				catch (Exception exc){
					MessageDialog.openError(shlBoardFoot, "Error", "Please enter a number.");
					return;
				}
				
				//call the function that calculates the third dimension
				thirdInt = CalculateBoardFoot(firstInt, secondInt);
				
				//display the answer
				lbl_answer.setText("The third dimension is about: " + thirdInt + " inches.");
			}
		});
		btn_calculate.setBounds(171, 136, 75, 25);
		btn_calculate.setText("Calculate");
		
		lbl_answer.setBounds(10, 204, 414, 15);
		lbl_answer.setText("The third dimension is about:");

	}
}

  /*
 * Created by: Leo Kay
 * Created on: 04-03-2020
 * Created for: ICS3U Programming
 * Daily Assignment – Day 13 - Multi-Dimensional Array
 * This program creates random marks for each student within an array, and displays the average
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import java.util.Arrays;
import java.util.Random;

public class MultiDimensionalArrayLeoK {

	protected Shell shlMultidimensionalArrayBy;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MultiDimensionalArrayLeoK window = new MultiDimensionalArrayLeoK();
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
		shlMultidimensionalArrayBy.open();
		shlMultidimensionalArrayBy.layout();
		while (!shlMultidimensionalArrayBy.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	private int GetAverage(int marksCopy[][]) {
		//variables
		int classAve;
		int totalMarks = 0;
		
		//loop through the array and add all the marks
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 6; y++) {
				totalMarks = totalMarks + marksCopy[x][y];
			}
		}
		
		//calculate the class average 
		classAve = totalMarks / 24;
		
		//return the average
		return classAve;
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMultidimensionalArrayBy = new Shell();
		shlMultidimensionalArrayBy.setSize(450, 300);
		shlMultidimensionalArrayBy.setText("Multi-Dimensional Array by Leo Kay");
		
		Label lblClickTheButton = new Label(shlMultidimensionalArrayBy, SWT.NONE);
		Label lblTheClassAverage = new Label(shlMultidimensionalArrayBy, SWT.NONE);
		
		lblClickTheButton.setBounds(10, 36, 414, 15);
		lblClickTheButton.setText("Click the button to generate random marks:");
		
		Button btnGenerate = new Button(shlMultidimensionalArrayBy, SWT.NONE);
		btnGenerate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//create a multi dimensional array
				int marks[][] = new int[4][6];
				
				//variables
				int average;
				
				//loop through the array and create random numbers
				for (int x = 0; x < 4; x++) {
					for (int y = 0; y < 6; y++) {
						marks[x][y] = new Random().nextInt(((100-0) + 1) + 0);
					}
				}
				
				//Get the average
				average = GetAverage(marks);
				
				//display the average
				lblTheClassAverage.setText("The class' average is: " + average);
			}
		});
		btnGenerate.setBounds(172, 97, 98, 45);
		btnGenerate.setText("Generate");
		
		lblTheClassAverage.setBounds(10, 187, 414, 15);
		lblTheClassAverage.setText("The class' average is:");

	}
}

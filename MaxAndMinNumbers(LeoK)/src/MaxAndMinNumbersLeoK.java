import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import java.util.Arrays;
import java.util.Random;

public class MaxAndMinNumbersLeoK {

	//variables
	protected Shell shlMaxAndMin;
	private Text txt_numbers;
	
	int maxRandom = 99;
	int minRandom = 1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MaxAndMinNumbersLeoK window = new MaxAndMinNumbersLeoK();
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
		shlMaxAndMin.open();
		shlMaxAndMin.layout();
		while (!shlMaxAndMin.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	//this function returns the max num
	private int maxNumFinder(int[] randomNumbersCopy) {
		//variables
		int maxNumTemp;
		int maxNum = randomNumbersCopy[0];
		
		//loop through and find the biggest number
		for (int i = 1; i < randomNumbersCopy.length; i++) {
			//set maxNumTemp to the next place in the array
			maxNumTemp = randomNumbersCopy[i];
			
			//check to see if the temporary max num is greater than the actual max num
			if (maxNumTemp > maxNum) {
				maxNum = maxNumTemp;
			}
		}
		
		//return the max num
		return maxNum;
	}
	
	//this function returns the min num
	private int minNumFinder(int[] randomNumbersCopy) {
		//variables
		int minNumTemp;
		int minNum = randomNumbersCopy[0];
		
		//loop through and find the smallest number
		for (int i = 1; i < randomNumbersCopy.length; i++) {
			//set minNumTemp to the next place in the array
			minNumTemp = randomNumbersCopy[i];
			
			//check to see if the temporary min num is greater than the actual min num
			if (minNumTemp < minNum) {
				minNum = minNumTemp;
			}
		}
		
		//return the min num
		return minNum;
	}
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMaxAndMin = new Shell();
		shlMaxAndMin.setSize(450, 300);
		shlMaxAndMin.setText("Max and Min Numbers by Leo Kay");
		
		Button btnGenerateRandomNumbers = new Button(shlMaxAndMin, SWT.NONE);
		Label lbl_minNum = new Label(shlMaxAndMin, SWT.NONE);
		Label lbl_maxNum = new Label(shlMaxAndMin, SWT.NONE);
		
		btnGenerateRandomNumbers.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Generate 10 random numbers between 1 and 99 and display them
				//variables
				int random;
				int[] randomNumbers = new int[10];
				int maxNum;
				int minNum;
				
				for (int i = 0; i < 10; i++) {
					random = new Random().nextInt(((maxRandom-minRandom) + 1) + minRandom);
					randomNumbers[i] = random; 
					txt_numbers.setText(Arrays.toString(randomNumbers));
				}
				
				//call maxNum and minNum to get the max and min numbers
				maxNum = maxNumFinder(randomNumbers);
				minNum = minNumFinder(randomNumbers);
				
				//display the answer
				lbl_minNum.setText("Min Num: " + minNum);
				lbl_maxNum.setText("Max Num: " + maxNum);
			}
		});
		btnGenerateRandomNumbers.setBounds(10, 10, 160, 61);
		btnGenerateRandomNumbers.setText("Generate Random Numbers");
		
		lbl_minNum.setBounds(10, 121, 160, 15);
		lbl_minNum.setText("Min Num:");
		
		lbl_maxNum.setBounds(10, 190, 160, 15);
		lbl_maxNum.setText("Max Num:");
		
		txt_numbers = new Text(shlMaxAndMin, SWT.BORDER);
		txt_numbers.setEnabled(false);
		txt_numbers.setEditable(false);
		txt_numbers.setBounds(211, 10, 213, 241);

	}
}

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class SimpCalc {

	protected Shell shlSimpleCalculator;
	private Text txt_firstNum;
	private Text txt_secondNum;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SimpCalc window = new SimpCalc();
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
		shlSimpleCalculator.open();
		shlSimpleCalculator.layout();
		while (!shlSimpleCalculator.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlSimpleCalculator = new Shell();
		shlSimpleCalculator.setSize(450, 300);
		shlSimpleCalculator.setText("Simple Calculator");
		
		txt_firstNum = new Text(shlSimpleCalculator, SWT.BORDER);
		txt_firstNum.setBounds(50, 69, 120, 21);
		
		txt_secondNum = new Text(shlSimpleCalculator, SWT.BORDER);
		txt_secondNum.setBounds(259, 69, 120, 21);
		
		Label lblFirstNumber = new Label(shlSimpleCalculator, SWT.NONE);
		lblFirstNumber.setBounds(50, 48, 120, 15);
		lblFirstNumber.setText("First Number:");
		
		Label lblSecondNumber = new Label(shlSimpleCalculator, SWT.NONE);
		lblSecondNumber.setText("Second Number:");
		lblSecondNumber.setBounds(259, 48, 120, 15);
		
		Label lbl_answer = new Label(shlSimpleCalculator, SWT.NONE);
		lbl_answer.setBounds(50, 224, 329, 15);
		
		Button btn_add = new Button(shlSimpleCalculator, SWT.NONE);
		
		btn_add.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//variables
				int number1, number2;
				
				//error checking
				try {
					number1 = Integer.parseInt(txt_firstNum.getText());
				}
				catch (Exception exc) {
					MessageDialog.openError(shlSimpleCalculator, "Error", "Bad first number. Please enter a new one");
					return;
				}
				try {
					number2 = Integer.parseInt(txt_secondNum.getText());
				}
				catch (Exception exc) {
					MessageDialog.openError(shlSimpleCalculator, "Error", "Bad second number. Please enter a new one");
					return;
				}
				
				//answer
				int answer = number1 + number2;
				lbl_answer.setText("The answer is " + answer);
			}
		});
		
		btn_add.setBounds(37, 145, 75, 25);
		btn_add.setText("+");
		
		Button btn_sub = new Button(shlSimpleCalculator, SWT.NONE);
		btn_sub.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//variables
				int number1, number2;
				
				//error checking
				try {
					number1 = Integer.parseInt(txt_firstNum.getText());
				}
				catch (Exception exc) {
					MessageDialog.openError(shlSimpleCalculator, "Error", "Bad first number. Please enter a new one");
					return;
				}
				try {
					number2 = Integer.parseInt(txt_secondNum.getText());
				}
				catch (Exception exc) {
					MessageDialog.openError(shlSimpleCalculator, "Error", "Bad second number. Please enter a new one");
					return;
				}
				
				//answer
				int answer = number1 - number2;
				lbl_answer.setText("The answer is " + answer);
			}
		});
		btn_sub.setText("-");
		btn_sub.setBounds(132, 145, 75, 25);
		
		Button btn_multiply = new Button(shlSimpleCalculator, SWT.NONE);
		btn_multiply.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//variables
				int number1, number2;
				
				//error checking
				try {
					number1 = Integer.parseInt(txt_firstNum.getText());
				}
				catch (Exception exc) {
					MessageDialog.openError(shlSimpleCalculator, "Error", "Bad first number. Please enter a new one");
					return;
				}
				try {
					number2 = Integer.parseInt(txt_secondNum.getText());
				}
				catch (Exception exc) {
					MessageDialog.openError(shlSimpleCalculator, "Error", "Bad second number. Please enter a new one");
					return;
				}
				
				//answer
				int answer = number1 * number2;
				lbl_answer.setText("The answer is " + answer);
			}
		});
		btn_multiply.setText("x");
		btn_multiply.setBounds(224, 145, 75, 25);
		
		Button btn_divide = new Button(shlSimpleCalculator, SWT.NONE);
		btn_divide.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//variables
				int number1, number2;
				
				//error checking
				try {
					number1 = Integer.parseInt(txt_firstNum.getText());
				}
				catch (Exception exc) {
					MessageDialog.openError(shlSimpleCalculator, "Error", "Bad first number. Please enter a new one");
					return;
				}
				try {
					number2 = Integer.parseInt(txt_secondNum.getText());
				}
				catch (Exception exc) {
					MessageDialog.openError(shlSimpleCalculator, "Error", "Bad second number. Please enter a new one");
					return;
				}
				
				//answer
				int answer = number1 / number2;
				lbl_answer.setText("The answer is " + answer);
			}
		});
		btn_divide.setText("/");
		btn_divide.setBounds(317, 145, 75, 25);
		
	}
}

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class LoggingCompanyGUI {
	
	//Variables
    final double LOG_MASS = 20;
    final double MAX_MASS = 1100;
    double log_length = 0;
    double log_mass_after;
    double number_of_logs;

	protected Shell shlLoggingCompanyLeo;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoggingCompanyGUI window = new LoggingCompanyGUI();
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
		shlLoggingCompanyLeo.open();
		shlLoggingCompanyLeo.layout();
		while (!shlLoggingCompanyLeo.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLoggingCompanyLeo = new Shell();
		shlLoggingCompanyLeo.setSize(450, 300);
		shlLoggingCompanyLeo.setText("Logging Company Leo Kay");
		
		Label lbl_request = new Label(shlLoggingCompanyLeo, SWT.NONE);
		lbl_request.setBounds(10, 10, 244, 15);
		lbl_request.setText("Please select the size of log you would like:");
		
		Label lblNoteEach = new Label(shlLoggingCompanyLeo, SWT.NONE);
		lblNoteEach.setBounds(10, 110, 381, 15);
		lblNoteEach.setText("Note: Each 1 meter log weighs 20 kg, and each truck can hold 1100kg.");
		
		Label lbl_answer = new Label(shlLoggingCompanyLeo, SWT.NONE);
		lbl_answer.setBounds(10, 191, 414, 15);
		
		Button btn_one = new Button(shlLoggingCompanyLeo, SWT.NONE);
		btn_one.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//set the log length
				log_length = 1;
				
				//Calculate the number of logs that can go on the truck
		        log_length = 1/log_length;
		        log_mass_after = LOG_MASS/log_length;
		        number_of_logs = MAX_MASS/log_mass_after;
		        
		        //display the answer
		        lbl_answer.setText("The number of logs you can fit is " + number_of_logs);			
			}
		});
		btn_one.setBounds(47, 57, 75, 25);
		btn_one.setText("1.0 m");
		
		Button btn_half = new Button(shlLoggingCompanyLeo, SWT.NONE);
		btn_half.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//set the log length
				log_length = 0.5;
				
				//Calculate the number of logs that can go on the truck
		        log_length = 1/log_length;
		        log_mass_after = LOG_MASS/log_length;
		        number_of_logs = MAX_MASS/log_mass_after;
		        
		        //display the answer
		        lbl_answer.setText("The number of logs you can fit is " + number_of_logs);	
			}
		});
		btn_half.setBounds(179, 57, 75, 25);
		btn_half.setText("0.5 m");
		
		Button btn_quarter = new Button(shlLoggingCompanyLeo, SWT.NONE);
		btn_quarter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//set the log length
				log_length = 0.25;
				
				//Calculate the number of logs that can go on the truck
		        log_length = 1/log_length;
		        log_mass_after = LOG_MASS/log_length;
		        number_of_logs = MAX_MASS/log_mass_after;
		        
		        //display the answer
		        lbl_answer.setText("The number of logs you can fit is " + number_of_logs);	
			}
		});
		btn_quarter.setBounds(304, 57, 75, 25);
		btn_quarter.setText("0.25 m");

	}
}

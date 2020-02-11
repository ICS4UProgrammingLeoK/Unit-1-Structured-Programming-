import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class EinsteinsEquationGUI {
	
	//variables
	double mass;
	final double SPEED_OF_LIGHT = 2.998*Math.pow(10, 8);
	double energy;

	protected Shell shlEinsteinsEquationleo;
	private Text txt_mass;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			EinsteinsEquationGUI window = new EinsteinsEquationGUI();
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
		shlEinsteinsEquationleo.open();
		shlEinsteinsEquationleo.layout();
		while (!shlEinsteinsEquationleo.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlEinsteinsEquationleo = new Shell();
		shlEinsteinsEquationleo.setSize(450, 300);
		shlEinsteinsEquationleo.setText("Einstein's Equation (Leo Kay)");
		
		Label lbl_request = new Label(shlEinsteinsEquationleo, SWT.NONE);
		lbl_request.setBounds(10, 10, 333, 15);
		lbl_request.setText("Please enter the mass of the object:");
		
		txt_mass = new Text(shlEinsteinsEquationleo, SWT.BORDER);
		txt_mass.setBounds(182, 80, 76, 21);
		
		Label lblMass = new Label(shlEinsteinsEquationleo, SWT.NONE);
		lblMass.setBounds(182, 59, 55, 15);
		lblMass.setText("Mass:");
		
		Label lbl_answer = new Label(shlEinsteinsEquationleo, SWT.NONE);
		lbl_answer.setBounds(10, 201, 414, 15);
		
		Button btn_calculate = new Button(shlEinsteinsEquationleo, SWT.NONE);
		btn_calculate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//error checking
				try {
					mass = Double.parseDouble(txt_mass.getText());
				}
				catch (Exception exc) {
					MessageDialog.openError(shlEinsteinsEquationleo, "Error", "Bad mass. Please enter a new one");
					return;
				}
				
				//answer
		        energy = mass*Math.pow(SPEED_OF_LIGHT, 2);
		        
		        //display the answer
		        lbl_answer.setText(String.format( "The total energy the object could release is %6.3e J", energy));
			}
		});
		btn_calculate.setBounds(182, 129, 75, 25);
		btn_calculate.setText("Calculate!");
		


	}
}

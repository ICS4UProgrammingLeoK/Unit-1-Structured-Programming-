import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Microwave {
	
	double microwaveTime;
	String foodType;

	protected Shell shlMicrowaveByLeo;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Microwave window = new Microwave();
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
		shlMicrowaveByLeo.open();
		shlMicrowaveByLeo.layout();
		while (!shlMicrowaveByLeo.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMicrowaveByLeo = new Shell();
		shlMicrowaveByLeo.setSize(450, 300);
		shlMicrowaveByLeo.setText("Microwave by Leo Kay");
		
		Label lbl_foodRequest = new Label(shlMicrowaveByLeo, SWT.NONE);
		lbl_foodRequest.setBounds(10, 10, 414, 15);
		lbl_foodRequest.setText("Please select your desired food:");
		
		Button btn_sub = new Button(shlMicrowaveByLeo, SWT.NONE);
		Button btn_pizza = new Button(shlMicrowaveByLeo, SWT.NONE);
		Button btn_soup = new Button(shlMicrowaveByLeo, SWT.NONE);
		
		btn_sub.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Get the time for one serving
				microwaveTime = 1;
				
				//set the string to the type of food
				foodType = "sub";
				
				//disable to food buttons
				btn_sub.setEnabled(false);
				btn_pizza.setEnabled(false);
				btn_soup.setEnabled(false);
				
			}
		});
		btn_sub.setBounds(10, 31, 111, 47);
		btn_sub.setText("Sub");
		
		btn_pizza.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Get the time for one serving
				microwaveTime = 0.75;
				
				//set the string to the type of food
				foodType = "pizza";
				
				//disable to food buttons
				btn_sub.setEnabled(false);
				btn_pizza.setEnabled(false);
				btn_soup.setEnabled(false);
				
			}
		});
		btn_pizza.setBounds(162, 31, 111, 47);
		btn_pizza.setText("Pizza");
	
		btn_soup.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Get the time for one serving
				microwaveTime = 1.75;
				
				//set the string to the type of food
				foodType = "soup";
				
				//disable to food buttons
				btn_sub.setEnabled(false);
				btn_pizza.setEnabled(false);
				btn_soup.setEnabled(false);
			}
		});
		btn_soup.setBounds(313, 31, 111, 47);
		btn_soup.setText("Soup");
		
		Label lblPleaseSelectYour = new Label(shlMicrowaveByLeo, SWT.NONE);
		lblPleaseSelectYour.setBounds(10, 106, 414, 15);
		lblPleaseSelectYour.setText("Please select your desired servings:");
		
		Button btn_oneServing = new Button(shlMicrowaveByLeo, SWT.NONE);
		Button btn_twoServings = new Button(shlMicrowaveByLeo, SWT.NONE);
		Button btn_threeServings = new Button(shlMicrowaveByLeo, SWT.NONE);
		
		btn_oneServing.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//set the microwave time to the serving size
				microwaveTime = microwaveTime * 1;
				
				//disable to servings buttons
				btn_oneServing.setEnabled(false);
				btn_twoServings.setEnabled(false);
				btn_threeServings.setEnabled(false);
			}
		});
		btn_oneServing.setBounds(10, 127, 111, 47);
		btn_oneServing.setText("1");
		
		btn_twoServings.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//set the microwave time to the serving size
				microwaveTime = microwaveTime * 1.5;
				
				//disable to servings buttons
				btn_oneServing.setEnabled(false);
				btn_twoServings.setEnabled(false);
				btn_threeServings.setEnabled(false);
			}
		});
		btn_twoServings.setBounds(162, 127, 111, 47);
		btn_twoServings.setText("2");
		
		btn_threeServings.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//set the microwave time to the serving size
				microwaveTime = microwaveTime * 2;
				
				//disable to servings buttons
				btn_oneServing.setEnabled(false);
				btn_twoServings.setEnabled(false);
				btn_threeServings.setEnabled(false);
			}
		});
		btn_threeServings.setBounds(313, 127, 111, 47);
		btn_threeServings.setText("3");
		
		Label lbl_answer = new Label(shlMicrowaveByLeo, SWT.NONE);
		lbl_answer.setBounds(10, 236, 414, 15);
		
		Button btn_start = new Button(shlMicrowaveByLeo, SWT.NONE);
		btn_start.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//display the answer
				lbl_answer.setText("The total time to microwave " + foodType + " is " + microwaveTime + " minutes.");
				
			}
		});
		btn_start.setBounds(162, 192, 111, 38);
		btn_start.setText("Start Microwave");

	}
}

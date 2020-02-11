import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

public class HelloWorldGui {

	protected Shell shlHelloWorld;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HelloWorldGui window = new HelloWorldGui();
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
		shlHelloWorld.open();
		shlHelloWorld.layout();
		while (!shlHelloWorld.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlHelloWorld = new Shell();
		shlHelloWorld.setSize(450, 300);
		shlHelloWorld.setText("Hello World!");
		
		Label lblHelloWorld = new Label(shlHelloWorld, SWT.BORDER | SWT.SHADOW_NONE | SWT.CENTER);
		lblHelloWorld.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblHelloWorld.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblHelloWorld.setAlignment(SWT.CENTER);
		lblHelloWorld.setFont(SWTResourceManager.getFont("Verdana", 40, SWT.BOLD));
		lblHelloWorld.setBounds(16, 87, 395, 67);
		lblHelloWorld.setText("Hello World!");

	}
}

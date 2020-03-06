/*
 * Created by: Leo Kay
 * Created on: 04-03-2020
 * Created for: ICS4U Programming
 * Daily Assignment – Day 14-Planet Enumeration
 * This program displays where a planet that the user selected is
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import javax.swing.JOptionPane;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;
import org.eclipse.wb.swt.SWTResourceManager;

public class PlanetEnumerationLeoK {

	protected Shell shlPlanetEnumerationBy;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PlanetEnumerationLeoK window = new PlanetEnumerationLeoK();
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
		shlPlanetEnumerationBy.open();
		shlPlanetEnumerationBy.layout();
		while (!shlPlanetEnumerationBy.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

    //create the planet enumeration
    public enum Planets{
    Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune
    }
    
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlPlanetEnumerationBy = new Shell();
		shlPlanetEnumerationBy.setSize(450, 300);
		shlPlanetEnumerationBy.setText("Planet Enumeration by Leo Kay");
		
		Label lblSelectAPlanet = new Label(shlPlanetEnumerationBy, SWT.NONE);
		lblSelectAPlanet.setBounds(10, 10, 414, 15);
		lblSelectAPlanet.setText("Select a planet:");
		
		List lst_planets = new List(shlPlanetEnumerationBy, SWT.BORDER);
		lst_planets.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lst_planets.setBounds(20, 31, 220, 220);
		
        //adds the enumeration values to the list
        for (Planets p:Planets.values()){
            lst_planets.add(p.toString());
        }
		
		Button btn_go = new Button(shlPlanetEnumerationBy, SWT.NONE);
		btn_go.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//display the planet and position the user selects
				if (lst_planets.getSelectionIndex() == 0){
					//displays the planet and planet number
					 JOptionPane.showMessageDialog(null, "You want to go to " + Planets.Mercury + ", planet #1");
				}
				else if (lst_planets.getSelectionIndex() == 1) {
					//displays the planet and planet number
					 JOptionPane.showMessageDialog(null, "You want to go to " + Planets.Venus + ", planet #2");
				}
				else if (lst_planets.getSelectionIndex() == 2) {
					//displays the planet and planet number
					 JOptionPane.showMessageDialog(null, "You want to go to " + Planets.Earth + ", planet #3");
				}
				else if (lst_planets.getSelectionIndex() == 3) {
					//displays the planet and planet number
					 JOptionPane.showMessageDialog(null, "You want to go to " + Planets.Mars + ", planet #4");
				}
				else if (lst_planets.getSelectionIndex() == 4) {
					//displays the planet and planet number
					 JOptionPane.showMessageDialog(null, "You want to go to " + Planets.Jupiter + ", planet #5");
				}
				else if (lst_planets.getSelectionIndex() == 5) {
					//displays the planet and planet number
					 JOptionPane.showMessageDialog(null, "You want to go to " + Planets.Saturn + ", planet #6");
				}
				else if (lst_planets.getSelectionIndex() == 6) {
					//displays the planet and planet number
					 JOptionPane.showMessageDialog(null, "You want to go to " + Planets.Uranus + ", planet #7");
				}
				else if (lst_planets.getSelectionIndex() == 7) {
					//displays the planet and planet number
					 JOptionPane.showMessageDialog(null, "You want to go to " + Planets.Neptune + ", planet #8");
				}
				else {
					//if the user doesn't select anything, tell them to
					 JOptionPane.showMessageDialog(null, "Select a planet you would like to go to.");
				}
			}
		});
		btn_go.setText("Go!");
		btn_go.setBounds(301, 115, 75, 25);
	}
}

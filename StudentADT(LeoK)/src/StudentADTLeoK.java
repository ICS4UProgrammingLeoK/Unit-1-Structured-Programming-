/*
 * Created by Leo Kay
 * Created on: 09-03-2020
 * Created for: ICS4U
 * Day #15 (Student ADT)
 * This program takes the user's information and displays it
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import java.awt.BorderLayout;
import javax.swing.JComboBox;

public class StudentADTLeoK {

	protected Shell shlStudentAdtBy;
	private Text txt_mid;
	private Text txt_last;
	private Text txt_first;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			StudentADTLeoK window = new StudentADTLeoK();
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
		shlStudentAdtBy.open();
		shlStudentAdtBy.layout();
		while (!shlStudentAdtBy.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlStudentAdtBy = new Shell();
		shlStudentAdtBy.setSize(326, 387);
		shlStudentAdtBy.setText("Student ADT by Leo Kay");
		
		Label lblFirstName = new Label(shlStudentAdtBy, SWT.NONE);
		lblFirstName.setBounds(10, 33, 69, 15);
		lblFirstName.setText("First Name:");
		
		Label lblSecondName = new Label(shlStudentAdtBy, SWT.NONE);
		lblSecondName.setText("Last Name:");
		lblSecondName.setBounds(10, 85, 77, 15);
		
		Label lblMiddleInitial = new Label(shlStudentAdtBy, SWT.NONE);
		lblMiddleInitial.setText("Middle Initial:");
		lblMiddleInitial.setBounds(10, 135, 77, 15);
		
		Label lblGrade = new Label(shlStudentAdtBy, SWT.NONE);
		lblGrade.setText("Grade:");
		lblGrade.setBounds(10, 184, 69, 15);
		
		Label lblIdentified = new Label(shlStudentAdtBy, SWT.NONE);
		lblIdentified.setText("Identified:");
		lblIdentified.setBounds(10, 231, 69, 15);
		
		Button rad_identified = new Button(shlStudentAdtBy, SWT.RADIO);
		rad_identified.setBounds(127, 230, 90, 16);
		
		Combo cmb_grade = new Combo(shlStudentAdtBy, SWT.NONE);
		cmb_grade.setItems(new String[] {"7", "8", "9", "10", "11", "12"});
		cmb_grade.setBounds(126, 181, 91, 23);
		
		txt_mid = new Text(shlStudentAdtBy, SWT.BORDER);
		txt_mid.setBounds(127, 135, 76, 21);
		
		txt_last = new Text(shlStudentAdtBy, SWT.BORDER);
		txt_last.setBounds(127, 85, 76, 21);
		
		txt_first = new Text(shlStudentAdtBy, SWT.BORDER);
		txt_first.setBounds(127, 27, 76, 21);
		
		Button btn_enter = new Button(shlStudentAdtBy, SWT.NONE);
		btn_enter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					//get the student info
					StudentInfo studentInfo = new StudentInfo();
					studentInfo.firstName = txt_first.getText();
					studentInfo.lastName = txt_last.getText();
					studentInfo.middleInitial = txt_mid.getText();
					studentInfo.grade = cmb_grade.getSelectionIndex() + 7;
					if (rad_identified.isEnabled() == true) {
						studentInfo.identified = "Identified";
					}
					else {
						studentInfo.identified = "not Identified";
					}
					//call the display function
					studentInfo.DisplayInfo();
				}
				catch (Exception exc){
					//error checking
					JOptionPane.showMessageDialog(null, "Please enter the proper information.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		btn_enter.setBounds(92, 265, 125, 56);
		btn_enter.setText("Enter");
	}
	
	//create a class that contains the student info
	class StudentInfo {
		//Variables
		String firstName;		
		String lastName;		
		String middleInitial;   
		int grade;				
		String identified;	
		
		public void DisplayInfo(){
			//Display the answer
			JOptionPane.showMessageDialog(null, firstName + " " + middleInitial + " " + lastName + " is in grade " + grade + " and is " + identified, "Student Information", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}

package Collection;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Authorises a user, also instantiates a user interface for the Yuconz system
 * @author sr705
 * @author jt539
 *
 */
 public class Authorisation extends Repository {

	protected ArrayList<String> authLog = new ArrayList<>();
	Date date = new Date();
	
	String statLogValue = statLog.get(0); //gets username and saves it to statLogValue.
	
	private JFrame f; // Is the window.
	private JPanel p; // Displays components of frame.
	
	private JButton b1; // ------- Personal Details button. -
	private JButton b2; // ------- View & Edit Personal Details button. -
	private JButton b4; // ------- Creates Employment Details document button. - 
	private JButton b10;// ------- View & Edit Employment Details button. - 
	private JButton b5; // ------- Create Salary Increase Records. -
	private JButton b11;// ------- View & Edit Salary Increase Records button. -
	private JButton b6; // ------- Create Promotion Records. -
	private JButton b12;// ------- View Promotion Records. -
	private JButton b7; // ------- Create Annual Review.
	private JButton b14;// ------- View Annual Review.
	private JButton b8; // ------- Termination Records.-
	private JButton b13;// ------- View Promotion Records. -
	private JButton b15; // ------- Creates a attemp log
	
	private JButton LogoutB; // ------- Personal Logout button.
	
	public Authorisation(String threeCheck) { // Constructor
		super.ValueCheckThree = threeCheck;	}
	/**
	 * JButton for createPersonalDetails()
	 */
	public void createPersonalDetailsButton() { // Preforms button operation createsPersonalDetails.
		b1 =new JButton("Create Personal Details");
		
		b1.addActionListener(new ActionListener()  {  
			public void actionPerformed(ActionEvent e)  {
				PersonalDetails pd = new PersonalDetails();
				pd.createPersonalDetails(statLogValue);
				JOptionPane.showMessageDialog(null,"Personal Detail Docuemnt has been created." + "\n" + "To view select the View & Edit Personal Details button.");
			}						
		});
		p.add(b1);
	}
	/**
	 * JButton for viewPersonalDetails()
	 */
	public void ViewPersonalDetailsButton() { // Preforms button operation ViewPersonalDetails.
		b2 =new JButton("View & Edit Personal Details");
		b2.addActionListener(new ActionListener()  { // Preforms button operation viwerPersonalDetails. 
			public void actionPerformed(ActionEvent e)  {
				PersonalDetails pd = new PersonalDetails();
				try {
					pd.viewPersonalDetails();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}						
		});
		p.add(b2);
	}
	/**
	 * JButton for createEmployeeDetails()
	 */
	public void createEmploymentDetailsButton() { // Preforms button operation createsEmploymentDetails.
		b4 =new JButton("Create Employment Details");
		
		b4.addActionListener(new ActionListener()  {  
			public void actionPerformed(ActionEvent e)  {
				
				PersonalDetails pd = new PersonalDetails();
				pd.createEmploymentDocument();
				
				JOptionPane.showMessageDialog(null,"Employment Detail Docuemnt has been created." + "\n" + "To view select the View & Edit Employment Button.");
			}						
		});
		p.add(b4);
	}
	/**
	 * JButton for viewEmploymentDetails()
	 */
	public void  ViewEmploymentDetailsButton() { // Preforms button operation ViewPersonalDetails.
		b10 =new JButton("View Employment Details");
		b10.addActionListener(new ActionListener()  { // Preforms button operation viwerPersonalDetails. 
			public void actionPerformed(ActionEvent e)  {
				PersonalDetails pd = new PersonalDetails();
				try {
					pd. EmploymentDetailsDocument();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}						
		});
		p.add(b10);
	}
	/**
	 * JButton for createSalaryIncreaseRecordsDocument()
	 */
	public void createSalaryIncreaseRecordsDocument() { // Preforms button operation createsEmploymentDetails.
		b5 =new JButton("Create Salary Increase Records");
		
		b5.addActionListener(new ActionListener()  {  
			public void actionPerformed(ActionEvent e)  {
				
				PersonalDetails pd = new PersonalDetails();
				pd.createSalaryIncreaseRecordsDocument();
				
				JOptionPane.showMessageDialog(null,"Salary Increase Records Docuemnt has been created." + "\n" + "To view select the View Salary Increase Records Button.");
			}						
		});
		p.add(b5);
	}
	/**
	 * JButton for viewSalaryIncreaseRecordsDocument()
	 */
	public void ViewSalaryIncreaseRecordsDocument() { // Preforms button operation ViewSalaryIncreaseRecordsDocument.
		b11 =new JButton("View Salary Increase Records");
		b11.addActionListener(new ActionListener()  { // Preforms button operation viwerPersonalDetails. 
			public void actionPerformed(ActionEvent e)  {
				PersonalDetails pd = new PersonalDetails();
				try {
					pd.SalaryIncreaseRecordsDocument();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}						
		});
		p.add(b11);
	}
	/**
	 * JButton for createPromotionRecords()
	 */
	public void createPromotionRecords() { // Preforms button operation createPromotionRecords.
		b6 =new JButton("Create Promotion Records");
		
		b6.addActionListener(new ActionListener()  {  
			public void actionPerformed(ActionEvent e)  {
				
				PersonalDetails pd = new PersonalDetails();
				pd.createPromotionRecords();
				
				JOptionPane.showMessageDialog(null,"Promotion Records Docuemnt has been created." + "\n" + "To view select the View Promotion Records Button.");
			}						
		});
		p.add(b6);
	}
	/**
	 * JButton for viewPromotionRecords()
	 */
	public void ViewPromotionRecords() { // Preforms button operation ViewPromotionRecords.
		b12 =new JButton("View Promotion Records");
		b12.addActionListener(new ActionListener()  { // Preforms button operation viwerPersonalDetails. 
			public void actionPerformed(ActionEvent e)  {
				PersonalDetails pd = new PersonalDetails();
				try {
					pd.viewPromotionRecords();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}						
		});
		p.add(b12);
	}
	/**
	 * JButton for createTerminationRecords()
	 */
	public void createTerminationRecordsButton() { // Preforms button operation ViewTerminationRecordsButton.
		b8 =new JButton("Create Termination Records");
		
		b8.addActionListener(new ActionListener()  {  
			public void actionPerformed(ActionEvent e)  {
				
				PersonalDetails pd = new PersonalDetails();
				pd.createTerminationRecords();
				
				JOptionPane.showMessageDialog(null,"Termination Records Docuemnt has been created." + "\n" + "To view select the View Termination Records Button.");
			}						
		});
		p.add(b8);
	}
	/**
	 * JButton for viewTerminationRecords()
	 */
	public void ViewTerminationRecordsButton() { // Preforms button operation ViewTerminationRecordsButton.
		b13 =new JButton("View Termination Records");
		b13.addActionListener(new ActionListener()  { // Preforms button operation View Termination Records 
			public void actionPerformed(ActionEvent e)  {
				PersonalDetails pd = new PersonalDetails();
				try {
					pd.viewTerminationRecords();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}						
		});
		p.add(b13);
	}
	/**
	 * JButton for createAnnualReview()
	 */
	public void createAnnualReviewButton() { // Preforms button operation Annual Review.
		b7 =new JButton("Create Annual Review");
		
		b7.addActionListener(new ActionListener()  {  
			public void actionPerformed(ActionEvent e)  {
				
				PersonalDetails pd = new PersonalDetails();
				pd.createAnnualReviewDocument();
				
				JOptionPane.showMessageDialog(null,"Termination Records Docuemnt has been created." + "\n" + "To view select the View Annual Review Button.");
			}						
		});
		p.add(b7);
	}
	/**
	 * JButton for viewAnnualReview()
	 */
	public void viewAnnualReviewButton() { // Preforms button operation viewAnnualReviewButton.
		b14 =new JButton("View Annual Review");
		b14.addActionListener(new ActionListener()  { // Preforms button operation viewAnnualReviewButton. 
			public void actionPerformed(ActionEvent e)  {
				PersonalDetails pd = new PersonalDetails();
				try {
					pd.annualReview();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}						
		});
		p.add(b14);
	}
	/**
	 * JButton for viewUsersPersonalDetails()
	 */
	public void viewUsersPersonalDetailsButton() { // Preforms button operation viewUsersPersonalDetailsButton.
		b14 =new JButton("View Users Personal Details");
		b14.addActionListener(new ActionListener()  { // Preforms button operation viewUsersPersonalDetailsButton. 
			public void actionPerformed(ActionEvent e)  {
				PersonalDetails pd = new PersonalDetails();
				try {
					pd.viewUsersPersonalDetails();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}						
		});
		p.add(b14);
	}
	/**
	 * JButton for AttemptLog()
	 */
	public void AttemptLog() { // Preforms button operation AttemptLog.
		b15 =new JButton("Attempt Log");
		b15.addActionListener(new ActionListener()  { // Preforms button operation AttemptLog. 
			public void actionPerformed(ActionEvent e)  {
				PersonalDetails pd = new PersonalDetails();
				try {
					pd.viewAttemptLog();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}						
		});
		p.add(b15);
	}
	/**
	 * JButton for doLogout()
	 */
	public void logout() { // Preforms button operation logout.
		LogoutB =new JButton("Logout");
		
		LogoutB.addActionListener(new ActionListener()  {  
			public void actionPerformed(ActionEvent e)  {
				System.exit(0);
			}						
		});
		p.add(LogoutB);
	}
	
	/**
	 * Checks a users role, then displays corresponding buttons based on a users accessible options
	 */
	public void checkPermission() {
		
		if(ValueCheckThree.equals("Employee"))  {
				authLog.add(ValueCheckThree);// Adds user role to authLog so can then log the user and there role.
				System.out.println("You have access to: " + employeePermission);
				
				f = new JFrame("Yuconz IT System: " + statLogValue);
				f.setVisible(true);
				f.setSize(2000,600);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When press close button on the frame it'll close program.
				
				p = new JPanel();
				p.setBackground(Color.decode("#d4d0cf"));
				
				createPersonalDetailsButton(); // BUTTONS: Uses the methods to create and add button to frame to eliminate repeated code.
				ViewPersonalDetailsButton();
				logout();
				
				f.add(p); // Adds panel to frame.
			
		}else if(ValueCheckThree.equals("Director")) {
				authLog.add(ValueCheckThree);
				System.out.println("You have access to: " + directorPermission);
				
				f = new JFrame("Yuconz IT System: " + statLogValue);
				f.setVisible(true);
				f.setSize(2000,600);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When press close button on the frame it'll close program.
				
				p = new JPanel();
				p.setBackground(Color.decode("#d4d0cf"));
				
				createPersonalDetailsButton(); // BUTTONS: Uses the methods to create and add button to frame to eliminate repeated code.
				ViewPersonalDetailsButton();
				createEmploymentDetailsButton();
				ViewEmploymentDetailsButton();
				logout();
				
				f.add(p); // Adds panel to frame.
		
		}else if(ValueCheckThree.equals("Manager")) {
				authLog.add(ValueCheckThree);
				System.out.println("You have access to: " + managerPermission);
				
				f = new JFrame("Yuconz IT System: " + statLogValue);
				f.setVisible(true);
				f.setSize(2000,600);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When press close button on the frame it'll close program.
				
				p = new JPanel();
				p.setBackground(Color.decode("#d4d0cf"));
				
				createPersonalDetailsButton(); // BUTTONS: Uses the methods to create and add button to frame to eliminate repeated code.
				ViewPersonalDetailsButton();
				createEmploymentDetailsButton();
				ViewEmploymentDetailsButton();
				createSalaryIncreaseRecordsDocument();
				ViewSalaryIncreaseRecordsDocument();
				createPromotionRecords();
				ViewPromotionRecords();
				logout();
				
				f.add(p); // Adds panel to frame.
		
		}else if(ValueCheckThree.equals("HR")) {
				authLog.add(ValueCheckThree);
				System.out.println("You have access to: " + hrPermission);
				
				f = new JFrame("Yuconz IT System:" + statLogValue);
				f.setVisible(true);
				f.setSize(2000,700);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When press close button on the frame it'll close program.
				
				p = new JPanel();
				p.setBackground(Color.decode("#d4d0cf"));
				
				createPersonalDetailsButton(); // BUTTONS: Uses the methods to create and add button to frame to eliminate repeated code.
				ViewPersonalDetailsButton();
				
				createEmploymentDetailsButton();
				ViewEmploymentDetailsButton();
				
				createSalaryIncreaseRecordsDocument();
				ViewSalaryIncreaseRecordsDocument();
				
				createPromotionRecords();
				ViewPromotionRecords();
				
				createTerminationRecordsButton();
				ViewTerminationRecordsButton();
				
				createAnnualReviewButton();
				viewAnnualReviewButton();
				
				viewUsersPersonalDetailsButton();
				
				AttemptLog();
				logout();
				
				f.add(p); // Adds panel to frame.
			
		}else System.out.println("ERROR: Access has not been granted");		
	}
	/**
	 * Prints all authorisation attempts to the log
	 */
	public void printAuth() { // A user that does exist.
		BufferedWriter bw = null;
		try {
			 File file = new File("log.txt"); // Add the name of the file and the path.

			  if (!file.exists()) { // If files doesnt exist then create it. 
			     file.createNewFile();
			  }

			  bw = new BufferedWriter(new FileWriter(file,true));
			  bw.write(date + ", "  + "User:" + statLog.get(0) + ", " + ValueCheckThree + "\n"); // Uses bufferedWriter to write the data, time, username and role to log.
		          System.out.println("Your login attempt has been logged.");

		      } catch (IOException ioe) {
			   ioe.printStackTrace();
			}
		finally
		{ 
		   try{
		      if(bw!=null)
		    	  bw.close();
		   	  }catch(Exception ex){
		       System.out.println("Error in closing the BufferedWriter"+ex);
		    }
		}
	   }
	/**
	 * Prints invalid attempts to the log
	 */
	public void printAuthWithout() { // A user that doesn't exist.
		BufferedWriter bw = null;
		try {
			 File file = new File("log.txt"); // Add the name of the file and the path.

			  if (!file.exists()) { // If files doesnt exist then create it.
			     file.createNewFile();
			  }

			  bw = new BufferedWriter(new FileWriter(file,true));
			  bw.write(date + ", "  + "User:" + statLog.get(0) + ", " + "USER NOT VALID" + "\n"); // Uses bufferedWriter to write the data, time and failed message to log.
		          System.out.println("Your login attempt has been logged.");

		      } catch (IOException ioe) {
			   ioe.printStackTrace();
			}
		finally
		{ 
		   try{
		      if(bw!=null)
		    	  bw.close();
		   	  }catch(Exception ex){
		       System.out.println("Error in closing the BufferedWriter"+ex);
		    }
		}
	   }
}

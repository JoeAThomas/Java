package Collection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Creates the text files which store a users personal details
 * @author sr705
 * @author jt539
 *
 */
public class PersonalDetails extends Repository {
	protected File file;
	protected FileWriter write;
	protected BufferedWriter bwr;
	private boolean isFile;
	
	String statLogValue = statLog.get(0); //gets username and saves it to statLogValue.
	
	/**
	 * Constructor for PersonalDetails
	 */
	public PersonalDetails() {		
		isFile = false;
		
	}
	/**
	 * Creates a new Personal Details file for specified staff using employee logins
	 * @param statLogValue the user login value
	 */
	public void createPersonalDetails(String statLogValue) {
		try {
			File file = new File(statLogValue + "_PDetails" + ".txt"); // User enters there Username and then the .txt file would be titled that.
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter write = new FileWriter(file);
			BufferedWriter bwr = new BufferedWriter(write, 16384);
			bwr.write("Staff_Number: " + statLogValue + "\n");
			bwr.write("Surname: \n");
			bwr.write("Forename: \n");
			bwr.write("Date of Birth: \n");
			bwr.write("Address: \n");
			bwr.write("Town/City: \n");
			bwr.write("County: \n");
			bwr.write("Postcode: \n");
			bwr.write("Telephone Number: \n");
			bwr.write("Mobile Number: \n");
			bwr.write("Emergency Contact: \n");
			bwr.write("Emergency Contact Number: \n");
			bwr.close();
			isFile = true;
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	
	}
	
	/**
	 * Opens the PersonalDetail file of the user currently logged in
	 * @throws Exception
	 */
	public void viewPersonalDetails() throws Exception { // opens the personal details.txt file.
			ProcessBuilder pb = new ProcessBuilder("Notepad.exe",statLogValue + "_PDetails" + ".txt"); 
			pb.start();
	}
	/**
	 * Creates Employment document file
	 */
	public void createEmploymentDocument() { // creates employment details.txt file.
		try {
			File file = new File("Employment Details/" + "Base Employment Details Document" + ".txt"); 
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter write = new FileWriter(file);
			BufferedWriter bwr = new BufferedWriter(write, 16384);
			bwr.write("---- Save this documents file name as the usersname followed by  _EM.txt  of the person you are setting up for.----");
			bwr.close();
			isFile = true;
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/**
	 * Opens employment details file
	 * @throws Exception
	 */
	public void EmploymentDetailsDocument() throws Exception { // Views the employment details files
		ProcessBuilder pb = new ProcessBuilder("explorer.exe","Employment Details"); // opens the file with all of the txt files in so HR can pick who they want to review.
		pb.start();
	}
	
	/**
	 * Opens salary increase record file
	 * @throws Exception
	 */
	public void SalaryIncreaseRecordsDocument() throws Exception { // Views the employment details files
		ProcessBuilder pb = new ProcessBuilder("explorer.exe","Salary Increase Records"); // opens the file with all of the txt files in so HR can pick who they want to review.
		pb.start();
	}
	
	/**
	 * Creates a salary increase record file
	 */
	public void createSalaryIncreaseRecordsDocument() {
		try {
			File file = new File("Salary Increase Records/" + "Base Salary Increase Records Document" + ".txt"); 
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter write = new FileWriter(file);
			BufferedWriter bwr = new BufferedWriter(write, 16384);
			bwr.write("---- Save this documents file name as the usersname followed by  _SIR.txt  of the person you are setting up.----");
			bwr.close();
			isFile = true;
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	/**
	 * Creates promotion records file
	 */
	public void createPromotionRecords() {
		try {
			File file = new File("Promotion Records/" + "Base Promotion Records Document" + ".txt"); 
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter write = new FileWriter(file);
			BufferedWriter bwr = new BufferedWriter(write, 16384);
			bwr.write("---- Save this documents file name as the usersname followed by  _PR.txt  of the person you are reviewing.----");
			bwr.close();
			isFile = true;
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/**
	 * Opens promotion records file
	 * @throws Exception
	 */
	public void viewPromotionRecords() throws Exception {
		ProcessBuilder pb = new ProcessBuilder("explorer.exe","Promotion Records"); // opens the file with all of the txt files in so HR can pick who they want to review.
		pb.start();
	}
	
	/**
	 * Creates file for annual reviews
	 */
	public void createAnnualReviewDocument() {
		try {
			File file = new File("Annual Review/" + "Base Annual Review Document" + ".txt"); 
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter write = new FileWriter(file);
			BufferedWriter bwr = new BufferedWriter(write, 16384);
			bwr.write("---- Save this documents file name as the usersname followed by  _AR.txt  of the person you are reviewing.----");
			bwr.close();
			isFile = true;
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/**
	 * Opens annual review file
	 * @throws Exception
	 */
	public void annualReview() throws Exception {
		ProcessBuilder pb = new ProcessBuilder("explorer.exe","Annual Review"); // opens the file with all of the txt files in so HR can pick who they want to review.
		pb.start();
	}
	
	/**
	 * Opens termination records file
	 * @throws Exception
	 */
	public void viewTerminationRecords() throws Exception {
		ProcessBuilder pb = new ProcessBuilder("explorer.exe","Termination Records"); // opens the file with all of the txt files in so HR can pick who they want to review.
		pb.start();
	}
	
	/**
	 * Creates file for termination records
	 */
	public void createTerminationRecords() {
		try {
			File file = new File("Termination Records/" + "Base Termination Records Document" + ".txt"); 
			if(!file.exists()) {
				file.createNewFile();
			}
			FileWriter write = new FileWriter(file);
			BufferedWriter bwr = new BufferedWriter(write, 16384);
			bwr.write("---- Save this documents file name as the usersname followed by  _TR.txt  of the person you are reviewing.----");
			bwr.close();
			isFile = true;
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/**
	 * Views a users personal details
	 * @throws Exception
	 */
	public void viewUsersPersonalDetails() throws Exception {
		ProcessBuilder pb = new ProcessBuilder("explorer.exe","Personal Details"); // opens the file with all of the txt files in so HR can pick who they want to review.
		pb.start();
	}
	
	/**
	 * Opens attempt log file
	 * @throws Exception
	 */
	public void viewAttemptLog() throws Exception { // opens the personal details.txt file.
		ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "log.txt"); 
		pb.start();
}
	
}

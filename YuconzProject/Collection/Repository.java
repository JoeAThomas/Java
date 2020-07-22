/**
 * 
 */
package Collection;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Superclass which stores all details used across the system
 * @author sr705
 * @author jt539
 *
 */
public class Repository {
	
	protected boolean loggedIn; // used to say if the user is logged in or not.
	
	
	protected String ValueCheckThree; //Users role.
	
	
	
	//stores the permissions.
	protected HashMap<String, Boolean> employeePermission = new HashMap<>();
	protected HashMap<String, Boolean> directorPermission = new HashMap<>();
	protected HashMap<String, Boolean> managerPermission = new HashMap<>();
	protected HashMap<String, Boolean> hrPermission = new HashMap<>();
	
	protected HashMap<String, String> storedUsers = new HashMap<>();
	protected HashMap<String, String> individualRoles = new HashMap<>();
	
	//stores the username entered when the user.
	static ArrayList<String> statLog = new ArrayList<>();
	
	//storing the details of the scanner. 
	protected HashMap<String, String> storedDetails;
	protected HashMap<String, String> loginDetails;
	
	/**
	 * Constructor of Repository, instantiates all HashMaps and their values
	 */
	public Repository() {
		//Setting the permissions for each roll within Yuconzs.
		employeePermission.put("Personal details", true);
		employeePermission.put("Employment details", false );
		employeePermission.put("Annual Review", false );
		employeePermission.put("Salary increase records", false);
		employeePermission.put("Promotion records", false);
		employeePermission.put("Termination records", false);	
	
		directorPermission.put("Personal details", true);
		directorPermission.put("Employment details", true);
		directorPermission.put("Annual Review", false);
		directorPermission.put("Salary increase records", false);
		directorPermission.put("Promotion records", false);
		directorPermission.put("Termination records",false);	
	
		managerPermission.put("Personal details", true);
		managerPermission.put("Employment details", true);
		managerPermission.put("Annual Review", false);
		managerPermission.put("Salary increase records", true);
		managerPermission.put("Promotion records", true);
		managerPermission.put("Termination records",false);
	
		hrPermission.put("Personal details", true);
		hrPermission.put("Employment details", true);
		hrPermission.put("Annual Review", true);
		hrPermission.put("Salary increase records", true);
		hrPermission.put("Promotion records", true);
		hrPermission.put("Termination records",true);
		
		//individuals within the company and their passwords.
		storedUsers.put("abc123", "Password123");
		storedUsers.put("User01", "Password01");
		storedUsers.put("def456", "Password456");
		storedUsers.put("User02", "Password02");
		storedUsers.put("MilesRoman123", "Yuconz123");
		storedUsers.put("User03", "Password03");
		storedUsers.put("Carlos789", "Password789");
		storedUsers.put("User04", "Password04");
		
		//individuals and there roles. call the employee and it will print their permissions.
		individualRoles.put("abc123", "Employee");
		individualRoles.put("User01", "Employee");
		individualRoles.put("def456", "HR");
		individualRoles.put("User02", "HR");
		individualRoles.put("MilesRoman123", "Director");
		individualRoles.put("User03", "Director");
		individualRoles.put("Carlos789", "Manager");
		individualRoles.put("User04", "Manager");
	}
	
	public void loginDetails(String username, String role) {
		
	}
	
}

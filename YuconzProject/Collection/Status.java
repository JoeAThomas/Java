/**
 * @author jt539,sr705
 */
package Collection;

import java.util.*;
/**
 * Logs the user out of the system
 * @author sr705
 * @author jt539
 *
 */
public class Status extends Repository {
	
	/**
	 * Constructor of Status
	 * @param isLoggedin the boolean value which determines whether a user's logged in
	 */
	public Status(boolean isLoggedin) {
		super.loggedIn = isLoggedin; //saved login as isLoggedin which is they log in should be false is not logged in. 
	}
	
	/**
	 * Calls the value of ValueCheckThree
	 * @return ValueCheckThree
	 */		
	public String getValueCheckThree() {
		return ValueCheckThree;
	}
	
	/**
	 * Logs out the user from the system, also prints a message to console
	 */
	public void doLogout() {
		loggedIn = false;
		System.out.print("You are now signed out");
	}
	
 }


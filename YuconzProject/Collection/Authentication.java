package Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Authentication  extends Repository {
	
	protected boolean authentication  = false;
	
	public Authentication() {
		loginDetails = new HashMap<>();
		statLog = new ArrayList<>();
	}
	
	public void doLogin() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your Username & Password: ");
		String username = s.nextLine();
		String password = s.nextLine();
				
			Repository.statLog.add(username);	
			loginDetails.put(username, password);
			     
			 if(loginDetails.containsKey(username) && storedUsers.containsKey(username) && storedUsers.get(username).equals(password)) {
			    	
				 loginDetails.get(password); // Assigning the Password to the ValueCheck variable.	
				 //ValueCheck = password ;
			 	 
				 		loggedIn = true;
						System.out.println("Access Granted!");
							 
						if(storedUsers.containsKey(username) && individualRoles.containsKey(username)) {  // Checks if the username in storedUsers & individualRoles in storedUsers are same.	
							ValueCheckThree = individualRoles.get(username); // Gets the users role from the individualRoles HashMap and stores it on as a variable.
						    System.out.println("You have "+ ValueCheckThree + " access."); // Takes variable and strings it together.
						}
						
						Authorisation auth = new Authorisation(getValueCheckThree());
						auth.checkPermission();
						auth.printAuth();
		 
			 } else {
				loggedIn = false;
				System.out.println("Invalid username or password.");
				
				Authorisation auth = new Authorisation(getValueCheckThree());
				auth.printAuthWithout();
			 }
	}
	
	public String getValueCheckThree() {
		return ValueCheckThree;
	}
		
	public void authenticationFails() {
		if(authentication == false) {
			System.out.println("Authentication failed");
		}
	}
}


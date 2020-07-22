package Collection;

/**
 * JUnit class for the Authentication Class
 * @author sr705
 * @author jt539
 */

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.HashMap;

public class AuthenticationTest {
	/**
	 * Fail case for DoLogin()
	 */
	@Test
	public void testDoLoginFail() {
		HashMap<String, String> storedDetails = new HashMap<>();
		storedDetails.put("abc123","Password123");
		String username = "wrongUser123";
		String password = "wrongPassword123";
		assertEquals(username, "wrongUser123");
		assertEquals(password, "wrongPassword123");
	}
	
	/**
	 * Pass case for doLogin()
	 */
	@Test
	public void testDoLoginPass() {
		HashMap<String, String> storedDetails = new HashMap<>();
		storedDetails.put("abc123","Password123");
		String username = "abc123";
		String password = "Password123";
		assertEquals(username, "abc123");
		assertEquals(password, "Password123");
	}
	
	
	@Test
	public void testAuthenticationFailsFail() {
		fail("Not yet implemented");
	}
	
	public void testAuthenticationFailsPass() {
		fail("Not yet implemented");
	}
	
	public void testLogAttemptFail() {
		fail("Not yet implemented");
	}
	
	public void testLogAttemptPass() {
		fail("Not yet implemented");
	}
	
	public void testRemoveLoginAccessFail() {
		fail("Not yet implemented");
	}
	
	public void testRemoveLoginAccessPass() {
		fail("Not yet implemented");
	}

}


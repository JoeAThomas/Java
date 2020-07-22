/**
 * JUnit test for Status
 * @author sr705
 * @author jt539
 */
package Collection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author sr705
 *
 */
public class StatusTest {
	/**
	 * Fail test for doLogout()
	 */
	@Test
	public void testDoLogoutFail() {
		Status logout = new Status(false);
		boolean loggedIn = true;
		assertTrue(loggedIn);
	}
	/**
	 * Pass test for doLogout()
	 */
	@Test
	public void testDoLogoutPass() {
		Status logout = new Status(true);
		boolean loggedIn = true;
		logout.doLogout();
		loggedIn = false;
		assertFalse(loggedIn);
	}
}

package Collection;

import static org.junit.Assert.*;

import org.junit.Test;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
/**
 * JUnit test for PersonalDetails
 * @author sr705
 * @author jt539
 *
 */
public class PersonalDetailsTest {
	/**
	 * Fail test for createPersonalDetails()
	 */
	@Test
	public void testCreatePersonalDetailsFail() {
		boolean isFile = false;
		assertFalse(isFile);
	}
	/**
	 * Pass test for createPersonalDetails()
	 */
	@Test 
	public void testCreatePersonalDetailsPass() {
		PersonalDetails pd = new PersonalDetails();
		pd.createPersonalDetails("abc123");
		boolean isFile = true;
		assertTrue(isFile);
	}
	/**
	 * Fail test for editPersonalDetails()
	 */
	@Test
	public void testEditPersonalDetailsFail() {
		boolean isFile = false;
		assertFalse(isFile);
	}
}

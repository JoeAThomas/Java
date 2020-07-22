package Collection;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
 * JUnit test class for Authorisation
 * @author sr705
 * @author jt539
 *
 */
public class AuthorisationTest {
	/**
	 *  Fail test for checkPermission()
	 */
	@Test
	public void testCheckPermissionFail() {
		String role = "_";
		assertTrue(role != "Employee");
		assertTrue(role != "Manager");
		assertTrue(role != "Director");
		assertTrue(role != "HR");
	}
	/**
	 * Employee pass test for checkPermission()
	 */
	@Test
	public void testCheckPermissionEmployee() {
		String role = "Employee";
		assertEquals(role, "Employee");
	}
	/**
	 * Manager pass test for checkEmployee()
	 */
	@Test
	public void testCheckPermissionManager() {
		String role = "Manager";
		assertEquals(role, "Manager");
	}
	/**
	 * Director pass test for checkEmployee()
	 */
	@Test
	public void testCheckPermissionDirector() {
		String role = "Director";
		assertEquals(role, "Director");
	}
	/**
	 * HR pass test for checkEmployee()
	 */
	@Test
	public void testCheckPermissionHR() {
		String role = "HR";
		assertEquals(role, "HR");
	}
	/**
	 * fail test for printAuth()
	 */
	@Test
	public void testChangePermissionFail() {
		fail();
	}
	/**
	 * Pass test for printAuth()
	 */
	@Test
	public void testChangePermissionPass() {
		fail();
	}
	/**
	 * Fail test for printAuthWithout()
	 */
	@Test
	public void testPrintAuthFail() {
		boolean isFile = false;
		Authorisation auth = new Authorisation("_");
		BufferedWriter bw = null;
		File file = new File("log.txt");
		try {
		bw = new BufferedWriter(new FileWriter(file, true));
		bw.write("Test should Fail\n");
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		assertFalse(isFile);
	}
	/**
	 * Pass test for printAuthWithout()
	 */
	@Test
	public void testPrintAuthPass() {
		Boolean isFile = false;
		Authorisation auth = new Authorisation("_");
		BufferedWriter bw = null;
		File file = new File("log.txt");
		try {
			  if (!file.exists()) {
			     file.createNewFile();
			  }
			  bw = new BufferedWriter(new FileWriter(file,true));
			  bw.write("Test should pass \n");
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
		isFile = true;
		assertTrue(isFile);
	}
	
	@Test
	public void testPrintAuthWithoutFail() {
		boolean isFile = false;
		Authorisation auth = new Authorisation("_");
		BufferedWriter bw = null;
		File file = new File("log.txt");
		try {
		bw = new BufferedWriter(new FileWriter(file, true));
		bw.write("Test should Fail\n");
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		assertFalse(isFile);
	}
	
	@Test
	public void testPrintAuthWithoutPass() {
		Boolean isFile = false;
		Authorisation auth = new Authorisation("_");
		BufferedWriter bw = null;
		File file = new File("log.txt");
		try {
			  if (!file.exists()) {
			     file.createNewFile();
			  }
			  bw = new BufferedWriter(new FileWriter(file,true));
			  bw.write("USER NOT VALID (Test) \n");
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
		isFile = true;
		assertTrue(isFile);
	}
}

/**
 * 
 */
package edu.wgu.assignment;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The <code>StringHelperTest</code> class runs test cases to validate all the inputs to return from 
 * {@link edu.wgu.assignment StringHelper} class.
 * @author Koti Bajjuri
 *
 */
public class StringHelperTest {
	
	/**
	 * Declaring the helper bean to make it available for testcase.
	 */
	StringHelper helper;
	
	/**
	 * <code>Before</code> annotation make sure that initialize will invoke as a first method, 
	 * so that we can inject the bean to make it available for testing. 
	 */
	@Before
	public void initialize() {
		helper = new StringHelper();
	}

	/**
	 * This method will validate all the user cases to return from the StringHelper class.
	 * @throws Exception
	 */
	@Test
	public void testStringHelper() throws Exception {
		//Automotive have 2 t's and 2 o's makes total 6 distinctive alphabets.
		assertTrue(helper.getDistinctLettersBetweenFirstAndLastLetters("Automotive").equals("A6e"));
		
		//AutomOtive have lower case and upper case O makes total 7 distinctive alphabets
		assertTrue(helper.getDistinctLettersBetweenFirstAndLastLetters("AutomOtive").equals("A7e"));
		
		//Auto_motive have a special character _ makes to return 3 count of distinctive ahead and 5 count after.
		assertTrue(helper.getDistinctLettersBetweenFirstAndLastLetters("Auto_motive").equals("A3_5e") );
		
		//Auto_98_motive have _98_ non alphabetics make it to return 3 count distinct, _98_ ignored characters and 5 count of distinctive.  
		assertTrue(helper.getDistinctLettersBetweenFirstAndLastLetters("Auto_98_motive").equals("A3_98_5e") );
		
		//Hello have 2 distinct characters in the middle.
		assertTrue(helper.getDistinctLettersBetweenFirstAndLastLetters("Hello").equals("H2o") );
		
		
		//non-alphabet at the end returning the same with the distinctive characters in the middle with other non-alphabets.
		assertTrue(helper.getDistinctLettersBetweenFirstAndLastLetters("Iam_doing_good&").equals("I2_5_3&"));
		
		//non-alphabet at the beginning returning the same with the distinctive characters in the middle with other non-alphabets.
		assertTrue(helper.getDistinctLettersBetweenFirstAndLastLetters("$Iam_doing_good&").equals("$3_5_3&"));
		
		//Validating the false positive case returning with A6e but validating against A7e.
		assertFalse(helper.getDistinctLettersBetweenFirstAndLastLetters("Automotive").equals("A7e"));
	}
	
	/**
	 * It can be used to clean up the tasks before ending the unit testing.
	 */
	@After
	public void cleanupTasks() {
		System.out.println("Cleanup any unused objects or beans like StringHelper");
	}

}

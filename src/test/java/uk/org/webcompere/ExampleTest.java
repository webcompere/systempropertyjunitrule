package uk.org.webcompere;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;

/**
 * Quick example of how to use this using a simpler test than that used to verify
 * that the mechanism works
 *
 * The test within this class will only work if the system property "run.test" is set to "true"
 * 
 * To demo this running try setting the JVM option -Drun.test=true, which you can do in the maven
 * command line, or via your IDE's invocation of the junit runner
 */
public class ExampleTest {
	@Rule
	public RequireSystemProperty property = new RequireSystemProperty("run.test", "true");
	
	@Test
	public void systemPropertyDependentTest() {
		// do some sort of test we only want to do when a system property is set...
		assertTrue(true);
	}
}

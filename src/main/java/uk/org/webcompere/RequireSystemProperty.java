package uk.org.webcompere;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static org.junit.Assume.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * This will filter out tests from running when the system property is not
 * Set to the expected value
 */
public class RequireSystemProperty implements TestRule {
	private String property;
	private String expectedValue;
	
	public RequireSystemProperty(String property, String expectedValue) {
		this.property = property;
		this.expectedValue = expectedValue;
	}
	
	/**
	 * Call this to skip a test if the required property is not as expected
	 */
	public void skipTestIfNotAllowed() {
		assumeThat(System.getProperty(property), is(expectedValue));
	}
	
	@Override
	public Statement apply(final Statement base, Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				skipTestIfNotAllowed();
				base.evaluate();
			}
		};
	}
	

}

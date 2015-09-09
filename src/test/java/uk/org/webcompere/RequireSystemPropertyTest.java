package uk.org.webcompere;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import static org.junit.Assert.*;

@RunWith(Suite.class)
@SuiteClasses({RequireSystemPropertyTest.WithProperty.class, RequireSystemPropertyTest.WithoutPropertyTestsDontRun.class})	
public class RequireSystemPropertyTest {
	public static class WithProperty {
		@Rule
		public RequireSystemProperty property = new RequireSystemProperty("prop", "a");
		
		private static boolean done = false;
		
		@BeforeClass
		public static void makeProperty() {
			System.setProperty("prop", "a");
		}
		
		@Test
		public void doIt() {
			done = true;
		}
		
		@AfterClass
		public static void shouldHaveDoneIt() {
			assertTrue(done);
		}
	}
	
	public static class WithoutPropertyTestsDontRun {
		@Rule
		public RequireSystemProperty property = new RequireSystemProperty("prop", "a");
		
		private static boolean done = false;
		
		@BeforeClass
		public static void makeProperty() {
			System.setProperty("prop", "b");
		}
		
		@Test
		public void doIt() {
			done = true;
		}
		
		@AfterClass
		public static void shouldHaveDoneIt() {
			assertFalse(done);
		}
	}	
}

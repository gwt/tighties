package tighties.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {
	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(ApplicationPresenterTest.class);
		suite.addTestSuite(TightnessServiceTest.class);
		suite.addTestSuite(CachingTightnessServiceTest.class);
		//$JUnit-END$
		return suite;
	}
}

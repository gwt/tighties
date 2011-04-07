package tighties.test;

import junit.framework.TestCase;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

abstract public class DatastoreTest extends TestCase {
	private LocalServiceTestHelper helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
	protected DatastoreService db = DatastoreServiceFactory.getDatastoreService();

	@Override
	protected void setUp() throws Exception {
		helper.setUp();
	}
	
	protected void tearDown() throws Exception {
		helper.tearDown();
	};
}

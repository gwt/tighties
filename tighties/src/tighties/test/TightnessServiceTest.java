package tighties.test;

import tighties.client.Tightness;
import tighties.server.TightnessServiceImpl;

import com.google.appengine.api.datastore.Entity;

public class TightnessServiceTest extends DatastoreTest {
	private TightnessServiceImpl service;

	private Entity getTightnessEntity(final Tightness t) {
		final Entity e = new Entity(Tightness.class.getSimpleName());
		e.setProperty("domain", t.getDomain());
		e.setProperty("views", t.getViews());
		e.setProperty("tighties", t.getTighties());
		return e;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		service = new TightnessServiceImpl();
	}

	public void testGetNotNull() {
		assertNotNull(service.getTopTightSites());
	}

	public void testGetIsEmpty() {
		assertTrue(service.getTopTightSites().length == 0);
	}

	public void testInsert() {
		db.put(getTightnessEntity(new Tightness("a", 0, 0)));
		assertEquals(1, service.getTopTightSites().length);
	}

	public void testSortOrder() {
		db.put(getTightnessEntity(new Tightness("a", 1, 1)));
		db.put(getTightnessEntity(new Tightness("b", 1, 2)));
		db.put(getTightnessEntity(new Tightness("c", 1, 3)));

		assertEquals("c", service.getTopTightSites()[0].getDomain());
		assertEquals("b", service.getTopTightSites()[1].getDomain());
		assertEquals("a", service.getTopTightSites()[2].getDomain());
	}

	public void testAtMostTen() {
		for (int i = 0; i < 100; i++)
			db.put(getTightnessEntity(new Tightness("domain" + i, 0, i)));

		assertEquals(10, service.getTopTightSites().length);
	}
	
	public void testIncreaseTighties() {
		db.put(getTightnessEntity(new Tightness("a", 0, 0)));
		service.incrementTighties("a");

		assertEquals(1, service.getTopTightSites()[0].getTighties());
	}
	
	public void testIncreaseViews() {
		db.put(getTightnessEntity(new Tightness("a", 0, 0)));
		service.incrementViews("a");
		
		assertEquals(1, service.getTopTightSites()[0].getViews());
	}
	
	public void testGetTightnessFresh() {
		db.put(getTightnessEntity(new Tightness("a", 0, 0)));

		assertEquals(0, service.getTightnessByDomain("a").getTighties());
	}
	
	public void testGetTightnessIncremented() {
		db.put(getTightnessEntity(new Tightness("a", 0, 0)));
		service.incrementTighties("a");
		
		assertEquals(1, service.getTightnessByDomain("a").getTighties());
	}

}

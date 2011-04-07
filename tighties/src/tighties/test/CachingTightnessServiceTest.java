package tighties.test;

import tighties.server.CachingTightnessServiceImpl;

public class CachingTightnessServiceTest extends DatastoreTest {
	private CachingTightnessServiceImpl service;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.service = new CachingTightnessServiceImpl();
	}
	
	public void testGetEmpty() {
		assertEquals(0, service.getTopTightSites().length);
	}

	public void testGetOne() {
		service.incrementTighties("heise.de");
		
		assertEquals(1, service.getTopTightSites().length);
		assertEquals("heise.de", service.getTopTightSites()[0].getDomain());
	}

	
	public void testInsert() {
		service.incrementTighties("heise.de");
		assertEquals(1, service.getTightnessByDomain("heise.de").getTighties());
		assertEquals(1, service.getTopTightSites()[0].getTighties());
		
		service.incrementTighties("heise.de");
		assertEquals(2, service.getTightnessByDomain("heise.de").getTighties());
		assertEquals(2, service.getTopTightSites()[0].getTighties());
	}
}

package tighties.server;

import java.util.ArrayList;

import tighties.client.Tightness;
import tighties.client.TightnessService;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class TightnessServiceImpl extends RemoteServiceServlet implements TightnessService {
	private static final long serialVersionUID = 6803736245591814628L;
	private static final DatastoreService db = DatastoreServiceFactory.getDatastoreService();

	@Override
	public void incrementViews(String domain) {
		incrementIntegerField(domain, "views");
	}

	@Override
	public void incrementTighties(String domain) {
		incrementIntegerField(domain, "tighties");
	}
	
	/**
	 * Increment the value of a given integer field (fieldName) of the entity specified by its domain field by one.
	 * @param domain	The domain of the entity t
	 * @param fieldName
	 */
	private void incrementIntegerField(final String domain, final String fieldName) {
		final Query q = new Query(Tightness.class.getSimpleName());
		q.addFilter("domain", FilterOperator.EQUAL, domain);
		
		Entity e = db.prepare(q).asSingleEntity();
		
		if (null == e) {
			// domain does not exist yet
			e = new Entity(Tightness.class.getSimpleName());
			e.setProperty("domain", domain);
			e.setProperty("views", 0);
			e.setProperty("tighties", 0);
		}
		
		e.setProperty(fieldName, 1 + Integer.parseInt(String.valueOf(e.getProperty(fieldName))));
		
		db.put(e);
	}

	@Override
	public Tightness[] getTopTightSites() {
		final Query q = new Query(Tightness.class.getSimpleName());
		q.addSort("tighties", SortDirection.DESCENDING);

		final ArrayList<Tightness> l = new ArrayList<Tightness>();
		for (final Entity e: db.prepare(q).asIterable(FetchOptions.Builder.withLimit(10))) {
			l.add(new Tightness(String.valueOf(e.getProperty("domain")), Integer.parseInt(String.valueOf(e.getProperty("views"))), Integer.parseInt(String.valueOf(e.getProperty("tighties")))));
		}
		
		return l.toArray(new Tightness[0]);
	}
}

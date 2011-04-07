package tighties.server;

import java.util.HashMap;

import tighties.client.Tightness;

public class CachingTightnessServiceImpl extends TightnessServiceImpl {
	private static final long serialVersionUID = 7907398206606911297L;

	private Tightness[] topSites;
	private HashMap<String, Tightness> tightnessByDomain = new HashMap<String, Tightness>();

	@Override
	public int incrementTighties(String domain) {
		clearCache();
		return super.incrementTighties(domain);
	}

	@Override
	public int incrementViews(String domain) {
		clearCache();
		return super.incrementViews(domain);
	}

	@Override
	public Tightness getTightnessByDomain(String domain) {
		if (!tightnessByDomain.containsKey(domain)) {
			tightnessByDomain.put(domain, super.getTightnessByDomain(domain));
		}
		return tightnessByDomain.get(tightnessByDomain);
	}

	@Override
	public Tightness[] getTopTightSites() {
		if (null == topSites) {
			topSites = super.getTopTightSites();
		}
		return topSites;
	}

	private void clearCache() {
		topSites = null;
		tightnessByDomain.clear();
	}
}

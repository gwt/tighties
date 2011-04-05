package tighties.client;

import java.io.Serializable;

public class Tightness implements Serializable {
	private static final long serialVersionUID = 1600968766844339139L;
	private String domain;
	private int views;
	private int tighties;

	public Tightness() {
	}

	public Tightness(final String domain, final int views, final int tighties) {
		this.domain = domain;
		this.views = views;
		this.tighties = tighties;
	}
	
	public String getDomain() {
		return domain;
	}
	
	public int getTighties() {
		return tighties;
	}

	public int getViews() {
		return views;
	}
}

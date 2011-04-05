package tighties.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TightnessServiceAsync {
	void incrementTighties(String domain, AsyncCallback<Integer> callback);
	void incrementViews(String domain, AsyncCallback<Integer> callback);
	void getTopTightSites(AsyncCallback<Tightness[]> callback);
	void getTightnessByDomain(String domain, AsyncCallback<Tightness> callback);
}

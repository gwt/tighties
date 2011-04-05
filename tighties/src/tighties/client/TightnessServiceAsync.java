package tighties.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TightnessServiceAsync {
	void incrementTighties(String domain, AsyncCallback<Void> callback);
	void incrementViews(String domain, AsyncCallback<Void> callback);
	void getTopTightSites(AsyncCallback<Tightness[]> callback);
}

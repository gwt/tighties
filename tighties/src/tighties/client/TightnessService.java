package tighties.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("tightness")
public interface TightnessService extends RemoteService {
	void incrementViews(String domain);
	void incrementTighties(String domain);
	Tightness[] getTopTightSites();
}

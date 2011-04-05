package tighties.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("tightness")
public interface TightnessService extends RemoteService {
	int incrementViews(String domain);
	int incrementTighties(String domain);
	Tightness[] getTopTightSites();
	Tightness getTightnessByDomain(String domain);
}

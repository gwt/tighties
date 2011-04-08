package tighties.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class AsyncProvider {
	// create it to avoid reloading additional javascript source
	private static TightnessServiceAsync service = GWT.create(TightnessService.class);

	public static void get(final AsyncCallback<TightnessServiceAsync> callback) {
		callback.onSuccess(service);
	}
}

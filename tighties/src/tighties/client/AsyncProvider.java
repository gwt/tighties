package tighties.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class AsyncProvider {
	private static TightnessServiceAsync service;

	public static void get(final AsyncCallback<TightnessServiceAsync> callback) {
		GWT.runAsync(new RunAsyncCallback() {
			@Override
			public void onSuccess() {
				if (null == service) {
					service = GWT.create(TightnessService.class);
				}
				callback.onSuccess(service);
			}
			
			@Override
			public void onFailure(final Throwable reason) {
				callback.onFailure(reason);
			}
		});
	}
}

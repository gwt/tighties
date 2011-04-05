package tighties.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class ApplicationPresenter {
	public interface Display {
		void addToGrid(String domain, int tighties);
	}

	private Display display;

	public ApplicationPresenter(final Display display) {
		this.display = display;
		insertTopSites();
	}

	private void insertTopSites() {
		AsyncProvider.get(new AsyncCallback<TightnessServiceAsync>() {
			@Override
			public void onSuccess(TightnessServiceAsync service) {
				service.getTopTightSites(new AsyncCallback<Tightness[]>() {
					@Override
					public void onSuccess(Tightness[] result) {
						for (final Tightness t: result) {
							display.addToGrid(t.getDomain(), t.getTighties());
						}
					}
					
					@Override
					public void onFailure(Throwable caught) {
					}
				});
			}
			
			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
}

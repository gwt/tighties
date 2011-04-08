package tighties.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ApplicationPresenter {
	private static final TightnessServiceAsync service = GWT.create(TightnessService.class);

	public interface Display {
		void addToGrid(String domain, int tighties);
	}

	private Display display;

	public ApplicationPresenter(final Display display) {
		this.display = display;
		insertTopSites();
//		measureRoundtripTime(10);
	}
/*
	private void measureRoundtripTime(final int times) {
		if (times == 0) {
			// stop measuring the timing
		} else {
			final long before = System.currentTimeMillis();
			
			service.hello(new AsyncCallback<Void>() {
				@Override
				public void onSuccess(Void result) {
					appendLogText((System.currentTimeMillis() - before) + "ms");
					measureRoundtripTime(times - 1);
				}
				
				@Override
				public void onFailure(Throwable caught) {
					appendLogText("[F]" + (System.currentTimeMillis() - before) + "ms");
				}
			});
		}
	}*/

	private void insertTopSites() {
		service.getTopTightSites(new AsyncCallback<Tightness[]>() {
			@Override
			public void onSuccess(Tightness[] result) {
				for (final Tightness t : result) {
					display.addToGrid(t.getDomain(), t.getTighties());
				}
			}

			@Override
			public void onFailure(Throwable caught) {
			}
		});
	}
/*
	private void appendLogText(final String text) {
		final String originalText = display.getLog().getText();
		display.getLog().setText(originalText + text + " ");
	}*/
}

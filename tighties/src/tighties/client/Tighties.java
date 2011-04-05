package tighties.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class Tighties implements EntryPoint {
	public void onModuleLoad() {
		if (History.getToken().equals("iframe")) {
			final IFrameView view = new IFrameView();
			RootLayoutPanel.get().add(view);
			new IFramePresenter(view);
		} else {
			final ApplicationView view = new ApplicationView();
			RootLayoutPanel.get().add(view);
			new ApplicationPresenter(view);
		}
	}
}

package tighties.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Tighties implements EntryPoint {
	public void onModuleLoad() {
		final ApplicationView view = new ApplicationView();
		RootLayoutPanel.get().add(view);
		new ApplicationPresenter(view);
	}
}

package tighties.client;

import tighties.client.ApplicationPresenter.Display;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationView extends Composite implements Display {
	private static ApplicationViewUiBinder uiBinder = GWT.create(ApplicationViewUiBinder.class);

	interface ApplicationViewUiBinder extends UiBinder<Widget, ApplicationView> {
	}

	@UiField
	FlexTable grid;

	public ApplicationView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void addToGrid(final String domain, final int tighties) {
		int rowCount = grid.getRowCount();

		grid.setWidget(rowCount, 0, new Anchor(domain, "http://"+domain));
		grid.setHTML(rowCount, 1, String.valueOf(tighties));
	}
}

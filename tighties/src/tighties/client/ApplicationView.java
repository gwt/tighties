package tighties.client;

import java.util.ArrayList;

import tighties.client.ApplicationPresenter.Display;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Widget;

public class ApplicationView extends Composite implements Display {
	private static ApplicationViewUiBinder uiBinder = GWT.create(ApplicationViewUiBinder.class);

	interface ApplicationViewUiBinder extends UiBinder<Widget, ApplicationView> {
	}

	@UiField
	Grid grid;

	public ApplicationView() {
		initWidget(uiBinder.createAndBindUi(this));
	
		grid.setHTML(0, 0, "domain");
		grid.setHTML(0, 1, "tighties");
	}
	
	@Override
	public void addToGrid(final ArrayList<Pair<String, Integer>> data) {
		int rowCount = grid.getRowCount();
		
		for (final Pair<String, Integer> row: data) {
			grid.setHTML(rowCount, 0, row.getLeft());
			grid.setHTML(rowCount, 1, row.getRight().toString());
			rowCount++;
		}
	}
}

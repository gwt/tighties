package tighties.client;

import tighties.client.IFramePresenter.Display;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class IFrameView extends Composite implements Display {
	private static IFrameViewUiBinder uiBinder = GWT.create(IFrameViewUiBinder.class);

	interface IFrameViewUiBinder extends UiBinder<Widget, IFrameView> {
	}
	
	@UiField
	Button button;
	@UiField
	Label tighties;
	
	public IFrameView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override	
	public HasClickHandlers getButton() {
		return button;
	}

	@Override
	public void setTighties(int tighties) {
		this.tighties.setText(String.valueOf(tighties) + " tight" + (1 == tighties ? "y" : "ies"));
	}
}

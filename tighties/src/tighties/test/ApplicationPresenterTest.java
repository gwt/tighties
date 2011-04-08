package tighties.test;

import junit.framework.TestCase;
import tighties.client.ApplicationPresenter;
import tighties.client.ApplicationPresenter.Display;

import com.google.gwt.user.client.ui.HasText;

public class ApplicationPresenterTest extends TestCase {
	public void testCreate() {
		new ApplicationPresenter(new ApplicationViewMock());
	}
	
	class ApplicationViewMock implements Display {
		@Override
		public void addToGrid(String domain, int tighties) {
		}

		@Override
		public HasText getLog() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}

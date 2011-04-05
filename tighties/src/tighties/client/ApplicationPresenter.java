package tighties.client;

import java.util.ArrayList;

public class ApplicationPresenter {
	public interface Display {
		void addToGrid(ArrayList<Pair<String, Integer>> data);
	}

	public ApplicationPresenter(final Display display) {
		display.addToGrid(getRatingData());
	}

	private ArrayList<Pair<String, Integer>> getRatingData() {
		// TODO get data from server
		final ArrayList<Pair<String, Integer>> data = new ArrayList<Pair<String, Integer>>();

		data.add(new Pair<String, Integer>("heise.de", 100));
		data.add(new Pair<String, Integer>("youtube.de", 50));
		data.add(new Pair<String, Integer>("google.com", 10));
		
		return data;
	}
}

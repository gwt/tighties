package tighties.client;

import java.io.Serializable;

public class Pair<L, R> implements Serializable {
	private static final long serialVersionUID = -7143663055324729855L;
	private L left;
	private R right;

	public Pair() {
	}
	
	public Pair(final L left, final R right) {
		this.left = left;
		this.right = right;
	}

	public L getLeft() {
		return left;
	}

	public R getRight() {
		return right;
	}
}

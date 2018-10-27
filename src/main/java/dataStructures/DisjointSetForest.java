package dataStructures;

import static shared.ADTFactories.ADTs;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;

/**
 * This class implements the {@link DisjointSet} interface. Each equivalence
 * class is represented by a rooted tree (so the whole structure is represented
 * by a forest), and "path compression" and "union by rank" principles are
 * utilized in order to receive good amortized bounds.
 * 
 * @param <T> The type of the objects that are stored in the structure
 */
public class DisjointSetForest<T> implements DisjointSet<T> {

	/**
	 * This object maps the items of the structure to their nodes.
	 */
	private Map<T, Node> nodes;

	/**
	 * @invariant <code>totalItems</code> equals the total number of items in the
	 *            structure.
	 */
	private int itemsCount;

	/**
	 * @invariant <code>totalSets</code> equals the total number of sets
	 *            (equivalence classes) in the structure.
	 */
	private int setsCount;

	public DisjointSetForest() {
		nodes = ADTs().genMap();
		itemsCount = 0;
		setsCount = 0;
	}

	@Override
	public void makeSet(T x) {
		assert (x != null && !nodes.containsKey(x));

		nodes.put(x, new Node(x));
		itemsCount++;
		setsCount++;
	}

	@Override
	public void union(T x, T y) {
		assert (x != null && y != null && nodes.containsKey(x) && nodes.containsKey(y));

		link(nodes.get(findSet(x)), nodes.get(findSet(y)));
		setsCount--;
	}

	@Override
	public T findSet(T x) {
		assert (x != null && nodes.containsKey(x));

		return findSet(nodes.get(x)).item;
	}

	/**
	 * This method returns the node that wraps the representative of the equivalence
	 * class that contains <code>node.item</code>.
	 * 
	 * @param x
	 * @preconditions node != null
	 * @return the node that wraps the representative of the set that contains
	 *         <code>node.item</code>
	 */
	private Node findSet(Node node) {
		assert (node != null);

		if (node.parent != node) {
			node.parent = findSet(node.parent);
		}
		return node.parent;
	}

	/**
	 * This method links two nodes.
	 * 
	 * @param x
	 * @param y
	 * @preconditions
	 *                <ol>
	 *                <li><code>x, y != null</code></li>
	 *                <li><code>findSet(x).equals(findSet(y))</code></li>
	 *                <li><code>x.item</code> and <code>y.item</code> are the
	 *                representatives of their classes (that is,
	 *                <code>x.getParent().equals(x), y.getParent().equals(y)</code>)</li>
	 *                </ol>
	 */
	private void link(Node x, Node y) {
		assert (x != null && y != null);

		if (x.rank > y.rank) {
			y.parent = x;
		} else {
			x.parent = y;
			if (x.rank == y.rank) {
				y.rank++;
			}
		}
	}

	@Override
	public int itemsCount() {
		return itemsCount;
	}

	@Override
	public int setsCount() {
		return setsCount;
	}

	@Override
	public void addAll(Collection<T> collection) {
		assert (collection != null);
		addAll(collection.stream());
	}

	@Override
	public void addAll(Stream<T> stream) {
		assert (stream != null);
		stream.forEach(this::makeSet);
	}

	/**
	 * This class defines a single node in the forest. Every element <code>T</code>
	 * in the structure is packed in <code>this</code> object.
	 * 
	 * Invariant: <code>x.getParent().equals(x)</code> iff <code>x.item</code> is
	 * the representative of its equivalence set.
	 */
	private class Node {

		/**
		 * The item that is packed in <code>this</code> node
		 */
		private final T item;

		/**
		 * The parent of <code>this</code> node
		 */
		private Node parent;

		/**
		 * The rank of <code>this</code> node
		 */
		private int rank;

		private Node(T item) {
			this.item = item;
			this.parent = this;
			this.rank = 0;
		}
	}
}
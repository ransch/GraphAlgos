package dataStructures;

import static shared.ADTFactories.ADTs;

import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * This class implements the {@link PriorityQueue} interface. It follows the
 * data structure that was invented by Hansen, Kaplan, Tarjan and Zwick in 2015.
 * 
 * @param <T> The type of objects that are stored in the heap
 */
public class HollowHeap<T> implements PriorityQueue<T> {

	/**
	 * This field points the node that contains the item with the minimal key.
	 */
	private Node min;

	/**
	 * This structure maps the items of the queue to their nodes.
	 */
	private Map<T, Node> nodes;

	/**
	 * @invariant <code>totalNodes</code> equals the total number of nodes (either
	 *            full or hollow) in the forest.
	 */
	private int totalNodes;

	public HollowHeap() {
		nodes = ADTs().genMap();
	}

	@Override
	public void insert(T item, double key) {
		assert (item != null && !nodes.containsKey(item));
		this.min = meld(makenode(item, key), this.min);
	}

	@Override
	public Optional<T> findMin() {
		if (this.min == null) {
			return Optional.empty();
		}
		return Optional.of(this.min.item);
	}

	@Override
	public void deleteMin() {
		assert (this.size() > 0);
		delete(this.min.item);
	}

	@Override
	public void delete(T item) {
		assert (item != null && nodes.containsKey(item));

		var h = this.min;
		nodes.get(item).item = null;
		nodes.remove(item);
		if (h.item != null) { // Non-minimum deletion
			return;
		}

		Object[] A = new Object[(int) (Math.log(totalNodes + 1) / Math.log(1.5)) + 1];
		var maxRank = 0;
		h.next = null;

		while (h != null) { // While L is not empty
			var w = h.child;
			var v = h;
			h = h.next;
			while (w != null) {
				var u = w;
				w = w.next;
				if (u.item == null) { // u is hollow
					if (u.ep == null) { // v is the only parent
						u.next = h; // add u to L
						h = u;
					} else { // u has two parents
						if (u.ep == v) { // v is the second parent
							w = null;
						} else { // v is the first parent
							u.next = null;
						}
						u.ep = null;
					}
				} else { // u is full
					maxRank = doRankedLinks(A, maxRank, u);
				}
			}

			nodes.remove(v);
			totalNodes--;
		}

		h = doUnrankedLinks(A, maxRank, h);

		this.min = h;
	}

	@Override
	public int size() {
		return nodes.size();
	}

	@Override
	public void decreaseKey(T item, double newK) {
		assert (item != null && nodes.containsKey(item) && getKey(item).getAsDouble() > newK);

		var u = nodes.get(item);
		if (u == this.min) {
			u.key = newK;
			return;
		}

		var v = makenode(item, newK);
		u.item = null;
		if (u.rank > 2) {
			v.rank = u.rank - 2;
		}
		v.child = u;
		u.ep = v;
		this.min = link(v, this.min);
	}

	/**
	 * This method meld a given heap with the current heap. After calling this
	 * method, <code>heap</code> must not be accessed.
	 * 
	 * @param heap
	 * @preconditions
	 *                <ol>
	 *                <li><code>heap != null</code></li>
	 *                <li><code>this</code> and <code>heap</code> are disjoint</li>
	 *                </ol>
	 */
	public void meld(HollowHeap<T> heap) {
		assert (heap != null);

		this.min = meld(this.min, heap.min);
		this.nodes.putAll(heap.nodes);
	}

	/**
	 * This method meld two dags, given by their roots.
	 * 
	 * @param g The root of the first dag
	 * @param h The root of the second dag
	 * @preconditions <code>g != null || h != null</code>
	 * @return The root of the resulted dag
	 */
	private Node meld(Node g, Node h) {
		assert (g != null || h != null);

		if (h == null) {
			return g;
		}
		if (g == null) {
			return h;
		}
		return link(g, h);
	}

	/**
	 * This method links two full roots - it compares their keys and makes the root
	 * of larger key a child of the other, breaking a tie arbitrarily. The new child
	 * is the loser of the link; its new parent is the winner.
	 * 
	 * @param v
	 * @param w
	 * @preconditions
	 *                <ol>
	 *                <li><code>v, w != null</code></li>
	 *                <li><code>v.item, w.item != null</code></li>
	 *                </ol>
	 * @return The winner of the link
	 */
	private Node link(Node v, Node w) {
		assert (v != null && w != null && v.item != null && w.item != null);

		if (v.key >= w.key) {
			addChild(v, w);
			return w;
		}

		addChild(w, v);
		return v;
	}

	private void addChild(Node v, Node w) {
		assert (v != null && w != null && v.item != null && w.item != null);

		v.next = w.child;
		w.child = v;
	}

	/**
	 * This method gets an array of the full roots in the heap and links them via
	 * unranked links until there is at exactly one.
	 * 
	 * @param A       An array of the full roots in the heap, indexed by rank
	 * @param maxRank The maximal rank indexed in <code>A</code>
	 * @param u       A new node that should be linked into <code>A</code>
	 * @preconditions
	 *                <ol>
	 *                <li><code>A != null</code></li>
	 *                <li><code>A.length &gt maxRank</code></li>
	 *                <li>$maxRank \neq 0 \rightarrow \Big( A[maxRank] \neq null
	 *                \wedge \forall i>maxRank,A[i]=null \Big)$</li>
	 *                <li>Every item in <code>A</code> is a Node</li>
	 *                <li>$\forall 0 \leq i \leq maxRank, A[i].item \neq null$</li>
	 *                </ol>
	 * @return The only (full) root that has remained
	 */
	private Node doUnrankedLinks(Object[] A, int maxRank, Node h) {
		assert (A != null && A.length >= maxRank);

		for (var i = 0; i <= maxRank; i++) {
			@SuppressWarnings("unchecked")
			var ai = (Node) A[i];
			if (A[i] != null) {
				if (h == null) {
					h = ai;
				} else {
					h = link(h, ai);
				}
			}
		}

		return h;
	}

	/**
	 * This method makes ranked links until none are possible, that is, all roots
	 * have different ranks.
	 * 
	 * @param A       An array of the full roots in the heap, indexed by rank
	 * @param maxRank The maximal rank indexed in <code>A</code>
	 * @param u       A new node that should be linked into <code>A</code>
	 * @preconditions
	 *                <ol>
	 *                <li><code>A, u != null</code></li>
	 *                <li><code>A.length &gt maxRank</code></li>
	 *                <li><code>u.item != null</code></li>
	 *                <li>$maxRank \neq 0 \rightarrow \Big( A[maxRank] \neq null
	 *                \wedge \forall i>maxRank,A[i]=null \Big)$</li>
	 *                <li>Every item in <code>A</code> is a Node</li>
	 *                <li>$\forall 0 \leq i \leq maxRank, A[i].item \neq null$</li>
	 *                </ol>
	 * @return The maximal rank indexed in A (after the linkage)
	 */
	private int doRankedLinks(Object[] A, int maxRank, Node u) {
		assert (A != null && u != null && A.length >= maxRank && u.item != null);

		while (A[u.rank] != null) {
			@SuppressWarnings("unchecked")
			Node aurank = (Node) A[u.rank];
			u = link(u, aurank);
			A[u.rank] = null;
			u.rank = u.rank + 1;
		}
		A[u.rank] = u;
		if (u.rank > maxRank) {
			maxRank = u.rank;
		}
		return maxRank;
	}

	private Node makenode(T item, double key) {
		assert (item != null);

		totalNodes++;
		var node = new Node(item, key);
		nodes.put(item, node);
		return node;
	}

	@Override
	public OptionalDouble getKey(T item) {
		HollowHeap<T>.Node k = nodes.get(item);
		return k != null ? OptionalDouble.of(k.key) : OptionalDouble.empty();
	}

	@Override
	public void addAll(Map<T, Double> map) {
		map.entrySet().forEach(entry -> this.insert(entry.getKey(), entry.getValue()));
	}

	/**
	 * This class defines a node in the structure.
	 */
	private class Node {

		/**
		 * The item that is stored in <code>this</code> node.
		 */
		private T item;

		/**
		 * The child of <code>this</code> node.
		 */
		private Node child;

		/**
		 * The next node.
		 */
		private Node next;

		/**
		 * The extra parent of <code>this</code> node.
		 */
		private Node ep;

		/**
		 * The key of <code>this</code> node.
		 */
		private double key;

		/**
		 * The rank of <code>this</code> node.
		 */
		private int rank;

		/**
		 * @param item
		 * @param key
		 * @preconditions <code>item != null</code>
		 */
		private Node(T item, double key) {
			assert (item != null);

			this.item = item;
			this.child = null;
			this.next = null;
			this.ep = null;
			this.key = key;
			this.rank = 0;
		}
	}
}
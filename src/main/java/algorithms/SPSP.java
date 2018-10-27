package algorithms;

import static shared.ADTFactories.ADTs;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import dataStructures.graph.DirectedGraph;
import dataStructures.graph.Edge;
import dataStructures.graph.Graph;
import dataStructures.graph.Vertex;
import dataStructures.graph.Weight;

/**
 * This class bundles several algorithms that solve the single-pair
 * shortest-paths problem: given a simple directed graph and two vertices, the
 * algorithms compute a shortest path (i.e. a path with minimal weight) from the
 * first vertex to the second.
 */
public class SPSP {

	/**
	 * This method computes a shortest path (i.e. a path with minimal weight) from
	 * <code>u</code> to <code>v</code>, using the Bellman-Ford algorithm. If there
	 * exists a negative-weight cycle that is reachable from <code>u</code>, or if
	 * <code>v</code> is not reachable from <code>u</code>, an empty list is
	 * returned; Otherwise, the computed path is returned.
	 * 
	 * @param g
	 * @param u
	 * @param v
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, u, v != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                <li><code>u, v</code> have been inserted into
	 *                <code>g</code></li>
	 *                </ol>
	 * @return $\text{\text{If [there exists a negative-weight cycle that is
	 *         reachable from u]} \vee \neg \exists p:u \leadsto v, [ret] = []
	 *         \text{. Otherwise, [ret] forms a shortest path from u to v}$
	 */
	public static <V, E extends Weight> List<Edge<V, E>> BellmanFord(DirectedGraph<V, E> g, Vertex<V> u, Vertex<V> v) {
		Optional<Map<Vertex<V>, Edge<V, E>>> opt = SSSP.BellmanFord(g, u);
		if (!opt.isPresent()) {
			return ADTs().genList();
		}
		return shortestPathsTreeToPath(opt.get(), v);
	}

	/**
	 * This method computes a shortest path (i.e. a path with minimal weight) from
	 * <code>u</code> to <code>v</code> in a DAG, using an adapted version of the
	 * Bellman-Ford algorithm, which is optimal. If <code>v</code> is not reachable
	 * from <code>u</code>, an empty list is returned; Otherwise, the computed path
	 * is returned.
	 * 
	 * @param g
	 * @param u
	 * @param v
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, u, v != null</code></li>
	 *                <li><code>g</code> is simple and acyclic</li>
	 *                <li><code>u, v</code> have been inserted into
	 *                <code>g</code></li>
	 *                </ol>
	 * @return $\Big( \exists p:u \leadsto v \Big) \rightarrow \Big( \text{ [ret]
	 *         forms a shortest path from u to v } \Big) \; ; \; \Big( \neg \exists
	 *         p:u \leadsto v \Big) \rightarrow [ret]=[]$
	 */
	public static <V, E extends Weight> List<Edge<V, E>> DAG(DirectedGraph<V, E> g, Vertex<V> u, Vertex<V> v) {
		return shortestPathsTreeToPath(SSSP.DAG(g, u), v);
	}

	/**
	 * This method computes a shortest path (i.e. a path with minimal weight) from
	 * <code>u</code> to <code>v</code>, assuming all the edges that are placed in a
	 * path from <code>u</code> to some other vertex <code>w</code> have nonnegative
	 * weights, using the Dijkstra algorithm. If <code>v</code> is not reachable
	 * from <code>u</code>, an empty list is returned; Otherwise, the computed path
	 * is returned.
	 * 
	 * @param g
	 * @param u
	 * @param v
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, u, v != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                <li><code>u, v</code> have been inserted into
	 *                <code>g</code></li>
	 *                <li>$\forall e= \langle a,b \rangle \in g.E, \big[ \exists
	 *                p:u\leadsto a \big] \rightarrow w(e) \geq 0$</li>
	 *                </ol>
	 * @return $\Big( \exists p:u \leadsto v \Big) \rightarrow \Big( \text{ [ret]
	 *         forms a shortest path from u to v } \Big) \; ; \; \Big( \neg \exists
	 *         p:u \leadsto v \Big) \rightarrow [ret]=[]$
	 */
	public static <V, E extends Weight> List<Edge<V, E>> Dijkstra(DirectedGraph<V, E> g, Vertex<V> u, Vertex<V> v) {
		return shortestPathsTreeToPath(SSSP.Dijkstra(g, u), v);
	}

	/**
	 * This method computes a shortest path (i.e. a path with fewest edges) from
	 * <code>u</code> to <code>v</code>. If <code>v</code> is not reachable from
	 * <code>u</code>, an empty list is returned; Otherwise, the computed path is
	 * returned.
	 * 
	 * @param g
	 * @param s
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, u, v != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                <li><code>u, v</code> have been inserted into
	 *                <code>g</code></li>
	 *                </ol>
	 * @return $\Big( \exists p:u \leadsto v \Big) \rightarrow \Big( \text{ [ret]
	 *         forms a shortest path from u to v } \Big) \; ; \; \Big( \neg \exists
	 *         p:u \leadsto v \Big) \rightarrow [ret]=[]$
	 */
	public static <V, E> List<Edge<V, E>> unitWeights(Graph<V, E> g, Vertex<V> u, Vertex<V> v) {
		return shortestPathsTreeToPath(SSSP.unitWeights(g, u), v);
	}

	/**
	 * This method converts a shortest-paths tree into a path between the root of
	 * the tree and a given destination vertex. The tree is represented by a
	 * {@link Map} as described in {@link SSSP}.
	 * 
	 * @param tree
	 * @param dest
	 * @return A shortest path from the root of <code>tree</code> to
	 *         <code>dest</code>
	 */
	private static <V, E> List<Edge<V, E>> shortestPathsTreeToPath(Map<Vertex<V>, Edge<V, E>> tree, Vertex<V> dest) {
		List<Edge<V, E>> res = ADTs().genList();
		var edge = tree.get(dest);

		if (edge == null) {
			return res;
		}

		do {
			res.add(0, edge);
			edge = tree.get(edge.getA());
		} while (edge != null);

		return res;
	}
}
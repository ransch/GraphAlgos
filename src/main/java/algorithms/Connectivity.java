package algorithms;

import static shared.ADTFactories.ADTs;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import dataStructures.graph.Graph;
import dataStructures.graph.UndirectedGraph;
import dataStructures.graph.Vertex;

public class Connectivity {

	/**
	 * This method checks if <code>u</code> is reachable from <code>v</code>.
	 * 
	 * @param g
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, v, u != null</code></li>
	 *                <li>Both <code>v</code> and <code>u</code> have been already
	 *                inserted into the graph</li>
	 *                <li><code>g</code> is simple</li>
	 *                </ol>
	 * @return <code>true</code> iff <code>u</code> is reachable from <code>v</code>
	 */
	public static <V, E> boolean are(Graph<V, E> g, Vertex<V> v, Vertex<V> u) {
		if (v.equals(u)) {
			return true;
		}
		return BFS.traverse(g, v, w -> false, (e, w) -> w == u);
	}

	/**
	 * This method returns all the reachable vertices from a given vertex.
	 * 
	 * @param g
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, v != null</code></li>
	 *                <li><code>v</code> has been already inserted into the
	 *                graph</li>
	 *                <li><code>g</code> is simple</li>
	 *                </ol>
	 * @return $\{u \big| u \in g.V \wedge \exists p:v\leadsto u\}$
	 */
	public static <V, E> Set<Vertex<V>> find(Graph<V, E> g, Vertex<V> v) {
		Set<Vertex<V>> res = ADTs().genSet();
		BFS.traverse(g, v, u -> {
			res.add(u);
			return false;
		}, (e, w) -> false);
		return res;
	}

	/**
	 * This method returns <code>true</code> iff <code>g</code> is connected.
	 * 
	 * @param g
	 * @preconditions
	 *                <ol>
	 *                <li><code>g != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                </ol>
	 * @return <code>true</code> iff <code>g</code> is connected
	 */
	public static <V, E> boolean connected(UndirectedGraph<V, E> g) {
		Map<Vertex<V>, Integer> distances = ADTs().genMap();
		Optional<Vertex<V>> opt = g.vertices().findFirst();
		if (opt.isPresent()) {
			BFS.traverse(g, opt.get(), distances);
			return distances.size() == g.verticesCount();
		}
		return true;
	}

	/**
	 * This method returns the connected component of a given undirected graph.
	 * 
	 * @param g
	 * @preconditions
	 *                <ol>
	 *                <li><code>g != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                </ol>
	 * @return A list that contains sets of vertices; Each set forms a connected
	 *         component
	 */
	public static <V, E> List<Set<Vertex<V>>> connectedComponents(UndirectedGraph<V, E> g) {
		List<Set<Vertex<V>>> res = ADTs().genList();
		BFS.traverseExhaustive(g, () -> {
			Set<Vertex<V>> s = ADTs().genSet();
			res.add(s);
			return s;
		}, (s, v) -> {
			s.add(v);
		});
		return res;
	}
}
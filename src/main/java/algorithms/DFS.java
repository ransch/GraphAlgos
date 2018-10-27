package algorithms;

import java.util.Map;
import java.util.stream.Collectors;

import algorithms.Functions.Function1Par;
import algorithms.Functions.Function2Par;
import dataStructures.graph.Edge;
import dataStructures.graph.Graph;
import dataStructures.graph.Vertex;

/**
 * This class defines methods run depth-first searches.
 */
/* package */ class DFS {

	/**
	 * This method does a depth-first search on a given graph, and runs the user's
	 * code during the traversal. The search is terminated if one of the user's
	 * functions returns <code>true</code>.
	 * 
	 * @param g
	 * @param block1 This code runs on a vertex $v$ when an edge $(u,v)$ is
	 *               discovered
	 * @param block2 This code runs on each vertex when it is marked as "seen"
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, block1, block2 != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                </ol>
	 * @return <code>true</code> iff the search was terminated by one of the user's
	 *         functions
	 */
	/* package */ static <V, E> boolean traverse(Graph<V, E> g, Function2Par<Vertex<V>, Byte, Boolean> block1,
			Function1Par<Vertex<V>, Boolean> block2) {
		Map<Vertex<V>, Byte> seen = g.vertices()
				.collect(Collectors.toMap(java.util.function.Function.identity(), v -> (byte) 0));

		for (var iter = g.vertices().iterator(); iter.hasNext();) {
			var u = iter.next();
			if (seen.get(u) == 0 && visit(g, seen, u, block1, block2)) {
				return true;
			}
		}

		return false;
	}

	private static <V, E> boolean visit(Graph<V, E> g, Map<Vertex<V>, Byte> seen, Vertex<V> u,
			Function2Par<Vertex<V>, Byte, Boolean> block1, Function1Par<Vertex<V>, Boolean> block2) {
		seen.put(u, (byte) 1);

		for (var iter = g.outgoing(u).map(Edge::getB).iterator(); iter.hasNext();) {
			var v = iter.next();
			if (block1.run(v, seen.get(v))) {
				return true;
			}
			if (seen.get(v) == 0) {
				if (visit(g, seen, v, block1, block2)) {
					return true;
				}
			}
		}

		seen.put(u, (byte) 2);
		if (block2.run(u)) {
			return true;
		}
		return false;
	}
}
package algorithms;

import static shared.ADTFactories.ADTs;

import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

import algorithms.Functions.Function0Par;
import algorithms.Functions.Function1Par;
import algorithms.Functions.Function2Par;
import algorithms.Functions.Void2Par;
import dataStructures.graph.Edge;
import dataStructures.graph.Graph;
import dataStructures.graph.Vertex;

/**
 * This class defines methods run breadth-first searches.
 */
/* package */ class BFS {

	/**
	 * This method does a breadth-first search on a given graph, finds all the
	 * reachable vertices from the given source, and calculates the number of edges
	 * of the shortest paths from the source to those vertices.
	 * 
	 * @param g
	 * @param s         The source of the search
	 * @param distances
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, s, distances != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                <li><code>s</code> has already inserted into the graph</li>
	 *                <li><code>distances.size() == 0</code></li>
	 *                </ol>
	 * @postconditions $distances = \{ \langle v,d \rangle \Big| v \; is \;
	 *                 reachable \; from \; s \ \wedge \ d=\big| shortest \; path \;
	 *                 p:s\leadsto v \big| \}$
	 */
	/* package */ static <V, E> void traverse(Graph<V, E> g, Vertex<V> s, Map<Vertex<V>, Integer> distances) {
		traverse(g, s, distances, v -> false, (e, v) -> false);
	}

	/**
	 * This method does a breadth-first search on a given graph, and runs the user's
	 * code during the traversal. The search is terminated if one of the user's
	 * functions returns <code>true</code>.
	 * 
	 * @param g
	 * @param s
	 * @param block1 This code runs on each vertex that is popped from the queue
	 * @param block2 This code runs on each vertex that is a neighbor of the one
	 *               that has been popped from the queue
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, s, block1, block2 != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                <li><code>s</code> has already inserted into the graph</li>
	 *                <li><code>block1</code>, <code>block2</code> are defined only
	 *                on the accessible vertices from <code>s</code> (in
	 *                <code>g</code>)</li>
	 *                </ol>
	 * @return <code>true</code> iff the search was terminated by one of the user's
	 *         functions
	 */
	/* package */ static <V, E> boolean traverse(Graph<V, E> g, Vertex<V> s, Function1Par<Vertex<V>, Boolean> block1,
			Function2Par<Edge<V, E>, Vertex<V>, Boolean> block2) {
		return traverse(g, s, null, block1, block2);
	}

	/**
	 * This method does a breadth-first search on a given graph, and runs the user's
	 * code during the traversal. The search is terminated if one of the user's
	 * functions returns <code>true</code>. Also, the method finds all the reachable
	 * vertices from the given source, and calculates the number of edges of the
	 * shortest paths from the source to those vertices.
	 * 
	 * @param g
	 * @param s         The source of the search
	 * @param distances
	 * @param block1    This code runs on each vertex that is popped from the queue
	 * @param block2    This code runs on each vertex that is a neighbor of the one
	 *                  that has been popped from the queue
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, s, block1, block2 != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                <li><code>s</code> has already inserted into the graph</li>
	 *                <li>if <code>distances != null</code>,
	 *                <code>distances.size() == 0</code></li>
	 *                <li><code>block1</code>, <code>block2</code> are defined only
	 *                on the accessible vertices from <code>s</code> (in
	 *                <code>g</code>)</li>
	 *                </ol>
	 * @return <code>true</code> iff the search was terminated by one of the user's
	 *         functions
	 * @postconditions if <code>distances != null</code>, $distances = \{ \langle
	 *                 v,d \rangle \Big| v \; is \; reachable \; from \; s \ \wedge
	 *                 \ d=\big| shortest \; path \; p:s\leadsto v \big| \}$
	 */
	/* package */ static <V, E> boolean traverse(Graph<V, E> g, Vertex<V> s, Map<Vertex<V>, Integer> distances,
			Function1Par<Vertex<V>, Boolean> block1, Function2Par<Edge<V, E>, Vertex<V>, Boolean> block2) {
		Set<Vertex<V>> seen = ADTs().genSet();
		Queue<Vertex<V>> queue = ADTs().genQueue();
		Vertex<V> u;
		queue.add(s);
		if (distances != null) {
			assert (distances.size() == 0);
			distances.put(s, 0);
		}

		while (queue.size() > 0) {
			u = queue.remove();
			if (!seen.contains(u) && block1.run(u)) {
				return true;
			}
			for (var iter = g.outgoing(u).filter(e -> !seen.contains(e.getB())).iterator(); iter.hasNext();) {
				var e = iter.next();
				var v = e.getB();
				queue.add(v);
				if (distances != null)
					distances.putIfAbsent(v, distances.get(u) + 1);
				if (block2.run(e, v)) {
					return true;
				}
			}
			seen.add(u);
		}

		return false;
	}

	/**
	 * This method does an exhaustive breadth-first search on a given graph, and
	 * runs the user's code during the traversal. The search is terminated if one of
	 * the user's functions returns <code>true</code>. Exhaustiveness means that
	 * every vertex in the graph is visited during the search, as opposed to a
	 * regular BFS, in which only the reachable vertices from a given source are
	 * visited.
	 * 
	 * @param g
	 * @param block1 This code runs on each vertex that is popped from the queue
	 * @param block2 This code runs on each vertex that is a neighbor of the one
	 *               that has been popped from the queue
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, block1, block2 != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                <li><code>block1</code>, <code>block2</code> are defined only
	 *                on the accessible vertices from <code>s</code> (in
	 *                <code>g</code>)</li>
	 *                </ol>
	 * @return <code>true</code> iff the search was terminated by one of the user's
	 *         functions
	 */
	/* package */ static <V, E, R> void traverseExhaustive(Graph<V, E> g, Function0Par<R> block1,
			Void2Par<R, Vertex<V>> block2) {
		if (g.verticesCount() == 0)
			return;

		Set<Vertex<V>> remained = g.vertices().collect(Collectors.toCollection(ADTs()::genSet));

		while (remained.size() > 0) {
			var ret = block1.run();

			traverse(g, remained.iterator().next(), v -> {
				remained.remove(v);
				block2.run(ret, v);
				return false;
			}, (e, v) -> false);
		}
	}
}
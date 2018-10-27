package algorithms;

import static shared.ADTFactories.ADTs;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import dataStructures.PriorityQueue;
import dataStructures.graph.DirectedGraph;
import dataStructures.graph.Edge;
import dataStructures.graph.Graph;
import dataStructures.graph.Vertex;
import dataStructures.graph.Weight;

/**
 * This class bundles several algorithms that solve the single-source
 * shortest-paths problem: given a simple directed graph and a source vertex,
 * the algorithms compute shortest paths (i.e. paths with minimal weights) from
 * the source to each other vertex in the graph.
 */
public class SSSP {

	private static <V, E extends Weight> void BellmanFordInit(DirectedGraph<V, E> g, Vertex<V> s,
			Map<Vertex<V>, Double> distances) {
		g.vertices().forEach(v -> {
			distances.put(v, Double.POSITIVE_INFINITY);
		});
		distances.put(s, 0.);
	}

	private static <V, E extends Weight> void BellmanFordRelax(Edge<V, E> e, Map<Vertex<V>, Double> distances,
			Map<Vertex<V>, Edge<V, E>> pi) {
		var d = distances.get(e.getA()) + e.getData().getWeight();
		if (distances.get(e.getB()) > d) {
			distances.put(e.getB(), d);
			pi.put(e.getB(), e);
		}
	}

	/**
	 * This method computes shortest paths (i.e. paths with minimal weights) from a
	 * given source <code>s</code> to each other vertex in the graph, using the
	 * Bellman-Ford algorithm. If there exists a negative-weight cycle that is
	 * reachable from <code>s</code>, an empty {@link Optional} is returned.
	 * Otherwise, the returned object maps each vertex in the graph to the edge that
	 * connects it with its parent in the (computed) shortest-paths tree of
	 * <code>g</code>.
	 * 
	 * @param g
	 * @param s
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, s != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                <li><code>s</code> has been inserted into <code>g</code></li>
	 *                </ol>
	 * @return $\text{If there don't exist a negative-weight cycle that is reachable
	 *         from } s \text{:} \; A = \big\{ v \big| \exists p:s\leadsto v \big\}
	 *         \; ; \; \pi \in A \rightarrow g.E \; s.t. \; \forall v \in A, \;
	 *         {proj}_2(\pi (v))=v \ \wedge \ \pi (v) \in [\text{computed
	 *         shortest-paths tree}] \text{. Otherwise,} \; ![ret].isPresent())$
	 */
	public static <V, E extends Weight> Optional<Map<Vertex<V>, Edge<V, E>>> BellmanFord(DirectedGraph<V, E> g,
			Vertex<V> s) {
		Map<Vertex<V>, Double> distances = ADTs().genMap();
		return BellmanFord(g, s, distances);
	}

	/**
	 * This method computes shortest paths (i.e. paths with minimal weights) from a
	 * given source <code>s</code> to each other vertex in the graph, using the
	 * Bellman-Ford algorithm. If there exists a negative-weight cycle that is
	 * reachable from <code>s</code>, an empty {@link Optional} is returned.
	 * Otherwise, the returned object maps each vertex in the graph to the edge that
	 * connects it with its parent in the (computed) shortest-paths tree of
	 * <code>g</code>.
	 * 
	 * @param g
	 * @param s
	 * @param distances
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, s, distances != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                <li><code>s</code> has been inserted into <code>g</code></li>
	 *                <li><code>distances.size() == 0</code></li>
	 *                </ol>
	 * @return $\text{If there don't exist a negative-weight cycle that is reachable
	 *         from } s \text{:} \; A = \big\{ v \big| \exists p:s\leadsto v \big\}
	 *         \; ; \; \pi \in A \rightarrow g.E \; s.t. \; \forall v \in A, \;
	 *         {proj}_2(\pi (v))=v \ \wedge \ \pi (v) \in [\text{computed
	 *         shortest-paths tree}] \text{. Otherwise,} \; ![ret].isPresent())$
	 * @postconditions $distances=\{\langle v,d \rangle \Big| v \in g.V \wedge
	 *                 d=\text{shortest distance between v and s} \}$
	 */
	public static <V, E extends Weight> Optional<Map<Vertex<V>, Edge<V, E>>> BellmanFord(DirectedGraph<V, E> g,
			Vertex<V> s, Map<Vertex<V>, Double> distances) {
		Map<Vertex<V>, Edge<V, E>> pi = ADTs().genMap();
		if (g.verticesCount() < 2) {
			return Optional.of(pi);
		}

		BellmanFordInit(g, s, distances);

		for (int i = 1; i <= g.verticesCount() - 1; i++) {
			g.edges().forEach(e -> {
				BellmanFordRelax(e, distances, pi);
			});
		}

		for (var iter = g.edges().iterator(); iter.hasNext();) { // detect negative-weight cycles
			var e = iter.next();
			if (distances.get(e.getB()) > distances.get(e.getA()) + e.getData().getWeight()) {
				return Optional.empty();
			}
		}

		return Optional.of(pi);
	}

	/**
	 * This method computes shortest paths (i.e. paths with minimal weights) from a
	 * given source <code>s</code> to each other vertex in a DAG, using an adapted
	 * version of the Bellman-Ford algorithm, which is optimal. The returned object
	 * maps each vertex in the graph to the edge that connects it with its parent in
	 * the (computed) shortest-paths tree of <code>g</code>.
	 * 
	 * @param g
	 * @param s
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, s != null</code></li>
	 *                <li><code>g</code> is simple and acyclic</li>
	 *                <li><code>s</code> has been inserted into <code>g</code></li>
	 *                </ol>
	 * @return $A = \big\{ v \big| \exists p:s\leadsto v \big\} \; ; \; \pi \in A
	 *         \rightarrow g.E \; s.t. \; \forall v \in A, \; {proj}_2(\pi (v))=v \
	 *         \wedge \ \pi (v) \in [\text{computed shortest-paths tree}]$
	 */
	public static <V, E extends Weight> Map<Vertex<V>, Edge<V, E>> DAG(DirectedGraph<V, E> g, Vertex<V> s) {
		Map<Vertex<V>, Double> distances = ADTs().genMap();
		return DAG(g, s, distances);
	}

	/**
	 * This method computes shortest paths (i.e. paths with minimal weights) from a
	 * given source <code>s</code> to each other vertex in a DAG, using an adapted
	 * version of the Bellman-Ford algorithm, which is optimal. The returned object
	 * maps each vertex in the graph to the edge that connects it with its parent in
	 * the (computed) shortest-paths tree of <code>g</code>.
	 * 
	 * @param g
	 * @param s
	 * @param distances
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, s, distances != null</code></li>
	 *                <li><code>g</code> is simple and acyclic</li>
	 *                <li><code>s</code> has been inserted into <code>g</code></li>
	 *                <li><code>distances.size() == 0</code></li>
	 *                </ol>
	 * @return $A = \big\{ v \big| \exists p:s\leadsto v \big\} \; ; \; \pi \in A
	 *         \rightarrow g.E \; s.t. \; \forall v \in A, \; {proj}_2(\pi (v))=v \
	 *         \wedge \ \pi (v) \in [\text{computed shortest-paths tree}]$
	 * @postconditions $distances=\{\langle v,d \rangle \Big| v \in g.V \wedge
	 *                 d=\text{shortest distance between v and s} \}$
	 */
	public static <V, E extends Weight> Map<Vertex<V>, Edge<V, E>> DAG(DirectedGraph<V, E> g, Vertex<V> s,
			Map<Vertex<V>, Double> distances) {
		Map<Vertex<V>, Edge<V, E>> pi = ADTs().genMap();

		if (g.verticesCount() < 2) {
			return pi;
		}

		BellmanFordInit(g, s, distances);

		List<Vertex<V>> sorted = TopologicalSort.sort(g).get();
		for (var u : sorted) {
			g.outgoing(u).forEach(e -> BellmanFordRelax(e, distances, pi));
		}

		return pi;
	}

	private static <V, E extends Weight> void DijkstraInit(DirectedGraph<V, E> g, Vertex<V> s,
			PriorityQueue<Vertex<V>> queue) {
		g.vertices().filter(v -> !v.equals(s)).forEach(v -> {
			queue.insert(v, Double.POSITIVE_INFINITY);
		});
		queue.insert(s, 0.);
	}

	private static <V, E extends Weight> void DijkstraRelax(Edge<V, E> e, PriorityQueue<Vertex<V>> queue,
			Map<Vertex<V>, Edge<V, E>> pi) {
		if (queue.getKey(e.getB()).isPresent()) {
			var d = queue.getKey(e.getA()).getAsDouble() + e.getData().getWeight();
			if (queue.getKey(e.getB()).getAsDouble() > d) {
				queue.decreaseKey(e.getB(), d);
				pi.put(e.getB(), e);
			}
		}
	}

	/**
	 * This method computes shortest paths (i.e. paths with minimal weights) from a
	 * given source <code>s</code> to each other vertex in a graph, assuming all the
	 * edges that are placed in a path from <code>s</code> to some other vertex
	 * <code>u</code> have nonnegative weights, using the Dijkstra algorithm. The
	 * returned object maps each vertex in the graph to the edge that connects it
	 * with its parent in the (computed) shortest-paths tree of <code>g</code>.
	 * 
	 * @param g
	 * @param s
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, s != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                <li><code>s</code> has been inserted into <code>g</code></li>
	 *                <li>$\forall e= \langle u,v \rangle \in g.E, \big[ \exists
	 *                p:s\leadsto u \big] \rightarrow w(e) \geq 0$</li>
	 *                </ol>
	 * @return $A = \big\{ v \big| \exists p:s\leadsto v \big\} \; ; \; \pi \in A
	 *         \rightarrow g.E \; s.t. \; \forall v \in A, \; {proj}_2(\pi (v))=v \
	 *         \wedge \ \pi (v) \in [\text{computed shortest-paths tree}]$
	 */
	public static <V, E extends Weight> Map<Vertex<V>, Edge<V, E>> Dijkstra(DirectedGraph<V, E> g, Vertex<V> s) {
		return Dijkstra(g, s, null);
	}

	/**
	 * This method computes shortest paths (i.e. paths with minimal weights) from a
	 * given source <code>s</code> to each other vertex in a graph, assuming all the
	 * edges that are placed in a path from <code>s</code> to some other vertex
	 * <code>u</code> have nonnegative weights, using the Dijkstra algorithm. The
	 * returned object maps each vertex in the graph to the edge that connects it
	 * with its parent in the (computed) shortest-paths tree of <code>g</code>.
	 * 
	 * @param g
	 * @param s
	 * @param distances
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, s != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                <li><code>s</code> has been inserted into <code>g</code></li>
	 *                <li>$\forall e= \langle u,v \rangle \in g.E, \big[ \exists
	 *                p:s\leadsto u \big] \rightarrow w(e) \geq 0$</li>
	 *                <li>If <code>distances != null</code>,
	 *                <code>distances.size() == 0</code></li>
	 *                </ol>
	 * @return $A = \big\{ v \big| \exists p:s\leadsto v \big\} \; ; \; \pi \in A
	 *         \rightarrow g.E \; s.t. \; \forall v \in A, \; {proj}_2(\pi (v))=v \
	 *         \wedge \ \pi (v) \in [\text{computed shortest-paths tree}]$
	 * @postconditions $distances \neq null \rightarrow distances=\{\langle v,d
	 *                 \rangle \Big| v \in g.V \wedge d=\text{shortest distance
	 *                 between v and s} \}$
	 */
	public static <V, E extends Weight> Map<Vertex<V>, Edge<V, E>> Dijkstra(DirectedGraph<V, E> g, Vertex<V> s,
			Map<Vertex<V>, Double> distances) {
		Map<Vertex<V>, Edge<V, E>> pi = ADTs().genMap();
		if (g.verticesCount() < 2) {
			return pi;
		}

		PriorityQueue<Vertex<V>> queue = ADTs().genPriorityQueue();
		DijkstraInit(g, s, queue);
		if (distances != null)
			g.vertices().forEach(v -> distances.put(v, Double.POSITIVE_INFINITY));

		while (queue.size() > 0) {
			var u = queue.findMin().get();
			g.outgoing(u).forEach(e -> DijkstraRelax(e, queue, pi));
			if (distances != null)
				distances.put(u, queue.getKey(u).getAsDouble());
			queue.deleteMin();
		}

		return pi;
	}

	/**
	 * This method computes shortest paths (i.e. paths with fewest edges) from a
	 * given source <code>s</code> to each other vertex in a graph. The returned
	 * object maps each vertex in the graph to the edge that connects it with its
	 * parent in the (computed) shortest-paths tree of <code>g</code>.
	 * 
	 * @param g
	 * @param s
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, s != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                <li><code>s</code> has been inserted into <code>g</code></li>
	 *                </ol>
	 * @return $A = \big\{ v \big| \exists p:s\leadsto v \big\} \; ; \; \pi \in A
	 *         \rightarrow g.E \; s.t. \; \forall v \in A, \; {proj}_2(\pi (v))=v \
	 *         \wedge \ \pi (v) \in [\text{computed shortest-paths tree}]$
	 */
	public static <V, E> Map<Vertex<V>, Edge<V, E>> unitWeights(Graph<V, E> g, Vertex<V> s) {
		return unitWeights(g, s, null);
	}

	/**
	 * This method computes shortest paths (i.e. paths with fewest edges) from a
	 * given source <code>s</code> to each other vertex in a graph. The returned
	 * object maps each vertex in the graph to the edge that connects it with its
	 * parent in the (computed) shortest-paths tree of <code>g</code>.
	 * 
	 * @param g
	 * @param s
	 * @param distances
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, s, distances != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                <li><code>s</code> has been inserted into <code>g</code></li>
	 *                <li><code>distances.size() == 0</code></li>
	 *                </ol>
	 * @return $A = \big\{ v \big| \exists p:s\leadsto v \big\} \; ; \; \pi \in A
	 *         \rightarrow g.E \; s.t. \; \forall v \in A, \; {proj}_2(\pi (v))=v \
	 *         \wedge \ \pi (v) \in [\text{computed shortest-paths tree}]$
	 * @postconditions $distances=\{\langle v,d \rangle \Big| v \in g.V \wedge
	 *                 d=\text{shortest distance between v and s} \}$
	 */
	public static <V, E> Map<Vertex<V>, Edge<V, E>> unitWeights(Graph<V, E> g, Vertex<V> s,
			Map<Vertex<V>, Integer> distances) {
		Map<Vertex<V>, Edge<V, E>> pi = ADTs().genMap();
		if (g.verticesCount() < 2) {
			return pi;
		}

		BFS.traverse(g, s, distances, v -> false, (e, v) -> {
			pi.putIfAbsent(v, e);
			return false;
		});
		return pi;
	}

	/**
	 * This method computes the shortest paths graph of a given graph by filtering
	 * out edges.
	 * 
	 * @param g
	 * @param distances A mapping between the vertices in <code>g</code> and their
	 *                  distances from the source vertex <code>s</code>
	 * @preconditions
	 *                <ol>
	 *                <li><code>g, distances != null</code></li>
	 *                <li>$distances=\{\langle v,d \rangle \Big| v \in g.V \wedge
	 *                d=\text{shortest distance between v and s} \}$</li>
	 *                </ol>
	 * @postconditions $this.E^{afterwards} = \bigg\{ e \in this.E^{beforehand}
	 *                 \quad \Big| \text{e is a member of a shortest path from s to
	 *                 another vertex in the graph} \bigg\}$
	 */
	public static <V, E extends Weight> void shortestPathsGraph(DirectedGraph<V, E> g,
			Map<Vertex<V>, Double> distances) {
		g.filterEdges(e -> distances.get(e.getB()) == distances.get(e.getA()) + e.getData().getWeight());
	}
}
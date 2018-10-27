package algorithms;

import static shared.ADTFactories.ADTs;

import java.util.Map;

import dataStructures.graph.DirectedGraph;
import dataStructures.graph.EdgeImpl;
import dataStructures.graph.Graph;
import dataStructures.graph.Vertex;
import dataStructures.graph.VertexImpl;
import dataStructures.graph.Weight;
import dataStructures.graph.WeightImpl;

public class Cycles {

	/**
	 * This method returns <code>true</code> iff <code>g</code> is acyclic.
	 * 
	 * @param g
	 * @preconditions
	 *                <ol>
	 *                <li><code>g != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                </ol>
	 * @return <code>true</code> iff <code>g</code> is acyclic
	 */
	public static <V, E> boolean isAcyclic(DirectedGraph<V, E> g) {
		return !DFS.traverse(g, (v, seen) -> seen == 1, v -> false);
	}

	/**
	 * This method returns <code>true</code> iff <code>g</code> contains a
	 * zero-weight cycle, assuming <code>g</code> does not contain any
	 * negative-weight cycles.
	 * 
	 * @param g
	 * @preconditions
	 *                <ol>
	 *                <li><code>g != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                <li>$\forall n \in \mathbb{N}, 2 \leq n \leq \big| g.E \big|
	 *                \rightarrow \bigg( \forall e \in {g.E}^{\big\{ a \big| a \in
	 *                \mathbb{N} \wedge 1 \leq a \leq n \big\}}, \Big( \forall i \in
	 *                \mathbb{N}, 2 \leq i \leq n \rightarrow proj_2 (e_{i-1}) =
	 *                proj_1 (e_i) \wedge proj_1 (e_1) = proj_2 (e_n) \Big)
	 *                \rightarrow \sum_{i=1}^{n} w(e_i) \geq 0 \bigg)$</li>
	 *                </ol>
	 * @return $\text{true iff } \exists n \in \mathbb{N}: 2 \leq n \leq \big| g.E
	 *         \big| \wedge \bigg( \exists e \in {g.E}^{\big\{ a \big| a \in
	 *         \mathbb{N} \wedge 1 \leq a \leq n \big\}}, \Big( \forall i \in
	 *         \mathbb{N}, 2 \leq i \leq n \rightarrow proj_2 (e_{i-1}) = proj_1
	 *         (e_i) \wedge proj_1 (e_1) = proj_2 (e_n) \Big) \wedge \sum_{i=1}^{n}
	 *         w(e_i) = 0 \bigg)$
	 */
	public static <V> boolean containsZeroCycle(DirectedGraph<V, Weight> g) {
		if (g.verticesCount() < 2) {
			return true;
		}

		DirectedGraph<V, Weight> clone = g.clone();
		Vertex<V> s = newVertex(clone, 0);

		Map<Vertex<V>, Double> distances = ADTs().genMap();
		boolean b = SSSP.BellmanFord(clone, s, distances).isPresent();
		assert (b);

		SSSP.shortestPathsGraph(clone, distances);

		return !Cycles.isAcyclic(clone);
	}

	/**
	 * This method returns <code>true</code> iff <code>g</code> contains a
	 * negative-weight cycle.
	 * 
	 * @param g
	 * @preconditions
	 *                <ol>
	 *                <li><code>g != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                </ol>
	 * @return $\text{true iff } \exists n \in \mathbb{N}: 2 \leq n \leq \big| g.E
	 *         \big| \wedge \bigg( \exists e \in {g.E}^{\big\{ a \big| a \in
	 *         \mathbb{N} \wedge 1 \leq a \leq n \big\}}, \Big( \forall i \in
	 *         \mathbb{N}, 2 \leq i \leq n \rightarrow proj_2 (e_{i-1}) = proj_1
	 *         (e_i) \wedge proj_1 (e_1) = proj_2 (e_n) \Big) \wedge \sum_{i=1}^{n}
	 *         w(e_i) < 0 \bigg)$
	 */
	public static <V> boolean containsNegativeCycle(DirectedGraph<V, Weight> g) {
		DirectedGraph<V, Weight> clone = g.clone();
		Vertex<V> s = newVertex(clone, 0);

		return !SSSP.BellmanFord(clone, s).isPresent();
	}

	/**
	 * This method adds a new vertex into the graph and connects it to all the other
	 * vertices.
	 * 
	 * @param g
	 * @param w The weight that is given to the newly added edges
	 * @preconditions <code>g != null</code>
	 * @return The newly added vertex
	 * @preconditions <code>ret</code> is connected to all the other vertices in
	 *                <code>g</code>
	 */
	private static <V> Vertex<V> newVertex(Graph<V, Weight> g, double w) {
		Vertex<V> s = new VertexImpl<>();

		g.addVertex(s);

		g.vertices().filter(v -> !v.equals(s)).forEach(v -> {
			g.addEdge(new EdgeImpl<>(s, v, new WeightImpl(w)));
		});

		return s;
	}
}
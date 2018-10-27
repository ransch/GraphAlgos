package algorithms;

import static shared.ADTFactories.ADTs;

import java.util.List;
import java.util.Optional;

import dataStructures.graph.DirectedGraph;
import dataStructures.graph.Vertex;

public class TopologicalSort {

	/**
	 * This method tries to topologically sort a given directed graph. If the graph
	 * is a DAG, it returns a sorted list of the vertices. Otherwise, an empty
	 * {@link Optional} is returned.
	 * 
	 * @param g
	 * @preconditions
	 *                <ol>
	 *                <li><code>g != null</code></li>
	 *                <li><code>g</code> is simple</li>
	 *                </ol>
	 * @return $g \; is \; a \; DAG \rightarrow \Big( |[ret.get()]| = |g.V| \;
	 *         \wedge \; \{v \big| v \in [ret.get()]\}=g.V \; \wedge \; \forall
	 *         (v,u)\in g.E, \big( [ret.get()][i]=v \wedge [ret.get()][j]=u \big)
	 *         \rightarrow i \lt j\Big) \newline g \; isn't \; a \; DAG \rightarrow
	 *         !ret.isPresent()$
	 */
	public static <V, E> Optional<List<Vertex<V>>> sort(DirectedGraph<V, E> g) {
		List<Vertex<V>> res = ADTs().genList();
		if (DFS.traverse(g, (v, seen) -> seen == 1, v -> {
			res.add(0, v);
			return false;
		})) {
			return Optional.empty();
		}
		return Optional.of(res);
	}
}
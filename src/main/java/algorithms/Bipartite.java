package algorithms;

import static shared.ADTFactories.ADTs;

import java.util.Map;
import java.util.Optional;

import dataStructures.graph.Color;
import dataStructures.graph.Edge;
import dataStructures.graph.UndirectedGraph;
import dataStructures.graph.Vertex;

public class Bipartite {

	/**
	 * This method checks whether a given graph <code>g</code> is bipartite. If the
	 * graph is bipartite it is colored with 0 and 1.
	 * 
	 * @param g
	 * @preconditions
	 *                <ol>
	 *                <li><code>g != null</code></li>
	 *                <li><code>g</code> is simple and connected</li>
	 *                <li>$\forall v \in g, v.getData().getColor() == 0$</li>
	 *                </ol>
	 * @return <code>true</code> iff <code>g</code> is bipartite
	 * @postconditions if <code>g</code> is bipartite, it is colored with 0 and 1.
	 *                 Otherwise, it is not mutated.
	 */
	public static <V extends Color, E> boolean isBipartite(UndirectedGraph<V, E> g) {
		Map<Vertex<V>, Integer> distances = ADTs().genMap();
		Optional<Vertex<V>> opt = g.vertices().findFirst();
		if (opt.isPresent()) {
			var b = !BFS.traverse(g, opt.get(), distances, v -> {
				assert (v.getData().getColor() == 0);
				var color = distances.get(v) % 2;
				v.getData().setColor(color);
				for (var iter = g.outgoing(v).map(Edge::getB)
						.filter(u -> distances.containsKey(u) && distances.get(u) % 2 == color).iterator(); iter
								.hasNext();) {
					return true;
				}
				return false;
			}, (e, v) -> false);

			if (!b) {
				g.vertices().forEach(v -> v.getData().setColor(0));
			}

			return b;
		}
		return true;
	}
}
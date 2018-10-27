package dataStructures.graph;

import static shared.ADTFactories.ADTs;

import java.util.List;
import java.util.stream.Stream;

/**
 * This class is an implementation of the UndirectedGraph abstract class. It
 * used {@link AdjListGraphDirected} as its implementation, so the graph is
 * represented as a collection of adjacency lists.
 * 
 * Note that this class should meet all the requirements of
 * {@link AdjListGraphDirected}.
 * 
 * @param <V> The type of the data that is stored in the vertices
 * @param <E> The type of the data that is stored in the edges
 */
public class AdjListGraphUndirected<V, E> extends UndirectedGraph<V, E> {

	/**
	 * @invariant This list contains all the edges in the graph. Each edge appears
	 *            exactly once.
	 */
	private List<Edge<V, E>> edges;

	public AdjListGraphUndirected() {
		super(new AdjListGraphDirected<>());
		edges = ADTs().genList();
	}

	@Override
	public void addEdge(Edge<V, E> edge) {
		super.addEdge(edge);
		edges.add(edge);
	}

	@Override
	public int edgesCount() {
		var res = super.edgesCount();
		assert (res == this.edges.size());
		return res;
	}

	@Override
	public Stream<Edge<V, E>> edges() {
		return edges.stream();
	}
}
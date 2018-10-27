package dataStructures.graph;

import java.util.stream.Stream;

/**
 * This class represents an undirected graph. All the time complexities are
 * identical to those of the {@link DirectedGraph} implementation (that is
 * passed during construction).
 *
 * @param <V> The type of the data that is stored in the vertices
 * @param <E> The type of the data that is stored in the edge
 */
public abstract class UndirectedGraph<V, E> implements Graph<V, E> {

	/**
	 * An {@link DirectedGraph} instance that is used as the implementation of the
	 * current graph.
	 */
	private final DirectedGraph<V, E> impl;

	/**
	 * @param impl An {@link DirectedGraph} instance that is used as the
	 *             implementation of the current graph
	 * @preconditions <code>impl != null</code>
	 */
	protected UndirectedGraph(DirectedGraph<V, E> impl) {
		assert (impl != null);
		this.impl = impl;
	}

	@Override
	public void addVertex(Vertex<V> vertex) {
		impl.addVertex(vertex);
	}

	@Override
	public void addEdge(Edge<V, E> edge) {
		impl.addEdge(edge);
		impl.addEdge(edge.invert());
	}

	@Override
	public boolean adjacent(Vertex<V> vertexA, Vertex<V> vertexB) {
		return impl.adjacent(vertexA, vertexB);
	}

	@Override
	public Stream<Edge<V, E>> outgoing(Vertex<V> vertexA, Vertex<V> vertexB) {
		return impl.outgoing(vertexA, vertexB);
	}

	@Override
	public Stream<Edge<V, E>> outgoing(Vertex<V> vertex) {
		return impl.outgoing(vertex);
	}

	@Override
	public Stream<Vertex<V>> vertices() {
		return impl.vertices();
	}

	/**
	 * This method returns the degree of the given vertex.
	 * 
	 * @param vertex
	 * @preconditions
	 *                <ol>
	 *                <li><code>vertex != null</code></li>
	 *                <li><code>vertex</code> has been already inserted into the
	 *                graph (using {@link Graph#addVertex(Vertex)})</li>
	 *                </ol>
	 * @return The degree of <code>vertex</code>
	 */
	public int degree(Vertex<V> vertex) {
		return impl.outdegree(vertex);
	}

	@Override
	public int verticesCount() {
		return impl.verticesCount();
	}

	@Override
	public int edgesCount() {
		assert (impl.edgesCount() % 2 == 0);
		return impl.edgesCount() / 2;
	}

	@Override
	public boolean containsVertex(Vertex<V> v) {
		return impl.containsVertex(v);
	}
}
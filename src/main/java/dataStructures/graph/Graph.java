package dataStructures.graph;

import java.util.stream.Stream;

/**
 * This interface defines the Multigraph abstract data type.
 *
 * @param <V> The type of the data that is stored in the vertices
 * @param <E> The type of the data that is stored in the edges
 */
public interface Graph<V, E> {
	/**
	 * This method adds a vertex into the graph.
	 * 
	 * @preconditions
	 *                <ol>
	 *                <li><code>vertex != null</code></li>
	 *                <li><code>vertex</code> is not contained in the graph</li>
	 *                </ol>
	 * @param vertex
	 */
	public void addVertex(Vertex<V> vertex);

	/**
	 * This method adds a new edge into the graph.
	 * 
	 * @preconditions
	 *                <ol>
	 *                <li><code>edge != null</code></li>
	 *                <li>Both <code>edge.getA()</code> and <code>edge.getB()</code>
	 *                have been already inserted into the graph (using</li>
	 *                </ol>
	 * @param edge
	 */
	public void addEdge(Edge<V, E> edge);

	/**
	 * This method checks if <code>vertexA</code> is connected to
	 * <code>vertexB</code> in the graph.
	 * 
	 * @param vertexA
	 * @param vertexB
	 * @preconditions
	 *                <ol>
	 *                <li><code>vertexA, vertexB != null</code></li>
	 *                <li>Both <code>vertexA</code> and <code>vertexB</code> have
	 *                been already inserted into the graph (using
	 *                {@link #addVertex(Vertex)})</li>
	 *                </ol>
	 * @return true iff vertexA is connected to vertexB in the graph.
	 */
	public boolean adjacent(Vertex<V> vertexA, Vertex<V> vertexB);

	/**
	 * This method returns a stream of all the outgoing edges from
	 * <code>vertexA</code> to <code>vertexB</code>.
	 * 
	 * @param vertexA
	 * @param vertexB
	 * @preconditions
	 *                <ol>
	 *                <li><code>vertexA, vertexB != null</code></li>
	 *                <li>Both <code>vertexA</code> and <code>vertexB</code> have
	 *                been already inserted into the graph (using
	 *                {@link #addVertex(Vertex)})</li>
	 *                </ol>
	 * @return A stream of all the outgoing edges from <code>vertexA</code> to
	 *         <code>vertexB</code>
	 */
	public Stream<Edge<V, E>> outgoing(Vertex<V> vertexA, Vertex<V> vertexB);

	/**
	 * This method returns a stream of all the outgoing edges from
	 * <code>vertex</code>.
	 * 
	 * @param vertex
	 * @preconditions
	 *                <ol>
	 *                <li><code>vertex != null</code></li>
	 *                <li>vertex has been already inserted into the graph (using
	 *                {@link #addVertex(Vertex)})</li>
	 *                </ol>
	 * @return A stream of all the outgoing edges from <code>vertex</code>
	 */
	public Stream<Edge<V, E>> outgoing(Vertex<V> vertex);

	/**
	 * This method returns a stream of all the vertices in the graph. Note that the
	 * object in the stream must not be mutated.
	 * 
	 * @return A stream of all the vertices in the graph
	 */
	public Stream<Vertex<V>> vertices();

	/**
	 * This method returns a stream of all the edges in the graph. Note that the
	 * object in the stream must not be mutated.
	 * 
	 * @return A stream of all the edges in the graph
	 */
	public Stream<Edge<V, E>> edges();

	/**
	 * This method returns the total number of vertices in the graph.
	 * 
	 * @return The number of vertices in the graph.
	 */
	public int verticesCount();

	/**
	 * This method returns the total number of edges in the graph.
	 * 
	 * @return The number of edges in the graph.
	 */
	public int edgesCount();

	/**
	 * This method checks whether a given vertex has already been inserted into the
	 * graph.
	 * 
	 * @param v
	 * @preconditions <code>v != null</code>
	 * @return <code>true</code> iff <code>v</code> has already been inserted into
	 *         <code>this</code> graph
	 */
	public boolean containsVertex(Vertex<V> v);
}
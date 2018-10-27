package dataStructures.graph;

import java.util.function.Predicate;

/**
 * This class represents an directed graph.
 *
 * @param <T> The type of the data that is stored in the vertices
 * @param <V> The type of the vertices in the graph
 * @param <E> The type of the edges in the graph
 */
public abstract class DirectedGraph<V, E> implements Graph<V, E> {
	/**
	 * This method returns the outdegree of the given vertex.
	 * 
	 * @param vertex
	 * @preconditions
	 *                <ol>
	 *                <li><code>vertex != null</code></li>
	 *                <li><code>vertex</code> has been already inserted into the
	 *                graph (using {@link Graph#addVertex(Vertex)})</li>
	 *                </ol>
	 * @return The outdegree of <code>vertex</code>
	 */
	public abstract int outdegree(Vertex<V> vertex);

	/**
	 * This method returns the indegree of the given vertex.
	 * 
	 * @param vertex
	 * @preconditions
	 *                <ol>
	 *                <li><code>vertex != null</code></li>
	 *                <li><code>vertex</code> has been already inserted into the
	 *                graph (using {@link Graph#addVertex(Vertex)})</li>
	 *                </ol>
	 * @return The outdegree of <code>vertex</code>
	 */
	public abstract int indegree(Vertex<V> vertex);

	/**
	 * This method clones <code>this</code> graph.
	 * 
	 * @return A clone of <code>this</code>
	 */
	public abstract DirectedGraph<V, E> clone();

	/**
	 * This method filters out all edges that do not match a given predicate.
	 * 
	 * @param predicate
	 * @preconditions <code>predicate != null </code>
	 * @postconditions $this.E^{afterwards} = \bigg\{ e \in this.E^{beforehand}
	 *                 \quad \Big| \quad predicate.test(e)=true \bigg\}$
	 */
	public abstract void filterEdges(Predicate<Edge<V, E>> predicate);
}
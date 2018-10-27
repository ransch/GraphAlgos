package dataStructures.graph;

/**
 * This interface defines an edge in the graph. Each edge may be a member of
 * multiple graphs. The vertices of the edge must not be changed.
 * 
 * @param <V> The type of the data that is stored in the vertices
 * @param <E> The type of the data that is stored in the edge
 */
public interface Edge<V, E> {

	/**
	 * This method returns the data that is stored in the edge. Each each may be a
	 * member of multiple graphs.
	 * 
	 * @return The data that is stored in the edge
	 */
	public E getData();

	/**
	 * This method returns the first vertex.
	 * 
	 * @return The first vertex
	 * @postconditions <code><code>ret</code> != null</code>
	 */
	public Vertex<V> getA();

	/**
	 * This method returns the second vertex.
	 * 
	 * @return The second vertex
	 * @postconditions <code><code>ret</code> != null</code>
	 */
	public Vertex<V> getB();

	/**
	 * This method returns a new edge e such that: e.getA().equals(this.getB()) and
	 * e.getB().equals(this.getA()).
	 * 
	 * @param edge
	 * @return A new edge e such that <code>e.getA().equals(this.getB())</code> and
	 *         <code>e.getB().equals(this.getA())</code>
	 */
	public Edge<V, E> invert();
}
package dataStructures.graph;

/**
 * This interface defines a vertex in the graph. Each vertex may be a member of
 * multiple graphs.
 * 
 * @param <T> The type of the data that is stored in the vertex
 */
public interface Vertex<V> {

	/**
	 * This method returns the data that is stored in the vertex.
	 * 
	 * @return The data that is stored in the vertex
	 */
	public V getData();
}
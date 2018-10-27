package dataStructures.graph;

/**
 * This class is an implementation of the {@link Vertex} interface. Note that
 * the methods {@link #equals(Object)} and {@link #hashCode()} are not
 * overridden, so in particular they are not affected by the data that is stored
 * in the vertex.
 * 
 * @param <T> The type of the data that is stored in the vertex
 */
public class VertexImpl<V> implements Vertex<V> {
	private V data;

	public VertexImpl() {

	}

	public VertexImpl(V data) {
		this.data = data;
	}

	@Override
	public V getData() {
		return data;
	}
}
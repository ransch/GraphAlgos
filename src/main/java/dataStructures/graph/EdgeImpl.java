package dataStructures.graph;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * This class is an implementation of the {@link Edge} interface.
 * 
 * @param <V> The type of the data that is stored in the vertices
 * @param <E> The type of the data that is stored in the edge
 */
public class EdgeImpl<V, E> implements Edge<V, E> {
	private Vertex<V> vertexA;
	private Vertex<V> vertexB;
	private E data;

	/**
	 * @param vertexA
	 * @param vertexB
	 * @preconditions <code>vertexA, vertexB != null</code>
	 */
	public EdgeImpl(Vertex<V> vertexA, Vertex<V> vertexB) {
		assert (vertexA != null && vertexB != null);
		this.vertexA = vertexA;
		this.vertexB = vertexB;
	}

	/**
	 * @param vertexA
	 * @param vertexB
	 * @param data
	 * @preconditions <code>vertexA, vertexB != null</code>
	 */
	public EdgeImpl(Vertex<V> vertexA, Vertex<V> vertexB, E data) {
		assert (vertexA != null && vertexB != null);
		this.vertexA = vertexA;
		this.vertexB = vertexB;
		this.data = data;
	}

	@Override
	public E getData() {
		return data;
	}

	@Override
	public Vertex<V> getA() {
		return vertexA;
	}

	@Override
	public Vertex<V> getB() {
		return vertexB;
	}

	@Override
	public Edge<V, E> invert() {
		return new EdgeImpl<>(vertexB, vertexA, data);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Edge) {
			var edge = (Edge<?, ?>) obj;
			boolean b = this.getA().equals(edge.getA()) && this.getB().equals(edge.getB());
			if (b) {
				return this.getData() == null ? edge.getData() == null : this.getData().equals(edge.getData());
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getA()).append(this.getB()).append(this.getData()).toHashCode();
	}
}
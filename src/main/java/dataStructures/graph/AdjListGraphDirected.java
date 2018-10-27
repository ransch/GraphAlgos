package dataStructures.graph;

import static shared.ADTFactories.ADTs;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * This class is an implementation of the DirectedGraph abstract class. The
 * graph is represented as a collection of adjacency lists.
 * 
 * @param <V> The type of the data that is stored in the vertices
 * @param <E> The type of the data that is stored in the edges
 */
public class AdjListGraphDirected<V, E> extends DirectedGraph<V, E> {

	/**
	 * This map contains the adjacency lists that store that graph data. The keys
	 * are the vertices and the values are the lists.
	 * 
	 * @invariant $\forall v \in this.V \forall e \in adjLists.get(v), proj_1 (e) =
	 *            v$
	 */
	private Map<Vertex<V>, List<Edge<V, E>>> adjLists;

	/**
	 * This map contains the adjacency lists that store that graph data. The keys
	 * are the vertices and the values are the lists.
	 * 
	 * @invariants $\forall u \in this.V, indegrees(v) = \bigg|\bigg[ v \in this.V
	 *             \Big| \big\langle v,u \big\rangle \in this.E \bigg]\bigg|$
	 */
	private Map<Vertex<V>, Integer> indegrees;

	/**
	 * @invariants $edgesCount = |this.E|$
	 */
	private int edgesCount;

	public AdjListGraphDirected() {
		adjLists = ADTs().genMap();
		indegrees = ADTs().genMap();
		this.edgesCount = 0;
	}

	@Override
	public void addVertex(Vertex<V> vertex) {
		assert (vertex != null && !adjLists.containsKey(vertex));
		List<Edge<V, E>> adjList = ADTs().genList();
		adjLists.put(vertex, adjList);
		indegrees.put(vertex, 0);
	}

	@Override
	public void addEdge(Edge<V, E> edge) {
		assert (edge != null && adjLists.containsKey(edge.getA()) && adjLists.containsKey(edge.getB()));
		adjLists.get(edge.getA()).add(edge);
		indegrees.put(edge.getB(), indegrees.get(edge.getB()) + 1);
		edgesCount++;
	}

	@Override
	public boolean adjacent(Vertex<V> vertexA, Vertex<V> vertexB) {
		assert (vertexA != null && vertexB != null && adjLists.containsKey(vertexA) && adjLists.containsKey(vertexB));
		return this.outgoing(vertexA).anyMatch(e -> e.getB().equals(vertexB));
	}

	@Override
	public Stream<Edge<V, E>> outgoing(Vertex<V> vertexA, Vertex<V> vertexB) {
		return this.outgoing(vertexA).filter(e -> e.getB().equals(vertexB));
	}

	@Override
	public Stream<Edge<V, E>> outgoing(Vertex<V> vertex) {
		assert (vertex != null && adjLists.containsKey(vertex));
		return adjLists.get(vertex).stream();
	}

	@Override
	public Stream<Vertex<V>> vertices() {
		return adjLists.keySet().stream();
	}

	@Override
	public Stream<Edge<V, E>> edges() {
		return vertices().map(adjLists::get).flatMap(Collection::stream);
	}

	@Override
	public int outdegree(Vertex<V> vertex) {
		assert (vertex != null && adjLists.containsKey(vertex));
		return adjLists.get(vertex).size();
	}

	@Override
	public int indegree(Vertex<V> vertex) {
		assert (vertex != null && adjLists.containsKey(vertex));
		return indegrees.get(vertex);
	}

	@Override
	public int verticesCount() {
		return adjLists.size();
	}

	@Override
	public int edgesCount() {
		return edgesCount;
	}

	@Override
	public boolean containsVertex(Vertex<V> v) {
		assert (v != null);
		return adjLists.containsKey(v);
	}

	@Override
	public AdjListGraphDirected<V, E> clone() {
		AdjListGraphDirected<V, E> clone = new AdjListGraphDirected<>();

		this.vertices().forEach(v -> clone.addVertex(v));

		this.vertices().forEach(v -> {
			this.outgoing(v).forEach(e -> clone.addEdge(e));
		});

		return clone;
	}

	@Override
	public void filterEdges(Predicate<Edge<V, E>> filter) {
		this.adjLists.entrySet().stream().map(e -> e.getValue()).forEach(list -> {
			for (var iter = list.iterator(); iter.hasNext();) {
				var e = iter.next();
				if (!filter.test(e)) {
					indegrees.put(e.getB(), indegrees.get(e.getB()) - 1);
					edgesCount--;
					iter.remove();
				}
			}
		});
	}
}
package tests.dataStructures.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dataStructures.graph.AdjListGraphDirected;
import dataStructures.graph.DirectedGraph;
import dataStructures.graph.Edge;
import dataStructures.graph.EdgeImpl;
import dataStructures.graph.Vertex;
import dataStructures.graph.VertexImpl;

public class AdjListGraphDirectedTest {

	DirectedGraph<Integer, String> g;
	DirectedGraph<Integer, String> q;
	Vertex<Integer> v1, v2, v3, v4, v5, v6, w1, w2, w3, w4;
	Edge<Integer, String> e1, e2, e3, e4, e5, e6, e7, e8, e9, f1, f2, f3, f4, f5, f6, f7, f8, f9;

	@BeforeEach
	void init() {
		g = new AdjListGraphDirected<>();
		v1 = new VertexImpl<>(1);
		v2 = new VertexImpl<>(2);
		v3 = new VertexImpl<>(null);
		v4 = new VertexImpl<>(1);
		v5 = new VertexImpl<>(2);
		v6 = new VertexImpl<>(2);
		e1 = new EdgeImpl<>(v1, v2, "edge label 1");
		e8 = new EdgeImpl<>(v2, v1, "edge label 2");
		e2 = new EdgeImpl<>(v1, v3, "edge label 1");
		e3 = new EdgeImpl<>(v1, v4, "edge label 1");
		e4 = new EdgeImpl<>(v1, v5, "edge label 1");
		e5 = new EdgeImpl<>(v2, v3, "edge label 1");
		e6 = new EdgeImpl<>(v2, v5, null);
		e7 = new EdgeImpl<>(v4, v5, "edge label 3");
		e9 = new EdgeImpl<>(v5, v3, "edge label 4");

		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		g.addVertex(v5);
		g.addVertex(v6);
		g.addEdge(e1);
		g.addEdge(e2);
		g.addEdge(e3);
		g.addEdge(e4);
		g.addEdge(e5);
		g.addEdge(e6);
		g.addEdge(e7);
		g.addEdge(e8);
		g.addEdge(e9);

		q = new AdjListGraphDirected<>();
		w1 = new VertexImpl<>(null);
		w2 = new VertexImpl<>(1);
		w3 = new VertexImpl<>(1);
		w4 = new VertexImpl<Integer>(2);
		f1 = new EdgeImpl<>(w1, w1, "edge label 1");
		f2 = new EdgeImpl<>(w2, w1, "edge label 2");
		f3 = new EdgeImpl<>(w1, w3, null);
		f4 = new EdgeImpl<>(w4, w4, "edge label 1");
		f5 = new EdgeImpl<>(w2, w1, "edge label 1");
		f6 = new EdgeImpl<>(w1, w3, "edge label 3");
		f7 = new EdgeImpl<>(w1, w1, null);
		f8 = new EdgeImpl<>(w4, w4, "edge label 1");
		f9 = new EdgeImpl<>(w4, w4, "edge label 2");

		q.addVertex(w1);
		q.addVertex(w2);
		q.addVertex(w3);
		q.addVertex(w4);
		q.addEdge(f1);
		q.addEdge(f2);
		q.addEdge(f3);
		q.addEdge(f4);
		q.addEdge(f5);
		q.addEdge(f6);
		q.addEdge(f7);
		q.addEdge(f8);
		q.addEdge(f9);
	}

	@Test
	@DisplayName("Tests the adjacent method")
	void connected() {
		assertTrue(g.adjacent(v1, v2));
		assertTrue(g.adjacent(v2, v1));
		assertTrue(g.adjacent(v1, v3));
		assertTrue(g.adjacent(v1, v4));
		assertTrue(g.adjacent(v1, v5));
		assertTrue(g.adjacent(v2, v3));
		assertTrue(g.adjacent(v2, v5));
		assertTrue(g.adjacent(v4, v5));
		assertTrue(g.adjacent(v5, v3));
		assertFalse(g.adjacent(v2, v4));
		assertFalse(g.adjacent(v3, v1));
		assertFalse(g.adjacent(v3, v2));
		assertFalse(g.adjacent(v3, v4));
		assertFalse(g.adjacent(v3, v5));
		assertFalse(g.adjacent(v4, v1));
		assertFalse(g.adjacent(v4, v2));
		assertFalse(g.adjacent(v4, v3));
		assertFalse(g.adjacent(v5, v1));
		assertFalse(g.adjacent(v5, v2));
		assertFalse(g.adjacent(v5, v4));
		assertFalse(g.adjacent(v1, v6));
		assertFalse(g.adjacent(v2, v6));
		assertFalse(g.adjacent(v3, v6));
		assertFalse(g.adjacent(v4, v6));
		assertFalse(g.adjacent(v5, v6));
		assertFalse(g.adjacent(v6, v1));
		assertFalse(g.adjacent(v6, v2));
		assertFalse(g.adjacent(v6, v3));
		assertFalse(g.adjacent(v6, v4));
		assertFalse(g.adjacent(v6, v5));

		assertTrue(q.adjacent(w1, w1));
		assertTrue(q.adjacent(w2, w1));
		assertTrue(q.adjacent(w1, w3));
		assertTrue(q.adjacent(w4, w4));
		assertFalse(q.adjacent(w1, w2));
		assertFalse(q.adjacent(w1, w4));
		assertFalse(q.adjacent(w2, w2));
		assertFalse(q.adjacent(w2, w3));
		assertFalse(q.adjacent(w2, w4));
		assertFalse(q.adjacent(w4, w1));
		assertFalse(q.adjacent(w4, w2));
		assertFalse(q.adjacent(w4, w3));
		assertFalse(q.adjacent(w3, w1));
		assertFalse(q.adjacent(w3, w2));
		assertFalse(q.adjacent(w3, w3));
		assertFalse(q.adjacent(w3, w4));
	}

	@Test
	@DisplayName("Tests the outgoing(v1,v2) method")
	void outgoingAB() {
		assertEquals(g.outgoing(v3, v2).count(), 0);
		assertEquals(g.outgoing(v6, v5).count(), 0);
		assertTrue(g.outgoing(v2, v3).count() == 1 && g.outgoing(v2, v3).findFirst().get() == e5);
		assertTrue(g.outgoing(v4, v5).count() == 1 && g.outgoing(v4, v5).findFirst().get() == e7);

		assertEquals(q.outgoing(w3, w1).count(), 0);
		assertEquals(q.outgoing(w3, w2).count(), 0);
		assertEquals(q.outgoing(w3, w3).count(), 0);
		assertEquals(q.outgoing(w3, w4).count(), 0);

		var arr1 = new boolean[2];
		q.outgoing(w2, w1).forEach(e -> {
			if (e == f2) {
				if (arr1[0])
					fail();
				arr1[0] = true;
			} else if (e == f5) {
				if (arr1[1])
					fail();
				arr1[1] = true;
			} else {
				fail();
			}
		});
		for (var i = 0; i < 2; i++) {
			if (!arr1[i]) {
				fail();
			}
		}

		var arr2 = new boolean[3];
		q.outgoing(w4, w4).forEach(e -> {
			if (e == f4) {
				if (arr2[0])
					fail();
				arr2[0] = true;
			} else if (e == f8) {
				if (arr2[1])
					fail();
				arr2[1] = true;
			} else if (e == f9) {
				if (arr2[2])
					fail();
				arr2[2] = true;
			} else {
				fail();
			}
		});
		for (var i = 0; i < 3; i++) {
			if (!arr2[i]) {
				fail();
			}
		}
	}

	@Test
	@DisplayName("Tests the outgoing(v) method")
	void outgoing() {
		assertEquals(g.outgoing(v3).count(), 0);
		assertEquals(g.outgoing(v6).count(), 0);

		var arr1 = new boolean[3];
		g.outgoing(v2).forEach(e -> {
			if (e == e5) {
				if (arr1[0])
					fail();
				arr1[0] = true;
			} else if (e == e6) {
				if (arr1[1])
					fail();
				arr1[1] = true;
			} else if (e == e8) {
				if (arr1[2])
					fail();
				arr1[2] = true;
			} else {
				fail();
			}
		});
		for (var i = 0; i < 3; i++) {
			if (!arr1[i]) {
				fail();
			}
		}

		assertEquals(q.outgoing(w3).count(), 0);

		var arr2 = new boolean[2];
		q.outgoing(w2).forEach(f -> {
			if (f == f2) {
				if (arr2[0])
					fail();
				arr2[0] = true;
			} else if (f == f5) {
				if (arr2[1])
					fail();
				arr2[1] = true;
			} else {
				fail();
			}
		});
		for (var i = 0; i < 2; i++) {
			if (!arr2[i]) {
				fail();
			}
		}
	}

	@Test
	@DisplayName("Tests the vertices method")
	void vertices() {
		var arr1 = new boolean[6];
		g.vertices().forEach(v -> {
			if (v.equals(v1)) {
				if (arr1[0])
					fail();
				arr1[0] = true;
			} else if (v.equals(v2)) {
				if (arr1[1])
					fail();
				arr1[1] = true;
			} else if (v.equals(v3)) {
				if (arr1[2])
					fail();
				arr1[2] = true;
			} else if (v.equals(v4)) {
				if (arr1[3])
					fail();
				arr1[3] = true;
			} else if (v.equals(v5)) {
				if (arr1[4])
					fail();
				arr1[4] = true;
			} else if (v.equals(v6)) {
				if (arr1[5])
					fail();
				arr1[5] = true;
			} else {
				fail();
			}
		});
		for (var i = 0; i < 6; i++) {
			if (!arr1[i]) {
				fail();
			}
		}

		var arr2 = new boolean[4];
		q.vertices().forEach(w -> {
			if (w.equals(w1)) {
				if (arr2[0])
					fail();
				arr2[0] = true;
			} else if (w.equals(w2)) {
				if (arr2[1])
					fail();
				arr2[1] = true;
			} else if (w.equals(w3)) {
				if (arr2[2])
					fail();
				arr2[2] = true;
			} else if (w.equals(w4)) {
				if (arr2[3])
					fail();
				arr2[3] = true;
			} else {
				fail();
			}
		});
		for (var i = 0; i < 4; i++) {
			if (!arr2[i]) {
				fail();
			}
		}
	}

	@Test
	@DisplayName("Tests the edges method")
	void edges() {
		var arr1 = new boolean[9];
		g.edges().forEach(e -> {
			if (e == e1) {
				if (arr1[0])
					fail();
				arr1[0] = true;
			} else if (e == e2) {
				if (arr1[1])
					fail();
				arr1[1] = true;
			} else if (e == e3) {
				if (arr1[2])
					fail();
				arr1[2] = true;
			} else if (e == e4) {
				if (arr1[3])
					fail();
				arr1[3] = true;
			} else if (e == e5) {
				if (arr1[4])
					fail();
				arr1[4] = true;
			} else if (e == e6) {
				if (arr1[5])
					fail();
				arr1[5] = true;
			} else if (e == e7) {
				if (arr1[6])
					fail();
				arr1[6] = true;
			} else if (e == e8) {
				if (arr1[7])
					fail();
				arr1[7] = true;
			} else if (e == e9) {
				if (arr1[8])
					fail();
				arr1[8] = true;
			} else {
				fail();
			}
		});
		for (var i = 0; i < 9; i++) {
			if (!arr1[i]) {
				fail();
			}
		}

		var arr2 = new boolean[9];
		q.edges().forEach(f -> {
			if (f == f1) {
				if (arr2[0])
					fail();
				arr2[0] = true;
			} else if (f == f2) {
				if (arr2[1])
					fail();
				arr2[1] = true;
			} else if (f == f3) {
				if (arr2[2])
					fail();
				arr2[2] = true;
			} else if (f == f4) {
				if (arr2[3])
					fail();
				arr2[3] = true;
			} else if (f == f5) {
				if (arr2[4])
					fail();
				arr2[4] = true;
			} else if (f == f6) {
				if (arr2[5])
					fail();
				arr2[5] = true;
			} else if (f == f7) {
				if (arr2[6])
					fail();
				arr2[6] = true;
			} else if (f == f8) {
				if (arr2[7])
					fail();
				arr2[7] = true;
			} else if (f == f9) {
				if (arr2[8])
					fail();
				arr2[8] = true;
			} else {
				fail();
			}
		});
		for (var i = 0; i < 9; i++) {
			if (!arr2[i]) {
				fail();
			}
		}
	}

	@Test
	@DisplayName("Tests the outdegree method")
	void outdegree() {
		assertEquals(g.outdegree(v1), 4);
		assertEquals(g.outdegree(v2), 3);
		assertEquals(g.outdegree(v3), 0);
		assertEquals(g.outdegree(v4), 1);
		assertEquals(g.outdegree(v5), 1);
		assertEquals(g.outdegree(v6), 0);

		assertEquals(q.outdegree(w1), 4);
		assertEquals(q.outdegree(w2), 2);
		assertEquals(q.outdegree(w3), 0);
		assertEquals(q.outdegree(w4), 3);
	}

	@Test
	@DisplayName("Tests the indegree method")
	void indegree() {
		assertEquals(g.indegree(v1), 1);
		assertEquals(g.indegree(v2), 1);
		assertEquals(g.indegree(v3), 3);
		assertEquals(g.indegree(v4), 1);
		assertEquals(g.indegree(v5), 3);
		assertEquals(g.indegree(v6), 0);

		assertEquals(q.indegree(w1), 4);
		assertEquals(q.indegree(w2), 0);
		assertEquals(q.indegree(w3), 2);
		assertEquals(q.indegree(w4), 3);
	}

	@Test
	@DisplayName("Tests the verticesCount method")
	void verticesCount() {
		assertEquals(g.verticesCount(), 6);
		assertEquals(q.verticesCount(), 4);
	}

	@Test
	@DisplayName("Tests the edgesCount method")
	void edgesCount() {
		assertEquals(g.edgesCount(), 9);
		assertEquals(q.edgesCount(), 9);
	}

	@Test
	@DisplayName("Tests the containsVertex method")
	void containsVertex() {
		assertTrue(g.containsVertex(v1));
		assertTrue(g.containsVertex(v2));
		assertTrue(g.containsVertex(v3));
		assertTrue(g.containsVertex(v4));
		assertTrue(g.containsVertex(v5));
		assertTrue(g.containsVertex(v6));
		assertFalse(g.containsVertex(new VertexImpl<Integer>(1)));
		assertFalse(g.containsVertex(new VertexImpl<Integer>(2)));
		assertFalse(g.containsVertex(new VertexImpl<Integer>()));
		assertFalse(g.containsVertex(w1));
		assertFalse(g.containsVertex(w2));
		assertFalse(g.containsVertex(w3));
		assertFalse(g.containsVertex(w4));

		assertTrue(q.containsVertex(w1));
		assertTrue(q.containsVertex(w2));
		assertTrue(q.containsVertex(w3));
		assertTrue(q.containsVertex(w4));
		assertFalse(q.containsVertex(new VertexImpl<Integer>(1)));
		assertFalse(q.containsVertex(new VertexImpl<Integer>(2)));
		assertFalse(q.containsVertex(new VertexImpl<Integer>()));
		assertFalse(q.containsVertex(v1));
		assertFalse(q.containsVertex(v2));
		assertFalse(q.containsVertex(v3));
		assertFalse(q.containsVertex(v4));
		assertFalse(q.containsVertex(v5));
		assertFalse(q.containsVertex(v6));
	}

	@Test
	@DisplayName("Tests the clone method")
	void cloneTest() {
		DirectedGraph<Void, Void> g = new AdjListGraphDirected<>();
		Vertex<Void> a = new VertexImpl<>();
		Vertex<Void> b = new VertexImpl<>();
		Vertex<Void> c = new VertexImpl<>();
		Vertex<Void> d = new VertexImpl<>();
		Edge<Void, Void> ab = new EdgeImpl<>(a, b);
		Edge<Void, Void> ac = new EdgeImpl<>(a, c);
		Edge<Void, Void> bc = new EdgeImpl<>(b, c);
		g.addVertex(a);
		g.addVertex(b);
		g.addVertex(c);
		g.addVertex(d);
		g.addEdge(ab);
		g.addEdge(ac);
		g.addEdge(bc);

		DirectedGraph<Void, Void> q = g.clone();
		assertTrue(q.containsVertex(a));
		assertTrue(q.containsVertex(b));
		assertTrue(q.containsVertex(c));
		assertTrue(q.containsVertex(d));
		assertEquals(g.edgesCount(), q.edgesCount());
		assertEquals(g.verticesCount(), q.verticesCount());
		assertEquals(g.indegree(a), q.indegree(a));
		assertEquals(g.indegree(b), q.indegree(b));
		assertEquals(g.indegree(c), q.indegree(c));
		assertEquals(g.indegree(d), q.indegree(d));
		assertEquals(g.outdegree(a), q.outdegree(a));
		assertEquals(g.outdegree(b), q.outdegree(b));
		assertEquals(g.outdegree(c), q.outdegree(c));
		assertEquals(g.outdegree(d), q.outdegree(d));

		var arr1 = new boolean[3];
		g.edges().forEach(e -> {
			if (e == ab) {
				if (arr1[0])
					fail();
				arr1[0] = true;
			} else if (e == ac) {
				if (arr1[1])
					fail();
				arr1[1] = true;
			} else if (e == bc) {
				if (arr1[2])
					fail();
				arr1[2] = true;
			} else {
				fail();
			}
		});
		for (var i = 0; i < 3; i++) {
			if (!arr1[i]) {
				fail();
			}
		}

		var arr2 = new boolean[4];
		g.vertices().forEach(v -> {
			if (v == a) {
				if (arr2[0])
					fail();
				arr2[0] = true;
			} else if (v == b) {
				if (arr2[1])
					fail();
				arr2[1] = true;
			} else if (v == c) {
				if (arr2[2])
					fail();
				arr2[2] = true;
			} else if (v == d) {
				if (arr2[3])
					fail();
				arr2[3] = true;
			} else {
				fail();
			}
		});
		for (var i = 0; i < 4; i++) {
			if (!arr2[i]) {
				fail();
			}
		}

		q.addVertex(new VertexImpl<>());
		assertEquals(g.verticesCount(), 4);

		g.addEdge(new EdgeImpl<>(b, a));
		assertEquals(q.edgesCount(), 3);
	}

	@Test
	@DisplayName("Tests the filterEdges method")
	void filterEdges() {

	}
}
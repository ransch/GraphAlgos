package tests.dataStructures.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dataStructures.graph.AdjListGraphUndirected;
import dataStructures.graph.Edge;
import dataStructures.graph.EdgeImpl;
import dataStructures.graph.UndirectedGraph;
import dataStructures.graph.Vertex;
import dataStructures.graph.VertexImpl;

public class AdjListGraphUndirectedTest {

	UndirectedGraph<Integer, String> g;
	Vertex<Integer> v1, v2, v3, v4, v5;
	Edge<Integer, String> e1, e2, e3, e4, e5;

	@BeforeEach
	void init() {
		g = new AdjListGraphUndirected<>();
		v1 = new VertexImpl<>(1);
		v2 = new VertexImpl<>(2);
		v3 = new VertexImpl<>(null);
		v4 = new VertexImpl<>(1);
		v5 = new VertexImpl<>(2);
		e1 = new EdgeImpl<>(v1, v2, "edge labe 1");
		e2 = new EdgeImpl<>(v2, v1, null);
		e3 = new EdgeImpl<>(v3, v1, "edge label 2");
		e4 = new EdgeImpl<>(v5, v5, "edge label 1");
		e5 = new EdgeImpl<>(v5, v5, "edge label 1");

		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		g.addVertex(v5);
		g.addEdge(e1);
		g.addEdge(e2);
		g.addEdge(e3);
		g.addEdge(e4);
		g.addEdge(e5);
	}

	@Test
	@DisplayName("Tests the adjacent method")
	void connected() {
		assertTrue(g.adjacent(v1, v2));
		assertTrue(g.adjacent(v2, v1));
		assertTrue(g.adjacent(v1, v3));
		assertTrue(g.adjacent(v3, v1));
		assertTrue(g.adjacent(v5, v5));
		assertFalse(g.adjacent(v1, v4));
		assertFalse(g.adjacent(v4, v1));
		assertFalse(g.adjacent(v1, v5));
		assertFalse(g.adjacent(v5, v1));
		assertFalse(g.adjacent(v2, v3));
		assertFalse(g.adjacent(v3, v2));
		assertFalse(g.adjacent(v2, v4));
		assertFalse(g.adjacent(v4, v2));
		assertFalse(g.adjacent(v2, v5));
		assertFalse(g.adjacent(v5, v2));
		assertFalse(g.adjacent(v3, v4));
		assertFalse(g.adjacent(v4, v3));
		assertFalse(g.adjacent(v3, v5));
		assertFalse(g.adjacent(v5, v3));
		assertFalse(g.adjacent(v4, v5));
		assertFalse(g.adjacent(v5, v4));
		assertFalse(g.adjacent(v1, v1));
		assertFalse(g.adjacent(v2, v2));
		assertFalse(g.adjacent(v3, v3));
		assertFalse(g.adjacent(v4, v4));
	}

	@Test
	@DisplayName("Tests the outgoing(v1,v2) method")
	void outgoingVU() {
		assertEquals(g.outgoing(v3, v2).count(), 0);
		assertEquals(g.outgoing(v3, v4).count(), 0);
		assertTrue(g.outgoing(v3, v1).count() == 1 && g.outgoing(v3, v1).findFirst().get() == e3);
		assertTrue(g.outgoing(v1, v3).count() == 1 && g.outgoing(v1, v3).findFirst().get().equals(e3.invert()));

		var arr1 = new boolean[2];
		g.outgoing(v1, v2).forEach(e -> {
			if (e == e1) {
				if (arr1[0])
					fail();
				arr1[0] = true;
			} else if (e.equals(e2.invert())) {
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

		var arr2 = new int[1];
		g.outgoing(v5).forEach(e -> {
			if (e.equals(e4)) {
				arr2[0]++;
			} else {
				fail();
			}
		});
		assertEquals(arr2[0], 4);
	}

	@Test
	@DisplayName("Tests the outgoing(v) method")
	void outgoingV() {
		assertEquals(g.outgoing(v4).count(), 0);
		assertTrue(g.outgoing(v3).count() == 1 && g.outgoing(v3).findFirst().get() == e3);

		var arr1 = new boolean[2];
		g.outgoing(v2).forEach(e -> {
			if (e.equals(e1.invert())) {
				if (arr1[0])
					fail();
				arr1[0] = true;
			} else if (e == e2) {
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
		g.outgoing(v1).forEach(e -> {
			if (e == e1) {
				if (arr2[0])
					fail();
				arr2[0] = true;
			} else if (e.equals(e2.invert())) {
				if (arr2[1])
					fail();
				arr2[1] = true;
			} else if (e.equals(e3.invert())) {
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

		var arr3 = new int[1];
		g.outgoing(v5).forEach(e -> {
			if (e.equals(e4)) {
				arr3[0]++;
			} else {
				fail();
			}
		});
		assertEquals(arr3[0], 4);
	}

	@Test
	@DisplayName("Tests the vertices method")
	void vertices() {
		var arr = new boolean[5];
		g.vertices().forEach(v -> {
			if (v.equals(v1)) {
				if (arr[0])
					fail();
				arr[0] = true;
			} else if (v.equals(v2)) {
				if (arr[1])
					fail();
				arr[1] = true;
			} else if (v.equals(v3)) {
				if (arr[2])
					fail();
				arr[2] = true;
			} else if (v.equals(v4)) {
				if (arr[3])
					fail();
				arr[3] = true;
			} else if (v.equals(v5)) {
				if (arr[4])
					fail();
				arr[4] = true;
			} else {
				fail();
			}
		});
		for (var i = 0; i < 5; i++) {
			if (!arr[i]) {
				fail();
			}
		}
	}

	@Test
	@DisplayName("Tests the edges method")
	void edges() {
		var arr = new boolean[5];
		g.edges().forEach(e -> {
			if (e == e1) {
				if (arr[0])
					fail();
				arr[0] = true;
			} else if (e == e2) {
				if (arr[1])
					fail();
				arr[1] = true;
			} else if (e == e3) {
				if (arr[2])
					fail();
				arr[2] = true;
			} else if (e == e4) {
				if (arr[3])
					fail();
				arr[3] = true;
			} else if (e == e5) {
				if (arr[4])
					fail();
				arr[4] = true;
			} else {
				fail();
			}
		});
		for (var i = 0; i < 5; i++) {
			if (!arr[i]) {
				fail();
			}
		}
	}

	@Test
	@DisplayName("Tests the degree method")
	void degree() {
		assertEquals(g.degree(v1), 3);
		assertEquals(g.degree(v2), 2);
		assertEquals(g.degree(v3), 1);
		assertEquals(g.degree(v4), 0);
		assertEquals(g.degree(v5), 4);
	}

	@Test
	@DisplayName("Tests the verticesCount method")
	void verticesCount() {
		assertEquals(g.verticesCount(), 5);
	}

	@Test
	@DisplayName("Tests the edgesCount method")
	void edgesCount() {
		assertEquals(g.edgesCount(), 5);
	}

	@Test
	@DisplayName("Tests the containsVertex method")
	void containsVertex() {
		assertTrue(g.containsVertex(v1));
		assertTrue(g.containsVertex(v2));
		assertTrue(g.containsVertex(v3));
		assertTrue(g.containsVertex(v4));
		assertTrue(g.containsVertex(v5));
		assertFalse(g.containsVertex(new VertexImpl<Integer>(1)));
		assertFalse(g.containsVertex(new VertexImpl<Integer>(2)));
		assertFalse(g.containsVertex(new VertexImpl<Integer>()));
	}
}
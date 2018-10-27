package tests.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import algorithms.TopologicalSort;
import dataStructures.graph.AdjListGraphDirected;
import dataStructures.graph.DirectedGraph;
import dataStructures.graph.Edge;
import dataStructures.graph.EdgeImpl;
import dataStructures.graph.Vertex;
import dataStructures.graph.VertexImpl;

public class TopologicalSortTest {

	DirectedGraph<Integer, String> g1;
	DirectedGraph<Integer, String> g2;
	DirectedGraph<Integer, String> g3;
	DirectedGraph<Integer, String> g4;
	DirectedGraph<Integer, String> g5;
	DirectedGraph<Integer, String> g6;
	DirectedGraph<Integer, String> g7;
	DirectedGraph<Integer, String> g8;

	Vertex<Integer> v1, v2, v3, v4, v5, v6;
	Edge<Integer, String> e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20,
			e21, e22, e23, e24, e25, e26, e27, e28, e29, e30, e31, e32, e33, e34, e35, e36, e37;

	@BeforeEach
	void init() {
		v1 = new VertexImpl<>();
		v2 = new VertexImpl<>();
		v3 = new VertexImpl<>();
		v4 = new VertexImpl<>();
		v5 = new VertexImpl<>();
		v6 = new VertexImpl<>();

		e1 = new EdgeImpl<>(v1, v2);
		e2 = new EdgeImpl<>(v2, v3);
		e3 = new EdgeImpl<>(v3, v4);
		e4 = new EdgeImpl<>(v4, v5);

		e5 = new EdgeImpl<>(v1, v2);
		e6 = new EdgeImpl<>(v2, v3);
		e7 = new EdgeImpl<>(v5, v1);
		e8 = new EdgeImpl<>(v4, v5);
		e9 = new EdgeImpl<>(v3, v4);

		e10 = new EdgeImpl<>(v1, v2);
		e11 = new EdgeImpl<>(v3, v2);
		e12 = new EdgeImpl<>(v4, v3);
		e13 = new EdgeImpl<>(v4, v5);

		e14 = new EdgeImpl<>(v1, v2);
		e15 = new EdgeImpl<>(v2, v3);
		e16 = new EdgeImpl<>(v3, v4);
		e17 = new EdgeImpl<>(v1, v5);
		e18 = new EdgeImpl<>(v5, v4);

		e19 = new EdgeImpl<>(v1, v2);
		e20 = new EdgeImpl<>(v3, v2);
		e21 = new EdgeImpl<>(v3, v4);
		e22 = new EdgeImpl<>(v5, v4);
		e23 = new EdgeImpl<>(v5, v1);

		e24 = new EdgeImpl<>(v1, v2);
		e25 = new EdgeImpl<>(v2, v3);
		e26 = new EdgeImpl<>(v3, v4);
		e27 = new EdgeImpl<>(v4, v5);
		e28 = new EdgeImpl<>(v4, v6);
		e29 = new EdgeImpl<>(v6, v2);

		e30 = new EdgeImpl<>(v1, v2);
		e31 = new EdgeImpl<>(v2, v3);
		e32 = new EdgeImpl<>(v3, v4);
		e33 = new EdgeImpl<>(v4, v5);
		e34 = new EdgeImpl<>(v2, v6);
		e35 = new EdgeImpl<>(v6, v4);

		e36 = new EdgeImpl<>(v1, v2);
		e37 = new EdgeImpl<>(v2, v1);

		g1 = new AdjListGraphDirected<>();
		g1.addVertex(v1);
		g1.addVertex(v2);
		g1.addVertex(v3);
		g1.addVertex(v4);
		g1.addVertex(v5);
		g1.addEdge(e1);
		g1.addEdge(e2);
		g1.addEdge(e3);
		g1.addEdge(e4);

		g2 = new AdjListGraphDirected<>();
		g2.addVertex(v1);
		g2.addVertex(v2);
		g2.addVertex(v3);
		g2.addVertex(v4);
		g2.addVertex(v5);
		g2.addEdge(e5);
		g2.addEdge(e6);
		g2.addEdge(e7);
		g2.addEdge(e8);
		g2.addEdge(e9);

		g3 = new AdjListGraphDirected<>();
		g3.addVertex(v1);
		g3.addVertex(v2);
		g3.addVertex(v3);
		g3.addVertex(v4);
		g3.addVertex(v5);
		g3.addEdge(e10);
		g3.addEdge(e11);
		g3.addEdge(e12);
		g3.addEdge(e13);

		g4 = new AdjListGraphDirected<>();
		g4.addVertex(v1);
		g4.addVertex(v2);
		g4.addVertex(v3);
		g4.addVertex(v4);
		g4.addVertex(v5);
		g4.addEdge(e14);
		g4.addEdge(e15);
		g4.addEdge(e16);
		g4.addEdge(e17);
		g4.addEdge(e18);

		g5 = new AdjListGraphDirected<>();
		g5.addVertex(v1);
		g5.addVertex(v2);
		g5.addVertex(v3);
		g5.addVertex(v4);
		g5.addVertex(v5);
		g5.addEdge(e19);
		g5.addEdge(e20);
		g5.addEdge(e21);
		g5.addEdge(e22);
		g5.addEdge(e23);

		g6 = new AdjListGraphDirected<>();
		g6.addVertex(v1);
		g6.addVertex(v2);
		g6.addVertex(v3);
		g6.addVertex(v4);
		g6.addVertex(v5);
		g6.addVertex(v6);
		g6.addEdge(e24);
		g6.addEdge(e25);
		g6.addEdge(e26);
		g6.addEdge(e27);
		g6.addEdge(e28);
		g6.addEdge(e29);

		g7 = new AdjListGraphDirected<>();
		g7.addVertex(v1);
		g7.addVertex(v2);
		g7.addVertex(v3);
		g7.addVertex(v4);
		g7.addVertex(v5);
		g7.addVertex(v6);
		g7.addEdge(e30);
		g7.addEdge(e31);
		g7.addEdge(e32);
		g7.addEdge(e33);
		g7.addEdge(e34);
		g7.addEdge(e35);

		g8 = new AdjListGraphDirected<>();
		g8.addVertex(v1);
		g8.addVertex(v2);
		g8.addEdge(e36);
		g8.addEdge(e37);
	}

	@Test
	@DisplayName("Tests the sort method")
	void sort() {
		var sort1 = TopologicalSort.sort(g1).get();
		var sort2 = TopologicalSort.sort(g2);
		var sort3 = TopologicalSort.sort(g3).get();
		var sort4 = TopologicalSort.sort(g4).get();
		var sort5 = TopologicalSort.sort(g5).get();
		var sort6 = TopologicalSort.sort(g6);
		var sort7 = TopologicalSort.sort(g7).get();
		var sort8 = TopologicalSort.sort(g8);

		assertEquals(sort1.size(), g1.verticesCount());
		assertEquals(sort2.isPresent(), false);
		assertEquals(sort3.size(), g3.verticesCount());
		assertEquals(sort4.size(), g4.verticesCount());
		assertEquals(sort5.size(), g5.verticesCount());
		assertEquals(sort6.isPresent(), false);
		assertEquals(sort7.size(), g7.verticesCount());
		assertEquals(sort8.isPresent(), false);

		assertTrue(0 <= sort1.indexOf(e1.getA()) && sort1.indexOf(e1.getA()) < sort1.indexOf(e1.getB()));
		assertTrue(0 <= sort1.indexOf(e2.getA()) && sort1.indexOf(e2.getA()) < sort1.indexOf(e2.getB()));
		assertTrue(0 <= sort1.indexOf(e3.getA()) && sort1.indexOf(e3.getA()) < sort1.indexOf(e3.getB()));
		assertTrue(0 <= sort1.indexOf(e4.getA()) && sort1.indexOf(e4.getA()) < sort1.indexOf(e4.getB()));

		assertTrue(0 <= sort3.indexOf(e10.getA()) && sort3.indexOf(e10.getA()) < sort3.indexOf(e10.getB()));
		assertTrue(0 <= sort3.indexOf(e11.getA()) && sort3.indexOf(e11.getA()) < sort3.indexOf(e11.getB()));
		assertTrue(0 <= sort3.indexOf(e12.getA()) && sort3.indexOf(e12.getA()) < sort3.indexOf(e12.getB()));
		assertTrue(0 <= sort3.indexOf(e13.getA()) && sort3.indexOf(e13.getA()) < sort3.indexOf(e13.getB()));

		assertTrue(0 <= sort4.indexOf(e14.getA()) && sort4.indexOf(e14.getA()) < sort4.indexOf(e14.getB()));
		assertTrue(0 <= sort4.indexOf(e15.getA()) && sort4.indexOf(e15.getA()) < sort4.indexOf(e15.getB()));
		assertTrue(0 <= sort4.indexOf(e16.getA()) && sort4.indexOf(e16.getA()) < sort4.indexOf(e16.getB()));
		assertTrue(0 <= sort4.indexOf(e17.getA()) && sort4.indexOf(e17.getA()) < sort4.indexOf(e17.getB()));
		assertTrue(0 <= sort4.indexOf(e18.getA()) && sort4.indexOf(e18.getA()) < sort4.indexOf(e18.getB()));

		assertTrue(0 <= sort5.indexOf(e19.getA()) && sort5.indexOf(e19.getA()) < sort5.indexOf(e19.getB()));
		assertTrue(0 <= sort5.indexOf(e20.getA()) && sort5.indexOf(e20.getA()) < sort5.indexOf(e20.getB()));
		assertTrue(0 <= sort5.indexOf(e21.getA()) && sort5.indexOf(e21.getA()) < sort5.indexOf(e21.getB()));
		assertTrue(0 <= sort5.indexOf(e22.getA()) && sort5.indexOf(e22.getA()) < sort5.indexOf(e22.getB()));
		assertTrue(0 <= sort5.indexOf(e23.getA()) && sort5.indexOf(e23.getA()) < sort5.indexOf(e23.getB()));

		assertTrue(0 <= sort7.indexOf(e30.getA()) && sort7.indexOf(e30.getA()) < sort7.indexOf(e30.getB()));
		assertTrue(0 <= sort7.indexOf(e31.getA()) && sort7.indexOf(e31.getA()) < sort7.indexOf(e31.getB()));
		assertTrue(0 <= sort7.indexOf(e32.getA()) && sort7.indexOf(e32.getA()) < sort7.indexOf(e32.getB()));
		assertTrue(0 <= sort7.indexOf(e33.getA()) && sort7.indexOf(e33.getA()) < sort7.indexOf(e33.getB()));
		assertTrue(0 <= sort7.indexOf(e34.getA()) && sort7.indexOf(e34.getA()) < sort7.indexOf(e34.getB()));
		assertTrue(0 <= sort7.indexOf(e35.getA()) && sort7.indexOf(e35.getA()) < sort7.indexOf(e35.getB()));
	}
}
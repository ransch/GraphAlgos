package tests.algorithms;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import algorithms.Connectivity;
import dataStructures.graph.AdjListGraphDirected;
import dataStructures.graph.AdjListGraphUndirected;
import dataStructures.graph.DirectedGraph;
import dataStructures.graph.Edge;
import dataStructures.graph.EdgeImpl;
import dataStructures.graph.Graph;
import dataStructures.graph.UndirectedGraph;
import dataStructures.graph.Vertex;
import dataStructures.graph.VertexImpl;

public class ConnectivityTest {

	Vertex<Integer> v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12;
	Edge<Integer, String> e1, e2, e3, e4, e5, e6, e7, e8, e9, e10;

	@BeforeEach
	void init() {
		v1 = new VertexImpl<Integer>(null);
		v2 = new VertexImpl<Integer>(null);
		v3 = new VertexImpl<Integer>(null);
		v4 = new VertexImpl<Integer>(null);
		v5 = new VertexImpl<Integer>(null);
		v6 = new VertexImpl<Integer>(null);
		v7 = new VertexImpl<Integer>(null);
		v8 = new VertexImpl<Integer>(null);
		v9 = new VertexImpl<Integer>(null);
		v10 = new VertexImpl<Integer>(null);
	}

	void initGraph1(Graph<Integer, String> g) {
		e1 = new EdgeImpl<>(v1, v3, null);
		e2 = new EdgeImpl<>(v3, v2, null);
		e3 = new EdgeImpl<>(v3, v5, null);
		e4 = new EdgeImpl<>(v5, v4, null);
		e5 = new EdgeImpl<>(v4, v6, null);
		e6 = new EdgeImpl<>(v6, v9, null);
		e7 = new EdgeImpl<>(v9, v7, null);
		e8 = new EdgeImpl<>(v8, v6, null);
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		g.addVertex(v5);
		g.addVertex(v6);
		g.addVertex(v7);
		g.addVertex(v8);
		g.addVertex(v9);
		g.addVertex(v10);
		g.addEdge(e1);
		g.addEdge(e2);
		g.addEdge(e3);
		g.addEdge(e4);
		g.addEdge(e5);
		g.addEdge(e6);
		g.addEdge(e7);
		g.addEdge(e8);
	}

	@Test
	@DisplayName("Tests the are method on directed graphs")
	void areDirected() {
		DirectedGraph<Integer, String> g = new AdjListGraphDirected<>();
		initGraph1(g);
		assertTrue(Connectivity.are(g, v1, v1));
		assertTrue(Connectivity.are(g, v1, v2));
		assertTrue(Connectivity.are(g, v1, v3));
		assertTrue(Connectivity.are(g, v1, v4));
		assertTrue(Connectivity.are(g, v1, v5));
		assertTrue(Connectivity.are(g, v1, v6));
		assertTrue(Connectivity.are(g, v1, v7));
		assertFalse(Connectivity.are(g, v1, v8));
		assertTrue(Connectivity.are(g, v1, v9));
		assertFalse(Connectivity.are(g, v1, v10));

		assertFalse(Connectivity.are(g, v2, v1));
		assertTrue(Connectivity.are(g, v2, v2));
		assertFalse(Connectivity.are(g, v2, v3));
		assertFalse(Connectivity.are(g, v2, v4));
		assertFalse(Connectivity.are(g, v2, v5));
		assertFalse(Connectivity.are(g, v2, v6));
		assertFalse(Connectivity.are(g, v2, v7));
		assertFalse(Connectivity.are(g, v2, v8));
		assertFalse(Connectivity.are(g, v2, v9));
		assertFalse(Connectivity.are(g, v2, v10));

		assertFalse(Connectivity.are(g, v3, v1));
		assertTrue(Connectivity.are(g, v3, v2));
		assertTrue(Connectivity.are(g, v3, v3));
		assertTrue(Connectivity.are(g, v3, v4));
		assertTrue(Connectivity.are(g, v3, v5));
		assertTrue(Connectivity.are(g, v3, v6));
		assertTrue(Connectivity.are(g, v3, v7));
		assertFalse(Connectivity.are(g, v3, v8));
		assertTrue(Connectivity.are(g, v3, v9));
		assertFalse(Connectivity.are(g, v3, v10));

		assertFalse(Connectivity.are(g, v4, v1));
		assertFalse(Connectivity.are(g, v4, v2));
		assertFalse(Connectivity.are(g, v4, v3));
		assertTrue(Connectivity.are(g, v4, v4));
		assertFalse(Connectivity.are(g, v4, v5));
		assertTrue(Connectivity.are(g, v4, v6));
		assertTrue(Connectivity.are(g, v4, v7));
		assertFalse(Connectivity.are(g, v4, v8));
		assertTrue(Connectivity.are(g, v4, v9));
		assertFalse(Connectivity.are(g, v4, v10));

		assertFalse(Connectivity.are(g, v5, v1));
		assertFalse(Connectivity.are(g, v5, v2));
		assertFalse(Connectivity.are(g, v5, v3));
		assertTrue(Connectivity.are(g, v5, v4));
		assertTrue(Connectivity.are(g, v5, v5));
		assertTrue(Connectivity.are(g, v5, v6));
		assertTrue(Connectivity.are(g, v5, v7));
		assertFalse(Connectivity.are(g, v5, v8));
		assertTrue(Connectivity.are(g, v5, v9));
		assertFalse(Connectivity.are(g, v5, v10));

		assertFalse(Connectivity.are(g, v6, v1));
		assertFalse(Connectivity.are(g, v6, v2));
		assertFalse(Connectivity.are(g, v6, v3));
		assertFalse(Connectivity.are(g, v6, v4));
		assertFalse(Connectivity.are(g, v6, v5));
		assertTrue(Connectivity.are(g, v6, v6));
		assertTrue(Connectivity.are(g, v6, v7));
		assertFalse(Connectivity.are(g, v6, v8));
		assertTrue(Connectivity.are(g, v6, v9));
		assertFalse(Connectivity.are(g, v6, v10));

		assertFalse(Connectivity.are(g, v7, v1));
		assertFalse(Connectivity.are(g, v7, v2));
		assertFalse(Connectivity.are(g, v7, v3));
		assertFalse(Connectivity.are(g, v7, v4));
		assertFalse(Connectivity.are(g, v7, v5));
		assertFalse(Connectivity.are(g, v7, v6));
		assertTrue(Connectivity.are(g, v7, v7));
		assertFalse(Connectivity.are(g, v7, v8));
		assertFalse(Connectivity.are(g, v7, v9));
		assertFalse(Connectivity.are(g, v7, v10));

		assertFalse(Connectivity.are(g, v8, v1));
		assertFalse(Connectivity.are(g, v8, v2));
		assertFalse(Connectivity.are(g, v8, v3));
		assertFalse(Connectivity.are(g, v8, v4));
		assertFalse(Connectivity.are(g, v8, v5));
		assertTrue(Connectivity.are(g, v8, v6));
		assertTrue(Connectivity.are(g, v8, v7));
		assertTrue(Connectivity.are(g, v8, v8));
		assertTrue(Connectivity.are(g, v8, v9));
		assertFalse(Connectivity.are(g, v8, v10));

		assertFalse(Connectivity.are(g, v9, v1));
		assertFalse(Connectivity.are(g, v9, v2));
		assertFalse(Connectivity.are(g, v9, v3));
		assertFalse(Connectivity.are(g, v9, v4));
		assertFalse(Connectivity.are(g, v9, v5));
		assertFalse(Connectivity.are(g, v9, v6));
		assertTrue(Connectivity.are(g, v9, v7));
		assertFalse(Connectivity.are(g, v9, v8));
		assertTrue(Connectivity.are(g, v9, v9));
		assertFalse(Connectivity.are(g, v9, v10));

		assertFalse(Connectivity.are(g, v10, v1));
		assertFalse(Connectivity.are(g, v10, v2));
		assertFalse(Connectivity.are(g, v10, v3));
		assertFalse(Connectivity.are(g, v10, v4));
		assertFalse(Connectivity.are(g, v10, v5));
		assertFalse(Connectivity.are(g, v10, v6));
		assertFalse(Connectivity.are(g, v10, v7));
		assertFalse(Connectivity.are(g, v10, v8));
		assertFalse(Connectivity.are(g, v10, v9));
		assertTrue(Connectivity.are(g, v10, v10));
	}

	@Test
	@DisplayName("Tests the find method on directed graphs")
	void findDirected() {
		DirectedGraph<Integer, String> g = new AdjListGraphDirected<>();
		initGraph1(g);
		Set<Vertex<Integer>> q1 = Connectivity.find(g, v1);
		Set<Vertex<Integer>> q2 = Connectivity.find(g, v2);
		Set<Vertex<Integer>> q3 = Connectivity.find(g, v3);
		Set<Vertex<Integer>> q4 = Connectivity.find(g, v4);
		Set<Vertex<Integer>> q5 = Connectivity.find(g, v5);
		Set<Vertex<Integer>> q6 = Connectivity.find(g, v6);
		Set<Vertex<Integer>> q7 = Connectivity.find(g, v7);
		Set<Vertex<Integer>> q8 = Connectivity.find(g, v8);
		Set<Vertex<Integer>> q9 = Connectivity.find(g, v9);
		Set<Vertex<Integer>> q10 = Connectivity.find(g, v10);

		assertTrue(q1.contains(v1));
		assertTrue(q1.contains(v2));
		assertTrue(q1.contains(v3));
		assertTrue(q1.contains(v4));
		assertTrue(q1.contains(v5));
		assertTrue(q1.contains(v6));
		assertTrue(q1.contains(v7));
		assertFalse(q1.contains(v8));
		assertTrue(q1.contains(v9));
		assertFalse(q1.contains(v10));

		assertFalse(q2.contains(v1));
		assertTrue(q2.contains(v2));
		assertFalse(q2.contains(v3));
		assertFalse(q2.contains(v4));
		assertFalse(q2.contains(v5));
		assertFalse(q2.contains(v6));
		assertFalse(q2.contains(v7));
		assertFalse(q2.contains(v8));
		assertFalse(q2.contains(v9));
		assertFalse(q2.contains(v10));

		assertFalse(q3.contains(v1));
		assertTrue(q3.contains(v2));
		assertTrue(q3.contains(v3));
		assertTrue(q3.contains(v4));
		assertTrue(q3.contains(v5));
		assertTrue(q3.contains(v6));
		assertTrue(q3.contains(v7));
		assertFalse(q3.contains(v8));
		assertTrue(q3.contains(v9));
		assertFalse(q3.contains(v10));

		assertFalse(q4.contains(v1));
		assertFalse(q4.contains(v2));
		assertFalse(q4.contains(v3));
		assertTrue(q4.contains(v4));
		assertFalse(q4.contains(v5));
		assertTrue(q4.contains(v6));
		assertTrue(q4.contains(v7));
		assertFalse(q4.contains(v8));
		assertTrue(q4.contains(v9));
		assertFalse(q4.contains(v10));

		assertFalse(q5.contains(v1));
		assertFalse(q5.contains(v2));
		assertFalse(q5.contains(v3));
		assertTrue(q5.contains(v4));
		assertTrue(q5.contains(v5));
		assertTrue(q5.contains(v6));
		assertTrue(q5.contains(v7));
		assertFalse(q5.contains(v8));
		assertTrue(q5.contains(v9));
		assertFalse(q5.contains(v10));

		assertFalse(q6.contains(v1));
		assertFalse(q6.contains(v2));
		assertFalse(q6.contains(v3));
		assertFalse(q6.contains(v4));
		assertFalse(q6.contains(v5));
		assertTrue(q6.contains(v6));
		assertTrue(q6.contains(v7));
		assertFalse(q6.contains(v8));
		assertTrue(q6.contains(v9));
		assertFalse(q6.contains(v10));

		assertFalse(q7.contains(v1));
		assertFalse(q7.contains(v2));
		assertFalse(q7.contains(v3));
		assertFalse(q7.contains(v4));
		assertFalse(q7.contains(v5));
		assertFalse(q7.contains(v6));
		assertTrue(q7.contains(v7));
		assertFalse(q7.contains(v8));
		assertFalse(q7.contains(v9));
		assertFalse(q7.contains(v10));

		assertFalse(q8.contains(v1));
		assertFalse(q8.contains(v2));
		assertFalse(q8.contains(v3));
		assertFalse(q8.contains(v4));
		assertFalse(q8.contains(v5));
		assertTrue(q8.contains(v6));
		assertTrue(q8.contains(v7));
		assertTrue(q8.contains(v8));
		assertTrue(q8.contains(v9));
		assertFalse(q8.contains(v10));

		assertFalse(q9.contains(v1));
		assertFalse(q9.contains(v2));
		assertFalse(q9.contains(v3));
		assertFalse(q9.contains(v4));
		assertFalse(q9.contains(v5));
		assertFalse(q9.contains(v6));
		assertTrue(q9.contains(v7));
		assertFalse(q9.contains(v8));
		assertTrue(q9.contains(v9));
		assertFalse(q9.contains(v10));

		assertFalse(q10.contains(v1));
		assertFalse(q10.contains(v2));
		assertFalse(q10.contains(v3));
		assertFalse(q10.contains(v4));
		assertFalse(q10.contains(v5));
		assertFalse(q10.contains(v6));
		assertFalse(q10.contains(v7));
		assertFalse(q10.contains(v8));
		assertFalse(q10.contains(v9));
		assertTrue(q10.contains(v10));
	}

	@Test
	@DisplayName("Tests the are method on undirected graphs")
	void areUndirected() {
		UndirectedGraph<Integer, String> g = new AdjListGraphUndirected<>();
		initGraph1(g);
		v11 = new VertexImpl<Integer>(null);
		v12 = new VertexImpl<Integer>(null);
		e9 = new EdgeImpl<Integer, String>(v10, v11, null);
		e10 = new EdgeImpl<Integer, String>(v10, v12, null);
		g.addVertex(v11);
		g.addVertex(v12);
		g.addEdge(e9);
		g.addEdge(e10);

		assertTrue(Connectivity.are(g, v1, v1));
		assertTrue(Connectivity.are(g, v1, v2));
		assertTrue(Connectivity.are(g, v1, v3));
		assertTrue(Connectivity.are(g, v1, v4));
		assertTrue(Connectivity.are(g, v1, v5));
		assertTrue(Connectivity.are(g, v1, v6));
		assertTrue(Connectivity.are(g, v1, v7));
		assertTrue(Connectivity.are(g, v1, v8));
		assertTrue(Connectivity.are(g, v1, v9));
		assertFalse(Connectivity.are(g, v1, v10));
		assertFalse(Connectivity.are(g, v1, v11));
		assertFalse(Connectivity.are(g, v1, v12));

		assertTrue(Connectivity.are(g, v2, v1));
		assertTrue(Connectivity.are(g, v2, v2));
		assertTrue(Connectivity.are(g, v2, v3));
		assertTrue(Connectivity.are(g, v2, v4));
		assertTrue(Connectivity.are(g, v2, v5));
		assertTrue(Connectivity.are(g, v2, v6));
		assertTrue(Connectivity.are(g, v2, v7));
		assertTrue(Connectivity.are(g, v2, v8));
		assertTrue(Connectivity.are(g, v2, v9));
		assertFalse(Connectivity.are(g, v2, v10));
		assertFalse(Connectivity.are(g, v2, v11));
		assertFalse(Connectivity.are(g, v2, v12));

		assertTrue(Connectivity.are(g, v3, v1));
		assertTrue(Connectivity.are(g, v3, v2));
		assertTrue(Connectivity.are(g, v3, v3));
		assertTrue(Connectivity.are(g, v3, v4));
		assertTrue(Connectivity.are(g, v3, v5));
		assertTrue(Connectivity.are(g, v3, v6));
		assertTrue(Connectivity.are(g, v3, v7));
		assertTrue(Connectivity.are(g, v3, v8));
		assertTrue(Connectivity.are(g, v3, v9));
		assertFalse(Connectivity.are(g, v3, v10));
		assertFalse(Connectivity.are(g, v3, v11));
		assertFalse(Connectivity.are(g, v3, v12));

		assertTrue(Connectivity.are(g, v4, v1));
		assertTrue(Connectivity.are(g, v4, v2));
		assertTrue(Connectivity.are(g, v4, v3));
		assertTrue(Connectivity.are(g, v4, v4));
		assertTrue(Connectivity.are(g, v4, v5));
		assertTrue(Connectivity.are(g, v4, v6));
		assertTrue(Connectivity.are(g, v4, v7));
		assertTrue(Connectivity.are(g, v4, v8));
		assertTrue(Connectivity.are(g, v4, v9));
		assertFalse(Connectivity.are(g, v4, v10));
		assertFalse(Connectivity.are(g, v4, v11));
		assertFalse(Connectivity.are(g, v4, v12));

		assertTrue(Connectivity.are(g, v5, v1));
		assertTrue(Connectivity.are(g, v5, v2));
		assertTrue(Connectivity.are(g, v5, v3));
		assertTrue(Connectivity.are(g, v5, v4));
		assertTrue(Connectivity.are(g, v5, v5));
		assertTrue(Connectivity.are(g, v5, v6));
		assertTrue(Connectivity.are(g, v5, v7));
		assertTrue(Connectivity.are(g, v5, v8));
		assertTrue(Connectivity.are(g, v5, v9));
		assertFalse(Connectivity.are(g, v5, v10));
		assertFalse(Connectivity.are(g, v5, v11));
		assertFalse(Connectivity.are(g, v5, v12));

		assertTrue(Connectivity.are(g, v6, v1));
		assertTrue(Connectivity.are(g, v6, v2));
		assertTrue(Connectivity.are(g, v6, v3));
		assertTrue(Connectivity.are(g, v6, v4));
		assertTrue(Connectivity.are(g, v6, v5));
		assertTrue(Connectivity.are(g, v6, v6));
		assertTrue(Connectivity.are(g, v6, v7));
		assertTrue(Connectivity.are(g, v6, v8));
		assertTrue(Connectivity.are(g, v6, v9));
		assertFalse(Connectivity.are(g, v6, v10));
		assertFalse(Connectivity.are(g, v6, v11));
		assertFalse(Connectivity.are(g, v6, v12));

		assertTrue(Connectivity.are(g, v7, v1));
		assertTrue(Connectivity.are(g, v7, v2));
		assertTrue(Connectivity.are(g, v7, v3));
		assertTrue(Connectivity.are(g, v7, v4));
		assertTrue(Connectivity.are(g, v7, v5));
		assertTrue(Connectivity.are(g, v7, v6));
		assertTrue(Connectivity.are(g, v7, v7));
		assertTrue(Connectivity.are(g, v7, v8));
		assertTrue(Connectivity.are(g, v7, v9));
		assertFalse(Connectivity.are(g, v7, v10));
		assertFalse(Connectivity.are(g, v7, v11));
		assertFalse(Connectivity.are(g, v7, v12));

		assertTrue(Connectivity.are(g, v8, v1));
		assertTrue(Connectivity.are(g, v8, v2));
		assertTrue(Connectivity.are(g, v8, v3));
		assertTrue(Connectivity.are(g, v8, v4));
		assertTrue(Connectivity.are(g, v8, v5));
		assertTrue(Connectivity.are(g, v8, v6));
		assertTrue(Connectivity.are(g, v8, v7));
		assertTrue(Connectivity.are(g, v8, v8));
		assertTrue(Connectivity.are(g, v8, v9));
		assertFalse(Connectivity.are(g, v8, v10));
		assertFalse(Connectivity.are(g, v8, v11));
		assertFalse(Connectivity.are(g, v8, v12));

		assertTrue(Connectivity.are(g, v9, v1));
		assertTrue(Connectivity.are(g, v9, v2));
		assertTrue(Connectivity.are(g, v9, v3));
		assertTrue(Connectivity.are(g, v9, v4));
		assertTrue(Connectivity.are(g, v9, v5));
		assertTrue(Connectivity.are(g, v9, v6));
		assertTrue(Connectivity.are(g, v9, v7));
		assertTrue(Connectivity.are(g, v9, v8));
		assertTrue(Connectivity.are(g, v9, v9));
		assertFalse(Connectivity.are(g, v9, v10));
		assertFalse(Connectivity.are(g, v9, v11));
		assertFalse(Connectivity.are(g, v9, v12));

		assertFalse(Connectivity.are(g, v10, v1));
		assertFalse(Connectivity.are(g, v10, v2));
		assertFalse(Connectivity.are(g, v10, v3));
		assertFalse(Connectivity.are(g, v10, v4));
		assertFalse(Connectivity.are(g, v10, v5));
		assertFalse(Connectivity.are(g, v10, v6));
		assertFalse(Connectivity.are(g, v10, v7));
		assertFalse(Connectivity.are(g, v10, v8));
		assertFalse(Connectivity.are(g, v10, v9));
		assertTrue(Connectivity.are(g, v10, v10));
		assertTrue(Connectivity.are(g, v10, v11));
		assertTrue(Connectivity.are(g, v10, v12));

		assertFalse(Connectivity.are(g, v11, v1));
		assertFalse(Connectivity.are(g, v11, v2));
		assertFalse(Connectivity.are(g, v11, v3));
		assertFalse(Connectivity.are(g, v11, v4));
		assertFalse(Connectivity.are(g, v11, v5));
		assertFalse(Connectivity.are(g, v11, v6));
		assertFalse(Connectivity.are(g, v11, v7));
		assertFalse(Connectivity.are(g, v11, v8));
		assertFalse(Connectivity.are(g, v11, v9));
		assertTrue(Connectivity.are(g, v11, v10));
		assertTrue(Connectivity.are(g, v11, v11));
		assertTrue(Connectivity.are(g, v11, v12));

		assertFalse(Connectivity.are(g, v12, v1));
		assertFalse(Connectivity.are(g, v12, v2));
		assertFalse(Connectivity.are(g, v12, v3));
		assertFalse(Connectivity.are(g, v12, v4));
		assertFalse(Connectivity.are(g, v12, v5));
		assertFalse(Connectivity.are(g, v12, v6));
		assertFalse(Connectivity.are(g, v12, v7));
		assertFalse(Connectivity.are(g, v12, v8));
		assertFalse(Connectivity.are(g, v12, v9));
		assertTrue(Connectivity.are(g, v12, v10));
		assertTrue(Connectivity.are(g, v12, v11));
		assertTrue(Connectivity.are(g, v12, v12));
	}

	@Test
	@DisplayName("Tests the find method on undirected graphs")
	void findUndirected() {
		UndirectedGraph<Integer, String> g = new AdjListGraphUndirected<>();
		initGraph1(g);
		v11 = new VertexImpl<Integer>(null);
		v12 = new VertexImpl<Integer>(null);
		e9 = new EdgeImpl<Integer, String>(v10, v11, null);
		e10 = new EdgeImpl<Integer, String>(v10, v12, null);
		g.addVertex(v11);
		g.addVertex(v12);
		g.addEdge(e9);
		g.addEdge(e10);
		Set<Vertex<Integer>> q1 = Connectivity.find(g, v1);
		Set<Vertex<Integer>> q2 = Connectivity.find(g, v2);
		Set<Vertex<Integer>> q3 = Connectivity.find(g, v3);
		Set<Vertex<Integer>> q4 = Connectivity.find(g, v4);
		Set<Vertex<Integer>> q5 = Connectivity.find(g, v5);
		Set<Vertex<Integer>> q6 = Connectivity.find(g, v6);
		Set<Vertex<Integer>> q7 = Connectivity.find(g, v7);
		Set<Vertex<Integer>> q8 = Connectivity.find(g, v8);
		Set<Vertex<Integer>> q9 = Connectivity.find(g, v9);
		Set<Vertex<Integer>> q10 = Connectivity.find(g, v10);
		Set<Vertex<Integer>> q11 = Connectivity.find(g, v11);
		Set<Vertex<Integer>> q12 = Connectivity.find(g, v12);

		assertTrue(q1.contains(v1));
		assertTrue(q1.contains(v2));
		assertTrue(q1.contains(v3));
		assertTrue(q1.contains(v4));
		assertTrue(q1.contains(v5));
		assertTrue(q1.contains(v6));
		assertTrue(q1.contains(v7));
		assertTrue(q1.contains(v8));
		assertTrue(q1.contains(v9));
		assertFalse(q1.contains(v10));
		assertFalse(q1.contains(v11));
		assertFalse(q1.contains(v12));

		assertTrue(q2.contains(v1));
		assertTrue(q2.contains(v2));
		assertTrue(q2.contains(v3));
		assertTrue(q2.contains(v4));
		assertTrue(q2.contains(v5));
		assertTrue(q2.contains(v6));
		assertTrue(q2.contains(v7));
		assertTrue(q2.contains(v8));
		assertTrue(q2.contains(v9));
		assertFalse(q2.contains(v10));
		assertFalse(q2.contains(v11));
		assertFalse(q2.contains(v12));

		assertTrue(q3.contains(v1));
		assertTrue(q3.contains(v2));
		assertTrue(q3.contains(v3));
		assertTrue(q3.contains(v4));
		assertTrue(q3.contains(v5));
		assertTrue(q3.contains(v6));
		assertTrue(q3.contains(v7));
		assertTrue(q3.contains(v8));
		assertTrue(q3.contains(v9));
		assertFalse(q3.contains(v10));
		assertFalse(q3.contains(v11));
		assertFalse(q3.contains(v12));

		assertTrue(q4.contains(v1));
		assertTrue(q4.contains(v2));
		assertTrue(q4.contains(v3));
		assertTrue(q4.contains(v4));
		assertTrue(q4.contains(v5));
		assertTrue(q4.contains(v6));
		assertTrue(q4.contains(v7));
		assertTrue(q4.contains(v8));
		assertTrue(q4.contains(v9));
		assertFalse(q4.contains(v10));
		assertFalse(q4.contains(v11));
		assertFalse(q4.contains(v12));

		assertTrue(q5.contains(v1));
		assertTrue(q5.contains(v2));
		assertTrue(q5.contains(v3));
		assertTrue(q5.contains(v4));
		assertTrue(q5.contains(v5));
		assertTrue(q5.contains(v6));
		assertTrue(q5.contains(v7));
		assertTrue(q5.contains(v8));
		assertTrue(q5.contains(v9));
		assertFalse(q5.contains(v10));
		assertFalse(q5.contains(v11));
		assertFalse(q5.contains(v12));

		assertTrue(q6.contains(v1));
		assertTrue(q6.contains(v2));
		assertTrue(q6.contains(v3));
		assertTrue(q6.contains(v4));
		assertTrue(q6.contains(v5));
		assertTrue(q6.contains(v6));
		assertTrue(q6.contains(v7));
		assertTrue(q6.contains(v8));
		assertTrue(q6.contains(v9));
		assertFalse(q6.contains(v10));
		assertFalse(q6.contains(v11));
		assertFalse(q6.contains(v12));

		assertTrue(q7.contains(v1));
		assertTrue(q7.contains(v2));
		assertTrue(q7.contains(v3));
		assertTrue(q7.contains(v4));
		assertTrue(q7.contains(v5));
		assertTrue(q7.contains(v6));
		assertTrue(q7.contains(v7));
		assertTrue(q7.contains(v8));
		assertTrue(q7.contains(v9));
		assertFalse(q7.contains(v10));
		assertFalse(q7.contains(v11));
		assertFalse(q7.contains(v12));

		assertTrue(q8.contains(v1));
		assertTrue(q8.contains(v2));
		assertTrue(q8.contains(v3));
		assertTrue(q8.contains(v4));
		assertTrue(q8.contains(v5));
		assertTrue(q8.contains(v6));
		assertTrue(q8.contains(v7));
		assertTrue(q8.contains(v8));
		assertTrue(q8.contains(v9));
		assertFalse(q8.contains(v10));
		assertFalse(q8.contains(v11));
		assertFalse(q8.contains(v12));

		assertTrue(q9.contains(v1));
		assertTrue(q9.contains(v2));
		assertTrue(q9.contains(v3));
		assertTrue(q9.contains(v4));
		assertTrue(q9.contains(v5));
		assertTrue(q9.contains(v6));
		assertTrue(q9.contains(v7));
		assertTrue(q9.contains(v8));
		assertTrue(q9.contains(v9));
		assertFalse(q9.contains(v10));
		assertFalse(q9.contains(v11));
		assertFalse(q9.contains(v12));

		assertFalse(q10.contains(v1));
		assertFalse(q10.contains(v2));
		assertFalse(q10.contains(v3));
		assertFalse(q10.contains(v4));
		assertFalse(q10.contains(v5));
		assertFalse(q10.contains(v6));
		assertFalse(q10.contains(v7));
		assertFalse(q10.contains(v8));
		assertFalse(q10.contains(v9));
		assertTrue(q10.contains(v10));
		assertTrue(q10.contains(v11));
		assertTrue(q10.contains(v12));

		assertFalse(q11.contains(v1));
		assertFalse(q11.contains(v2));
		assertFalse(q11.contains(v3));
		assertFalse(q11.contains(v4));
		assertFalse(q11.contains(v5));
		assertFalse(q11.contains(v6));
		assertFalse(q11.contains(v7));
		assertFalse(q11.contains(v8));
		assertFalse(q11.contains(v9));
		assertTrue(q11.contains(v10));
		assertTrue(q11.contains(v11));
		assertTrue(q11.contains(v12));

		assertFalse(q12.contains(v1));
		assertFalse(q12.contains(v2));
		assertFalse(q12.contains(v3));
		assertFalse(q12.contains(v4));
		assertFalse(q12.contains(v5));
		assertFalse(q12.contains(v6));
		assertFalse(q12.contains(v7));
		assertFalse(q12.contains(v8));
		assertFalse(q12.contains(v9));
		assertTrue(q12.contains(v10));
		assertTrue(q12.contains(v11));
		assertTrue(q12.contains(v12));
	}

	@Test
	@DisplayName("Tests the connected method")
	void connected() {
		UndirectedGraph<Integer, String> g = new AdjListGraphUndirected<>();
		initGraph1(g);
		assertFalse(Connectivity.connected(g));

		g = new AdjListGraphUndirected<>();
		initGraph1(g);
		v11 = new VertexImpl<Integer>(null);
		v12 = new VertexImpl<Integer>(null);
		e9 = new EdgeImpl<Integer, String>(v10, v11, null);
		e10 = new EdgeImpl<Integer, String>(v10, v12, null);
		g.addVertex(v11);
		g.addVertex(v12);
		g.addEdge(e9);
		g.addEdge(e10);
		assertFalse(Connectivity.connected(g));

		g = new AdjListGraphUndirected<>();
		initGraph1(g);
		e9 = new EdgeImpl<Integer, String>(v10, v1, null);
		g.addEdge(e9);
		assertTrue(Connectivity.connected(g));

		g = new AdjListGraphUndirected<>();
		initGraph1(g);
		e9 = new EdgeImpl<Integer, String>(v10, v2, null);
		g.addEdge(e9);
		assertTrue(Connectivity.connected(g));

		g = new AdjListGraphUndirected<>();
		initGraph1(g);
		e9 = new EdgeImpl<Integer, String>(v10, v3, null);
		g.addEdge(e9);
		assertTrue(Connectivity.connected(g));

		g = new AdjListGraphUndirected<>();
		initGraph1(g);
		e9 = new EdgeImpl<Integer, String>(v10, v4, null);
		g.addEdge(e9);
		assertTrue(Connectivity.connected(g));

		g = new AdjListGraphUndirected<>();
		initGraph1(g);
		e9 = new EdgeImpl<Integer, String>(v10, v5, null);
		g.addEdge(e9);
		assertTrue(Connectivity.connected(g));

		g = new AdjListGraphUndirected<>();
		initGraph1(g);
		e9 = new EdgeImpl<Integer, String>(v10, v6, null);
		g.addEdge(e9);
		assertTrue(Connectivity.connected(g));

		g = new AdjListGraphUndirected<>();
		initGraph1(g);
		e9 = new EdgeImpl<Integer, String>(v10, v7, null);
		g.addEdge(e9);
		assertTrue(Connectivity.connected(g));

		g = new AdjListGraphUndirected<>();
		initGraph1(g);
		e9 = new EdgeImpl<Integer, String>(v10, v8, null);
		g.addEdge(e9);
		assertTrue(Connectivity.connected(g));

		g = new AdjListGraphUndirected<>();
		initGraph1(g);
		e9 = new EdgeImpl<Integer, String>(v10, v9, null);
		g.addEdge(e9);
		assertTrue(Connectivity.connected(g));

		g = new AdjListGraphUndirected<>();
		initGraph1(g);
		e9 = new EdgeImpl<Integer, String>(v1, v10, null);
		g.addEdge(e9);
		assertTrue(Connectivity.connected(g));

		g = new AdjListGraphUndirected<>();
		initGraph1(g);
		e9 = new EdgeImpl<Integer, String>(v2, v10, null);
		g.addEdge(e9);
		assertTrue(Connectivity.connected(g));

		g = new AdjListGraphUndirected<>();
		initGraph1(g);
		e9 = new EdgeImpl<Integer, String>(v3, v10, null);
		g.addEdge(e9);
		assertTrue(Connectivity.connected(g));

		g = new AdjListGraphUndirected<>();
		initGraph1(g);
		e9 = new EdgeImpl<Integer, String>(v4, v10, null);
		g.addEdge(e9);
		assertTrue(Connectivity.connected(g));

		g = new AdjListGraphUndirected<>();
		initGraph1(g);
		e9 = new EdgeImpl<Integer, String>(v5, v10, null);
		g.addEdge(e9);
		assertTrue(Connectivity.connected(g));

		g = new AdjListGraphUndirected<>();
		initGraph1(g);
		e9 = new EdgeImpl<Integer, String>(v6, v10, null);
		g.addEdge(e9);
		assertTrue(Connectivity.connected(g));

		g = new AdjListGraphUndirected<>();
		initGraph1(g);
		e9 = new EdgeImpl<Integer, String>(v7, v10, null);
		g.addEdge(e9);
		assertTrue(Connectivity.connected(g));

		g = new AdjListGraphUndirected<>();
		initGraph1(g);
		e9 = new EdgeImpl<Integer, String>(v8, v10, null);
		g.addEdge(e9);
		assertTrue(Connectivity.connected(g));

		g = new AdjListGraphUndirected<>();
		initGraph1(g);
		e9 = new EdgeImpl<Integer, String>(v9, v10, null);
		g.addEdge(e9);
		assertTrue(Connectivity.connected(g));
	}

	@Test
	@DisplayName("Tests the connectedComponents method")
	void connectedComponents() {
		UndirectedGraph<Integer, String> g = new AdjListGraphUndirected<>();
		Vertex<Integer> v1, v2, v3, v4, v5, v6, v7, v8, v9;
		Edge<Integer, String> e1, e2, e3, e4, e5;
		v1 = new VertexImpl<>();
		v2 = new VertexImpl<>();
		v3 = new VertexImpl<>();
		v4 = new VertexImpl<>();
		v5 = new VertexImpl<>();
		v6 = new VertexImpl<>();
		v7 = new VertexImpl<>();
		v8 = new VertexImpl<>();
		v9 = new VertexImpl<>();
		e1 = new EdgeImpl<>(v2, v3);
		e2 = new EdgeImpl<>(v3, v4);
		e3 = new EdgeImpl<>(v6, v5);
		e4 = new EdgeImpl<>(v6, v7);
		e5 = new EdgeImpl<>(v2, v9);
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		g.addVertex(v5);
		g.addVertex(v6);
		g.addVertex(v7);
		g.addVertex(v8);
		g.addVertex(v9);
		g.addEdge(e1);
		g.addEdge(e2);
		g.addEdge(e3);
		g.addEdge(e4);
		g.addEdge(e5);

		List<Set<Vertex<Integer>>> comp = Connectivity.connectedComponents(g);
		Set<Vertex<Integer>> s1, s2, s3, s4;
		s1 = new HashSet<>();
		s2 = new HashSet<>();
		s3 = new HashSet<>();
		s4 = new HashSet<>();
		s1.add(v1);
		s2.add(v2);
		s2.add(v3);
		s2.add(v4);
		s3.add(v5);
		s3.add(v6);
		s3.add(v7);
		s4.add(v8);
		s2.add(v9);

		var arr = new boolean[4];
		comp.stream().forEach(s -> {
			if (s.equals(s1)) {
				if (arr[0])
					fail();
				arr[0] = true;
			} else if (s.equals(s2)) {
				if (arr[1])
					fail();
				arr[1] = true;
			} else if (s.equals(s3)) {
				if (arr[2])
					fail();
				arr[2] = true;
			} else if (s.equals(s4)) {
				if (arr[3])
					fail();
				arr[3] = true;
			} else {
				fail();
			}
		});
		for (var i = 0; i < 4; i++) {
			if (!arr[i]) {
				fail();
			}
		}
	}
}
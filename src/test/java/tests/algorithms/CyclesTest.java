package tests.algorithms;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import algorithms.Cycles;
import dataStructures.graph.AdjListGraphDirected;
import dataStructures.graph.DirectedGraph;
import dataStructures.graph.Edge;
import dataStructures.graph.EdgeImpl;
import dataStructures.graph.Vertex;
import dataStructures.graph.VertexImpl;
import dataStructures.graph.Weight;
import dataStructures.graph.WeightImpl;

public class CyclesTest {

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
	@DisplayName("Tests the isAcyclic method")
	void isAcyclic() {
		assertTrue(Cycles.isAcyclic(g1));
		assertFalse(Cycles.isAcyclic(g2));
		assertTrue(Cycles.isAcyclic(g3));
		assertTrue(Cycles.isAcyclic(g4));
		assertTrue(Cycles.isAcyclic(g5));
		assertFalse(Cycles.isAcyclic(g6));
		assertTrue(Cycles.isAcyclic(g7));
		assertFalse(Cycles.isAcyclic(g8));
	}

	@Test
	@DisplayName("Tests the containsZeroCycle method")
	void containsZeroCycle() {
		DirectedGraph<Void, Weight> k1 = new AdjListGraphDirected<>();
		DirectedGraph<Void, Weight> k2 = new AdjListGraphDirected<>();
		DirectedGraph<Void, Weight> k3 = new AdjListGraphDirected<>();
		DirectedGraph<Void, Weight> k4 = new AdjListGraphDirected<>();

		Vertex<Void> w1, w2, w3, w4, w5, w6, w7, w8;
		Edge<Void, Weight> f1, f2, f3a, f3b, f3c, f3d, f4, f5, f6, f7, f8;
		w1 = new VertexImpl<>();
		w2 = new VertexImpl<>();
		w3 = new VertexImpl<>();
		w4 = new VertexImpl<>();
		w5 = new VertexImpl<>();
		w6 = new VertexImpl<>();
		w7 = new VertexImpl<>();
		w8 = new VertexImpl<>();
		f1 = new EdgeImpl<>(w1, w2, new WeightImpl(1));
		f2 = new EdgeImpl<>(w2, w3, new WeightImpl(8));
		f3a = new EdgeImpl<>(w3, w1, new WeightImpl(-9));
		f3b = new EdgeImpl<>(w3, w1, new WeightImpl(-8.9));
		f3c = new EdgeImpl<>(w3, w2, new WeightImpl(-8));
		f3d = new EdgeImpl<>(w3, w2, new WeightImpl(-7.9));
		f4 = new EdgeImpl<>(w1, w4, new WeightImpl(1));
		f5 = new EdgeImpl<>(w4, w5, new WeightImpl(9));
		f6 = new EdgeImpl<>(w5, w6, new WeightImpl(-3));
		f7 = new EdgeImpl<>(w2, w5, new WeightImpl(4));
		f8 = new EdgeImpl<>(w6, w3, new WeightImpl(28));

		k1.addVertex(w1);
		k1.addVertex(w2);
		k1.addVertex(w3);
		k1.addVertex(w4);
		k1.addVertex(w5);
		k1.addVertex(w6);
		k1.addVertex(w7);
		k1.addVertex(w8);
		k1.addEdge(f1);
		k1.addEdge(f2);
		k1.addEdge(f3a);
		k1.addEdge(f4);
		k1.addEdge(f5);
		k1.addEdge(f6);
		k1.addEdge(f7);
		k1.addEdge(f8);

		k2.addVertex(w1);
		k2.addVertex(w2);
		k2.addVertex(w3);
		k2.addVertex(w4);
		k2.addVertex(w5);
		k2.addVertex(w6);
		k2.addVertex(w7);
		k2.addVertex(w8);
		k2.addEdge(f1);
		k2.addEdge(f2);
		k2.addEdge(f3b);
		k2.addEdge(f4);
		k2.addEdge(f5);
		k2.addEdge(f6);
		k2.addEdge(f7);
		k2.addEdge(f8);

		k3.addVertex(w1);
		k3.addVertex(w2);
		k3.addVertex(w3);
		k3.addVertex(w4);
		k3.addVertex(w5);
		k3.addVertex(w6);
		k3.addVertex(w7);
		k3.addVertex(w8);
		k3.addEdge(f1);
		k3.addEdge(f2);
		k3.addEdge(f3c);
		k3.addEdge(f4);
		k3.addEdge(f5);
		k3.addEdge(f6);
		k3.addEdge(f7);
		k3.addEdge(f8);

		k4.addVertex(w1);
		k4.addVertex(w2);
		k4.addVertex(w3);
		k4.addVertex(w4);
		k4.addVertex(w5);
		k4.addVertex(w6);
		k4.addVertex(w7);
		k4.addVertex(w8);
		k4.addEdge(f1);
		k4.addEdge(f2);
		k4.addEdge(f3d);
		k4.addEdge(f4);
		k4.addEdge(f5);
		k4.addEdge(f6);
		k4.addEdge(f7);
		k4.addEdge(f8);

		assertTrue(Cycles.containsZeroCycle(k1));
		assertFalse(Cycles.containsZeroCycle(k2));
		assertTrue(Cycles.containsZeroCycle(k3));
		assertFalse(Cycles.containsZeroCycle(k4));
	}

	@Test
	@DisplayName("Tests the containsNegativeCycle method")
	void containsNegativeCycle() {
		DirectedGraph<Void, Weight> k1 = new AdjListGraphDirected<>();
		DirectedGraph<Void, Weight> k2 = new AdjListGraphDirected<>();
		DirectedGraph<Void, Weight> k3 = new AdjListGraphDirected<>();
		DirectedGraph<Void, Weight> k4 = new AdjListGraphDirected<>();

		Vertex<Void> w1, w2, w3, w4, w5, w6, w7, w8;
		Edge<Void, Weight> f1, f2, f3a, f3b, f3c, f3d, f4, f5, f6, f7, f8;
		w1 = new VertexImpl<>();
		w2 = new VertexImpl<>();
		w3 = new VertexImpl<>();
		w4 = new VertexImpl<>();
		w5 = new VertexImpl<>();
		w6 = new VertexImpl<>();
		w7 = new VertexImpl<>();
		w8 = new VertexImpl<>();
		f1 = new EdgeImpl<>(w1, w2, new WeightImpl(1));
		f2 = new EdgeImpl<>(w2, w3, new WeightImpl(8));
		f3a = new EdgeImpl<>(w3, w1, new WeightImpl(-9));
		f3b = new EdgeImpl<>(w3, w1, new WeightImpl(-9.1));
		f3c = new EdgeImpl<>(w3, w2, new WeightImpl(-8));
		f3d = new EdgeImpl<>(w3, w2, new WeightImpl(-8.1));
		f4 = new EdgeImpl<>(w1, w4, new WeightImpl(1));
		f5 = new EdgeImpl<>(w4, w5, new WeightImpl(9));
		f6 = new EdgeImpl<>(w5, w6, new WeightImpl(-3));
		f7 = new EdgeImpl<>(w2, w5, new WeightImpl(4));
		f8 = new EdgeImpl<>(w6, w3, new WeightImpl(28));

		k1.addVertex(w1);
		k1.addVertex(w2);
		k1.addVertex(w3);
		k1.addVertex(w4);
		k1.addVertex(w5);
		k1.addVertex(w6);
		k1.addVertex(w7);
		k1.addVertex(w8);
		k1.addEdge(f1);
		k1.addEdge(f2);
		k1.addEdge(f3a);
		k1.addEdge(f4);
		k1.addEdge(f5);
		k1.addEdge(f6);
		k1.addEdge(f7);
		k1.addEdge(f8);

		k2.addVertex(w1);
		k2.addVertex(w2);
		k2.addVertex(w3);
		k2.addVertex(w4);
		k2.addVertex(w5);
		k2.addVertex(w6);
		k2.addVertex(w7);
		k2.addVertex(w8);
		k2.addEdge(f1);
		k2.addEdge(f2);
		k2.addEdge(f3b);
		k2.addEdge(f4);
		k2.addEdge(f5);
		k2.addEdge(f6);
		k2.addEdge(f7);
		k2.addEdge(f8);

		k3.addVertex(w1);
		k3.addVertex(w2);
		k3.addVertex(w3);
		k3.addVertex(w4);
		k3.addVertex(w5);
		k3.addVertex(w6);
		k3.addVertex(w7);
		k3.addVertex(w8);
		k3.addEdge(f1);
		k3.addEdge(f2);
		k3.addEdge(f3c);
		k3.addEdge(f4);
		k3.addEdge(f5);
		k3.addEdge(f6);
		k3.addEdge(f7);
		k3.addEdge(f8);

		k4.addVertex(w1);
		k4.addVertex(w2);
		k4.addVertex(w3);
		k4.addVertex(w4);
		k4.addVertex(w5);
		k4.addVertex(w6);
		k4.addVertex(w7);
		k4.addVertex(w8);
		k4.addEdge(f1);
		k4.addEdge(f2);
		k4.addEdge(f3d);
		k4.addEdge(f4);
		k4.addEdge(f5);
		k4.addEdge(f6);
		k4.addEdge(f7);
		k4.addEdge(f8);

		assertFalse(Cycles.containsNegativeCycle(k1));
		assertTrue(Cycles.containsNegativeCycle(k2));
		assertFalse(Cycles.containsNegativeCycle(k3));
		assertTrue(Cycles.containsNegativeCycle(k4));
	}
}
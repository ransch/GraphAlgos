package tests.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import algorithms.SSSP;
import dataStructures.graph.AdjListGraphDirected;
import dataStructures.graph.AdjListGraphUndirected;
import dataStructures.graph.DirectedGraph;
import dataStructures.graph.Edge;
import dataStructures.graph.EdgeImpl;
import dataStructures.graph.UndirectedGraph;
import dataStructures.graph.Vertex;
import dataStructures.graph.VertexImpl;
import dataStructures.graph.Weight;
import dataStructures.graph.WeightImpl;

public class SSSPTest {

	DirectedGraph<Void, Weight> graph, k;
	Vertex<Void> s, t, x, y, z, w1, w2, w3, w4, w5, w6, w7;
	Edge<Void, Weight> st, sy, tx, yz, zs, yx, ty, yt, xz, zx, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13,
			f14;

	void BFInitGraph() {
		k = new AdjListGraphDirected<>();

		w1 = new VertexImpl<>();
		w2 = new VertexImpl<>();
		w3 = new VertexImpl<>();
		w4 = new VertexImpl<>();
		w5 = new VertexImpl<>();
		w6 = new VertexImpl<>();
		w7 = new VertexImpl<>();
		f1 = new EdgeImpl<>(w1, w2, new WeightImpl(0));
		f2 = new EdgeImpl<>(w1, w3, new WeightImpl(0));
		f3 = new EdgeImpl<>(w1, w4, new WeightImpl(0));
		f4 = new EdgeImpl<>(w1, w5, new WeightImpl(0));
		f5 = new EdgeImpl<>(w1, w6, new WeightImpl(0));
		f6 = new EdgeImpl<>(w1, w7, new WeightImpl(0));
		f7 = new EdgeImpl<>(w2, w3, new WeightImpl(1));
		f8 = new EdgeImpl<>(w3, w4, new WeightImpl(9));
		f9 = new EdgeImpl<>(w2, w5, new WeightImpl(1));
		f10 = new EdgeImpl<>(w5, w4, new WeightImpl(4));
		f11 = new EdgeImpl<>(w5, w6, new WeightImpl(8));
		f12 = new EdgeImpl<>(w6, w2, new WeightImpl(-9));
		f13 = new EdgeImpl<>(w4, w7, new WeightImpl(-3));
		f14 = new EdgeImpl<>(w7, w6, new WeightImpl(28));

		k.addVertex(w1);
		k.addVertex(w2);
		k.addVertex(w3);
		k.addVertex(w4);
		k.addVertex(w5);
		k.addVertex(w6);
		k.addVertex(w7);
		k.addEdge(f1);
		k.addEdge(f2);
		k.addEdge(f3);
		k.addEdge(f4);
		k.addEdge(f5);
		k.addEdge(f6);
		k.addEdge(f7);
		k.addEdge(f8);
		k.addEdge(f9);
		k.addEdge(f10);
		k.addEdge(f11);
		k.addEdge(f12);
		k.addEdge(f13);
		k.addEdge(f14);
	}

	@BeforeEach
	void init() {
		graph = new AdjListGraphDirected<>();
		s = new VertexImpl<>();
		t = new VertexImpl<>();
		x = new VertexImpl<>();
		y = new VertexImpl<>();
		z = new VertexImpl<>();
		st = new EdgeImpl<>(s, t, new WeightImpl(3));
		sy = new EdgeImpl<>(s, y, new WeightImpl(5));
		tx = new EdgeImpl<>(t, x, new WeightImpl(6));
		yz = new EdgeImpl<>(y, z, new WeightImpl(6));
		zs = new EdgeImpl<>(z, s, new WeightImpl(3));
		yx = new EdgeImpl<>(y, x, new WeightImpl(4));
		ty = new EdgeImpl<>(t, y, new WeightImpl(2));
		yt = new EdgeImpl<>(y, t, new WeightImpl(1));
		xz = new EdgeImpl<>(x, z, new WeightImpl(2));
		zx = new EdgeImpl<>(z, x, new WeightImpl(7));
		graph.addVertex(s);
		graph.addVertex(t);
		graph.addVertex(x);
		graph.addVertex(y);
		graph.addVertex(z);
		graph.addEdge(st);
		graph.addEdge(sy);
		graph.addEdge(tx);
		graph.addEdge(yz);
		graph.addEdge(zs);
		graph.addEdge(yx);
		graph.addEdge(ty);
		graph.addEdge(yt);
		graph.addEdge(xz);
		graph.addEdge(zx);
	}

	@Test
	@DisplayName("Tests the BellmanFord method")
	void BellmanFord() {
		DirectedGraph<Void, Weight> graph1;
		Vertex<Void> s1, a, b, c, d, e, f, g;
		Edge<Void, Weight> sa, sc, se, ef, fe, cd, dc, ab, bg, dg, fg;
		graph1 = new AdjListGraphDirected<>();
		s1 = new VertexImpl<>();
		a = new VertexImpl<>();
		b = new VertexImpl<>();
		c = new VertexImpl<>();
		d = new VertexImpl<>();
		e = new VertexImpl<>();
		f = new VertexImpl<>();
		g = new VertexImpl<>();
		sa = new EdgeImpl<>(s1, a, new WeightImpl(3));
		sc = new EdgeImpl<>(s1, c, new WeightImpl(5));
		se = new EdgeImpl<>(s1, e, new WeightImpl(2));
		ef = new EdgeImpl<>(e, f, new WeightImpl(3));
		fe = new EdgeImpl<>(f, e, new WeightImpl(-6));
		cd = new EdgeImpl<>(c, d, new WeightImpl(6));
		dc = new EdgeImpl<>(d, c, new WeightImpl(-3));
		ab = new EdgeImpl<>(a, b, new WeightImpl(-4));
		bg = new EdgeImpl<>(b, g, new WeightImpl(4));
		dg = new EdgeImpl<>(d, g, new WeightImpl(8));
		fg = new EdgeImpl<>(f, g, new WeightImpl(7));
		graph1.addVertex(s1);
		graph1.addVertex(a);
		graph1.addVertex(b);
		graph1.addVertex(c);
		graph1.addVertex(d);
		graph1.addVertex(e);
		graph1.addVertex(f);
		graph1.addVertex(g);
		graph1.addEdge(sa);
		graph1.addEdge(sc);
		graph1.addEdge(se);
		graph1.addEdge(ef);
		graph1.addEdge(fe);
		graph1.addEdge(cd);
		graph1.addEdge(dc);
		graph1.addEdge(ab);
		graph1.addEdge(bg);
		graph1.addEdge(dg);
		graph1.addEdge(fg);

		DirectedGraph<Void, Weight> graph2;
		Vertex<Void> h, i, j;
		Edge<Void, Weight> hi, ij, jh;
		graph2 = new AdjListGraphDirected<>();
		h = new VertexImpl<>();
		i = new VertexImpl<>();
		j = new VertexImpl<>();
		hi = new EdgeImpl<>(h, i, new WeightImpl(2));
		ij = new EdgeImpl<>(i, j, new WeightImpl(3));
		jh = new EdgeImpl<>(j, h, new WeightImpl(-8));
		graph2.addVertex(h);
		graph2.addVertex(i);
		graph2.addVertex(j);
		graph2.addEdge(hi);
		graph2.addEdge(ij);
		graph2.addEdge(jh);

		assertFalse(SSSP.BellmanFord(graph1, s1).isPresent());
		assertFalse(SSSP.BellmanFord(graph1, e).isPresent());
		assertFalse(SSSP.BellmanFord(graph1, f).isPresent());
		assertFalse(SSSP.BellmanFord(graph2, h).isPresent());
		assertFalse(SSSP.BellmanFord(graph2, i).isPresent());
		assertFalse(SSSP.BellmanFord(graph2, j).isPresent());

		var tree = SSSP.BellmanFord(graph, s).get();
		validatePath(tree, s, s, 0);
		validatePath(tree, s, t, 3);
		validatePath(tree, s, x, 9);
		validatePath(tree, s, y, 5);
		validatePath(tree, s, z, 11);
	}

	@Test
	@DisplayName("Tests the DAG method")
	void DAG() {
		DirectedGraph<Void, Weight> graph1;
		Vertex<Void> r, s, t, x, y, z;
		Edge<Void, Weight> rs, st, sx, tx, xy, xz, yz, rt, ty, tz;
		graph1 = new AdjListGraphDirected<>();
		r = new VertexImpl<>();
		s = new VertexImpl<>();
		t = new VertexImpl<>();
		x = new VertexImpl<>();
		y = new VertexImpl<>();
		z = new VertexImpl<>();
		rs = new EdgeImpl<>(r, s, new WeightImpl(5));
		st = new EdgeImpl<>(s, t, new WeightImpl(2));
		sx = new EdgeImpl<>(s, x, new WeightImpl(6));
		tx = new EdgeImpl<>(t, x, new WeightImpl(7));
		xy = new EdgeImpl<>(x, y, new WeightImpl(-1));
		xz = new EdgeImpl<>(x, z, new WeightImpl(1));
		yz = new EdgeImpl<>(y, z, new WeightImpl(-2));
		rt = new EdgeImpl<>(r, t, new WeightImpl(3));
		ty = new EdgeImpl<>(t, y, new WeightImpl(4));
		tz = new EdgeImpl<>(t, z, new WeightImpl(2));
		graph1.addVertex(r);
		graph1.addVertex(s);
		graph1.addVertex(t);
		graph1.addVertex(x);
		graph1.addVertex(y);
		graph1.addVertex(z);
		graph1.addEdge(rs);
		graph1.addEdge(st);
		graph1.addEdge(sx);
		graph1.addEdge(tx);
		graph1.addEdge(xy);
		graph1.addEdge(xz);
		graph1.addEdge(yz);
		graph1.addEdge(rt);
		graph1.addEdge(ty);
		graph1.addEdge(tz);

		var tree = SSSP.DAG(graph1, s);
		assertFalse(tree.containsKey(r));
		validatePath(tree, s, s, 0);
		validatePath(tree, s, t, 2);
		validatePath(tree, s, x, 6);
		validatePath(tree, s, y, 5);
		validatePath(tree, s, z, 3);
	}

	@Test
	@DisplayName("Tests the Dijkstra method")
	void Dijkstra() {
		var tree = SSSP.Dijkstra(graph, s);
		validatePath(tree, s, s, 0);
		validatePath(tree, s, t, 3);
		validatePath(tree, s, x, 9);
		validatePath(tree, s, y, 5);
		validatePath(tree, s, z, 11);
	}

	@Test
	@DisplayName("Tests the unitWeights method")
	void unitWeights() {
		UndirectedGraph<String, Void> graph1;
		Vertex<String> r, s, t, u, v, w, x, y;
		Edge<String, Void> vr, rs, sw, wt, wx, tu, tx, xu, xy, uy;
		graph1 = new AdjListGraphUndirected<>();
		r = new VertexImpl<>("r");
		s = new VertexImpl<>("s");
		t = new VertexImpl<>("t");
		u = new VertexImpl<>("u");
		v = new VertexImpl<>("v");
		w = new VertexImpl<>("w");
		x = new VertexImpl<>("x");
		y = new VertexImpl<>("y");
		vr = new EdgeImpl<>(v, r);
		rs = new EdgeImpl<>(r, s);
		sw = new EdgeImpl<>(s, w);
		wt = new EdgeImpl<>(w, t);
		wx = new EdgeImpl<>(w, x);
		tu = new EdgeImpl<>(t, u);
		tx = new EdgeImpl<>(t, x);
		xu = new EdgeImpl<>(x, u);
		xy = new EdgeImpl<>(x, y);
		uy = new EdgeImpl<>(u, y);
		graph1.addVertex(r);
		graph1.addVertex(s);
		graph1.addVertex(t);
		graph1.addVertex(u);
		graph1.addVertex(v);
		graph1.addVertex(w);
		graph1.addVertex(x);
		graph1.addVertex(y);
		graph1.addEdge(vr);
		graph1.addEdge(rs);
		graph1.addEdge(sw);
		graph1.addEdge(wt);
		graph1.addEdge(wx);
		graph1.addEdge(tu);
		graph1.addEdge(tx);
		graph1.addEdge(xu);
		graph1.addEdge(xy);
		graph1.addEdge(uy);

		var tree = SSSP.unitWeights(graph1, s);
		validatePath(tree, s, r, 1);
		validatePath(tree, s, s, 0);
		validatePath(tree, s, t, 2);
		validatePath(tree, s, u, 3);
		validatePath(tree, s, v, 2);
		validatePath(tree, s, w, 1);
		validatePath(tree, s, x, 2);
		validatePath(tree, s, y, 3);
	}

	private static <V, E> void validatePath(Map<Vertex<V>, Edge<V, E>> map, Vertex<V> s, Vertex<V> t, double w) {
		assertFalse(map.containsKey(s));

		if (s.equals(t)) {
			assertEquals(w, 0);
			return;
		}

		assertEquals(map.get(t).getB(), t);
		var weight = 0.;
		var edge = map.get(t);
		var x = t;

		do {
			assertEquals(edge.getB(), x);
			x = edge.getA();
			if (edge.getData() instanceof Weight) {
				weight += ((Weight) edge.getData()).getWeight();
			} else {
				weight++;
			}
			edge = map.get(edge.getA());
		} while (edge != null);

		assertEquals(map.get(s), null);
		assertEquals(weight, w);
	}

	@Test
	@DisplayName("Tests the shortestPathsGraph method")
	void shortestPathsGraph() {
		BFInitGraph();
		Map<Vertex<Void>, Double> distances = new HashMap<>();
		SSSP.BellmanFord(k, w1, distances);
		SSSP.shortestPathsGraph(k, distances);

		assertEquals(k.indegree(w1), 0);
		assertEquals(k.indegree(w2), 1);
		assertEquals(k.indegree(w3), 1);
		assertEquals(k.indegree(w4), 1);
		assertEquals(k.indegree(w5), 1);
		assertEquals(k.indegree(w6), 2);
		assertEquals(k.indegree(w7), 1);

		assertEquals(k.outdegree(w1), 1);
		assertEquals(k.outdegree(w2), 2);
		assertEquals(k.outdegree(w3), 0);
		assertEquals(k.outdegree(w4), 1);
		assertEquals(k.outdegree(w5), 2);
		assertEquals(k.outdegree(w6), 1);
		assertEquals(k.outdegree(w7), 0);

		assertEquals(k.edgesCount(), 7);

		assertFalse(k.adjacent(w1, w2));
		assertFalse(k.adjacent(w1, w3));
		assertFalse(k.adjacent(w1, w4));
		assertFalse(k.adjacent(w1, w5));
		assertTrue(k.adjacent(w1, w6));
		assertFalse(k.adjacent(w1, w7));
		assertTrue(k.adjacent(w2, w3));
		assertFalse(k.adjacent(w3, w4));
		assertTrue(k.adjacent(w2, w5));
		assertTrue(k.adjacent(w5, w4));
		assertTrue(k.adjacent(w5, w6));
		assertTrue(k.adjacent(w6, w2));
		assertTrue(k.adjacent(w4, w7));
		assertFalse(k.adjacent(w7, w6));
	}

	@Test
	@DisplayName("Tests the distances output of the BellmanFord method")
	void BellmanFordDistances() {
		BFInitGraph();
		Map<Vertex<Void>, Double> distances = new HashMap<>();
		SSSP.BellmanFord(k, w1, distances);

		assertTrue(distances.get(w1) == 0);
		assertTrue(distances.get(w2) == -9);
		assertTrue(distances.get(w3) == -8);
		assertTrue(distances.get(w4) == -4);
		assertTrue(distances.get(w5) == -8);
		assertTrue(distances.get(w6) == 0);
		assertTrue(distances.get(w7) == -7);
	}

	@Test
	@DisplayName("Tests the distances output of the DAG method")
	void DAGDistances() {
		BFInitGraph();
		k.filterEdges(f -> f != f1 && f != f2 && f != f3 && f != f4 && f != f6 && f != f8 && f != f11 && f != f14);
		Map<Vertex<Void>, Double> distances = new HashMap<>();
		SSSP.DAG(k, w1, distances);

		assertTrue(distances.get(w1) == 0);
		assertTrue(distances.get(w2) == -9);
		assertTrue(distances.get(w3) == -8);
		assertTrue(distances.get(w4) == -4);
		assertTrue(distances.get(w5) == -8);
		assertTrue(distances.get(w6) == 0);
		assertTrue(distances.get(w7) == -7);
	}

	@Test
	@DisplayName("Tests the distances output of the Dijkstra method")
	void DijkstraDistances() {
		Map<Vertex<Void>, Double> distances = new HashMap<>();
		SSSP.Dijkstra(graph, s, distances);

		assertTrue(distances.get(s) == 0);
		assertTrue(distances.get(t) == 3);
		assertTrue(distances.get(x) == 9);
		assertTrue(distances.get(y) == 5);
		assertTrue(distances.get(z) == 11);
	}

	@Test
	@DisplayName("Tests the distances output of the unitWeights method")
	void unitWeightsDistances() {
		UndirectedGraph<String, Void> graph1;
		Vertex<String> r, s, t, u, v, w, x, y;
		Edge<String, Void> vr, rs, sw, wt, wx, tu, tx, xu, xy, uy;
		graph1 = new AdjListGraphUndirected<>();
		r = new VertexImpl<>("r");
		s = new VertexImpl<>("s");
		t = new VertexImpl<>("t");
		u = new VertexImpl<>("u");
		v = new VertexImpl<>("v");
		w = new VertexImpl<>("w");
		x = new VertexImpl<>("x");
		y = new VertexImpl<>("y");
		vr = new EdgeImpl<>(v, r);
		rs = new EdgeImpl<>(r, s);
		sw = new EdgeImpl<>(s, w);
		wt = new EdgeImpl<>(w, t);
		wx = new EdgeImpl<>(w, x);
		tu = new EdgeImpl<>(t, u);
		tx = new EdgeImpl<>(t, x);
		xu = new EdgeImpl<>(x, u);
		xy = new EdgeImpl<>(x, y);
		uy = new EdgeImpl<>(u, y);
		graph1.addVertex(r);
		graph1.addVertex(s);
		graph1.addVertex(t);
		graph1.addVertex(u);
		graph1.addVertex(v);
		graph1.addVertex(w);
		graph1.addVertex(x);
		graph1.addVertex(y);
		graph1.addEdge(vr);
		graph1.addEdge(rs);
		graph1.addEdge(sw);
		graph1.addEdge(wt);
		graph1.addEdge(wx);
		graph1.addEdge(tu);
		graph1.addEdge(tx);
		graph1.addEdge(xu);
		graph1.addEdge(xy);
		graph1.addEdge(uy);

		Map<Vertex<String>, Integer> distances = new HashMap<>();
		SSSP.unitWeights(graph1, s, distances);

		assertTrue(distances.get(r) == 1);
		assertTrue(distances.get(s) == 0);
		assertTrue(distances.get(t) == 2);
		assertTrue(distances.get(u) == 3);
		assertTrue(distances.get(v) == 2);
		assertTrue(distances.get(w) == 1);
		assertTrue(distances.get(x) == 2);
		assertTrue(distances.get(y) == 3);
	}
}
package tests.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import algorithms.SPSP;
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

public class SPSPTest {

	DirectedGraph<Void, Weight> graph;
	Vertex<Void> s, t, x, y, z;
	Edge<Void, Weight> st, sy, tx, yz, zs, yx, ty, yt, xz, zx;

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

		assertEquals(SPSP.BellmanFord(graph1, s1, a).size(), 0);
		assertEquals(SPSP.BellmanFord(graph1, s1, b).size(), 0);
		assertEquals(SPSP.BellmanFord(graph1, s1, c).size(), 0);
		assertEquals(SPSP.BellmanFord(graph1, s1, d).size(), 0);
		assertEquals(SPSP.BellmanFord(graph1, s1, e).size(), 0);
		assertEquals(SPSP.BellmanFord(graph1, s1, f).size(), 0);
		assertEquals(SPSP.BellmanFord(graph1, s1, g).size(), 0);
		assertEquals(SPSP.BellmanFord(graph2, h, h).size(), 0);
		assertEquals(SPSP.BellmanFord(graph2, h, i).size(), 0);
		assertEquals(SPSP.BellmanFord(graph2, h, j).size(), 0);
		assertEquals(SPSP.BellmanFord(graph2, i, i).size(), 0);
		assertEquals(SPSP.BellmanFord(graph2, i, h).size(), 0);
		assertEquals(SPSP.BellmanFord(graph2, i, j).size(), 0);
		assertEquals(SPSP.BellmanFord(graph2, j, j).size(), 0);
		assertEquals(SPSP.BellmanFord(graph2, j, h).size(), 0);
		assertEquals(SPSP.BellmanFord(graph2, j, i).size(), 0);

		validatePath(SPSP.BellmanFord(graph, s, s), s, s, 0);
		validatePath(SPSP.BellmanFord(graph, s, t), s, t, 3);
		validatePath(SPSP.BellmanFord(graph, s, x), s, x, 9);
		validatePath(SPSP.BellmanFord(graph, s, y), s, y, 5);
		validatePath(SPSP.BellmanFord(graph, s, z), s, z, 11);
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

		validatePath(SPSP.DAG(graph1, s, s), s, s, 0);
		validatePath(SPSP.DAG(graph1, s, t), s, t, 2);
		validatePath(SPSP.DAG(graph1, s, x), s, x, 6);
		validatePath(SPSP.DAG(graph1, s, y), s, y, 5);
		validatePath(SPSP.DAG(graph1, s, z), s, z, 3);
	}

	@Test
	@DisplayName("Tests the Dijkstra method")
	void Dijkstra() {
		validatePath(SPSP.Dijkstra(graph, s, s), s, s, 0);
		validatePath(SPSP.Dijkstra(graph, s, t), s, t, 3);
		validatePath(SPSP.Dijkstra(graph, s, x), s, x, 9);
		validatePath(SPSP.Dijkstra(graph, s, y), s, y, 5);
		validatePath(SPSP.Dijkstra(graph, s, z), s, z, 11);
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

		validatePath(SPSP.unitWeights(graph1, s, r), s, r, 1);
		validatePath(SPSP.unitWeights(graph1, s, s), s, s, 0);
		validatePath(SPSP.unitWeights(graph1, s, t), s, t, 2);
		validatePath(SPSP.unitWeights(graph1, s, u), s, u, 3);
		validatePath(SPSP.unitWeights(graph1, s, v), s, v, 2);
		validatePath(SPSP.unitWeights(graph1, s, w), s, w, 1);
		validatePath(SPSP.unitWeights(graph1, s, x), s, x, 2);
		validatePath(SPSP.unitWeights(graph1, s, y), s, y, 3);
	}

	private static <V, E> void validatePath(List<Edge<V, E>> path, Vertex<V> s, Vertex<V> t, double w) {
		if (s.equals(t)) {
			assertEquals(w, 0);
			return;
		}

		var weight = 0.;
		var x = s;

		for (var i = 0; i < path.size(); i++) {
			var e = path.get(i);
			assertEquals(e.getA(), x);
			if (e.getData() instanceof Weight) {
				weight += ((Weight) e.getData()).getWeight();
			} else {
				weight++;
			}

			x = path.get(i).getB();
		}
		assertEquals(path.get(path.size() - 1).getB(), t);

		assertEquals(weight, w);
	}
}
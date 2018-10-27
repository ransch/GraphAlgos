package tests.algorithms;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import algorithms.MST;
import dataStructures.graph.AdjListGraphUndirected;
import dataStructures.graph.Edge;
import dataStructures.graph.EdgeImpl;
import dataStructures.graph.UndirectedGraph;
import dataStructures.graph.Vertex;
import dataStructures.graph.VertexImpl;
import dataStructures.graph.Weight;
import dataStructures.graph.WeightImpl;

public class MSTTest {

	UndirectedGraph<Void, Weight> graph;
	Vertex<Void> a, b, c, d, e, f, g, h, i;
	Edge<Void, Weight> ab, ah, bh, bc, hi, ci, ig, cf, gf, df, cd, de, fe, hg;

	@BeforeEach
	void init() {
		graph = new AdjListGraphUndirected<>();
		a = new VertexImpl<>();
		b = new VertexImpl<>();
		c = new VertexImpl<>();
		d = new VertexImpl<>();
		e = new VertexImpl<>();
		f = new VertexImpl<>();
		g = new VertexImpl<>();
		h = new VertexImpl<>();
		i = new VertexImpl<>();
		ab = new EdgeImpl<>(a, b, new WeightImpl(4));
		ah = new EdgeImpl<>(a, h, new WeightImpl(8));
		bh = new EdgeImpl<>(b, h, new WeightImpl(11));
		bc = new EdgeImpl<>(b, c, new WeightImpl(8));
		hi = new EdgeImpl<>(h, i, new WeightImpl(7));
		ci = new EdgeImpl<>(c, i, new WeightImpl(2));
		ig = new EdgeImpl<>(i, g, new WeightImpl(6));
		cf = new EdgeImpl<>(c, f, new WeightImpl(4));
		gf = new EdgeImpl<>(g, f, new WeightImpl(2));
		df = new EdgeImpl<>(d, f, new WeightImpl(14));
		cd = new EdgeImpl<>(c, d, new WeightImpl(7));
		de = new EdgeImpl<>(d, e, new WeightImpl(9));
		fe = new EdgeImpl<>(f, e, new WeightImpl(10));
		hg = new EdgeImpl<>(h, g, new WeightImpl(1));
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		graph.addVertex(e);
		graph.addVertex(f);
		graph.addVertex(g);
		graph.addVertex(h);
		graph.addVertex(i);
		graph.addEdge(ab);
		graph.addEdge(ah);
		graph.addEdge(bh);
		graph.addEdge(bc);
		graph.addEdge(hi);
		graph.addEdge(ci);
		graph.addEdge(ig);
		graph.addEdge(cf);
		graph.addEdge(gf);
		graph.addEdge(df);
		graph.addEdge(cd);
		graph.addEdge(de);
		graph.addEdge(fe);
		graph.addEdge(hg);
	}

	@Test
	@DisplayName("Tests the Kruskal method")
	void Kruskal() {
		testMst(MST.Kruskal(graph));
	}

	@Test
	@DisplayName("Tests the Prim method")
	void Prim() {
		testMst(MST.Prim(graph, a));
	}

	@Test
	@DisplayName("Tests the Prim method")
	void Prim2() {
		testMst(MST.Prim(graph, d));
	}

	@Test
	@DisplayName("Tests the Prim method")
	void Prim3() {
		testMst(MST.Prim(graph, h));
	}

	void testMst(List<Edge<Void, Weight>> mst) {
		assertTrue(mst.stream().mapToDouble(e -> e.getData().getWeight()).sum() == 37);

		var arr = new boolean[9];
		mst.stream().map(e -> e.getA()).forEach(v -> {
			if (v == a) {
				arr[0] = true;
			} else if (v == b) {
				arr[1] = true;
			} else if (v == c) {
				arr[2] = true;
			} else if (v == d) {
				arr[3] = true;
			} else if (v == e) {
				arr[4] = true;
			} else if (v == f) {
				arr[5] = true;
			} else if (v == g) {
				arr[6] = true;
			} else if (v == h) {
				arr[7] = true;
			} else if (v == i) {
				arr[8] = true;
			} else {
				fail();
			}
		});

		mst.stream().map(e -> e.getB()).forEach(v -> {
			if (v == a) {
				arr[0] = true;
			} else if (v == b) {
				arr[1] = true;
			} else if (v == c) {
				arr[2] = true;
			} else if (v == d) {
				arr[3] = true;
			} else if (v == e) {
				arr[4] = true;
			} else if (v == f) {
				arr[5] = true;
			} else if (v == g) {
				arr[6] = true;
			} else if (v == h) {
				arr[7] = true;
			} else if (v == i) {
				arr[8] = true;
			} else {
				fail();
			}
		});

		for (var i = 0; i < 9; i++) {
			if (!arr[i]) {
				fail();
			}
		}
	}
}
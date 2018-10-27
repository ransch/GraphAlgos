package tests.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import algorithms.Bipartite;
import dataStructures.graph.AdjListGraphUndirected;
import dataStructures.graph.Color;
import dataStructures.graph.ColorImpl;
import dataStructures.graph.Edge;
import dataStructures.graph.EdgeImpl;
import dataStructures.graph.UndirectedGraph;
import dataStructures.graph.Vertex;
import dataStructures.graph.VertexImpl;

public class BipartiteTest {

	UndirectedGraph<Color, String> g1;
	UndirectedGraph<Color, String> g2;
	UndirectedGraph<Color, String> g3;
	UndirectedGraph<Color, String> g4;
	Vertex<Color> v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19;
	Edge<Color, String> e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20;

	@BeforeEach
	void init() {
		g1 = new AdjListGraphUndirected<>();
		g2 = new AdjListGraphUndirected<>();
		g3 = new AdjListGraphUndirected<>();
		g4 = new AdjListGraphUndirected<>();

		v1 = new VertexImpl<>(new ColorImpl(0));
		v2 = new VertexImpl<>(new ColorImpl(0));
		v3 = new VertexImpl<>(new ColorImpl(0));
		v4 = new VertexImpl<>(new ColorImpl(0));
		v5 = new VertexImpl<>(new ColorImpl(0));
		v6 = new VertexImpl<>(new ColorImpl(0));
		v7 = new VertexImpl<>(new ColorImpl(0));
		v8 = new VertexImpl<>(new ColorImpl(0));
		v9 = new VertexImpl<>(new ColorImpl(0));
		v10 = new VertexImpl<>(new ColorImpl(0));
		v11 = new VertexImpl<>(new ColorImpl(0));
		v12 = new VertexImpl<>(new ColorImpl(0));
		v13 = new VertexImpl<>(new ColorImpl(0));
		v14 = new VertexImpl<>(new ColorImpl(0));
		v15 = new VertexImpl<>(new ColorImpl(0));
		v16 = new VertexImpl<>(new ColorImpl(0));
		v17 = new VertexImpl<>(new ColorImpl(0));
		v18 = new VertexImpl<>(new ColorImpl(0));
		v19 = new VertexImpl<>(new ColorImpl(0));

		e1 = new EdgeImpl<>(v1, v2);
		e2 = new EdgeImpl<>(v1, v3);
		e3 = new EdgeImpl<>(v2, v3);
		e4 = new EdgeImpl<>(v5, v4);
		e5 = new EdgeImpl<>(v5, v6);
		e6 = new EdgeImpl<>(v4, v7);
		e7 = new EdgeImpl<>(v7, v6);
		e8 = new EdgeImpl<>(v8, v9);
		e9 = new EdgeImpl<>(v8, v10);
		e10 = new EdgeImpl<>(v11, v10);
		e11 = new EdgeImpl<>(v11, v12);
		e12 = new EdgeImpl<>(v13, v18);
		e13 = new EdgeImpl<>(v13, v19);
		e14 = new EdgeImpl<>(v17, v19);
		e15 = new EdgeImpl<>(v16, v17);
		e16 = new EdgeImpl<>(v15, v16);
		e17 = new EdgeImpl<>(v19, v15);
		e18 = new EdgeImpl<>(v14, v16);
		e19 = new EdgeImpl<>(v14, v18);
		e20 = new EdgeImpl<>(v17, v18);

		g1.addVertex(v1);
		g1.addVertex(v2);
		g1.addVertex(v3);
		g2.addVertex(v4);
		g2.addVertex(v5);
		g2.addVertex(v6);
		g2.addVertex(v7);
		g3.addVertex(v8);
		g3.addVertex(v9);
		g3.addVertex(v10);
		g3.addVertex(v11);
		g3.addVertex(v12);
		g4.addVertex(v13);
		g4.addVertex(v14);
		g4.addVertex(v15);
		g4.addVertex(v16);
		g4.addVertex(v17);
		g4.addVertex(v18);
		g4.addVertex(v19);

		g1.addEdge(e1);
		g1.addEdge(e2);
		g1.addEdge(e3);
		g2.addEdge(e4);
		g2.addEdge(e5);
		g2.addEdge(e6);
		g2.addEdge(e7);
		g3.addEdge(e8);
		g3.addEdge(e9);
		g3.addEdge(e10);
		g3.addEdge(e11);
		g4.addEdge(e12);
		g4.addEdge(e13);
		g4.addEdge(e14);
		g4.addEdge(e15);
		g4.addEdge(e16);
		g4.addEdge(e17);
		g4.addEdge(e18);
		g4.addEdge(e19);
		g4.addEdge(e20);
	}

	@Test
	@DisplayName("Tests the isBipartite method")
	void isBipartite() {
		assertFalse(Bipartite.isBipartite(g1));
		assertTrue(Bipartite.isBipartite(g2));
		assertTrue(Bipartite.isBipartite(g3));
		assertTrue(Bipartite.isBipartite(g4));

		assertEquals(v1.getData().getColor(), 0);
		assertEquals(v2.getData().getColor(), 0);
		assertEquals(v3.getData().getColor(), 0);

		assertTrue(v4.getData().getColor() == 0 || v4.getData().getColor() == 1);
		assertTrue(v5.getData().getColor() == 0 || v5.getData().getColor() == 1);
		assertTrue(v6.getData().getColor() == 0 || v6.getData().getColor() == 1);
		assertTrue(v7.getData().getColor() == 0 || v7.getData().getColor() == 1);
		assertTrue(v8.getData().getColor() == 0 || v8.getData().getColor() == 1);
		assertTrue(v9.getData().getColor() == 0 || v9.getData().getColor() == 1);
		assertTrue(v10.getData().getColor() == 0 || v10.getData().getColor() == 1);
		assertTrue(v11.getData().getColor() == 0 || v11.getData().getColor() == 1);
		assertTrue(v12.getData().getColor() == 0 || v12.getData().getColor() == 1);
		assertTrue(v13.getData().getColor() == 0 || v13.getData().getColor() == 1);
		assertTrue(v14.getData().getColor() == 0 || v14.getData().getColor() == 1);
		assertTrue(v15.getData().getColor() == 0 || v15.getData().getColor() == 1);
		assertTrue(v16.getData().getColor() == 0 || v16.getData().getColor() == 1);
		assertTrue(v17.getData().getColor() == 0 || v17.getData().getColor() == 1);
		assertTrue(v18.getData().getColor() == 0 || v18.getData().getColor() == 1);
		assertTrue(v19.getData().getColor() == 0 || v19.getData().getColor() == 1);

		assertNotEquals(e4.getA().getData().getColor(), e4.getB().getData().getColor());
		assertNotEquals(e5.getA().getData().getColor(), e5.getB().getData().getColor());
		assertNotEquals(e6.getA().getData().getColor(), e6.getB().getData().getColor());
		assertNotEquals(e7.getA().getData().getColor(), e7.getB().getData().getColor());
		assertNotEquals(e8.getA().getData().getColor(), e8.getB().getData().getColor());
		assertNotEquals(e9.getA().getData().getColor(), e9.getB().getData().getColor());
		assertNotEquals(e10.getA().getData().getColor(), e10.getB().getData().getColor());
		assertNotEquals(e11.getA().getData().getColor(), e11.getB().getData().getColor());
		assertNotEquals(e12.getA().getData().getColor(), e12.getB().getData().getColor());
		assertNotEquals(e13.getA().getData().getColor(), e13.getB().getData().getColor());
		assertNotEquals(e14.getA().getData().getColor(), e14.getB().getData().getColor());
		assertNotEquals(e15.getA().getData().getColor(), e15.getB().getData().getColor());
		assertNotEquals(e16.getA().getData().getColor(), e16.getB().getData().getColor());
		assertNotEquals(e17.getA().getData().getColor(), e17.getB().getData().getColor());
		assertNotEquals(e18.getA().getData().getColor(), e18.getB().getData().getColor());
		assertNotEquals(e19.getA().getData().getColor(), e19.getB().getData().getColor());
		assertNotEquals(e20.getA().getData().getColor(), e20.getB().getData().getColor());
	}
}
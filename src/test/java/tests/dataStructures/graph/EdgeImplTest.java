package tests.dataStructures.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dataStructures.graph.Edge;
import dataStructures.graph.EdgeImpl;
import dataStructures.graph.Vertex;
import dataStructures.graph.VertexImpl;

class EdgeImplTest {

	@Test
	@DisplayName("Tests the invert method using getA, getB, getData")
	void invert() {
		Vertex<String> v1, v2;
		Edge<String, String> e1, e2, e3;

		v1 = new VertexImpl<String>("vertex 1");
		v2 = new VertexImpl<String>("vertex 2");
		e1 = new EdgeImpl<String, String>(v1, v2, "edge 1");
		e2 = new EdgeImpl<String, String>(v2, v1, "edge 1");
		e3 = e1.invert();

		assertEquals(e2.getA(), e3.getA());
		assertEquals(e2.getB(), e3.getB());
		assertEquals(e2.getData(), e3.getData());

		// check that e1 was not mutated
		assertEquals(e1.getA(), v1);
		assertEquals(e1.getB(), v2);
		assertEquals(e1.getData(), "edge 1");
	}

	@Test
	@DisplayName("Tests the equals and hashCode methods")
	void equalsHashCode() {
		Vertex<String> v1, v2, v3, v4;
		Edge<String, String> e1, e2, e3, e4, e5, e6, e7;

		v1 = new VertexImpl<String>("vertex 1");
		v2 = new VertexImpl<String>("vertex 2");
		v3 = new VertexImpl<String>("vertex 1");
		v4 = new VertexImpl<String>("vertex 2");
		e1 = new EdgeImpl<String, String>(v1, v2, "edge 1");
		e2 = new EdgeImpl<String, String>(v1, v2, "edge 2");
		e3 = e1.invert().invert();
		e4 = new EdgeImpl<String, String>(v3, v2, "edge 1");
		e5 = new EdgeImpl<String, String>(v3, v4, "edge 2");
		e6 = new EdgeImpl<String, String>(v1, v2, "edge 1");
		e7 = e6.invert().invert();

		assertNotEquals(e1, e2);
		assertEquals(e1, e3);
		assertEquals(e1, e6);
		assertEquals(e1, e7);
		assertNotEquals(e1, e4);
		assertNotEquals(e1, e5);
		assertNotEquals(e3, e4);
		assertNotEquals(e3, e5);
		assertNotEquals(e4, e5);
		assertNotEquals(e1, "Some other object");

		assertNotEquals(e1.hashCode(), e2.hashCode());
		assertEquals(e1.hashCode(), e3.hashCode());
		assertEquals(e1.hashCode(), e6.hashCode());
		assertEquals(e1.hashCode(), e7.hashCode());
		assertNotEquals(e1.hashCode(), e4.hashCode());
		assertNotEquals(e1.hashCode(), e5.hashCode());
		assertNotEquals(e3.hashCode(), e4.hashCode());
		assertNotEquals(e3.hashCode(), e5.hashCode());
		assertNotEquals(e4.hashCode(), e5.hashCode());
	}
}
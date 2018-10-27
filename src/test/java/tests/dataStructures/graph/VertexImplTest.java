package tests.dataStructures.graph;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dataStructures.graph.Vertex;
import dataStructures.graph.VertexImpl;

class VertexImplTest {

	@Test
	@DisplayName("Tests the equals and hashCode methods")
	void equalsHashCode() {
		Vertex<String> v1, v2, v3;

		v1 = new VertexImpl<String>("vertex 1");
		v2 = new VertexImpl<String>("vertex 1");
		v3 = new VertexImpl<String>("vertex 2");

		assertNotEquals(v1, v2);
		assertNotEquals(v1, v3);
		assertNotEquals(v2, v3);
		assertNotEquals(v1, "Some other object");

		assertNotEquals(v1.hashCode(), v2.hashCode());
		assertNotEquals(v1.hashCode(), v3.hashCode());
		assertNotEquals(v2.hashCode(), v3.hashCode());
	}
}
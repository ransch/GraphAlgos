package tests.dataStructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import dataStructures.DisjointSet;
import dataStructures.DisjointSetForest;

public class DisjointSetForestTest {

	@Test
	void test() {
		DisjointSet<Integer> struct = new DisjointSetForest<>();
		assertEquals(struct.itemsCount(), 0);
		assertEquals(struct.setsCount(), 0);

		struct.makeSet(1);
		assertEquals(struct.itemsCount(), 1);
		assertEquals(struct.setsCount(), 1);
		assertTrue(struct.findSet(1) == 1);

		struct.makeSet(2);
		assertEquals(struct.itemsCount(), 2);
		assertEquals(struct.setsCount(), 2);
		assertTrue(struct.findSet(2) == 2);

		struct.union(1, 2);
		assertEquals(struct.itemsCount(), 2);
		assertEquals(struct.setsCount(), 1);
		assertEquals(struct.findSet(1), struct.findSet(2));

		struct.makeSet(3);
		assertEquals(struct.itemsCount(), 3);
		assertEquals(struct.setsCount(), 2);
		assertTrue(struct.findSet(3) == 3);

		struct.union(2, 3);
		assertEquals(struct.itemsCount(), 3);
		assertEquals(struct.setsCount(), 1);
		var a = struct.findSet(1);
		assertEquals(struct.findSet(2), a);
		assertEquals(struct.findSet(3), a);

		struct.makeSet(4);
		assertEquals(struct.itemsCount(), 4);
		assertEquals(struct.setsCount(), 2);
		assertTrue(struct.findSet(4) == 4);

		struct.makeSet(5);
		assertEquals(struct.itemsCount(), 5);
		assertEquals(struct.setsCount(), 3);
		assertTrue(struct.findSet(5) == 5);

		struct.makeSet(6);
		assertEquals(struct.itemsCount(), 6);
		assertEquals(struct.setsCount(), 4);
		assertTrue(struct.findSet(6) == 6);

		struct.union(4, 5);
		assertEquals(struct.itemsCount(), 6);
		assertEquals(struct.setsCount(), 3);
		assertEquals(struct.findSet(4), struct.findSet(5));

		struct.union(4, 1);
		assertEquals(struct.itemsCount(), 6);
		assertEquals(struct.setsCount(), 2);
		a = struct.findSet(1);
		assertEquals(struct.findSet(2), a);
		assertEquals(struct.findSet(3), a);
		assertEquals(struct.findSet(4), a);
		assertEquals(struct.findSet(5), a);

		struct.union(6, 2);
		assertEquals(struct.itemsCount(), 6);
		assertEquals(struct.setsCount(), 1);
		a = struct.findSet(1);
		assertEquals(struct.findSet(2), a);
		assertEquals(struct.findSet(3), a);
		assertEquals(struct.findSet(4), a);
		assertEquals(struct.findSet(5), a);
		assertEquals(struct.findSet(6), a);

		struct.addAll(Arrays.asList(7, 8, 9, 10));
		assertEquals(struct.itemsCount(), 10);
		assertEquals(struct.setsCount(), 5);
		a = struct.findSet(1);
		assertEquals(struct.findSet(2), a);
		assertEquals(struct.findSet(3), a);
		assertEquals(struct.findSet(4), a);
		assertEquals(struct.findSet(5), a);
		assertEquals(struct.findSet(6), a);
		assertTrue(struct.findSet(7) == 7);
		assertTrue(struct.findSet(8) == 8);
		assertTrue(struct.findSet(9) == 9);
		assertTrue(struct.findSet(10) == 10);

		struct.addAll(Arrays.asList(11, 12, 13, 14).stream());
		assertEquals(struct.itemsCount(), 14);
		assertEquals(struct.setsCount(), 9);
		a = struct.findSet(1);
		assertEquals(struct.findSet(2), a);
		assertEquals(struct.findSet(3), a);
		assertEquals(struct.findSet(4), a);
		assertEquals(struct.findSet(5), a);
		assertEquals(struct.findSet(6), a);
		assertTrue(struct.findSet(7) == 7);
		assertTrue(struct.findSet(8) == 8);
		assertTrue(struct.findSet(9) == 9);
		assertTrue(struct.findSet(10) == 10);
		assertTrue(struct.findSet(11) == 11);
		assertTrue(struct.findSet(12) == 12);
		assertTrue(struct.findSet(13) == 13);
		assertTrue(struct.findSet(14) == 14);
	}
}
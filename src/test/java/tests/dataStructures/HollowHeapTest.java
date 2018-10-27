package tests.dataStructures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import dataStructures.HollowHeap;
import dataStructures.PriorityQueue;

public class HollowHeapTest {

	@Test
	void test1() {
		PriorityQueue<Integer> queue = new HollowHeap<>();
		int i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12;
		i1 = 1;
		i2 = 2;
		i3 = 3;
		i4 = 4;
		i5 = 5;
		i6 = 6;
		i7 = 7;
		i8 = 8;
		i9 = 9;
		i10 = 10;
		i11 = 11;
		i12 = 12;

		assertEquals(queue.size(), 0);
		assertEquals(queue.findMin().isPresent(), false);
		assertTrue(!queue.getKey(i1).isPresent());

		queue.insert(i1, 14);
		assertEquals(queue.size(), 1);
		assertTrue(queue.findMin().get() == i1);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);

		queue.insert(i2, 11);
		assertEquals(queue.size(), 2);
		assertTrue(queue.findMin().get() == i2);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);

		queue.insert(i3, 5);
		assertEquals(queue.size(), 3);
		assertTrue(queue.findMin().get() == i3);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertEquals(queue.getKey(i3).getAsDouble(), 5);

		queue.insert(i4, 9);
		assertEquals(queue.size(), 4);
		assertTrue(queue.findMin().get() == i3);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertEquals(queue.getKey(i3).getAsDouble(), 5);
		assertEquals(queue.getKey(i4).getAsDouble(), 9);

		queue.insert(i5, 0);
		assertEquals(queue.size(), 5);
		assertTrue(queue.findMin().get() == i5);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertEquals(queue.getKey(i3).getAsDouble(), 5);
		assertEquals(queue.getKey(i4).getAsDouble(), 9);
		assertEquals(queue.getKey(i5).getAsDouble(), 0);

		queue.insert(i6, 8);
		assertEquals(queue.size(), 6);
		assertTrue(queue.findMin().get() == i5);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertEquals(queue.getKey(i3).getAsDouble(), 5);
		assertEquals(queue.getKey(i4).getAsDouble(), 9);
		assertEquals(queue.getKey(i5).getAsDouble(), 0);
		assertEquals(queue.getKey(i6).getAsDouble(), 8);

		queue.insert(i7, 10);
		assertEquals(queue.size(), 7);
		assertTrue(queue.findMin().get() == i5);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertEquals(queue.getKey(i3).getAsDouble(), 5);
		assertEquals(queue.getKey(i4).getAsDouble(), 9);
		assertEquals(queue.getKey(i5).getAsDouble(), 0);
		assertEquals(queue.getKey(i6).getAsDouble(), 8);
		assertEquals(queue.getKey(i7).getAsDouble(), 10);

		queue.insert(i8, 3);
		assertEquals(queue.size(), 8);
		assertTrue(queue.findMin().get() == i5);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertEquals(queue.getKey(i3).getAsDouble(), 5);
		assertEquals(queue.getKey(i4).getAsDouble(), 9);
		assertEquals(queue.getKey(i5).getAsDouble(), 0);
		assertEquals(queue.getKey(i6).getAsDouble(), 8);
		assertEquals(queue.getKey(i7).getAsDouble(), 10);
		assertEquals(queue.getKey(i8).getAsDouble(), 3);

		queue.insert(i9, 6);
		assertEquals(queue.size(), 9);
		assertTrue(queue.findMin().get() == i5);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertEquals(queue.getKey(i3).getAsDouble(), 5);
		assertEquals(queue.getKey(i4).getAsDouble(), 9);
		assertEquals(queue.getKey(i5).getAsDouble(), 0);
		assertEquals(queue.getKey(i6).getAsDouble(), 8);
		assertEquals(queue.getKey(i7).getAsDouble(), 10);
		assertEquals(queue.getKey(i8).getAsDouble(), 3);
		assertEquals(queue.getKey(i9).getAsDouble(), 6);

		queue.insert(i10, 12);
		assertEquals(queue.size(), 10);
		assertTrue(queue.findMin().get() == i5);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertEquals(queue.getKey(i3).getAsDouble(), 5);
		assertEquals(queue.getKey(i4).getAsDouble(), 9);
		assertEquals(queue.getKey(i5).getAsDouble(), 0);
		assertEquals(queue.getKey(i6).getAsDouble(), 8);
		assertEquals(queue.getKey(i7).getAsDouble(), 10);
		assertEquals(queue.getKey(i8).getAsDouble(), 3);
		assertEquals(queue.getKey(i9).getAsDouble(), 6);
		assertEquals(queue.getKey(i10).getAsDouble(), 12);

		queue.insert(i11, 13);
		assertEquals(queue.size(), 11);
		assertTrue(queue.findMin().get() == i5);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertEquals(queue.getKey(i3).getAsDouble(), 5);
		assertEquals(queue.getKey(i4).getAsDouble(), 9);
		assertEquals(queue.getKey(i5).getAsDouble(), 0);
		assertEquals(queue.getKey(i6).getAsDouble(), 8);
		assertEquals(queue.getKey(i7).getAsDouble(), 10);
		assertEquals(queue.getKey(i8).getAsDouble(), 3);
		assertEquals(queue.getKey(i9).getAsDouble(), 6);
		assertEquals(queue.getKey(i10).getAsDouble(), 12);
		assertEquals(queue.getKey(i11).getAsDouble(), 13);

		queue.insert(i12, 4);
		assertEquals(queue.size(), 12);
		assertTrue(queue.findMin().get() == i5);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertEquals(queue.getKey(i3).getAsDouble(), 5);
		assertEquals(queue.getKey(i4).getAsDouble(), 9);
		assertEquals(queue.getKey(i5).getAsDouble(), 0);
		assertEquals(queue.getKey(i6).getAsDouble(), 8);
		assertEquals(queue.getKey(i7).getAsDouble(), 10);
		assertEquals(queue.getKey(i8).getAsDouble(), 3);
		assertEquals(queue.getKey(i9).getAsDouble(), 6);
		assertEquals(queue.getKey(i10).getAsDouble(), 12);
		assertEquals(queue.getKey(i12).getAsDouble(), 4);

		queue.decreaseKey(i5, -1);
		assertEquals(queue.size(), 12);
		assertTrue(queue.findMin().get() == i5);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertEquals(queue.getKey(i3).getAsDouble(), 5);
		assertEquals(queue.getKey(i4).getAsDouble(), 9);
		assertEquals(queue.getKey(i5).getAsDouble(), -1);
		assertEquals(queue.getKey(i6).getAsDouble(), 8);
		assertEquals(queue.getKey(i7).getAsDouble(), 10);
		assertEquals(queue.getKey(i8).getAsDouble(), 3);
		assertEquals(queue.getKey(i9).getAsDouble(), 6);
		assertEquals(queue.getKey(i10).getAsDouble(), 12);
		assertEquals(queue.getKey(i12).getAsDouble(), 4);

		queue.decreaseKey(i5, -2);
		assertEquals(queue.size(), 12);
		assertTrue(queue.findMin().get() == i5);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertEquals(queue.getKey(i3).getAsDouble(), 5);
		assertEquals(queue.getKey(i4).getAsDouble(), 9);
		assertEquals(queue.getKey(i5).getAsDouble(), -2);
		assertEquals(queue.getKey(i6).getAsDouble(), 8);
		assertEquals(queue.getKey(i7).getAsDouble(), 10);
		assertEquals(queue.getKey(i8).getAsDouble(), 3);
		assertEquals(queue.getKey(i9).getAsDouble(), 6);
		assertEquals(queue.getKey(i10).getAsDouble(), 12);
		assertEquals(queue.getKey(i12).getAsDouble(), 4);

		queue.deleteMin();
		assertEquals(queue.size(), 11);
		assertTrue(queue.findMin().get() == i8);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertEquals(queue.getKey(i3).getAsDouble(), 5);
		assertEquals(queue.getKey(i4).getAsDouble(), 9);
		assertTrue(!queue.getKey(i5).isPresent());
		assertEquals(queue.getKey(i6).getAsDouble(), 8);
		assertEquals(queue.getKey(i7).getAsDouble(), 10);
		assertEquals(queue.getKey(i8).getAsDouble(), 3);
		assertEquals(queue.getKey(i9).getAsDouble(), 6);
		assertEquals(queue.getKey(i10).getAsDouble(), 12);
		assertEquals(queue.getKey(i12).getAsDouble(), 4);

		queue.insert(i5, -1.5);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertEquals(queue.getKey(i3).getAsDouble(), 5);
		assertEquals(queue.getKey(i4).getAsDouble(), 9);
		assertEquals(queue.getKey(i5).getAsDouble(), -1.5);
		assertEquals(queue.getKey(i6).getAsDouble(), 8);
		assertEquals(queue.getKey(i7).getAsDouble(), 10);
		assertEquals(queue.getKey(i8).getAsDouble(), 3);
		assertEquals(queue.getKey(i9).getAsDouble(), 6);
		assertEquals(queue.getKey(i10).getAsDouble(), 12);
		assertEquals(queue.getKey(i12).getAsDouble(), 4);

		queue.deleteMin();
		assertEquals(queue.size(), 11);
		assertTrue(queue.findMin().get() == i8);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertEquals(queue.getKey(i3).getAsDouble(), 5);
		assertEquals(queue.getKey(i4).getAsDouble(), 9);
		assertTrue(!queue.getKey(i5).isPresent());
		assertEquals(queue.getKey(i6).getAsDouble(), 8);
		assertEquals(queue.getKey(i7).getAsDouble(), 10);
		assertEquals(queue.getKey(i8).getAsDouble(), 3);
		assertEquals(queue.getKey(i9).getAsDouble(), 6);
		assertEquals(queue.getKey(i10).getAsDouble(), 12);
		assertEquals(queue.getKey(i12).getAsDouble(), 4);

		queue.decreaseKey(i3, 1);
		assertEquals(queue.size(), 11);
		assertTrue(queue.findMin().get() == i3);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertEquals(queue.getKey(i3).getAsDouble(), 1);
		assertEquals(queue.getKey(i4).getAsDouble(), 9);
		assertTrue(!queue.getKey(i5).isPresent());
		assertEquals(queue.getKey(i6).getAsDouble(), 8);
		assertEquals(queue.getKey(i7).getAsDouble(), 10);
		assertEquals(queue.getKey(i8).getAsDouble(), 3);
		assertEquals(queue.getKey(i9).getAsDouble(), 6);
		assertEquals(queue.getKey(i10).getAsDouble(), 12);
		assertEquals(queue.getKey(i12).getAsDouble(), 4);

		queue.decreaseKey(i8, 2);
		assertEquals(queue.size(), 11);
		assertTrue(queue.findMin().get() == i3);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertEquals(queue.getKey(i3).getAsDouble(), 1);
		assertEquals(queue.getKey(i4).getAsDouble(), 9);
		assertTrue(!queue.getKey(i5).isPresent());
		assertEquals(queue.getKey(i6).getAsDouble(), 8);
		assertEquals(queue.getKey(i7).getAsDouble(), 10);
		assertEquals(queue.getKey(i8).getAsDouble(), 2);
		assertEquals(queue.getKey(i9).getAsDouble(), 6);
		assertEquals(queue.getKey(i10).getAsDouble(), 12);
		assertEquals(queue.getKey(i12).getAsDouble(), 4);

		queue.decreaseKey(i6, 7);
		assertEquals(queue.size(), 11);
		assertTrue(queue.findMin().get() == i3);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertEquals(queue.getKey(i3).getAsDouble(), 1);
		assertEquals(queue.getKey(i4).getAsDouble(), 9);
		assertTrue(!queue.getKey(i5).isPresent());
		assertEquals(queue.getKey(i6).getAsDouble(), 7);
		assertEquals(queue.getKey(i7).getAsDouble(), 10);
		assertEquals(queue.getKey(i8).getAsDouble(), 2);
		assertEquals(queue.getKey(i9).getAsDouble(), 6);
		assertEquals(queue.getKey(i10).getAsDouble(), 12);
		assertEquals(queue.getKey(i12).getAsDouble(), 4);

		queue.deleteMin();
		assertEquals(queue.size(), 10);
		assertTrue(queue.findMin().get() == i8);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertTrue(!queue.getKey(i3).isPresent());
		assertEquals(queue.getKey(i4).getAsDouble(), 9);
		assertTrue(!queue.getKey(i5).isPresent());
		assertEquals(queue.getKey(i6).getAsDouble(), 7);
		assertEquals(queue.getKey(i7).getAsDouble(), 10);
		assertEquals(queue.getKey(i8).getAsDouble(), 2);
		assertEquals(queue.getKey(i9).getAsDouble(), 6);
		assertEquals(queue.getKey(i10).getAsDouble(), 12);
		assertEquals(queue.getKey(i12).getAsDouble(), 4);

		queue.deleteMin();
		assertEquals(queue.size(), 9);
		assertTrue(queue.findMin().get() == i12);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertTrue(!queue.getKey(i3).isPresent());
		assertEquals(queue.getKey(i4).getAsDouble(), 9);
		assertTrue(!queue.getKey(i5).isPresent());
		assertEquals(queue.getKey(i6).getAsDouble(), 7);
		assertEquals(queue.getKey(i7).getAsDouble(), 10);
		assertTrue(!queue.getKey(i8).isPresent());
		assertEquals(queue.getKey(i9).getAsDouble(), 6);
		assertEquals(queue.getKey(i10).getAsDouble(), 12);
		assertEquals(queue.getKey(i12).getAsDouble(), 4);

		queue.delete(i9);
		assertEquals(queue.size(), 8);
		assertTrue(queue.findMin().get() == i12);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertTrue(!queue.getKey(i3).isPresent());
		assertEquals(queue.getKey(i4).getAsDouble(), 9);
		assertTrue(!queue.getKey(i5).isPresent());
		assertEquals(queue.getKey(i6).getAsDouble(), 7);
		assertEquals(queue.getKey(i7).getAsDouble(), 10);
		assertTrue(!queue.getKey(i8).isPresent());
		assertTrue(!queue.getKey(i9).isPresent());
		assertEquals(queue.getKey(i10).getAsDouble(), 12);
		assertEquals(queue.getKey(i12).getAsDouble(), 4);

		queue.delete(i4);
		assertEquals(queue.size(), 7);
		assertTrue(queue.findMin().get() == i12);
		assertEquals(queue.getKey(i1).getAsDouble(), 14);
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertTrue(!queue.getKey(i3).isPresent());
		assertTrue(!queue.getKey(i4).isPresent());
		assertTrue(!queue.getKey(i5).isPresent());
		assertEquals(queue.getKey(i6).getAsDouble(), 7);
		assertEquals(queue.getKey(i7).getAsDouble(), 10);
		assertTrue(!queue.getKey(i8).isPresent());
		assertTrue(!queue.getKey(i9).isPresent());
		assertEquals(queue.getKey(i10).getAsDouble(), 12);
		assertEquals(queue.getKey(i12).getAsDouble(), 4);

		queue.delete(i1);
		assertEquals(queue.size(), 6);
		assertTrue(queue.findMin().get() == i12);
		assertTrue(!queue.getKey(i1).isPresent());
		assertEquals(queue.getKey(i2).getAsDouble(), 11);
		assertTrue(!queue.getKey(i3).isPresent());
		assertTrue(!queue.getKey(i4).isPresent());
		assertTrue(!queue.getKey(i5).isPresent());
		assertEquals(queue.getKey(i6).getAsDouble(), 7);
		assertEquals(queue.getKey(i7).getAsDouble(), 10);
		assertTrue(!queue.getKey(i8).isPresent());
		assertTrue(!queue.getKey(i9).isPresent());
		assertEquals(queue.getKey(i10).getAsDouble(), 12);
		assertEquals(queue.getKey(i12).getAsDouble(), 4);
	}

	@Test
	void test2() {
		PriorityQueue<Integer> queue = new HollowHeap<>();
		int i1, i2, i3, i4, i5, i6, i7, i8;
		i1 = 1;
		i2 = 2;
		i3 = 3;
		i4 = 4;
		i5 = 5;
		i6 = 6;
		i7 = 7;
		i8 = 8;

		assertEquals(queue.size(), 0);
		assertEquals(queue.findMin().isPresent(), false);

		queue.insert(i1, 4);
		assertEquals(queue.size(), 1);
		assertTrue(queue.findMin().get() == i1);

		queue.insert(i2, 3);
		assertEquals(queue.size(), 2);
		assertTrue(queue.findMin().get() == i2);

		queue.insert(i3, -2);
		assertEquals(queue.size(), 3);
		assertTrue(queue.findMin().get() == i3);

		queue.insert(i4, -2);
		assertEquals(queue.size(), 4);
		assertTrue(queue.findMin().get().equals(i3) || queue.findMin().get().equals(i4));

		queue.insert(i5, 0);
		assertEquals(queue.size(), 5);
		assertTrue(queue.findMin().get().equals(i3) || queue.findMin().get().equals(i4));

		queue.insert(i6, 3);
		assertEquals(queue.size(), 6);
		assertTrue(queue.findMin().get().equals(i3) || queue.findMin().get().equals(i4));

		queue.insert(i7, 7);
		assertEquals(queue.size(), 7);
		assertTrue(queue.findMin().get().equals(i3) || queue.findMin().get().equals(i4));

		queue.insert(i8, 5);
		assertEquals(queue.size(), 8);
		assertTrue(queue.findMin().get().equals(i3) || queue.findMin().get().equals(i4));

		queue.decreaseKey(i2, 2);
		assertEquals(queue.size(), 8);
		assertTrue(queue.findMin().get().equals(i3) || queue.findMin().get().equals(i4));

		queue.deleteMin();
		assertEquals(queue.size(), 7);
		assertTrue(queue.findMin().get().equals(i3) || queue.findMin().get().equals(i4));

		queue.delete(i7);
		assertEquals(queue.size(), 6);
		assertTrue(queue.findMin().get().equals(i3) || queue.findMin().get().equals(i4));

		queue.deleteMin();
		assertEquals(queue.size(), 5);
		assertTrue(queue.findMin().get() == i5);

		queue.delete(i5);
		assertEquals(queue.size(), 4);
		assertTrue(queue.findMin().get().equals(i2));

		queue.decreaseKey(i8, 3);
		assertEquals(queue.size(), 4);
		assertTrue(queue.findMin().get().equals(i2));

		queue.decreaseKey(i1, 0);
		assertEquals(queue.size(), 4);
		assertTrue(queue.findMin().get() == i1);

		queue.delete(i8);
		assertEquals(queue.size(), 3);
		assertTrue(queue.findMin().get() == i1);

		queue.deleteMin();
		assertEquals(queue.size(), 2);
		assertTrue(queue.findMin().get() == i2);

		queue.delete(i6);
		assertEquals(queue.size(), 1);
		assertTrue(queue.findMin().get() == i2);

		queue.deleteMin();
		assertEquals(queue.size(), 0);
		assertEquals(queue.findMin().isPresent(), false);
	}

	@Test
	void test3() {
		HollowHeap<Integer> queue1 = new HollowHeap<>();
		HollowHeap<Integer> queue2 = new HollowHeap<>();
		Map<Integer, Double> map = new HashMap<>();
		int i1, i2, i3, i4, i5, i6, i7, i8;
		i1 = 1;
		i2 = 2;
		i3 = 3;
		i4 = 4;
		i5 = 5;
		i6 = 6;
		i7 = 7;
		i8 = 8;

		assertEquals(queue1.size(), 0);
		assertEquals(queue1.findMin().isPresent(), false);
		assertEquals(queue2.size(), 0);
		assertEquals(queue2.findMin().isPresent(), false);
		assertFalse(queue1.getKey(i1).isPresent());
		assertFalse(queue1.getKey(i2).isPresent());
		assertFalse(queue1.getKey(i3).isPresent());
		assertFalse(queue1.getKey(i4).isPresent());
		assertFalse(queue1.getKey(i5).isPresent());
		assertFalse(queue1.getKey(i6).isPresent());
		assertFalse(queue1.getKey(i7).isPresent());
		assertFalse(queue1.getKey(i8).isPresent());

		queue1.insert(i1, 2);
		assertEquals(queue1.size(), 1);
		assertTrue(queue1.findMin().get() == i1);
		assertEquals(queue1.getKey(i1).getAsDouble(), 2);
		assertFalse(queue1.getKey(i2).isPresent());
		assertFalse(queue1.getKey(i3).isPresent());
		assertFalse(queue1.getKey(i4).isPresent());
		assertFalse(queue1.getKey(i5).isPresent());
		assertFalse(queue1.getKey(i6).isPresent());
		assertFalse(queue1.getKey(i7).isPresent());
		assertFalse(queue1.getKey(i8).isPresent());

		queue1.insert(i2, 0);
		assertEquals(queue1.size(), 2);
		assertTrue(queue1.findMin().get() == i2);
		assertEquals(queue1.getKey(i1).getAsDouble(), 2);
		assertEquals(queue1.getKey(i2).getAsDouble(), 0);
		assertFalse(queue1.getKey(i3).isPresent());
		assertFalse(queue1.getKey(i4).isPresent());
		assertFalse(queue1.getKey(i5).isPresent());
		assertFalse(queue1.getKey(i6).isPresent());
		assertFalse(queue1.getKey(i7).isPresent());
		assertFalse(queue1.getKey(i8).isPresent());

		queue1.insert(i3, 3);
		assertEquals(queue1.size(), 3);
		assertTrue(queue1.findMin().get() == i2);
		assertEquals(queue1.getKey(i1).getAsDouble(), 2);
		assertEquals(queue1.getKey(i2).getAsDouble(), 0);
		assertEquals(queue1.getKey(i3).getAsDouble(), 3);
		assertFalse(queue1.getKey(i4).isPresent());
		assertFalse(queue1.getKey(i5).isPresent());
		assertFalse(queue1.getKey(i6).isPresent());
		assertFalse(queue1.getKey(i7).isPresent());
		assertFalse(queue1.getKey(i8).isPresent());

		queue2.insert(i4, -1);
		assertEquals(queue2.size(), 1);
		assertTrue(queue2.findMin().get() == i4);
		assertFalse(queue2.getKey(i1).isPresent());
		assertFalse(queue2.getKey(i2).isPresent());
		assertFalse(queue2.getKey(i3).isPresent());
		assertEquals(queue2.getKey(i4).getAsDouble(), -1);
		assertFalse(queue2.getKey(i5).isPresent());
		assertFalse(queue2.getKey(i6).isPresent());
		assertFalse(queue2.getKey(i7).isPresent());
		assertFalse(queue2.getKey(i8).isPresent());

		queue2.insert(i5, 1.5);
		assertEquals(queue2.size(), 2);
		assertTrue(queue2.findMin().get() == i4);
		assertFalse(queue2.getKey(i1).isPresent());
		assertFalse(queue2.getKey(i2).isPresent());
		assertFalse(queue2.getKey(i3).isPresent());
		assertEquals(queue2.getKey(i4).getAsDouble(), -1);
		assertEquals(queue2.getKey(i5).getAsDouble(), 1.5);
		assertFalse(queue2.getKey(i6).isPresent());
		assertFalse(queue2.getKey(i7).isPresent());
		assertFalse(queue2.getKey(i8).isPresent());

		queue2.insert(i6, 0);
		assertEquals(queue2.size(), 3);
		assertTrue(queue2.findMin().get() == i4);
		assertFalse(queue2.getKey(i1).isPresent());
		assertFalse(queue2.getKey(i2).isPresent());
		assertFalse(queue2.getKey(i3).isPresent());
		assertEquals(queue2.getKey(i4).getAsDouble(), -1);
		assertEquals(queue2.getKey(i5).getAsDouble(), 1.5);
		assertEquals(queue2.getKey(i6).getAsDouble(), 0);
		assertFalse(queue2.getKey(i7).isPresent());
		assertFalse(queue2.getKey(i8).isPresent());

		queue2.deleteMin();
		assertEquals(queue2.size(), 2);
		assertTrue(queue2.findMin().get() == i6);
		assertFalse(queue2.getKey(i1).isPresent());
		assertFalse(queue2.getKey(i2).isPresent());
		assertFalse(queue2.getKey(i3).isPresent());
		assertFalse(queue2.getKey(i3).isPresent());
		assertEquals(queue2.getKey(i5).getAsDouble(), 1.5);
		assertEquals(queue2.getKey(i6).getAsDouble(), 0);
		assertFalse(queue2.getKey(i7).isPresent());
		assertFalse(queue2.getKey(i8).isPresent());

		map.put(i7, -1.);
		map.put(i8, 5.);

		queue1.meld(queue2);
		assertEquals(queue1.size(), 5);
		assertTrue(queue1.findMin().get() == i2 || queue1.findMin().get() == i6);
		assertEquals(queue1.getKey(i1).getAsDouble(), 2);
		assertEquals(queue1.getKey(i2).getAsDouble(), 0);
		assertEquals(queue1.getKey(i3).getAsDouble(), 3);
		assertFalse(queue1.getKey(i4).isPresent());
		assertEquals(queue1.getKey(i5).getAsDouble(), 1.5);
		assertEquals(queue1.getKey(i6).getAsDouble(), 0);
		assertFalse(queue1.getKey(i7).isPresent());
		assertFalse(queue1.getKey(i8).isPresent());

		queue1.addAll(map);
		assertEquals(queue1.size(), 7);
		assertTrue(queue1.findMin().get() == i7);
		assertEquals(queue1.getKey(i1).getAsDouble(), 2);
		assertEquals(queue1.getKey(i2).getAsDouble(), 0);
		assertEquals(queue1.getKey(i3).getAsDouble(), 3);
		assertFalse(queue1.getKey(i4).isPresent());
		assertEquals(queue1.getKey(i5).getAsDouble(), 1.5);
		assertEquals(queue1.getKey(i6).getAsDouble(), 0);
		assertEquals(queue1.getKey(i7).getAsDouble(), -1);
		assertEquals(queue1.getKey(i8).getAsDouble(), 5);
	}
}
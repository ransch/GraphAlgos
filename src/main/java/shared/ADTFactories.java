package shared;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import dataStructures.DisjointSet;
import dataStructures.DisjointSetForest;
import dataStructures.HollowHeap;
import dataStructures.PriorityQueue;

/**
 * This class bundles factories for the ADTs that are used in the library.
 */
public class ADTFactories {

	private final static ADTFactories INSTANCE = new ADTFactories();

	private ListFactory listFactory;
	private QueueFactory queueFactory;
	private SetFactory setFactory;
	private MapFactory mapFactory;
	private DisjointSetFactory disjointSetFactory;
	private PriorityQueueFactory priorityQueueFactory;

	private ADTFactories() {
		listFactory = LinkedList::new;
		queueFactory = LinkedList::new;
		setFactory = HashSet::new;
		mapFactory = HashMap::new;
		disjointSetFactory = DisjointSetForest::new;
		priorityQueueFactory = HollowHeap::new;
	}

	/**
	 * This method returns the object that provides the factories. The default
	 * implementations:
	 * <ol>
	 * <li>{@link List} - {@link LinkedList}</li>
	 * <li>{@link Queue} - {@link LinkedList}</li>
	 * <li>{@link Set} - {@link HashSet}</li>
	 * <li>{@link Map} - {@link HashMap}</li>
	 * <li>{@link DisjointSet} - {@link DisjointSetForest}</li>
	 * <li>{@link PriorityQueue} - {@link HollowHeap}</li>
	 * </ol>
	 * 
	 * @return the object that provides the factories
	 */
	public static ADTFactories ADTs() {
		return INSTANCE;
	}

	public <T> List<T> genList() {
		return listFactory.newInstance();
	}

	public <T> Queue<T> genQueue() {
		return queueFactory.newInstance();
	}

	public <T> Set<T> genSet() {
		return setFactory.newInstance();
	}

	public <T, S> Map<T, S> genMap() {
		return mapFactory.newInstance();
	}

	public <T> DisjointSet<T> genDisjointSet() {
		return disjointSetFactory.newInstance();
	}

	public <T> PriorityQueue<T> genPriorityQueue() {
		return priorityQueueFactory.newInstance();
	}

	public void setListFactory(ListFactory listFactory) {
		this.listFactory = listFactory;
	}

	public void setQueueFactory(QueueFactory queueFactory) {
		this.queueFactory = queueFactory;
	}

	public void setSetFactory(SetFactory setFactory) {
		this.setFactory = setFactory;
	}

	public void setMapFactory(MapFactory mapFactory) {
		this.mapFactory = mapFactory;
	}

	public void setDisjointSetFactory(DisjointSetFactory disjointSetFactory) {
		this.disjointSetFactory = disjointSetFactory;
	}

	public void setPriorityQueueFactory(PriorityQueueFactory priorityQueueFactory) {
		this.priorityQueueFactory = priorityQueueFactory;
	}

	@FunctionalInterface
	public interface ListFactory {
		public <E> List<E> newInstance();
	}

	@FunctionalInterface
	public interface QueueFactory {
		public <E> Queue<E> newInstance();
	}

	@FunctionalInterface
	public interface SetFactory {
		public <E> Set<E> newInstance();
	}

	@FunctionalInterface
	public interface MapFactory {
		public <T, S> Map<T, S> newInstance();
	}

	@FunctionalInterface
	public interface DisjointSetFactory {
		public <E> DisjointSet<E> newInstance();
	}

	@FunctionalInterface
	public interface PriorityQueueFactory {
		public <E> PriorityQueue<E> newInstance();
	}
}
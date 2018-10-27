package dataStructures;

import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;

/**
 * This interface defines the priority-queue abstract data type.
 * 
 * @param <T> The type of the objects that are stored in the queue
 */
public interface PriorityQueue<T> {

	/**
	 * This method inserts a new item into the queue.
	 * 
	 * @param item The item that would be inserted
	 * @param key  The item's key
	 * @preconditions
	 *                <ol>
	 *                <li><code>item != null</code></li>
	 *                <li><code>item</code> has not been inserted (yet) into the
	 *                queue</li>
	 *                </ol>
	 */
	public void insert(T item, double key);

	/**
	 * This method returns the key of a given item, or an empty {@link Optional} if
	 * the queue doesn't contain that item.
	 * 
	 * @param item
	 * @preconditions <code>item != null</code>
	 * @return If <code>item</code> is a member of the queue, its key is returned;
	 *         Otherwise, an empty {@link Optional} is returned
	 */
	public OptionalDouble getKey(T item);

	/**
	 * This method returns the element with the minimal key in the queue.
	 * 
	 * @return if <code>this.size() > 0</code>, the element with the minimal key is
	 *         returned. Otherwise, an empty {@link Optional} is returned.
	 */
	public Optional<T> findMin();

	/**
	 * This method removes the item with the minimal key from the queue.
	 * 
	 * @preconditions <code>this.size() > 0</code>
	 */
	public void deleteMin();

	/**
	 * This method removes an item from the queue
	 * 
	 * @param item the item that should be removed
	 * @preconditions
	 *                <ol>
	 *                <li><code>item != null</code></li>
	 *                <li><code>item</code> is a member of the queue</li>
	 *                </ol>
	 */
	public void delete(T item);

	/**
	 * This method returns the number of items that are currently members of
	 * <code>this</code> queue.
	 * 
	 * @return The size of the queue.
	 */
	public int size();

	/**
	 * This method decreases the key of an item in the queue.
	 * 
	 * @param item The item whose key would be decreased
	 * @preconditions
	 *                <ol>
	 *                <li><code>item != null</code></li>
	 *                <li><code>item</code> is a member of the queue</li>
	 *                <li><code>getKey(item).getAsDouble() &gt; newK</code></li>
	 *                </ol>
	 */
	public void decreaseKey(T item, double newK);

	/**
	 * This method adds an entire {@link Map} into the queue.
	 * 
	 * @param     <E>
	 * 
	 * @param map
	 * @preconditions
	 *                <ol>
	 *                <li><code>map != null</code></li>
	 *                <li><code>this</code> and <code>heap</code> are disjoint</li>
	 *                </ol>
	 * @postconditions Every item in <code>map</code> has been added into
	 *                 <code>this</code> queue
	 */
	public void addAll(Map<T, Double> map);
}
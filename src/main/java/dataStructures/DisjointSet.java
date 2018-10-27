package dataStructures;

import java.util.Collection;
import java.util.stream.Stream;

/**
 * This interface defines the disjoint-set abstract data type, that maintains
 * equivalence classes.
 * 
 * @param <T> The type of the objects that are stored in the structure
 */
public interface DisjointSet<T> {

	/**
	 * This method creates a new set (that is, a new equivalence class) whose only
	 * member (and thus representative) is <code>x</code>
	 * 
	 * @param x
	 * @preconditions
	 *                <ol>
	 *                <li><code>x != null</code></li>
	 *                <li><code>x</code> has not been inserted (yet) into the
	 *                structure</li>
	 *                </ol>
	 */
	public void makeSet(T x);

	/**
	 * This method unites two equivalence classes.
	 * 
	 * @param x
	 * @param y
	 * @preconditions
	 *                <ol>
	 *                <li><code>x, y != null</code></li>
	 *                <li><code>!x.equals(y)</code></li>
	 *                <li>Both <code>x</code> and <code>y</code> have been already
	 *                inserted into the structure</li>
	 *                <li><code>findSet(x) != findSet(y)</code></li>
	 *                </ol>
	 */
	public void union(T x, T y);

	/**
	 * This method returns the representative of the equivalence class that contains
	 * <code>x</code>.
	 * 
	 * @param x
	 * @preconditions
	 *                <ol>
	 *                <li>x != null</li>
	 *                <li><code>x</code> has already been inserted into the
	 *                structure</li>
	 *                </ol>
	 * @return
	 */
	public T findSet(T x);

	/**
	 * This method returns the total number of items that have been inserted into
	 * the structure.
	 * 
	 * @return The total number of items in the structure
	 */
	public int itemsCount();

	/**
	 * This method returns the total number of sets (equivalence classes) currently
	 * in the structure.
	 * 
	 * @return The total number of sets in the structure
	 */
	public int setsCount();

	/**
	 * This method adds the members of a given collection into <code>this</code>
	 * structure, making each member a new set.
	 * 
	 * @param collection
	 * @preconditions
	 *                <ol>
	 *                <li><code>collection != null</code></li>
	 *                <li>$\forall x \in collection, x \; has \; not \; been \;
	 *                inserted \; (yet) \; into \; the \; structure$</li>
	 *                </ol>
	 */
	public void addAll(Collection<T> collection);

	/**
	 * This method adds the members of a given stream into <code>this</code>
	 * structure, making each member a new set.
	 * 
	 * @param stream
	 * @preconditions
	 *                <ol>
	 *                <li><code>stream != null</code></li>
	 *                <li><code>stream</code> is finite</li>
	 *                <li>$\forall x \in stream, x \; has \; not \; been \; inserted
	 *                \; (yet) \; into \; the \; structure$</li>
	 *                </ol>
	 */
	public void addAll(Stream<T> stream);
}
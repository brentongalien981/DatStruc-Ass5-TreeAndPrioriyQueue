package coursepackage2;

import java.util.Comparator;

public class SortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

	private PositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

	public SortedPriorityQueue() {
		super();
	}

	public SortedPriorityQueue(Comparator<K> comp) {
		super(comp);
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key); // auxiliary key-checking method (could throw exception)
		Entry<K, V> newest = new PQEntry<>(key, value);
		Position<Entry<K, V>> walk = list.last();
		// walk backward, looking for smaller key
		while (walk != null && compare(newest, walk.getElement()) < 0)
			walk = list.before(walk);
		if (walk == null)
			list.addFirst(newest); // new key is smallest
		else
			list.addAfter(walk, newest); // newest goes after walk
		return newest;
	}

	@Override
	public Entry<K, V> min() {
		if (list.isEmpty())
			return null;
		return list.first().getElement();
	}

	@Override
	public Entry<K, V> removeMin() {
		if (list.isEmpty())
			return null;
		return list.remove(list.first());
	}

	@Override
	public int size() {
		return list.size();
	}
}

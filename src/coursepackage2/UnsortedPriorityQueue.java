package coursepackage2;

import java.util.Comparator;

public class UnsortedPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

	private PositionalList<Entry<K, V>> list = new LinkedPositionalList<>();

	public UnsortedPriorityQueue() {
		super();
	}

	public UnsortedPriorityQueue(Comparator<K> comp) {
		super(comp);
	}

	private Position<Entry<K, V>> findMin() { // only called when nonempty
		Position<Entry<K, V>> small = list.first();
		for (Position<Entry<K, V>> walk : list.positions())
			if (compare(walk.getElement(), small.getElement()) < 0)
				small = walk; // found an even smaller key
		return small;
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key); // auxiliary key-checking method (could throw exception)
		Entry<K, V> newest = new PQEntry<>(key, value);
		list.addLast(newest);
		return newest;
	}

	@Override
	public Entry<K, V> min() {
		if (list.isEmpty())
			return null;
		return findMin().getElement();
	}

	@Override
	public Entry<K, V> removeMin() {
		if (list.isEmpty())
			return null;
		return list.remove(findMin());
	}

	@Override
	public int size() {
		return list.size();
	}

	public static void main(String[] args) {

		UnsortedPriorityQueue<String, String> queue = new UnsortedPriorityQueue<String, String>();
		queue.insert("5", "A");
		queue.insert("9", "C");
		queue.insert("3", "B");
		// list all entries
		for (Position<Entry<String, String>> walk : queue.list.positions())
			System.out.println("(" + walk.getElement().getKey() + ", " + walk.getElement().getValue() + ")");
		// print the key of the first entry
		Position<Entry<String, String>> first = queue.list.first();
		System.out.println(first.getElement().getKey());
		// print the entry with minimal key
		System.out.println("Entry with minimal key: (" + queue.min().getKey() + ", " + queue.min().getValue() + ")");

	}

}

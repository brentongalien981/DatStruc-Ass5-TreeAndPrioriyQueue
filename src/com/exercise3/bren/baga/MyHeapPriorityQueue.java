package com.exercise3.bren.baga;

import coursepackage2.*;



public class MyHeapPriorityQueue<K, V> extends HeapPriorityQueue<K, V> {
	
	

	// 300726788 - Bren Baga
	public static void main(String[] args) {
		
		System.out.println("Exercise 3 - Modifying uphead() method with recursion.");
		System.out.println("TASK: Two priorityQueues should end up having similar entries, but using two different implementations of the upheap() method.\n\n\n");
		

		// Create a default heapPriorityQueue.
		System.out.println("Part 1) Default HeapPriorityQueue.\n");
		
		HeapPriorityQueue<Integer, String> defaultHpq = new HeapPriorityQueue<>();
		defaultHpq.insert(2, "B");
		defaultHpq.insert(3, "C");
		defaultHpq.insert(4, "D");
		defaultHpq.insert(1, "A");
		defaultHpq.insert(5, "E");
		defaultHpq.insert(6, "F");
		defaultHpq.insert(8, "H");
		defaultHpq.insert(9, "I");
		defaultHpq.insert(0, "X");
		defaultHpq.insert(7, "G");

		
		// Display the default HeapPriorityQueue.
		System.out.println("\nDefault HeapPriorityQueue Entries.\n");
		
		for (int i = 0; i < defaultHpq.size(); i++) {
			System.out.println("(" + defaultHpq.get(i).getKey() + ", " + defaultHpq.get(i).getValue() + ")");
		}

		
		
		System.out.println("\n\n\n--------------------------------------------------\n\n\n");

		
		
		// Create myHeapPriorityQueue with recursive upheap() method.
		System.out.println("Part 2) myHeapPriorityQueue with recursive upheap() method.\n");
		
		MyHeapPriorityQueue<Integer, String> myHpq = new MyHeapPriorityQueue<>();
		myHpq.insert(2, "B");
		myHpq.insert(3, "C");
		myHpq.insert(4, "D");
		myHpq.insert(1, "A");
		myHpq.insert(5, "E");
		myHpq.insert(6, "F");
		myHpq.insert(8, "H");
		myHpq.insert(9, "I");
		myHpq.insert(0, "X");
		myHpq.insert(7, "G");

		// Display myHeapPriorityQueue.
		System.out.println("\nmyHeapPriorityQueue Entries.\n");

		for (int i = 0; i < myHpq.size(); i++) {
			System.out.println("(" + myHpq.get(i).getKey() + ", " + myHpq.get(i).getValue() + ")");
		}

	}
	
	
	
	@Override
	protected void upheap(int childIndex) {

		System.out.println("Calling METHOD: upheap() from CLASS: MyHeapPriorityQueue...");

		int parentIndex = parent(childIndex);

		if (compare(heap.get(childIndex), heap.get(parentIndex)) < 0) {

			swap(childIndex, parentIndex);
			childIndex = parentIndex;
			upheap(childIndex);

		}

	}

}

package com.exercise2.bren.baga;

import java.util.List;

import com.exercise1.bren.baga.MyLinkedBinaryTree;

import coursepackage.AbstractTree;
import coursepackage.Position;
import coursepackage.TraversalExamples;
import coursepackage.Tree;

public class PostOrderHeight {

	// 300726788 - Bren Baga
	public static void main(String[] args) {

		// Create and populate binary tree.
		MyLinkedBinaryTree<String> t = new MyLinkedBinaryTree<>();

		// depth0
		Position<String> depth0 = t.addRoot("depth0");

		// depth1
		Position<String> depth1A = t.addLeft(depth0, "depth1A");
		Position<String> depth1B = t.addRight(depth0, "depth1B");

		// depth2
		Position<String> depth2A = t.addLeft(depth1A, "depth2A");
		Position<String> depth2B = t.addRight(depth1A, "depth2B");

		Position<String> depth2C = t.addLeft(depth1B, "depth2C");
		Position<String> depth2D = t.addRight(depth1B, "depth2D");

		// depth3
		Position<String> depth3C = t.addLeft(depth2B, "depth3C");
		Position<String> depth3D = t.addRight(depth2B, "depth3D");

		
		
		System.out.println("Exercise 2");
		System.out.println("Let H = height of position / node.\n");

		System.out.println("METHOD: printPostorderHeight()");
		System.out.println("RUNNING-TIME: O(n)\n");
		printPostorderHeight(t, t.root());

		
		System.out.println("\n\n\n-------------------------------\n\n\n");

		
		
		System.out.println("METHOD: printPostorderSlow()");
		System.out.println("RUNNING-TIME: O(n^2)\n");
		printPostorderSlow(t);
	}

	
	
	// Running time: O(n^2)
	public static <E> void printPostorderSlow(AbstractTree<E> T) {
		for (Position<E> p : T.postorder()) {
			int h = T.height(p);
			System.out.println(TraversalExamples.spaces(4 * h) + p.getElement() + " H = " + h);
		}

	}

	
	
	// Running time: O(n)
	public static <E> int printPostorderHeight(Tree<E> T, Position<E> p) {

		// Default height if node is a leaf (external node).
		int h = 0;

		for (Position<E> c : T.children(p)) {
			// Calculate the height recursively if node is internal.
			h = Math.max(h, 1 + printPostorderHeight(T, c));
		}

		System.out.println(TraversalExamples.spaces(4 * h) + p.getElement() + " H = " + h);

		return h;
	}

}

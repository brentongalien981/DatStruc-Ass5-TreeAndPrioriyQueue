package com.exercise1.bren.baga;

import java.util.Iterator;

import coursepackage.AbstractBinaryTree;
import coursepackage.AbstractTree;
import coursepackage.LinkedBinaryTree;
import coursepackage.Position;
import coursepackage.TraversalExamples;

public class MyLinkedBinaryTree<E> extends LinkedBinaryTree<E> {

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

		
		
		
		
		/* Demo the preorderNext() method. */
		System.out.println("Exercise 1");
		System.out.println("Demo preorderNext() method.\n");
		TraversalExamples.printPreorderIndent(t, depth0, t.depth(depth0));

		Position<String> referenceNode = depth2B;
		Position<String> nextNode = t.preorderNext(referenceNode);
		String nextNodeElement = (nextNode != null) ? nextNode.getElement() : null;

		System.out.println("\nreferenceNode ==> " + referenceNode.getElement());
		System.out.println("nextNode ==> " + nextNodeElement);

		referenceNode = depth3D;
		nextNode = t.preorderNext(referenceNode);
		nextNodeElement = (nextNode != null) ? nextNode.getElement() : null;

		System.out.println("\nreferenceNode ==> " + referenceNode.getElement());
		System.out.println("nextNode ==> " + nextNodeElement);

		// Exception case.
		referenceNode = depth2D;
		nextNode = t.preorderNext(referenceNode);
		nextNodeElement = (nextNode != null) ? nextNode.getElement() : null;

		System.out.println("\nreferenceNode ==> " + referenceNode.getElement());
		System.out.println("nextNode ==> " + nextNodeElement);

		
		
		
		
		/* Demo the inorderNext() method. */
		System.out.println("\n\n\n---------------------------------------------------------------\n\n\n");
		System.out.println("Demo inorderNext() method.\n");
		printInorder(t);

		referenceNode = depth2A;
		nextNode = t.inorderNext(referenceNode);
		nextNodeElement = (nextNode != null) ? nextNode.getElement() : null;

		System.out.println("\nreferenceNode ==> " + referenceNode.getElement());
		System.out.println("nextNode ==> " + nextNodeElement);

		referenceNode = depth3D;
		nextNode = t.inorderNext(referenceNode);
		nextNodeElement = (nextNode != null) ? nextNode.getElement() : null;

		System.out.println("\nreferenceNode ==> " + referenceNode.getElement());
		System.out.println("nextNode ==> " + nextNodeElement);

		// Exception case.
		referenceNode = depth2D;
		nextNode = t.inorderNext(referenceNode);
		nextNodeElement = (nextNode != null) ? nextNode.getElement() : null;

		System.out.println("\nreferenceNode ==> " + referenceNode.getElement());
		System.out.println("nextNode ==> " + nextNodeElement);

	}

	
	
	public Position<E> preorderNext(Position<E> p) {

		Iterator<Position<E>> posIterator = preorder().iterator();

		return genericOrderNext(p, posIterator);
	}

	
	
	public Position<E> inorderNext(Position<E> p) {

		Iterator<Position<E>> posIterator = inorder().iterator();

		return genericOrderNext(p, posIterator);
	}

	
	
	public Position<E> genericOrderNext(Position<E> p, Iterator<Position<E>> posIterator) {

		Node<E> referenceNode = validate(p);

		Node<E> nextNode = null;
		Node<E> walkNode;

		while (true) {

			try {
				walkNode = (Node<E>) posIterator.next();

				if (walkNode == referenceNode) {
					nextNode = (Node<E>) posIterator.next();
					break;
				}
			} catch (Exception e) {
				System.out.println("\nOops! Caught exception ==> " + e.getMessage());
				break;
			}

		}

		return nextNode;
	}

	
	
	public static <E> void printInorder(AbstractBinaryTree<E> T) {
		for (Position<E> p : T.inorder())
			System.out.println(p.getElement());
	}

}

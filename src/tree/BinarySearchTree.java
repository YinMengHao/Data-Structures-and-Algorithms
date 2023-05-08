package tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("unused")
public class BinarySearchTree<E> {
	
	private Node<E> root;
	private Comparator<E> comparator;
	
	public BinarySearchTree() {
		this(null);
	}
	
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
	}
 	
	private static class Node<E> {
		Node<E> left;
		Node<E> right;
		Node<E> parent;

		E element;
		
		public Node(E element, Node<E> parent) {
			this.parent = parent;
			this.element = element;
		}
	}
	
	private int size = 0;
	
	int size() {
		return size;
	}
	
	boolean isEmpty() {
		return size == 0;
	}
	
	void clear() {
		
	}
	
	void add(E element) {
		elementNotNullCheck(element);
		
		if (root == null) {
			root = new Node<>(element, null);
			size++;
			return;
		}
		
		// 记录父节点
		Node<E> parentNode = root;
		Node<E> node = root;
		int cmp = 0;
		
		while (node != null) {
			cmp = compare(element, node.element);
			parentNode = node;
			if (cmp > 0) {
				node = node.right;
			} else if (cmp < 0) {
				node = node.left;
			} else {
				return;
			}
		}
		
		Node<E> newNode = new Node<>(element, parentNode);
		if (cmp > 0) {
			parentNode.right = node;
		} else {
			parentNode.left = node;
		}
		size++;
	}
	
	void remove(E element) {
		
		size--;
		
	}
	
	boolean contains(E element) {
		return false;
	}
	
	// 前序遍历
	public void preorderTraversal() {
		preorderTraversal(root);
	}
	
	private void preorderTraversal(Node<E> node) {
		if (node == null) {
			return;
		}
		System.out.println(node.element);
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}
	
	// 中序遍历
	public void inorderTraversal() {
		inorderTraversal(root);
	}
	
	private void inorderTraversal(Node<E> node) {
		if (node == null) {
			return;
		}
		inorderTraversal(node.left);
		System.out.println(node.element);
		inorderTraversal(node.right);
	}
	
	// 后序遍历
		public void postorderTraversal() {
			postorderTraversal(root);
		}
		
		private void postorderTraversal(Node<E> node) {
			if (node == null) {
				return;
			}
			postorderTraversal(node.left);
			postorderTraversal(node.right);
			System.out.println(node.element);
		}
		
		// 层序遍历
		public void levelOrderTraversal() {
			if (root == null) return;
			Queue<Node<E>> queue = new LinkedList<>();
			queue.offer(root);
			while (!queue.isEmpty()) {
				Node<E> node = queue.poll();
				System.out.println(node.element);
				
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}
	
	
	/*
	 * @return 0: e1 = e2  大于0: e1 > e2 小于零：e1 < e2
	 * **/
	@SuppressWarnings("unchecked")
	private int compare(E e1, E e2) {
		if (comparator != null) {
			return compare(e1, e2);
		}
		return ((Comparable<E>) e1).compareTo(e2);
	}
	
	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}

}

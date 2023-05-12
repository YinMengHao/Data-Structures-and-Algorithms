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
		
		// 判断节点是否是叶子节点
		public boolean isLeaf() {
			return left == null && right == null;
		}
		
		public boolean hasTwoChildren() {
			return left != null && right != null;
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
		root = null;
		size = 0;
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

	// 1. 删除根节点  2. 删除度为1的节点 3. 删除度为2的节点（找前驱或后继 值覆盖 再删除）
	void remove(E element) {
		remove(node(element));
	}
	
	private void remove(Node<E> node) {
		if (node == null) return;
		size--;
		if (node.hasTwoChildren()) {
			// 找到后继节点
			Node<E> s = successor(node);
			// 用后继节点的值覆盖度为2的节点的值
			node.element = s.element;
			// 删除后继节点
			node = s;
		}
		// 删除node节点（node的度是1或者0）
		Node<E> replaceNode = node.left != null ? node.left : node.right;
		if (replaceNode != null) { // node的度为1
			// 更改parent
			replaceNode.parent = node.parent;
			// 更改parent的left、right的指向
			if (node.parent == null) {
				root = replaceNode;
			} else if (node == node.parent.left) {
				node.parent.left = replaceNode;
			} else if (node == node.parent.right) {
				node.parent.right = replaceNode;
			}
		} else if(node.parent == null) { // node是叶子节点并且是根节点
			root = null;
		} else { // node是叶子节点，但不是根节点
			if (node == node.parent.left) {
				node.parent.left = null;
			} else {
				node.parent.right = null;
			}
		}
	}
	
	private Node<E> node(E element) {
		Node<E> node = root;
		while (node != null) {
			int cmp = compare(element, node.element);
			if (cmp == 0) return node;
			if (cmp > 0) {
				node = node.right;
			} else {
				node = node.left;
			}
		}
		return null;
	}

	boolean contains(E element) {
		return node(element) != null;
	}
	
	// 前驱节点
	private Node<E> predecessor(Node<E> node) {
		if (node == null) return null;
		Node<E> p = node.left;
		if (p != null) {
			while (p.right != null) {
				p = p.right;
			}
			return p;
		}
		while (node.parent != null && node == node.parent.left) {
			node = node.parent;
		}
		return node.parent;
	}
	
	// 后继节点
	private Node<E> successor(Node<E> node) {
		if (node == null) return null;
		Node<E> p = node.right;
		if (p != null) {
			while (p.left != null) {
				p = p.left;
			}
			return p;
		}
		while (node.parent != null && node == node.parent.right) {
			node = node.parent;
		}
		return node.parent;
	}

	// 前序遍历
//	public void preorderTraversal() {
//		preorderTraversal(root);
//	}
//	
//	private void preorderTraversal(Node<E> node) {
//		if (node == null) {
//			return;
//		}
//		System.out.println(node.element);
//		preorderTraversal(node.left);
//		preorderTraversal(node.right);
//	}
	public void preorderTraversal(Visitor<E> visitor) {
		if (visitor == null) return;
		preorderTraversal(root, visitor);
	}

	private void preorderTraversal(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor.stop) return;
		visitor.visit(node.element);
		preorderTraversal(node.left, visitor);
		preorderTraversal(node.right, visitor);
	}
	// 中序遍历
//	public void inorderTraversal() {
//		inorderTraversal(root);
//	}
//	
//	private void inorderTraversal(Node<E> node) {
//		if (node == null) {
//			return;
//		}
//		inorderTraversal(node.left);
//		System.out.println(node.element);
//		inorderTraversal(node.right);
//	}

	public void inorderTraversal(Visitor<E> visitor) {
		if (visitor == null) return;
		inorderTraversal(root, visitor);
	}

	private void inorderTraversal(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor.stop) return;
		preorderTraversal(node.left, visitor);
		if (visitor.stop) return;
		visitor.visit(node.element);
		preorderTraversal(node.right, visitor);

	}

	// 后序遍历
//		public void postorderTraversal() {
//			postorderTraversal(root);
//		}
//		
//		private void postorderTraversal(Node<E> node) {
//			if (node == null) {
//				return;
//			}
//			postorderTraversal(node.left);
//			postorderTraversal(node.right);
//			System.out.println(node.element);
//		}

	public void postorderTraversal(Visitor<E> visitor) {
		if (visitor == null) return;
		postorderTraversal(root, visitor);
	}
	
	private void postorderTraversal(Node<E> node, Visitor<E> visitor) {
		if (node == null || visitor.stop) return;
		postorderTraversal(node.left, visitor);
		postorderTraversal(node.right, visitor);
		if (visitor.stop) return;
		visitor.visit(node.element);
	}

	// 层序遍历
	public void levelOrderTraversal(Visitor<E> visitor) {
		if (root == null || visitor == null) return;
		Queue<Node<E>> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node<E> node = queue.poll();
			if (visitor.visit(node.element)) {
				return;
			};
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}

	public static abstract class Visitor<E> {
		boolean stop;
		public abstract boolean visit(E element);
	}

	/*
	 * @return 0: e1 = e2 大于0: e1 > e2 小于零：e1 < e2
	 **/
	@SuppressWarnings("unchecked")
	private int compare(E e1, E e2) {
		if (comparator != null) {
			return comparator.compare(e1, e2);
		}
		return ((Comparable<E>) e1).compareTo(e2);
	}

	private void elementNotNullCheck(E element) {
		if (element == null) {
			throw new IllegalArgumentException("element must not be null");
		}
	}

}

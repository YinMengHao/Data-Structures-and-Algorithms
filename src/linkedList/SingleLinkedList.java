package linkedList;

public class SingleLinkedList<E> extends AbstractList<E> {
	private Node<E> first;
	
	// 内部类
	private static class Node<E> {
		E element;
	    Node<E> next;
	    
	    public Node(E element, Node<E> next) {
			this.element = element;
			this.next = next;
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		size = 0;
		first = null;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return node(index).element;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		Node<E> node = node(index);
		E old = node.element;
		node.element = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		checkIndexForAdd(index);
		if (index == 0) {
			first = new Node<>(element, first);
		} else {
			Node<E> pre = node(index - 1);
			pre.next = new Node<>(element, pre.next);
		}
		size++;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		checkIndex(index);
		Node<E> node = first;
		if (index == 0) {
			first = first.next;
		} else {
			Node<E> pre = node(index - 1);
			node = pre.next;
			pre.next = node.next;
		}
		size--;
		return node.element;
	}

	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		Node<E> node = first;
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (node.element == null) return i;
				node = node.next;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(node.element)) return i;
				node = node.next;
			}
		}
		
		return ELEMENT_NOT_FOUND;
	}
	
	// 根据索引返回对应的node
	private Node<E> node(int index) {
		checkIndex(index);
		Node<E> node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Node<E> node = first;
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append("[");
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}
			string.append(node.element);
			node = node.next;
		}
		string.append("]");
		
		return string.toString();
	}
	
}

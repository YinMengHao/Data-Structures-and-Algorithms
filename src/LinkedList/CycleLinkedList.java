package LinkedList;

public class CycleLinkedList<E> extends AbstractList<E> {
private Node<E> first;
private Node<E> last;

// 内部类
private static class Node<E> {
	E element;
	Node<E> pre;
    Node<E> next;
    
    public Node(E element, Node<E> pre, Node<E> next) {
		this.element = element;
		this.next = next;
		this.pre = pre;
	}
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	StringBuilder sb = new StringBuilder();
    	if (pre != null) {
			sb.append(pre.element);
		} else {
			sb.append("null");
		}
    	sb.append("_").append(element).append("_");
    	if (next != null) {
			sb.append(next.element);
		} else {
			sb.append("null");
		}
    	return sb.toString();
    }
}

@Override
public void clear() {
	// TODO Auto-generated method stub
	size = 0;
	first = null;
	last = null; 
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
	
	if (index == size) {
		Node<E> oldLast = last;
		last = new Node<>(element, last, null);
		if (oldLast == null) {
			first = last;
		} else {
			oldLast.next = last;
		}
	} else {
		Node<E> next = node(index);
		Node<E> pre = next.pre;
		Node<E> node = new Node<>(element, pre, next);
		next.pre = node;
		
		if (pre == null) {
			first = node; 
		} else {
			pre.next = node;
		}
	}
	  
	size++;
}

@Override
public E remove(int index) {
	// TODO Auto-generated method stub
	checkIndex(index);
	
	Node<E> node = node(index);
	Node<E> pre = node.pre;
	Node<E> next = node.next;
	if (pre == null) { // index == 0
		first = next;
	} else {
		pre.next = next;
	}
	
	if (next == null) { // index == size - 1
		last = pre;
	} else {
		next.pre = pre;
	}
//	if (index == size - 1) {
//		last = next.pre;
//		next.pre.next = null;
//	} else {
//		Node<E> pre = next.pre;
//		if (pre == null) { // index == 0
//			first = next.next;
//			next.pre = null;
//		} else {
//			pre.next = pre.next.next;
//			pre = pre.next.pre;
//		}
//	}
	
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
	Node<E> node = null;
	if (index < (size >> 1)) {
		node = first;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
	} else {
		node = last;
		for (int i = size - 1; i > index; i--) {
			node = node.pre;
		}
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
		string.append(node);
		node = node.next;
	}
	string.append("]");
	
	return string.toString();
	}
}

package linkedList;

public class CircleLinkedList<E> extends AbstractList<E> {
private Node<E> first;
private Node<E> last;
//记录当前node
private Node<E> current;

// 双向循环链表
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
		last = new Node<>(element, last, first);
		if (oldLast == null) {
			first = last;
			first.next = first;
			first.pre = first;
		} else {
			oldLast.next = last;
			first.pre = last; 
		}
	} else {
		Node<E> next = node(index);
		Node<E> pre = next.pre;
		Node<E> node = new Node<>(element, pre, next);
		next.pre = node;
		pre.next = node;

		if (index == 0) {
			first = node; 
		}
	}
	  
	size++;
}

@Override
public E remove(int index) {
	// TODO Auto-generated method stub
	checkIndex(index);
	return remove(node(index));
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

public void reset() {
	current = first;
}

public E next() {
	if (current == null) return null;
	current = current.next;
	return current.element;
}


public E remove() {
	if (current == null) return null;
	Node<E> nextNode = current.next;
	E element = remove(current);
	if (size == 0) {
		current = null;
	} else {
		current = nextNode;
	}
	return element;
}

private E remove(Node<E> node) {
	if (size == 1) {
		first = null;
		last = null;
	} else {
		Node<E> pre = node.pre; 
		Node<E> next = node.next;
		
		pre.next = next;
		next.pre = pre;

		if (node == first) { // index == 0
			first = next;
		} 
		
		if (node == last) { // index == size - 1
			last = pre;
		}
	}
	size--;
	return node.element;
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

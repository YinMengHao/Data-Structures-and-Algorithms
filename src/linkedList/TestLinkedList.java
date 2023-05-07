package linkedList;

public class TestLinkedList<E> extends AbstractList<E> {
	
	private Node<E> first;
	private Node<E> last;
	
	private static class Node<E> {
	    Node<E> pre;
		Node<E> next;
		E element;
		
		public Node(E element, Node<E> pre, Node<E> next) {
			this.element = element;
			this.pre = pre;
			this.next = next;
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
		checkIndex(index);
		// TODO Auto-generated method stub
		return node(index).element;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		checkIndex(index);
		Node<E> currentNode = node(index);
		Node<E> oldNode = currentNode;
		currentNode.element = element;
		return oldNode.element;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub
		checkIndexForAdd(index);
		if (index == 0) {
			if (first == null) {
				Node<E> resultNode = new Node<>(element, first, last);
				System.err.println(element);
				first = resultNode;
				last = resultNode;
				resultNode.pre = resultNode;
				resultNode.next = resultNode;
			} else {
				Node<E> indexNode = node(0);
				Node<E> resultNode = new Node<>(element, last, indexNode);
				System.out.println(element);
				
				first = resultNode;
				indexNode.pre = resultNode;
				last.next = resultNode;
			}
			
		} else {
			Node<E> currentNode = node(index);
			Node<E> preNode = null;
			Node<E> nextNode = null;
			if (index == size) {
				nextNode = first;
				preNode = currentNode;
			} else {
				System.err.println(currentNode.element);
				nextNode = currentNode;
				preNode = currentNode.pre;
			}

			Node<E> resultNode = new Node<>(element, preNode, nextNode);

			preNode.next = resultNode;
			if (index == size) {
				last = resultNode;
				nextNode.pre = resultNode;
			} else {
				currentNode.pre = resultNode;
			}
			
		}
		size++;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		checkIndex(index);
		
		Node<E> node = first;
		if (size == 1) {
			first = null;
			last = null;
		} else {
			Node<E> currentNode = node(index);
			Node<E> preNode = currentNode.pre;
			Node<E> nextNode = currentNode.next;
			preNode.next = nextNode;
			nextNode.pre = preNode;
			
			if (index == 0) {
				first = nextNode;
			}
			if (index == size - 1) {
				last = preNode;
			}
		}
		
		
		return node.element;
	}

	@Override
	public int indexOf(E element) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private Node<E> node(int index) {
		Node<E> crrentNode = first;
		if (index < (size >> 1)) {
			for (int i = 0; i < index; i++) {
				crrentNode = crrentNode.next;
			}
		} else {
			crrentNode = last;
			for (int i = size - 1; i > index; i--) {
				crrentNode = crrentNode.pre;
			}
		}
		return crrentNode;
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

package LinkedList;
import java.lang.Exception;
import java.util.Iterator;
// Dynamic Array
public class ArrayList<E> extends AbstractList<E> {
	private E[] elements;
	private static final int DEFAULT_CAPATICY = 10;
	
	@SuppressWarnings("unchecked")
	public ArrayList(int capaticy) {
		capaticy = (capaticy < DEFAULT_CAPATICY ? DEFAULT_CAPATICY : capaticy);
		elements = (E[])new Object[capaticy];
	}

	public ArrayList() {
		this(DEFAULT_CAPATICY);
	}
	
	/*
	 * 清除所有元素
	 * */
	public void clear() {
		size = 0;
	}
	
	
	public void add(int index, E element) {
		checkIndexForAdd(index);

		// 扩容
		ensuerCapacity(size + 1);
		
		for (int i = size - 1; i >= index; i--) {
			elements[i + 1] = elements[i];
		}
		elements[index] = element;
		size++;
	}
	
	public E remove(int index) {
		checkIndex(index);
		E old = elements[index];
		while (size > index) {
	 		elements[index] = elements[index + 1];
	 		index++;
		}
		elements[--size] = null;
		return old;
	}
	// 删除指定元素
	public void remove(E element) {
		remove(indexOf(element));
	}
	
	public int indexOf(E element) {
		if (element == null) {
			for (int i = 0; i < size; i++) {
				if (elements[i] == null) return i;
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (element.equals(elements[i])) return i;
			}
		}
		
		return ELEMENT_NOT_FOUND;
	}
	  
	public E set(int index, E element) {
		checkIndex(index);
		E old = elements[index];
		elements[index] = element;
		return old;
	}
	
	public E get(int index) {
		checkIndex(index);
		return elements[index];
	}
	
	@SuppressWarnings("unchecked")
	private void ensuerCapacity(int capacity) {
		int oldCapacity = elements.length;
		if (oldCapacity >= capacity) return;
		// 新容量是旧容量的1.5倍
		int newCapacity = capacity + capacity >> 1;
		E[] newElements =(E[])new Object[newCapacity];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
		System.out.println(oldCapacity + "扩容为：" + newCapacity);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder string = new StringBuilder();
		string.append("size=").append(size).append("[");
		for (int i = 0; i < size; i++) {
			if (i != 0) {
				string.append(", ");
			}
			string.append(elements[i]);
		}
		string.append("]");
		
		return string.toString();
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		// TODO Auto-generated method stub
//		return super.equals(obj);
//	}

}

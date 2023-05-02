package List;
import java.lang.Exception;
import java.util.Iterator;
// Dynamic Array
public class ArrayList<E> {
	private int size;
	private E[] elements;
	private static final int DEFAULT_CAPATICY = 10;
	private static final int ELEMENT_NOT_FOUND = -1;
	
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
	
	/*
	 * 元素的数量
	 * @return
	 * **/
	public int size() {
		return size;
	}
	
	/*
	 * 是否为空
	 * @return
	 * */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/*
	 * 是否包含某个元素
	 * @return
	 * */
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}
	
	public void add(E element) {
//		elements[size++] = element;
		add(size, element);
	}
	
	public void add(int index, E element) {
		checkIndexForAdd(index);

		// 扩容
		ensuerCapacity(size + 1);
		
		int tempSize = size;
//		while (tempSize-- > index) {
//			elements[tempSize + 1] = elements[tempSize];
//			
//		}
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
		size--;
		return old;
	}
	
	public int indexOf(E element) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == element) return i;
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
	
	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			String resultString = "Index: " + index + ", Size: " + size;
			throw new IndexOutOfBoundsException(resultString);
		} 
	}
	
	private void checkIndexForAdd(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
		}
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

}

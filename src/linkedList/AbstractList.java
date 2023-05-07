package linkedList;

public abstract class AbstractList<E> implements List<E> {
	protected int size;

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
	
	protected void outOfBounds(int index) {
		String resultString = "Index: " + index + ", Size: " + size;
		throw new IndexOutOfBoundsException(resultString);
	}
	
	protected void checkIndex(int index) {
		
		if (index < 0 || index >= size) {
			outOfBounds(index);
		} 
	}
	
	protected void checkIndexForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBounds(index);
		}
	}
}

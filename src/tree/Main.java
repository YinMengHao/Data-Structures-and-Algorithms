package tree;

import java.util.Comparator;

public class Main {
	
	public static class PersonComparator implements Comparator<Person> {

		@Override
		public int compare(Person o1, Person o2) {
			// TODO Auto-generated method stub
			return o1.getAge() - o2.getAge();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinarySearchTree<Person> bst = new BinarySearchTree<>();
		bst.add(new Person(10));
		bst.add(new Person(20));
		bst.add(new Person(30));
		
		BinarySearchTree<Person> bst1 = new BinarySearchTree<>(new PersonComparator());
		bst1.add(new Person(10));
		bst1.add(new Person(20));
		bst1.add(new Person(30));
		
		
		BinarySearchTree<Person> bst2 = new BinarySearchTree<>(new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getAge() - o2.getAge();
			}
			
		});


	}

}

package tree;

public class Person implements Comparable<Person> {
	
	private int age;
	
	public Person(int age) {
		this.age = age;
	}
	
	int getAge() {
		return age;
	}
	
	void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return age - o.age;
	}
	
	
}

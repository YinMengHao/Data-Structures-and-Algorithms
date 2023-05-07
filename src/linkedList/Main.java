package linkedList;


public class Main {
	
	static void josephus() {
		CircleLinkedList<Integer> list = new CircleLinkedList<>();
		for (int i = 1; i < 9; i++) {
			list.add(i);
		}
		
		
		
		list.reset();
		
		while (!list.isEmpty()) {
			list.next();
			list.next();
			System.out.println(list.remove());;
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		josephus();
				
		List<Integer> list = new SingleLinkedList<>();
//		list.remove(0);
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);

		list.add(0, 100);
		list.add(0, 1);
//		list.remove(-1);
		list.remove(1);
		list.remove(6);
//		System.out.println(list.size());
//		System.out.println(list);
		
		List<Integer> aryList = new ArrayList<>();
		
		for (int i = 0; i < 50; i++) {
			aryList.add(i);
		}
		
		for (int i = 0; i < 50; i++) {
			aryList.remove(0);
		}
//		aryList.add(10);
//		aryList.add(20);
//		aryList.add(30);
//		aryList.add(40);
//		aryList.add(50);
//		aryList.add(60);
//
//		aryList.add(0, 100);
//		aryList.add(0, 1);
////		list.remove(-1);
//		aryList.remove(1);
//		aryList.remove(6);
//		System.out.println(aryList.size());
//		System.out.println(aryList);
		
		List<Integer> linkedList = new  CircleLinkedList<>();
		linkedList.add(10);
		linkedList.add(40);
		linkedList.add(50);
		linkedList.add(60);

//		linkedList.add(0, 20);

//		linkedList.add(60);
//		linkedList.add(0, 100);
//		linkedList.add(50);
		linkedList.add(1, 1);
		linkedList.add(0, 30);

//		System.out.println(linkedList.size());
//		System.out.println(cycleList.remove(cycleList.size() - 2));;
//		
		System.out.println(linkedList);
		
		
		
		List<Integer> cycleList = new TestLinkedList<>();
		
		cycleList.add(10);
		cycleList.add(40);
		cycleList.add(50);
		cycleList.add(60);


//		cycleList.add(0, 20);
		cycleList.add(1, 1);

		cycleList.add(0, 30);


		System.out.println(cycleList.size());
		System.out.println(cycleList);

		
		
		
	

		// 斐波那契数列
		//0 1 1 2 3 5 8 13 。。。
		
//		Times.test((Block) new Block() {
//			
//			@Override
//			public void execute() {
//				// TODO Auto-generated method stub
//				System.out.println(fib1(44));
//			}
//		});
//
//		Times.test((Block) new Block() {
//			
//			@Override
//			public void execute() {
//				// TODO Auto-generated method stub
//				System.out.println(fib2(44));
//			}
//		});
		
	}
	
	// 时间复杂度: O(2^n)
	public static int fib1(int n) {
		if (n <= 1) { return n; }
		return fib1(n - 1) + fib1(n - 2);
	}
	
	// 时间复杂度: O(n)
	public static int fib2(int n) {
		if (n <= 1) return n;
		int first = 0, second = 1, sum = 0, index = 2;
		while (n >= index) {
			sum = first + second;
			first = second;
			second = sum;
			index++;
		}
		return second;
	}

}

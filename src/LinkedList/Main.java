package LinkedList;

import java.util.zip.Inflater;

import com.mh.Times;
import com.mh.Times.Block;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				
		List<Integer> list = new LinkedList<>();
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
		System.err.println(list.size());
		System.out.println(list);
		
		List<Integer> aryList = new ArrayList<>();
		aryList.add(10);
		aryList.add(20);
		aryList.add(30);
		aryList.add(40);
		aryList.add(50);
		aryList.add(60);

		aryList.add(0, 100);
		aryList.add(0, 1);
//		list.remove(-1);
		aryList.remove(1);
		aryList.remove(6);
		System.err.println(aryList.size());
		System.out.println(aryList);
		
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

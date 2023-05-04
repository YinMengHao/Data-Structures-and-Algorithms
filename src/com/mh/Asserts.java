package com.mh;

public class Asserts {
	
	public static void test(boolean result) {
		try {
			if (!result) {
				throw new Exception("测试未通过❌");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

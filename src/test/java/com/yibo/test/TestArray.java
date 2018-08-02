package com.yibo.test;

import org.junit.Test;

import com.yibo.leetcode.structrue.Array;

public class TestArray {
	@Test
	public void test01() {
		Array array = new Array(20);
		for (int i = 0; i < 11; i++) {
			array.addLast(i);
		}
		System.out.println(array);
	}
}

package com.yibo.leetcode.structrue;

public interface UnionFind {
	/**
	 * 查看两个元素是否所属一个集合
	 * 
	 * @param p 元素1
	 * @param q 元素2
	 * @return true-同一个集合, false-不同集合
	 */
	boolean isConnected(int p, int q);

	/**
	 * 合并元素p和元素q所在集合
	 * 
	 * @param p 元素1
	 * @param q 元素2
	 */
	void unionElements(int p, int q);

	int size();
}

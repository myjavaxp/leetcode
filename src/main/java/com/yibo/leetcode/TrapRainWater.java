package com.yibo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water-ii/description/
 */
public class TrapRainWater {
	public int trapRainWater(int[][] heightMap) {
		int x = heightMap.length;
		int y = heightMap[0].length;
		List<Pillar> list = new ArrayList<>();
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				list.add(new Pillar(i, j, heightMap[i][j]));
			}
		}
		return 0;
	}
}

class Pillar {
	private int x;
	private int y;
	private int value;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Pillar pillar = (Pillar) o;
		return x == pillar.x && y == pillar.y;
	}

	@Override
	public int hashCode() {

		return Objects.hash(x, y);
	}

	public Pillar() {
	}

	public Pillar(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Pillar{" + "x=" + x + ", y=" + y + ", value=" + value + '}';
	}
}
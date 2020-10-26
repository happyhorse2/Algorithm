package com.juzhen;

import java.util.LinkedList;
import java.util.Queue;

//最短通路值
public class ShortestPath {
	public static void main(String[] args) {
		int[][] array = {{1,0,1,1,1},{1,0,1,0,1},{1,1,1,0,1},{1,1,1,1,1}};
		System.out.print(shortestPathMethod(array));
	}
	
	//因为是广度遍历，每次都加1步，所以最先到达的就是最短的，重点是广度遍历
	public static int shortestPathMethod(int[][] matrix) {
		if (matrix==null) {
			return 0;
		}
		Queue<Integer> xqueue = new LinkedList<Integer>();
		Queue<Integer> yqueue = new LinkedList<Integer>();
		int[][] map = new int[matrix.length][matrix[0].length];
		map[0][0] = 1;
		xqueue.add(0);
		yqueue.add(0);
		int tempx, tempy;
		while(!xqueue.isEmpty()) {
			tempx = xqueue.poll();
			tempy = yqueue.poll();
			if(tempx==matrix.length-1&&tempy==matrix[0].length-1) {
				return map[tempx][tempy];
			}
			walkTo(map[tempx][tempy], matrix, map, tempx-1, tempy, xqueue, yqueue);
			walkTo(map[tempx][tempy], matrix, map, tempx+1, tempy, xqueue, yqueue);
			walkTo(map[tempx][tempy], matrix, map, tempx, tempy-1, xqueue, yqueue);
			walkTo(map[tempx][tempy], matrix, map, tempx, tempy+1, xqueue, yqueue);
		}
		return map[matrix.length-1][matrix[0].length-1];
		
	}
	
	public static void walkTo(int pre, int[][] matrix, int[][] map, int toX, int toY, Queue<Integer> xqueue, Queue<Integer> yqueue) {
		if(toX<0||toX>=matrix.length||toY<0||toY>=matrix[0].length||matrix[toX][toY]!=1||map[toX][toY]!=0) {
			return;
		}
		map[toX][toY]= pre+1;
		xqueue.add(toX);
		yqueue.add(toY);
		
	}
	
}

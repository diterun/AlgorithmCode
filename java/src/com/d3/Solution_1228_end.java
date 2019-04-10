package com.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution_1228_end {
	static int T, test_case;
	static int n, index, numCnt;
	static String[] line;
	static LinkedList<Integer> list = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d3/1228.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		T = 10;
		
		for(test_case = 1; test_case <= 10; test_case++) {
			n = Integer.parseInt(br.readLine().trim());
			
			line = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(line[i]));
			}
			
			n = Integer.parseInt(br.readLine().trim());
			
			line = br.readLine().split(" ");
			for (int i = 0, size = line.length; i < size; i++) {
				String command = line[i];
				
				switch(command) {
				case "I": case "i":
					index = Integer.parseInt(line[i + 1]);
					numCnt = Integer.parseInt(line[i + 2]);
					
					for (int j = i + 3; j < i + 3 + numCnt; j++) {
						list.add(index++, Integer.parseInt(line[j]));
					}
					
					i = i + numCnt;
					break;
				}
			}
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
			
			list.clear();
		}
		
		br.close();
	}

}

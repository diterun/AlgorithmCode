package com.none;

import java.io.FileWriter;
import java.util.Random;

public class NanSu {
	public static void main(String[] args) throws Exception{
		Random r = new Random();
		int n = 10000;
		int m = 10;
		FileWriter output = new FileWriter("res1/temp.txt");

		output.write(n + " " + m + "\n");
		
		for (int j = 1; j <= m; j++) {
			output.write("0 1 " + j + "\n");
		}
		System.out.println(r);
		output.close();
	}

//	public static void main(String[] args) throws Exception{
//		Random r = new Random();
//		String data;
//		FileWriter output = new FileWriter("res1/temp.txt");
//		
//		int a = 1;
//		for (int i = 0; i < 100; i++) {
//			if(i % 2 == 0) {
//				for (int j = 0; j < 100; j++) {
//					data = (a++) + " ";
//					output.write(data);
//				}
//			} else {
//				a += 99;
//				for (int j = 0; j < 100; j++) {
//					data = (a--) + " ";
//					output.write(data);
//				}
//				
//				a += 101;
//			}
//			output.write('\n');
//		}
//		
//		output.close();
//	}

}

package com.none;

import java.io.FileWriter;
import java.util.Random;

public class NanSu {
	public static void main(String[] args) throws Exception{
		Random r = new Random();
		int n = 10;
		int m = 10;
		int num;
		String data =" ";
		FileWriter output = new FileWriter("res1/temp.txt");
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				num = r.nextInt(99) + 1;
				
				if(0 <= num && num < 80) {
					data="A";
				} else if(80 <= num && num < 90) {
					data="W";
				} else {
					data="X";
				}
				output.write(data);
			}
			output.write('\n');
		}
		
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

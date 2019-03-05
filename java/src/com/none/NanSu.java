package com.none;

import java.io.FileWriter;
import java.util.Random;

public class NanSu {

	public static void main(String[] args) throws Exception{
		Random r = new Random();
		String data;
		FileWriter output = new FileWriter("res/temp.txt");
		
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 100; j++) {
				data = (r.nextInt(99) + 1) + " ";
				output.write(data);
			}
			output.write('\n');
		}
		
		output.close();
	}

}

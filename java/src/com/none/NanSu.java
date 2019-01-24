package com.none;

import java.io.FileWriter;
import java.util.Random;

public class NanSu {

	public static void main(String[] args) throws Exception{
		Random r = new Random();
		String data;
		FileWriter output = new FileWriter("res/temp.txt");
		
		for (int i = 0; i < 500; i++) {
			for (int j = 0; j < 500; j++) {
				data = r.nextInt(1000) + " ";
				output.write(data);
			}
			output.write('\n');
		}
		
		output.close();
	}

}

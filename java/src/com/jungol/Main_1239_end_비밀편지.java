package com.jungol;

import java.io.FileInputStream;
import java.util.Scanner;

public class Main_1239_end_비밀편지 {
	static int n;
	static char[] letter;
	static char[] word = new char[64];
	static char b;
	static char[] result;

	public static void main(String[] args) throws Exception {
		word[0] = 'A';
		word[1] = 'A';
		word[2] = 'A';
		word[4] = 'A';
		word[8] = 'A';
		word[16] = 'A';
		word[32] = 'A';
		word[15] = 'B';
		word[31] = 'B';
		word[47] = 'B';
		word[7] = 'B';
		word[11] = 'B';
		word[43] = 'B';
		word[14] = 'B';
		word[19] = 'C';
		word[3] = 'C';
		word[51] = 'C';
		word[27] = 'C';
		word[23] = 'C';
		word[17] = 'C';
		word[18] = 'C';
		word[28] = 'D';
		word[60] = 'D';
		word[30] = 'D';
		word[29] = 'D';
		word[12] = 'D';
		word[20] = 'D';
		word[24] = 'D';
		word[38] = 'E';
		word[54] = 'E';
		word[46] = 'E';
		word[39] = 'E';
		word[6] = 'E';
		word[34] = 'E';
		word[36] = 'E';
		word[41] = 'F';
		word[57] = 'F';
		word[45] = 'F';
		word[43] = 'F';
		word[9] = 'F';
		word[33] = 'F';
		word[40] = 'F';
		word[53] = 'G';
		word[61] = 'G';
		word[55] = 'G';
		word[21] = 'G';
		word[37] = 'G';
		word[49] = 'G';
		word[52] = 'G';
		word[58] = 'H';
		word[62] = 'H';
		word[59] = 'H';
		word[26] = 'H';
		word[42] = 'H';
		word[50] = 'H';
		word[56] = 'H';
		
		System.setIn(new FileInputStream("res/jungol/1239.txt"));
		Scanner sc = new Scanner(System.in);

		n = Integer.parseInt(sc.nextLine().trim());
		letter = sc.nextLine().toCharArray();
		result = new char[n];
		
		for (int i = 0, size = letter.length; i < size; i += 6) {
			int a = letter[i + 5] - '0';
			a += (letter[i + 4] - '0') << 1;
			a += (letter[i + 3] - '0') << 2;
			a += (letter[i + 2] - '0') << 3;
			a += (letter[i + 1] - '0') << 4;
			a += (letter[i] - '0') << 5;
			
			if(word[a] != b) {
				result[i / 6] = word[a];
			} else {
				System.out.println(i / 6 + 1);
				sc.close();
				return;
			}
		}
		
		System.out.println(result);
		
		sc.close();
	}
}

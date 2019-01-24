package com.d5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution_6782_end {
	static int T, test_case;
	static int MAX = 1000001;
	static long result;
	static long n , midJegob;
	static boolean isEqual;
	static int[] count = new int[MAX];
	static int min, max, mid, i, deckStartIndex, deckCount, key, key_i, maginot;
	
	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/6782.txt"));
		
		T = Integer.parseInt(br.readLine().trim());

		count[0] = 3;
		count[1] = 2;
		count[2] = 1;
		count[3] = 3;
		count[4] = 2;

		key_i = 3;
		key = count[key_i];	// 3
		deckCount = 5;
		deckStartIndex = 5;
	    while(deckStartIndex < MAX){
	    	if(deckStartIndex + deckCount < MAX) {
		        for(i = 0; i < deckCount; i++) {
			        count[deckStartIndex + i] = key + deckCount - i;
		        }
	    	} else {
	    		maginot = MAX - deckStartIndex;
		        for(i = 0; i < maginot; i++) {
			        count[deckStartIndex + i] = key + deckCount - i;
		        }
	    	}
	        key_i++;
			key = count[key_i];
			deckStartIndex += deckCount;
			deckCount += 2;
	    }
		
		for(test_case = 1; test_case <= T; test_case++) {
			n = Long.parseLong(br.readLine().trim());
			result = 0;

            isEqual = false;
            
            if (n < 1000001) {
    			System.out.println("#" + test_case + " " + (count[(int)n] - 1));
    			continue;
            }
            
            min = 0;
            max = MAX - 1;
            while(min < max - 1){
                mid = (min + max) / 2;
//            	System.out.println(n + " = [" + min + " ~ " + max + "] " + mid);
                midJegob = (long)mid * (long)mid;

                if(n < midJegob){
                    max = mid;
                } else if (n > midJegob){
                    min = mid;
                } else {
//                	System.out.println("EQUAL!");
                    isEqual = true;
                    break;
                }
            }

            if(isEqual){
                result = count[mid];
            } else {
                result = count[max] + (((long)max * (long)max) - n);
            }
			
			System.out.println("#" + test_case + " " + result);
		}
		br.close();
	}

}

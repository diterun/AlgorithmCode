package com.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_6782_end_2 {
	static int T, test_case;
	static int MAX = 1000001;
	static long result;
	static long n;
	static boolean isEqual;
	static long[] jegob = new long[MAX];
	static int[] count = new int[MAX];
	static int min, max, mid, i, deckStartIndex, deckCount, key, key_i, maginot;
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/6782.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine().trim());

		jegob[0] = 0L;	count[0] = 3;
		jegob[1] = 1L;	count[1] = 2;
		jegob[2] = 4L;	count[2] = 1;
		jegob[3] = 9L;	count[3] = 3;
		jegob[4] = 16L;	count[4] = 2;
//		jegob[5] = 25L;	count[5] = 8;
//		jegob[6] = 36L;	count[6] = 7;
//		jegob[7] = 49L;	count[7] = 6;
//		jegob[8] = 64L;	count[8] = 5;
//		jegob[9] = 81L;	count[9] = 4;
//		jegob[10] = 100L;	count[10] = 9;
//		jegob[11] = 121L;	count[11] = 8;
//		jegob[12] = 144L;	count[12] = 7;
//		jegob[13] = 169L;	count[13] = 6;
//		jegob[14] = 196L;	count[14] = 5;
//		jegob[15] = 225L;	count[15] = 4;
//		jegob[16] = 256L;	count[16] = 3;

		key_i = 3;
		key = count[key_i];	// 3
		deckCount = 5;
		deckStartIndex = 5;
	    while(deckStartIndex < MAX){
	    	if(deckStartIndex + deckCount < MAX) {
		        for(i = 0; i < deckCount; i++) {
		        	long gob = (long)deckStartIndex + (long)i;
			        jegob[deckStartIndex + i] = gob * gob;
			        count[deckStartIndex + i] = key + deckCount - i;
		        }
	    	} else {
	    		maginot = MAX - deckStartIndex;
		        for(i = 0; i < maginot; i++) {
		        	long gob = (long)deckStartIndex + (long)i;
			        jegob[deckStartIndex + i] = gob * gob;
			        count[deckStartIndex + i] = key + deckCount - i;
		        }
	    	}
	        key_i++;
			key = count[key_i];
			deckStartIndex += deckCount;
			deckCount += 2;
	    }
//	    for(int i = 0; i < MAX; i++){
//	        System.out.println(i + " : " + jegob[i] + "\t" + count[i]);
//	    }
//        System.out.println(jegob[625]);
//        System.out.println(count[625]);
//        System.out.println(jegob[10000]);
//        System.out.println(count[10000]);
		
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

                if(n < jegob[mid]){
                    max = mid;
                } else if (n > jegob[mid]){
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
                result = count[max] + (jegob[max] - n);
            }
			
			System.out.println("#" + test_case + " " + result);
		}
		br.close();
	}

}

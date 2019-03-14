package com.jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_2247_end {
	static public class Student implements Comparable<Student> {
		int s;
		int e;

		public Student(int s, int e) {
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Student o) {
			int a = 0;
			if (s == o.s) {
				a = e - o.e;
			} else {
				a = s - o.s;
			}
			return a;
		}
	}

	static int n, result1, result2;
	static TreeSet<Student> sts = new TreeSet<>();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("jungol/2247.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		result1 = result2 = 0;

		n = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());

			sts.add(new Student(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		int start = sts.first().s;
		int end = sts.first().e;
		int a = 0, b = 0;
		for (Student s : sts) {
			if (s.s <= end && end <= s.e) {
				end = s.e;
			} else if (s.e <= end) {
				continue;
			} else {
				a = end - start;
				b = s.s - end;

				start = s.s;
				end = s.e;

				result1 = result1 > a ? result1 : a;
				result2 = result2 > b ? result2 : b;
			}
		}
		
		a = end - start;
		result1 = result1 > a ? result1 : a;
		
		System.out.println(result1 + " " + result2);

		br.close();
	}
}

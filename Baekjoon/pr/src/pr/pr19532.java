// 백준 19532번
// 연립 방정식
// ax + by = c
// dx + ey = f 에서
// a,b,c,d,e,f가 주어지면
// x와 y를 구하는 문제
// 방법-----------------
// 한줄에 a,b,c,d,e,f를 공백으로 구분하여 입력 받고
// 중첩for문으로 두 식 모두 만족하는 x와 y를 구해
// 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr19532 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		int c = Integer.parseInt(input[2]);
		int d = Integer.parseInt(input[3]);
		int e = Integer.parseInt(input[4]);
		int f = Integer.parseInt(input[5]);
		// 출력
		for (int x = -999; x <= 999; x++) {
			for (int y = -999; y <= 999; y++) {
				if ((a * x + b * y == c) && (d * x + e * y == f)) { // 두 식을 모두 만족하면
					System.out.print(x + " " + y); // 해를 출력하고
					break; // for문 탈출
				}
			}
		}
	}
}
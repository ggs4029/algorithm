// 백준 17356번
// 욱제력을 입력 받고 문제에서 주어진 확률 구하기.
// 방법---------------------
// 첫 줄에 욱과 제의 욱제력을 입력 받고
// m을 구해 욱이 제를 이길 확률을 Math.pow()를 활용해 구한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr17356 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		double a = Double.parseDouble(input[0]);
		double b = Double.parseDouble(input[1]);
		double m = (b-a)/400;
		//출력
		System.out.print(1/(1+Math.pow(10, m)));
	}
}
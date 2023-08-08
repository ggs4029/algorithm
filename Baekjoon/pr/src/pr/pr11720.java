// 백준 11720번
// 숫자의 개수를 첫줄에 입력받고
// 둘째줄에 공백없이 숫자를 입력받고 숫자의 합을 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11720 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split("");
		// 합을 출력
		int sum = 0;
		for(int x=0; x<input.length; x++) {
			sum+=Integer.parseInt(input[x]);
		}
		System.out.print(sum);
	}
}
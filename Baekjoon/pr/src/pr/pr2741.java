// 백준 3373번
// N 찍기
// 방법---------------------
// n주어지면 1부터 n까지 한줄씩 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2741 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 출력
		for(int i=1; i<n; i++) {
			System.out.println(i);
		}
		System.out.print(n);
	}
}
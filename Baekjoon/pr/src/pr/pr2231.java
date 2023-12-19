// 백준 2231번
// 분해합
// 자연수 N의 가장 작은 생성자 구하기
// 방법-----------------------
// 0부터 입력받은 N-1까지 for문을 돌린다.
// for문을 통해 생성자가 있으면 가장 작은 생성자를 출력하고
// 없으면 0을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr2231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 생성자 구하기
		int answer = 0;
		for(int i=0; i<n; i++) {
			int n2 = i;
			int sum = 0;
			// 각 자리수를 더하기 위한 while문
			while(n2 != 0) {
				sum += n2 % 10;
				n2 /= 10;
			}
			// 생성자를 찾으면
			if(i+sum == n) {
				answer = i;
				break;
			}
		}
		// 출력
		System.out.print(answer);
	}
}
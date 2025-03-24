// 백준 28065번
// 길이가 n인 sw 수열 구하는 문제.
// sw 수열이 무엇인지는 문제 참조.
// 방법---------------------
// 첫 줄에 n이 주어짐.
// 번갈아가며 제일 큰 수 n, 제일 작은 수 1부터 추가해감.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr28065 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		// sw 수열 구하기
		int tmp = 1;
		int tmp2 = n;
		for(int i=0; i<n; i++) {
			if(i%2==0) {
				sb.append(tmp2 + " ");
				tmp2--;
			}
			else {
				sb.append(tmp + " ");
				tmp++;
			}
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}
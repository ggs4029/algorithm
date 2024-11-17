// 백준 19741번
// nxn 크기의 정사각형에서 숫자를 1부터 n^2까지 채울때
// 약수의 개수가 k이하면 표를 *로 칠하고 아니면 . 으로 칠하고 출력하는 문제.
// 방법---------------------
// 첫 줄에 n과 k가 주어짐.
// for문을 돌며 약수의 개수를 구해 표를 칠하고 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr19741 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		// 찍기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int tmp = j+1 + i*n;
				if(sum(tmp)<=k) {
					sb.append("*");
				}
				else
					sb.append(".");
			}
			sb.append("\n");
		}
		// 출력
		System.out.print(sb.toString());
	}

	// 약수 개수 구하기
	public static int sum(int n) {
		int sum = 0;
		for(int i=1; i*i<=n; i++) {
			if(n%i==0) {								// 약수면
				sum++;
				if(i!=n/i)								// n/i의 반대편 약수도 추가
					sum++;
			}
		}
		return sum;
	}
}
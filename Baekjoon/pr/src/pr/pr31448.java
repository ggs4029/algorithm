// 백준 31448번
// 오르막의 시작부터 끝날때까지 오른 최대 고도 상승을 구하는 문제
// 방법---------------------
// 첫 줄에 입력의 개수 n을 입력 받고
// 다음 줄에 고도 n개를 입력 받음.
// 오르막의 시작부터 끝까지의 고도 상승 값을 구하고 max값을 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr31448 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		long[] ascend = new long[n];
		for(int i=0; i<n; i++)
			ascend[i] = Long.parseLong(input[i]);
		// 고도 상승 max값 구하기
		long output = 0;
		long sum = 0;
		for(int i=1; i<n; i++) {
			if(ascend[i-1]<ascend[i]) {				// 오르막이면
				sum += ascend[i] - ascend[i-1];
			}
			else {									// 내리막이면
				output = Math.max(sum, output);
				sum = 0;
			}
		}

		// 배열의 마지막 요소 처리 후 출력
		System.out.print(Math.max(sum, output));
	}
}
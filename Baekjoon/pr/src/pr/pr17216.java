// 백준 17216번
// 입력으로 여러 개의 서로 다른 단어가 주어질 때, 첫 번째 단어와 비슷한 단어가 모두 몇 개인지 찾아 출력하는 프로그램을 작성.
// 영문 알파벳 대문자로 이루어진 두 단어가 다음의 두 가지 조건을 만족하면 같은 구성을 갖는다고 말함.
// 1. 두 개의 단어가 같은 종류의 문자로 이루어져 있다.
// 2. 같은 문자는 같은 개수 만큼 있다.
// 방법---------------------
// 첫 줄에 수열 크기 n을 입력 받음.
// 둘째 줄에는 수열 a를 이루고 있는 수들이 주어짐.
// dp[i]는 i를 포함하면서 그 전 원소들과 비교해가며 가장 큰 감소 부분 수열을 갱신해가는 방식으로 구현.
// dp에서 max 값 찾아 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr17216 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n+1];
		int[] dp = new int[n+1];
		String[] input = br.readLine().split(" ");
		for(int i=1; i<=n; i++) {
			a[i] = Integer.parseInt(input[i-1]);
			dp[i] = a[i];
		}
		// dp
		for(int i=1; i<=n; i++) {
			for(int j=1; j<i; j++) {
				if(a[i]<a[j])								// 전 값이 더 크면
					dp[i] = Math.max(dp[i], dp[j]+a[i]);	// 갱신 값 비교
			}
		}
		// max구하기 + 출력
		int output = -1557;
		for(int i=1; i<=n; i++) {
			if(dp[i]>output)
				output = dp[i];
		}
		System.out.print(output);
	}
}
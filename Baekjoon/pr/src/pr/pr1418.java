// 백준 1418번
// 어떤 자연수의 소인수중 최댓값이 k보다 크지 않을때 그 수를 k-세준수라고 부른다.
// n보다 작거나 같은 자연수 중에 k-세준수가 총 몇 개인지 구하는 문제.
// 방법---------------------
// 첫 줄에 n, 다음줄에 k가 주어짐.
// 에라토스테네스의 체로 소수를 구하면서 가장 큰 소인수만 저장하고
// 그 값이 k보다 크지 않은지 검사하고 그 개수를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1418 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		// 에라토스테네스의 체로 소수 구하기
		int output = 0;
		int[] prime = new int[n + 1];
		for(int i=2; i<=n; i++) {
			if(prime[i] == 0) {
				prime[i] = i;
				for(int j= i*2; j<=n; j+=i) {
					if(prime[j] < i)					// 기존 소인수보다 크면
						prime[j] = i;					// 체인지
				}
			}
		}
		// k-세준수 개수 세기
		for(int i=1; i<=n; i++) {
			if(prime[i]<=k)
				output++;
		}
		// 출력
		System.out.print(output);
	}
}
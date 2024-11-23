// 백준 32190번
// 수열을 사랑하는 ian0704를 위해, 다음의 조건을 모두 만족하는 길이가 2N인 수열 A를 구해주자.
// 1 이상 N 이하의 정수가 각각 2번 나타난다.
// 2<= i <= N을 만족하는 모든 정수 i에 대해 값이 i인 A의 두 원소 사이에 있는 A의 원소들의 합을 i로 나눈 나머지가 1이다.
// 만약, 두 i 사이에 존재하는 원소가 없다면 합은 0이라고 가정한다.
// 방법---------------------
// 첫 줄에 n이 입력으로 주어짐.
// 길이 2N인 수열 A 출력.
// n이 홀수일때와 짝수일때 나누어 짜기.
// A 합 = N(N+1)/2 	->	2A = N(N+1)	-> 즉, 2A는 N+1의 배수
// n홀수 - n n-1 n-2 ... 2 1 1 3 2 5 4 ... n n-1
// n짝수 - n-1 n n-4 n-2 ... 1 2 1 2 3 4 ... n-1 n
// 시간초과 주의하기!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr32190 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		int n = Integer.parseInt(br.readLine());
		// 수열 구하기
		if(n%2!=0) {												// 홀수인 경우
			for(int i=n; i>=1; i--)									// 왼
				sb.append(i).append(" ");
			sb.append(1).append(" ");
			for(int i=3; i<=n; i+=2)								// 오
				sb.append(i).append(" ").append(i-1).append(" ");
		}
		else {														// 짝수인 경우
			for(int i=n; i>=2; i-=2)								// 왼
				sb.append(i-1).append(" ").append(i).append(" ");
			for(int i=1; i<=n; i++)									// 오
				sb.append(i).append(" ");
		}
		// 출력
		System.out.print(sb.toString());
	}
}
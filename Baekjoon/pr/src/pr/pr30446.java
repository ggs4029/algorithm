// 백준 30446번
// n이 주어지면 n이하의 서로 다른 회문수의 개수를 출력하는 문제.
// 방법---------------------
// 첫 줄에 n이 주어짐.
// 입력 받은 n을 string으로 바꾸고 절반 자르기.
// 수 절반 만들고 반대로 붙여서 회문수 만들고
// 만든 회문수가 n이하면 카운트 아니면 버리기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr30446 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long n = Long.parseLong(br.readLine());
		// 회문수 개수 구하기
		long output = 0;
		for(int i=1; i<=Long.toString(n).length(); i++) {
			int tmp = (i+1) / 2;
			long start = 1557;
			if(tmp == 1)
				start = 1;
			else
				start = (long)Math.pow(10, tmp-1);
			long end = (long)Math.pow(10, tmp);
			for(long j=start; j<end; j++) {
				String tmp2 = Long.toString(j);
				String palin;
				// 자릿수 홀수인 경우
				if(i%2 == 1)
					palin = tmp2 + new StringBuilder(tmp2.substring(0, tmp2.length()-1)).reverse().toString();
				// 짝수인 경우
				else
					palin = tmp2 + new StringBuilder(tmp2).reverse().toString();
				// 만든 회문수가 n 이하면 ++
				if(Long.parseLong(palin) <= n)
					output++;
				else
					break;
			}
		}
		// 출력
		System.out.print(output);
	}
}
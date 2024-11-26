// 백준 1019번
// 지민이는 전체 페이지의 수가 N인 책이 하나 있다.
// 첫 페이지는 1 페이지이고, 마지막 페이지는 N 페이지이다. 각 숫자가 전체 페이지 번호에서 모두 몇 번 나오는지 구하는 문제.
// 방법---------------------
// 첫 줄에 n이 입력으로 주어짐.
// 1페이지부터 n페이지까지 각 페이지에서 나오는 숫자의 빈도를 기록하고
// 각 자릿수 마다 while문을 돌며 처리해 결과를 구하고 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr1019 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		long n = Long.parseLong(br.readLine());
		// 각 숫자 카운트
		long[] num = new long[10];
		long start = 1;											// 시작 페이지
		long digit = 1;											// 자리수
		while(start<=n) {
			while(start%10!=0 && start<=n) {
				long tmp = start;
				while(tmp>0) {
					num[(int) (tmp % 10)] += digit;
					tmp /= 10;
				}
				start++;
			}
			while(n%10!=9 && start<=n) {
				long tmp = n;
				while(tmp>0) {
					num[(int) (tmp % 10)] += digit;
					tmp /= 10;
				}
				n--;
			}
			if(start>n)
				break;
			start /= 10; n /= 10;
			for(int i=0; i<10; i++)
				num[i] += (n - start + 1) * digit;
			digit *= 10;
		}
		// 출력
		for(long i : num) {
			System.out.print(i+ " ");
		}
	}
}
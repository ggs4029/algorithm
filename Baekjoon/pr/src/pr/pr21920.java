// 백준 21920번
// 길이가 n인 수열 a에서 x와 서로소인 수들을 골라 평균을 구하는 문제
// 방법---------------------
// 첫 줄에 n이 입력으로 주어짐.
// 두번째 줄에 수열 a를 이루는 자연수들이 주어짐.
// 마지막 줄에 x가 주어진다.
// 유클리드 호제법을 사용해 최대공약수가 1인지 확인하고 평균을 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr21920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] num = new int[n];
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(input[i]);
		int x = Integer.parseInt(br.readLine());
		// 서로소들 평균 구하기
		long sum = 0;
		int tmp = 0;
		for(int i=0; i<n; i++) {
			if(gcd(num[i], x)==1) {
				sum += num[i];
				tmp++;
			}
		}
		// 출력
		System.out.print(sum/(double)tmp);
	}

	// 최대공약수 구하기 - 유클리드 호제법
	public static int gcd(int a, int b) {
		while(b>0) {
			int tmp = a;
			a = b;
			b = tmp%b;
		}
		return a;
	}
}
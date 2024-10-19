// 백준 11047번
// 준규가 가지고 있는 동전이 총 N종류이고, 각각의 동전을 매우 많이 가지고 있을때,
// 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 할때 필요한 동전 개수의 최솟값을 구하는 문제
// 방법---------------------
// 첫 줄에 n과 k를 입력 받음.
// 둘째 줄부터 n개 줄에 걸쳐 동전의 가치를 오름차순으로 입력 받음.
// 그리디 알고리즘으로 for문을 돌며 해결.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		long k = Long.parseLong(input[1]);
		long[] price = new long[n];
		for(int i=0; i<n; i++)
			price[i] = Integer.parseInt(br.readLine());
		// 동전 개수의 최솟값 구하기
		long sum = 0;
		for(int i=n-1; i>=0; i--) {						// 큰 가치부터 for문을 돌며
			if(k/price[i]!=0) {							// 몫이 있으면
				sum += k/price[i];						// 동전 개수에 더하고
				k = k - k/price[i] * price[i];			// 그만큼 k에서 뺌
			}
		}
		// 출력
		System.out.print(sum);
	}
}
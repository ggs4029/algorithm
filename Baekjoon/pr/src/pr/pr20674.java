// 백준 20674번
// 주어지는 통계를 기반으로 통계 조작의 최소 비용을 구하는 문제.
// 사례 수가 증가하는 부분을 없애야함.
// 방법---------------------
// 첫 줄에 다가오는 날 n이 주어짐.
// 그다음 n줄에 걸쳐 사례 수 Pi가 주어짐.
// for문을 돌려가며 다음 날에 사례가 증가하면 전날 사례에서 증가값만큼 sum에 더하고
// 다음날 사례를 전날 사례 값으로 조작.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr20674 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(br.readLine());
		// 계산
		int sum = 0;
		for(int i=1; i<n; i++) {
			if(num[i-1]<num[i]) {
				sum += num[i] - num[i-1];
				num[i] = num[i-1];
			}
		}
		// 출력
		System.out.print(sum);
	}
}
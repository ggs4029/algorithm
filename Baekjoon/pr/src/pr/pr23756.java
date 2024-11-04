// 백준 23756번
// 최소로 노브를 돌릴 때 돌려야 하는 각도의 합을 출력하는 문제.
// 방법---------------------
// 첫 줄에 맞추어야 하는 노브 각도의 개수 n이 주어짐.
// 둘째 줄에 노브의 초기 각도 A0이 주어짐.
// 그 다음 n개 줄에 걸쳐 맞추어야 하는 노브 각도가 주어짐.
// 시계 방향으로 돌렸을때와 반시계 방향으로 돌렸을 때의 돌린 각도를 계산해
// 둘이 비교해 더 작은 쪽을 더함.
// for문 다돌면 결과를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pr23756 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int a0 = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		for(int i=0; i<n; i++)
			a[i] = Integer.parseInt(br.readLine());
		// 최소값 구하기
		int output = 0;								// 총 돌린 각도
		int tmp = a0;								// 지금 각도
		for(int i=0; i<n; i++) {
			int tmp1 = (a[i] - tmp + 360) % 360;	// 시계 방향으로 돌린거
			int tmp2 = (tmp - a[i] + 360) % 360;	// 반시계 방향으로 돌린거
			output += Math.min(tmp1, tmp2);
			tmp = a[i];
		}
		// 출력
		System.out.print(output);
	}
}
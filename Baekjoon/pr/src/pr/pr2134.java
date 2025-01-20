// 백준 2134번
// n층짜리 창고 가지고 있는 회사가 새로 m층짜리 창고로 이전을 할건데 물품들을 새 창고로 옮길거임.
// 인부는 항상 하나의 물품을 옮기고 a층에 있던 물품을 새로운 창고의 b층에 옮기면
// a+b시간이 걸리고 a+b의 비용을 받아감.
// 회사 측에서는 우선 최대한 많은 물품을 옮기기를 원하고 그다음 이 물품들을 최소의 비용으로 옮기고 싶어함.
// 이를 구하는 문제.
// 방법---------------------
// 첫 줄에 n, m, k가 주어짐.
// 다음 줄부터 n줄에 걸쳐 각 층에 보관중인 물품의 개수가 주어짐.
// 다음 줄부터 m줄에 걸쳐 새 창고의 각 층에 보관할 수 있는 물품의 개수가 주어짐.
// 두 창고 다 밑층부터 작업.
// while문 사용해 두 창고의 층이 먼저 바닥나거나 꽉차는 경우 층을 높여가며
// 최대 물품 수와 최소 비용을 구해 출력한다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2134 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] storage1 = new int[n+1];							// 옛날 창고
		int[] storage2 = new int[m+1];							// 뉴 창고
		for(int i=1; i<=n; i++)
			storage1[i] = Integer.parseInt(br.readLine());
		for(int i=1; i<=m; i++)
			storage2[i] = Integer.parseInt(br.readLine());
		// 최대 물품 + 최소 비용 구하기
		int output1 = 0;  										// 최대 물품 수
		long output2 = 0;   									// 최소 비용
		int i = 1;
		int j = 1;
		while(i<=n && j<=m) {
			int tmp = Math.min(storage1[i], storage2[j]);		// 옮길 수 있는 물품의 수
			output1 += tmp;
			output2 += tmp * (i + j);
			storage1[i] -= tmp;
			storage2[j] -= tmp;
			if(storage1[i] == 0)								// i층의 물품이 먼저 바닥나면
				i++;											// 층 이동
			if(storage2[j] == 0)								// j층이 꽉차면
				j++;											// 층 이동
		}
		// 출력
		System.out.print(output1 + " " + output2);
	}
}
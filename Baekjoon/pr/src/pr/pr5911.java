// 백준 5911번
// 군대 가기 전에 자기 놀아준 친구 n명한테 선물을 줄건데
// i번째 애가 받고 싶어하는 선물 가격이 P(i)원, 배송비는 S(i)원.
// 즉, i번째 애한테 선물 보내려면 돈 P(i)+S(i)원 필요함.
// 물건 가격 절반 할인 쿠폰이 하나 있을때 이 쿠폰을 i번째 애한테 쓰면 ⌊P(i)/2⌋+S(i)원만 있으면 선물을 보낼 수 있음.
// 선물을 최대 몇 명에게 보낼 수 있는지 구하는 문제.
// 방법---------------------
// 첫 줄에 친구 수 n과 가지고 있는 돈 b가 주어짐.
// 다음 줄부터 n줄에 걸쳐 p(i)와 s(i)가 주어짐.
// 순회하며 하나씩 할인하며 선물 받을 수 있는 친구의 최댓값을 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr5911 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[] p = new int[n];								// 선물 가격
		int[] s = new int[n];								// 배송비
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken());
			s[i] = Integer.parseInt(st.nextToken());
		}
		int output = 0;
		// 순회하며 하나씩 할인해보기
		for(int i=0; i<n; i++) {
			int[] sum = new int[n];							// 총 드는 돈 저장할 배열
			for(int j=0; j<n; j++) {
				if(i == j)									// 할인 쿠폰 쓰기
					sum[j] = (p[j] / 2) + s[j];
				else
					sum[j] = p[j] + s[j];
			}
			// 정렬
			Arrays.sort(sum);
			// 선물 받을 수 있는 친구 수 구하기
			int friend = 0;
			long money = 0;
			for(int j : sum) {
				money += j;
				if(money > b)								// 한도 초과시
					break;
				friend++;
			}
			output = Math.max(output, friend);
		}
		// 출력
		System.out.print(output);
	}
}
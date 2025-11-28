// 백준 16208번
// n개의 막대가 필요해진 현우, 막대를 잘라 n개의 쇠막대를 만드려함.
// 가진게 a1 + a2 + ... + an 길이의 막대 하나 뿐임.
// 길이 x+y인 막대를 x, y로 자르려면 xy의 비용이 듬.
// 최소 비용으로 n개의 막대를 얻고 싶을 때 그 최소 비용을 출력하는 문제.
// 방법---------------------
// 첫 줄에 n을 입력 받음.
// 다음 줄에 원하는 쇠막대의 길이 a1, a2, ... an이 주어짐.
// 순서대로 잘랐다고치고 그때의 드는 비용을 식으로 전개하면
// a1a2 + a1a3 + a1a4 ... + a1an + a2a3 + a2a4 + ... 이렇게 가면서
// 이를 풀어서 보면 각 막대가 그냥 서로 각각을 곱해 가지고 있음.
// 그래서 입력 받은 순서대로 그냥 나누어도 비용은 어차피 같음.
// 비용 구해서 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr16208 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		long[] num = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		long stick = 0;												// 가지고 있는 쇠막대기들의 길이 합
		for(int i=0; i<n; i++) {
			num[i] = Long.parseLong(st.nextToken());
			stick += num[i];
		}
		// 최소 비용 구하기
		long output = 0;
		for(int i=0; i<n; i++) {
			stick -= num[i];											// 막대 쪼개고
			output += num[i] * stick;									// 자른 비용 더하기
		}
		// 출력
		System.out.print(output);
	}
}
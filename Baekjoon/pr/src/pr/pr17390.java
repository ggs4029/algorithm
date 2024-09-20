// 백준 17390번
// 수열을 오름차순으로 정렬하고 구간합을 구하는 문제
// 시간초과에 주의해야함
// 방법--------------------------
// 첫째 줄에 수열의 크기 n과 질문의 개수 q를 입력 받고
// 둘째 줄에 수열 a를 입력 받음.
// 그 다음부터 q개의 줄에 걸쳐 질문을 받고 답들을 출력.
// 그냥 구하면 시간 초과에 걸리므로 질문을 받기전
// 미리 구간합을 모두 구해 배열에 저장하는 방식으로 풀음.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr17390 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[] a = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for(int x=1; x<=n; x++) {
			a[x] = Integer.parseInt(st.nextToken());
		}
		// 정렬
		Arrays.sort(a);
		// 구간합 미리 구하기
		int[] b = new int[n+1];
		for(int x=1; x<=n; x++) {
			b[x] = b[x-1]+a[x];
		}
		// 질문입력
		for(int x=0; x<q; x++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			// 출력
			System.out.println(b[r]-b[l-1]);
		}
	}
}

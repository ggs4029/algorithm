// 백준 15761번
// 소가 n마리 있음.
// 레몬에이드를 먹기 위해 소들이 줄을 설건데
// i번 소는 wi만큼 줄서는것을 감내 가능.
// 줄에 합류할 수 있는 소들의 최소 수를 구하는 문제.
// 방법---------------------
// 첫 줄에 소의 수 n을 입력 받고
// 다음 줄에 w들이 n개가 한줄에 주어짐.
// w들 받아서 내림차순 정렬해
// 인내심 좋은 애들부터 세워두면 최소값 구할수있음.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class pr15761 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer[] num = new Integer[n];
		for(int i=0; i<n; i++)
			num[i] = Integer.parseInt(st.nextToken());
		// 내림차순으로 정렬
		Arrays.sort(num, Collections.reverseOrder());
		// 최소값 구하기
		int output = 0;
		for(int i=0; i<n; i++) {
			if(num[i] >= output)
				output++;
		}
		// 출력
		System.out.print(output);
	}
}
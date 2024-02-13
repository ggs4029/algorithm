// 백준 11399번
// ATM
// 사람들이 돈을 인출하는데 필요한 시간의 최솟값을 구하는
// 그리디 알고리즘 문제
// 방법----------------
// 첫줄에 사람 수를
// 그다음줄에 각 사람들이 돈을 인출하는데 걸리는 시간들을 입력 받는다.
// 입력 받은 시간들은 배열에 저장하고 오름차순으로 정렬한다.
// (오름차순 정렬해야 뒷사람들이 기다리는 시간이 최소)
// 인출하고 있는 사람과 그 뒷사람이 기다리는 시간까지 고려해 합을 구해 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] input = new int[n];
		for(int x=0; x<n; x++) {
			input[x] = Integer.parseInt(st.nextToken());
		}
		// 정렬
		Arrays.sort(input);
		// 출력
		int time = 0;				// 기다린 시간
		int sum = 0;				// 출력할 답
		for(int x=0; x<n; x++) {
			time += input[x];		// 앞서 기다린 시간 + 인출 시간
			sum += time;
		}
		System.out.print(sum);
	}
}
// 백준 30457번
// n명이 단체줄넘기 하려함.
// 학생들은 각자 바라보는 방향에 자신보다 키가 크거나 같은 사람이 있다면 점프할 타이밍을 놓쳐 줄에 걸릴 수 있다.
// 최대한 많은 학생들이 줄넘기를 넘고 싶어 하므로 줄에 걸릴 수 있는 상황을 안 만드려함.
// 학생들 키를 알 때 이 중 최대 몇 명의 학생이 단체줄넘기에 참여할 수 있을지 구하는 문제.
// 방법---------------------
// 첫 줄에 학생 수 n이 주어짐.
// 둘째 줄에 학생들의 키가 한줄에 주어짐.
// 왼쪽 or 오른쪽 볼 수 있으므로
// 같은 키인 사람이 최대 두명 가능함.
// 키의 범위가 1~1000이므로 키대로 빈도 세서
// 같은 키가 두명 이상 있으면 둘만 세는 식으로 학생 수 세서 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr30457 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[] student = new int[1000+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int input = Integer.parseInt(st.nextToken());
			student[input]++;
		}
		// 학생 수 세서 출력
		int output = 0;
		for(int i=1; i<1001; i++)
			output += Math.min(2, student[i]);			// 2명 이상이면 2만 더하기
		System.out.print(output);
	}
}
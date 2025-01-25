// 백준 14569번
// 비어 있는 시간에 추가로 신청할 수 있는 과목의 후보 개수를 구해보는 문제.
// 후보 개수를 세는 것이므로 현재 내 시간표에서 신청할 수 있는 과목끼리 시간이 겹치더라도 모두 세어야 한다.
// 즉, 월요일 1, 2, 3, 4, 5교시 시간이 비어 있고
// 한 과목의 시간이 월요일 1, 2, 3, 4교시이고
// 나머지 한 과목의 시간이 월요일 2, 3, 4, 5교시라면 2과목 모두 후보가 될 수 있다.
// 방법---------------------
// 첫 줄에 총 과목 수 n이 주어짐.
// 다음 줄부터 n줄에 걸쳐 각 과목의 수업시간의 수 k가 주어지고
// 그 옆에 k개의 숫자가 주어지는데 이는 이 과목의 수업이 진행되는 교시를 의미함.
// 다음 줄에 학생수 m이 주어짐.
// m줄에 걸쳐 각 학생들의 비어 있는 교시 개수 p가 주어지고 그 옆에 p개의 숫자가 주어짐.
// 비트 마스킹 이용해 문제 풀기.
// 수업 비트마스크 & 반전 시킨 학생 빈 시간 비트마스크 해서 0인지 확인하고
// 수를 세서 출력.
// 오답노트------------------
// 비트 마스킹 하는 부분에서 자료형 int에서 long으로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr14569 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		long[] masks = new long[n];										// 과목 수업 시간(비트 마스크)
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for(int j=0; j<k; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				masks[i] |= ((long)1 << tmp);							// 수업 시간 비트 마스크
			}
		}
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			long mask2 = 0;
			for(int j=0; j<p; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				mask2 |= ((long)1 << tmp);								// 비어 있는 시간 비트 마스크
			}
			mask2 = ~mask2;												// 비트 반전
			int output = 0;
			for(int j=0; j<n; j++) {
				if((mask2 & masks[j]) == 0)								// 시간 안겹치면
					output++;											// 수강 가능
			}
			sb.append(output).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}
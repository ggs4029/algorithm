// 백준 3758번
// 규칙에 따라 팀의 순위를 출력하는 문제.
// 최종 점수가 같을 때 팀의 순위를 정하는 규칙이 문제에 나와있음.
// 방법---------------------
// 첫 줄에 테스트 케이스의 개수 input을 입력 받음.
// 테스트 케이스 입력의 첫 줄에는 팀의 개수 n, 문제의 개수 k, 당신 팀의 ID t, 로그 엔트리의 개수 m을 입력 받음.
// 그 다음 m개의 줄에 걸쳐 각 풀이에 대한 정보를 입력 받는다.
// 팀 ID i, 문제 번호 j, 획득한 점수 s를 나타내는 세 개의 정수가 한 줄에 주어짐.
// 팀 클래스 구현해서 id 점수 제출횟수 마지막제출시간 저장하고
// 문제에서 주어진대로 정렬 구현해서 팀순위 구해 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class pr3758 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int input = Integer.parseInt(br.readLine().trim());
		for(int x=0; x<input; x++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] max = new int[n+1][k+1];							// 팀점수 최댓값 저장할 배열
			int[] submit = new int[n+1];								// 팀별 제출 횟수 저장할 배열
			int[] time = new int[n+1];									// 팀별 마지막 제출 시간
			// 로그 처리
			for(int y=0; y<m; y++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				submit[i]++;
				time[i] = y+1;
				if(s > max[i][j])										// 지금 팀좀수 최댓값보다 크면 갱신
					max[i][j] = s;
			}
			// 점수 계산
			Team[] team = new Team[n];
			for(int i=1; i<=n; i++) {
				int sum = 0;
				for(int j=1; j<=k; j++)
					sum += max[i][j];
				team[i-1] = new Team(i, sum, submit[i], time[i]);
			}
			// 정렬
			Arrays.sort(team, new Comparator<Team>() {
				@Override
				public int compare(Team x, Team y) {
					// 팀점수 높은순으로
					if(x.score != y.score)
						return y.score - x.score;
					// 제출횟수 적은순으로
					if(x.submit != y.submit)
						return x.submit - y.submit;
					// 마지막 제출 빠른순으로
					return x.time - y.time;
				}
			});
			// 순위 찾기
			int output = 0;
			for(int i=0; i<n; i++) {
				if(team[i].id == t) {
					output = i+1;
					break;
				}
			}
			sb.append(output).append("\n");
		}
		// 출력
		System.out.print(sb.toString().trim());
	}

	// 팀 클래스
	public static class Team {
		int id;
		int score;
		int submit;
		int time;

		public Team(int id, int score, int submit, int time) {
			this.id = id;
			this.score = score;
			this.submit = submit;
			this.time = time;
		}
	}
}
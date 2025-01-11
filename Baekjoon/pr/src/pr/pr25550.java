// 백준 25550번
// 택배 상자들을 옮기지 않고 보이는 모든 면에 붉은색 페인트를 칠하려 한다.
// 이 때, 보이는 면이란 다른 상자 또는 바닥과 닿아있지 않은 면을 말한다.
// 포닉스가 페인트칠을 마친 후, 어떤 면에도 페인트가 칠해져 있지 않은 택배 상자의 수를 구해 보자.
// 방법---------------------
// 첫 줄에 행과 열 n, m이 주어짐.
// 이후 둘째 줄부터 n줄에 걸쳐 각 줄에 m개의 수가 주어짐.
// 테두리 상자 제외하고 탐색하며 멀쩡한 상자 개수 찾아 다 더해주고 출력.
// 상 하 좌 우 (자신-1) 중에서 min값 을 더해감.
// 자신-1 인 이유는 꼭대기 상자 때문.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr25550 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long[][] box = new long[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++)
				box[i][j] = Integer.parseInt(st.nextToken());
		}
		// 멀쩡한 택배 상자의 개수 구하기
		long output = 0;
		for(int i=1; i<n-1; i++) {											// 테두리 상자 제외
			for(int j=1; j<m-1; j++)										// 		"
				if(box[i][j]==0)											// 상자 0이면 셀 필요 x
					continue;
				else {
					long tmp = Math.min(box[i-1][j], Math.min(box[i+1][j],	// 상하좌우,(자신-1) 중에서 min값 구해서
							Math.min(box[i][j-1], Math.min(box[i][j+1], box[i][j]-1))));
					output += tmp;
				}

		}
		// 출력
		System.out.print(output);
	}
}
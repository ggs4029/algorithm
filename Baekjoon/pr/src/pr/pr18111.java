// 백준 18111번
// 마크 할거임.
// 세로 n, 가로 m 크기의 집터를 골랐음.
// 작업은 두가지 가능.
// 1. 좌표 i, j의 가장 윗 블록을 제거하고 인벤토리에 넣음.		-> 2초 걸림
// 2. 인벤토리에서 블록 하나 꺼내서 좌표 i, j 가장 위에 놓음.	-> 1초 걸림
// 땅의 높이를 모두 동일하게 만드는게 목적일 때, 최소시간과 땅의 높이를 구하는 문제.
// 초기에 인벤토리에는 b개만큼의 블록이 있으며 땅의 높이는 256블록을 초과할 수 없음.
// 방법---------------------
// 첫 줄에 n, m, b가 주어진다.
// 다음 줄부터는 n줄에 걸쳐 한 줄에 m개씩 땅의 높이가 주어짐.
// 입력 받은 높이들 중에서 제일 낮은 층부터 순회하며
// 그 높이로 땅을 만들었을 때의 시간을 계산해
// 최소 시간 구하고 그 때의 높이도 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[][] mine = new int[n][m];
		int low = 888484;										// 최소높이
		int high = 0;											// 최대높이
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				mine[i][j] = Integer.parseInt(st.nextToken());
				if(low > mine[i][j])
					low = mine[i][j];
				if(high < mine[i][j])
					high = mine[i][j];
			}
		}
		// 최소시간과 그 높이 구하기
		int output = Integer.MAX_VALUE;
		int len = 0;
		for(int i=low; i<=high; i++) {
			int time = 0;
			int inven = b;
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					if(i < mine[j][k]) {						// 만들 층보다 높으면
						time += (2 * (mine[j][k] - i));			// 시간 추가 (2초씩)
						inven += mine[j][k] - i;				// 블록 인벤토리로
					}
					else {										// 만들 층보다 낮으면
						time += i - mine[j][k];					// 시간 추가
						inven -= i - mine[j][k];				// 블록 빼기
					}
				}
			}
			if(inven < 0)										// 인벤토리 비면
				break;
			if(output >= time) {
				output = time;
				len = i;
			}
		}
		// 출력
		System.out.print(output + " " + len);
	}
}
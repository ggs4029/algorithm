// 백준 2980번
// 상근이가 도로의 끝까지 이동하는데 걸리는 시간을 구하는 문제.
// 상근이는 트럭 운전중이고 도로에는 신호등이 있음.
// 빨간 불이 지속되는 시간과 초록 불이 지속되는 시간은 미리 알고있음.
// 트럭이 도로에 진입했을 때, 모든 신호등의 색상은 빨간색이고, 사이클이 막 시작한 상태.
// 트럭은 1초에 1미터 감.
// 방법---------------------
// 첫 줄에 신호등 개수 n과 도로 길이 l이 주어짐.
// 다음 줄부터 n줄에 걸쳐 신호등 정보 d, r, g가 주어짐.
// d는 신호등 위치, r과 g는 빨간불 초록불이 지속되는 시간.
// 이동하며 신호등 사이클 구하고 빨or초인지 보고 그만큼 더해주기.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2980 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int tmp = 0;										// 현재 위치
		int output = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());		// 신호등 위치
			int r = Integer.parseInt(st.nextToken());		// 빨간불 시간
			int g = Integer.parseInt(st.nextToken());		// 초록불 시간
			output += (d - tmp);							// 이동
			int light = output % (r + g);
			if(light < r)									// 빨간불이면
				output += (r - light);
			tmp = d;
		}
		output += (l - tmp);
		// 출력
		System.out.print(output);
	}
}
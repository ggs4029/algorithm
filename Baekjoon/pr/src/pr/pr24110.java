// 백준 24110번
// 문제에서 주어진 JOI 로고 규칙에 따라
// N이 주어졌을때의 포스터에서의 K행을 출력하는 문제
// 시간초과에 주의 - 재귀함수 사용
// 방법---------------------
// 한 줄에 N과 K를 입력 받는다.
// 재귀 함수를 이용해 K행을 구하고 출력
// K값 주의

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr24110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		// 행 구하기
		for(int i=0; i<Math.pow(2, N); i++) {
			output.append(result(N, K-1, i));
		}
		// 출력
		System.out.print(output.toString());
	}

	public static char result(int N, int x, int y) { 	// x = 행, y = 열

		if(N==0) return 'J';					// N이 0이면 J하나 밖에 없음

		int mid = (int)Math.pow(2, N-1); 		// 가운데
		if(x<mid && y<mid) {					// 왼쪽위
			return 'J';
		}
		else if(x<mid && y>=mid){				// 오른쪽위
			return 'O';
		}
		else if(x>=mid && y<mid) {				// 왼쪽아래
			return 'I';
		}
		else
			return result(N-1, x-mid, y-mid);	// 재귀
	}
}
// 백준 2630번
// 분할정복을 사용한 색종이 만들기
// 최종적으로 만들어진 파란색, 흰색 색종이의 개수들을 출력하는 문제
// 방법---------------------
// 첫 줄에 전체 종이의 한 변의 길이 n이 주어짐.
// 다음 줄부터 n줄에 걸쳐 정사각형 칸들의 색이 주어진다.
// 색종이를 분할하는 메소드, 색종이가 같은 색인지 확인하는 메소드 두개로 나누어 구현.
// 색종이 분할 메소드에서 재귀를 이용해 색종이를 분할.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr2630 {
	public static int white = 0, blue = 0;
	public static int[][] input;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int n = Integer.parseInt(br.readLine());
		input = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++)
				input[i][j] = Integer.parseInt(st.nextToken());
		}
		// 색종이 분할
		confetti(0, 0, n);
		// 출력
		System.out.println(white);
		System.out.print(blue);

	}

	// 색종이 분할
	public static void confetti(int a, int b, int n) {
		// 색깔 검사
		if(color(a, b, n)) {								// 구역이 한가지 색이면
			if(input[a][b]==0)
				white++;
			else
				blue++;
			return;											// 더 이상 구역을 나눌 필요 없으므로 return
		}
		// 재귀 파트
		confetti(a, b, n/2);								// 왼쪽 위
		confetti(a, b + n/2, n/2);							// 왼쪽 아래
		confetti(a + n/2, b, n/2);							// 오른쪽 위
		confetti(a + n/2, b + n/2, n/2);					// 오른쪽 아래
	}

	// 그 구역의 색이 같은지 확인
	public static boolean color(int a, int b, int n) {
		int tmp = input[a][b];
		for(int i=a; i<a+n; i++) {
			for(int j=b; j<b+n; j++) {
				if(input[i][j]!=tmp)						// 색깔 다르면 false
					return false;
			}
		}
		return true;										// 모든 색 동일 true

	}
}
// 백준 16967번
// 크기 h * w인 배열 a와 두 정수 x, y가 있을 때
// 크기 (h+x) * (w+y)인 배열 b는 배열 a랑 배열 a를 아래로 x칸, 오른쪽으로 y칸 이동시킨 배열을 겹쳐 만들 수 있음.
// 이 과정에서 수가 겹쳐지면 수도 합쳐짐.
// 즉 배열 b의 값 (i,j)는 두 배열에 모두 포함x면 0
// 모두에 포함되면 그 합임.
// 배열 b랑 x y 주어지면 배열 a복원해보자.
// 방법---------------------
// 첫 줄에 h w x y 가 주어짐.
// 다음 줄부터 h+w줄에 걸쳐 배열 b의 원소들이 주어짐.
// 순회하면서 겹치는 부분만 따로 뺄셈으로 구해주고
// 나머지 값 구해서 배열 a 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr16967 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int[][] b = new int[h+x][w+y];
		for(int i=0; i<h+x; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<w+y; j++)
				b[i][j] = Integer.parseInt(st.nextToken());
		}
		// 배열a 복원하기
		int[][] a = new int[h][w];
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++) {
				if(i-x >= 0 && j-y >= 0)						// a, b에 모두 포함되어있으면
					a[i][j] = b[i][j] - a[i-x][j-y];
				else
					a[i][j] = b[i][j];
			}
		}
		// 출력
		for(int i=0; i<h; i++) {
			for(int j=0; j<w; j++)
				sb.append(a[i][j] + " ");
			sb.append("\n");
		}
		System.out.print(sb.toString().trim());
	}
}
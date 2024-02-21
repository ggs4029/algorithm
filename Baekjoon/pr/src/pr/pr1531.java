// 백준 1026번
// 투명
// 100x100크기의 그림에 종이를 덮어
// 보이지 않는 그림의 개수를 세는 문제 (m개 이하의 종이가 올려져 있는 경우 그림 보임)
// 방법------------------------
// 덮을 종이의 수인 n과 m을 한줄에 입력 받는다.
// 그다음 n줄에 걸쳐 덮을 종이의 왼쪽 아래 모서리의 x,y 좌표와
// 오른쪽 위 모서리의 x,y 좌표를 입력 받는다.
// for문을 돌며 종이로 덮어질때마다 그 지역의 좌표들의 값을 +1 해주고
// 최종적으로 값이 m+1이상인 좌표들의 수를 세서 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1531 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] draw = new int[100][100];
		// 입력
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for(int x=0; x<n; x++) {
			st = new StringTokenizer(br.readLine());
			// 왼쪽 아래 모서리 좌표
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			// 오른쪽 위 모서리 좌표
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int y=x1-1; y<x2; y++)
				for(int z=y1-1; z<y2; z++)
					draw[y][z]++;
		}
		// 값이 m+1이상인 좌표들의 수 구하기
		int sum = 0;
		for(int x=0; x<100; x++)
			for(int y=0; y<100; y++)
				if(draw[x][y]>=m+1)
					sum++;
		// 출력
		System.out.print(sum);
	}
}
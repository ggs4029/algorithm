// 백준 1236번
// 성 지키기
// 모든 행과 열에 한 명 이상의 경비원을 배치하는 문제
// 방법---------------------------------
// 첫째 줄에 성의 세로, 가로 크기를 입력 받고
// 다음줄부터 성의 상태를 입력 받는다.
// 경비원이 없는 행과 열을 각각 2중 for문을 사용해 구하고
// 더 큰 값을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1236 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int n = Integer.parseInt(st.nextToken());		// 세로
		int m = Integer.parseInt(st.nextToken());		// 가로
		String[][] castle = new String[n][m];			// 성
		for(int x=0; x<n; x++) {
			String[] input = br.readLine().split("");
			for(int y=0; y<m; y++) {
				castle[x][y] = input[y];
			}
		}
		// 추가로 필요한 경비원의 수 구하기
		int tmp = 0;
		// 행 계산
		int output1 = 0;
		for(int x=0; x<n; x++) {
			for(int y=0; y<m; y++) {
				if(castle[x][y].equals("X")) {
					tmp++;
					continue;							// 경비원이 있으면 tmp 올리고 바로 for문 하나 탈출
				}
			}
			if(tmp==0)
				output1++;
			tmp = 0;
		}
		// 열 계산
		int output2 = 0;
		for(int x=0; x<m; x++) {
			for(int y=0; y<n; y++) {
				if(castle[y][x].equals("X")) {			// 경비원이 있으면 tmp 올리고 바로 for문 하나 탈출
					tmp++;
					continue;
				}
			}
			if(tmp==0)
				output2++;
			tmp = 0;
		}
		// 출력
		System.out.print(Math.max(output1, output2));
	}
}
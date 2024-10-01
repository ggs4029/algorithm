// 백준 11758번
// CCW
// 2차원 좌표 평면 위에 있는 점 세개를 순서대로 이은 선분이
// 어떤 방향을 이루고 있는지 출력하는 문제
// 방법---------------------
// 세 줄에 걸쳐 점 p1, p2, p3의 x, y좌표들을 입력 받는다.
// 신발끈 공식을 이용해 나온 결과값을 통해 방향을 구하고 -1, 0, 1 셋 중 하나 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr11758 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int[][] input = new int[3][2];
		for(int i=0; i<3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		// 계산
		int a = input[0][0]*input[1][1]+input[1][0]*input[2][1]+input[2][0]*input[0][1];
		int b = input[1][0]*input[0][1]+input[2][0]*input[1][1]+input[0][0]*input[2][1];
		//출력
		if(a-b>0)						// 반시계 방향
			System.out.print(1);
		else if(a-b==0)					// 평행
			System.out.print(0);
		else							// 시계 방향
			System.out.print(-1);
	}
}
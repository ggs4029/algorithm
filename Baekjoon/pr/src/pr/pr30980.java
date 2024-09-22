// 백준 30980번
// 입력 받은 수식들이
// 답이 맞으면 상하좌우 인접한 모든 원소를 *로
// 틀리면 행렬의 특정 부분(문제에 서술)을 /로 채우기
// 방법---------------------
// 첫째 줄에 N과 M을 입력 받는다.
// 그다음줄부터 3N줄에 걸쳐 여러 문제들을 입력 받는다.
// 채점 할 때 정답 여부에 따라 다르게 채워넣기.
// 문제의 정답이 두자리 수인 경우에 주의하여 풀기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr30980 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder output = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 입력
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] pr = new char[3*N][8*M];
		for(int i=0; i<3*N; i++) {
			String input = br.readLine();
			for(int j=0; j<8*M; j++) {
				pr[i][j] = input.charAt(j);
			}
		}
		// 채점
		for(int i=0; i<3*N; i+=3) {
			for(int j=0; j<8*M; j+=8) {
				// x+y=z
				int x = pr[i+1][j+1] - '0';
				int y = pr[i+1][j+3] - '0';
				int z = pr[i+1][j+5] - '0';
				// z가 두자릿수인 경우
				if(pr[i+1][j+6] != '.')
					z = (pr[i+1][j+6]- '0') + z * 10;
				// 정답
				if(x+y==z) {
					int tmp;
					if(z>=10)					// z 두자리인 경우
						tmp = 7;
					else						// z 한자리인 경우
						tmp = 6;
					pr[i+1][j] = '*';			// 좌, 우
					pr[i+1][j+tmp] = '*';
					for(int k=1; k<tmp; k++) {	// 상, 하
						pr[i][j+k] = '*';
						pr[i+2][j+k] = '*';
					}
				}
				// 땡
				else {
					pr[i][j+3] = '/';
					pr[i+1][j+2] = '/';
					pr[i+2][j+1] = '/';
				}
			}
		}
		// 출력
		for(int i=0; i<3*N; i++) {
			for(int j=0; j<8*M; j++) {
				output.append(pr[i][j]);
			}
			output.append("\n");
		}
		System.out.print(output.toString());
	}
}
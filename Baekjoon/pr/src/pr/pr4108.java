// 백준 4108번
// r * c 크기의 지뢰밭의 정보가 주어지면
// 모든 비어있는 칸마다 인접해 있는 지뢰의 개수를 세서 출력해야하는 문제.
// 지뢰는 그대로 * 로 출력하고 비어있는 칸인 . 만 숫자로 바꿔 출력.
// 방법---------------------
// 여러 개의 테스트 케이스가 제공되고 0이 입력되면 종료됨.
// 각 테스트 케이스의 첫 줄은 행과 열을 뜻하는 r, c가 한 줄에 주어짐.
// 그 다음 줄부터 r줄에 걸쳐 각 줄마다 c개의 문자를 입력 받음.
// 빈 공간에 대해 8방향에 지뢰의 개수를 세고 저장.
// 지뢰는 그대로 지뢰로 저장하고 최종 결과를 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr4108 {
	public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(r==0 && c==0)
				break;
			char[][] mine = new char[r][c];
			for(int i=0; i<r; i++)
				mine[i] = br.readLine().toCharArray();
			// 8방향 지뢰 개수 세기
			for(int i=0; i<r; i++) {
				for(int j=0; j<c; j++) {
					if(mine[i][j] == '.') {							// 빈 공간이면
						int sum = 0;
						for(int k=0; k<8; k++) {
							int nx = i + dx[k];
							int ny = j + dy[k];
							if(nx>=0 && nx<r && ny>=0 && ny<c) {	// 범위 안이고
								if(mine[nx][ny] == '*')				// 폭탄이면
									sum++;
							}
						}
						sb.append(sum);
					}
					else
						sb.append('*');
				}
				sb.append("\n");
			}
		}
		// 출력
		System.out.print(sb.toString().trim());
	}
}
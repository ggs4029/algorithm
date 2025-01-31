// 백준 1028번
// 다이아몬드 광산은 0과 1로 이루어진 R행*C열 크기의 배열이다.
// 다이아몬드는 1로 이루어진 정사각형의 경계선을 45도 회전시킨 모양이다.
// 다이아몬드 광산에서 가장 큰 다이아몬드의 크기를 출력하는 문제.
// 방법---------------------
// 첫 줄에 r과 c가 주어짐.
// 둘째 줄부터 r줄에 걸쳐 다이아몬드 광산의 모양이 주어짐.
// dp[i][j][k] =  좌표 (i, j)에서 k방향으로 다이아몬드를 만들수 있는 최대 크기를 저장.
// k방향 - 순서대로 왼쪽 위, 왼쪽 아래, 오른쪽 위, 오른쪽 아래
// dp값중 최대값을 구해 출력한다.
// 오답노트------------------
// 시간 초과 - dp[i][j][k] 구하는 부분 메소드로 따로 빼기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr1028 {
	public static int r, c;
	public static int[][] mine;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		mine = new int[r][c];
		for(int i=0; i<r; i++) {
			String input = br.readLine();
			for(int j=0; j<c; j++)
				mine[i][j] = input.charAt(j) - '0';
		}
		if(r==1 && c==1) {
			System.out.print(mine[0][0]);
			return;
		}
		// dp
		int[][][] dp = new int[r][c][4];
		int output = 0;
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(mine[i][j] == 1) {												// 시작 위치
					for(int k=0; k<4; k++)
						dp[i][j][k] = cal(i, j, k);									// 각 방향의 크기 계산
					// 최대 크기의 다이아몬드 찾기
					if(dp[i][j][0]>output && dp[i][j][2]>output) {					// 왼쪽, 오른쪽 위 이동한 길이가 원래 값보다 커 갱신 가능하면
						int tmp = Math.min(dp[i][j][0], dp[i][j][2]) - 1;			// 가능한 제일 큰 다이아몬드의 크기
						for(int l=tmp; l>=output; l--) {							// 최대 길이부터 output 까지 다이아몬드 모양이 되는지
							if(i-(2*l) < 0)											// 다이아몬드 위쪽 검사
								continue;
							if(dp[i-(2*l)][j][1]>l && dp[i-(2*l)][j][3]>l) {		// 다이아몬드 아래쪽 검사
								output = l + 1;
								break;
							}
						}
					}
				}
			}
		}
		// 출력
		System.out.print(output);
	}

	// dp[i][j][k]를 구하는 메소드
	public static int cal(int i, int j, int k) {
		int dx = 0;
		int dy = 0;
		int tmp = 0;
		while(true) {
			int nx = i + dx;
			int ny = j + dy;
			if(k==0) {												// 왼쪽 위 이동
				dx--;
				dy--;
			}
			else if(k==1) {											// 왼쪽 아래 이동
				dx++;
				dy--;
			}
			else if(k==2) { 										// 오른쪽 위 이동
				dx--;
				dy++;
			}
			else {													// 오른쪽 아래 이동
				dx++;
				dy++;
			}
			if(nx<0 || nx>=r || ny<0 || ny>=c || mine[nx][ny]==0)	// 범위 벗어나면
				break;
			else
				tmp++;
		}
		return tmp;
	}
}
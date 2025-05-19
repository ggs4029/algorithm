// 백준 2025IUPC_C번
// 쿠키런 스테이지 크기는 3 * n
// 점프를 j번 이하, 슬라이드를 s번 이하로만 사용해 스테이지를 클리어 할거임.
// 스테이지가 주어지면 클리어 했을 때의 최대 체력을 구하는 문제.
// 시작점과 도착점에는 장애물x, ?번 열에 장애물 있으면 ?+1열에는 장애물 연속하게 존재x
// 처음 쿠키 체력은 h, 한번 부딪히면 체력 k만큼 감소.
// 스테이지 클리어가 불가능하면 -1 출력.
// 방법---------------------
// 첫 줄에 정수 n, j, s, h, k 가 주어짐.
// 그 다음 줄부터 3줄에 걸쳐 스테이지 정보가 주어진다.
// dp로 구현해 점프,슬라이드 or 쳐맞기 나눠서 구하기.
// dp[x][y][z] = x열까지 가면서 jump y번, slide z번 쓰고 남은 최대 체력
// 오답노트------------------
// 점프할 수 있으면 점프하고 슬라이딩할 수 있으면 하도록 코드를 그리디하게 짜면 x
// 높은 장애물은 점프를 2번 쓰고 낮은 장애물은 점프를 1번만 쓰기 때문 -> dp로 구현

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr33925 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());						// 스테이지 길이
		int j = Integer.parseInt(st.nextToken());						// 점프 횟수
		int s = Integer.parseInt(st.nextToken());						// 슬라이드 횟수
		int h = Integer.parseInt(st.nextToken());						// 시작 체력
		int k = Integer.parseInt(st.nextToken());						// 피격시 까이는 체력
		char[][] cookie = new char[3][n];
		for(int x=0; x<3; x++) {
			String input = br.readLine();
			for(int y=0; y<n; y++)
				cookie[x][y] = input.charAt(y);
		}
		// dp - dp[x][y][z] = x까지 저믚 y번 슬라이드 z번하고 남은 체력을 저장
		int[][][] dp = new int[n+1][j+1][s+1];
		for(int x=0; x<=n; x++)
			for(int y=0; y<=j; y++)
				Arrays.fill(dp[x][y], -1);
		dp[0][0][0] = h;
		for(int x=0; x<n; x++) {
			int ground = 0;												// 점프용 장애물 높이
			int sky = 0;												// 슬라이드용 장애물
			for(int y=0; y<3; y++) {
				if(cookie[y][x] == '^')
					ground++;
				else if(cookie[y][x] == 'v')
					sky++;
			}
			for(int y=0; y<=j; y++) {
				for(int z=0; z<=s; z++) {
					int tmp = dp[x][y][z];								// 현재 체력
					if(tmp < 0)
						continue;
					else if(ground==0 && sky==0) {						// 장애물 x면
						dp[x+1][y][z] = Math.max(dp[x+1][y][z], tmp);
						continue;
					}
					else if(ground > 0) {								// 바닥 장애물 있으면
						if(y+ground <= j)								// 점프 사용
							dp[x+1][y+ground][z] = Math.max(dp[x+1][y+ground][z], tmp);
						if(tmp > k)										// 점프 사용x
							dp[x+1][y][z] = Math.max(dp[x+1][y][z], tmp-k);
					}
					else {												// 슬라이드용 장애물 있으면
						if(z+1 <= s)									// 슬라이드 사용한 경우
							dp[x+1][y][z+1] = Math.max(dp[x+1][y][z+1], tmp);
						if(tmp > k)										// 슬라이드 사용x
							dp[x+1][y][z] = Math.max(dp[x+1][y][z], tmp-k);
						continue;
					}
				}
			}
		}
		// 최댓값 구해 출력
		int creamSoda = -1557;
		for(int x=0; x<=j; x++) {
			for(int y=0; y<=s; y++) {
				creamSoda = Math.max(creamSoda, dp[n][x][y]);
			}
		}
		System.out.print(creamSoda);
	}
}
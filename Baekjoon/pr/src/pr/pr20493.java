// 백준 20493번
// 2차원 좌표평면에서 (0,0)에서 동쪽으로 출발하여 걸어갈 때,
// 준원이가 방향을 바꾼 기록이 입력으로 주어지면
// 준원이가 t초간 걸어간 이후 도착했을 좌표를 구하는 문제.
// 방법---------------------
// 첫 줄에 방향 바꾼 횟수 n과 걸어간 시간 t를 입력 받음.
// 다음 줄부터 n개 줄에 걸쳐 방향을 바꾼 시간 + 왼쪽인지 오른쪽인지 문자열을 한줄에 입력 받음.
// 입력 들어온데로 방향만 바꿔가며 좌표 더하고 빼서 구하기.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr20493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long t = Long.parseLong(st.nextToken());
		// 걷기
		long x = 0;
		long y = 0;
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		int tmp = 0;											// 방향 기록할 변수
		long sum = 0;											// 이동한 거리 기록할 변수
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			long time = Long.parseLong(st.nextToken());
			String dir = st.nextToken();
			// 입력 들어온데로 이동
			x += dx[tmp] * (time-sum);
			y += dy[tmp] * (time-sum);
			if(dir.equals("left"))
				tmp = (tmp+1) % 4;								// 왼쪽으로 방향 틀기
			else
				tmp = (tmp+3) % 4;								// 오른쪽으로 방향 틀기
			sum = time;
		}
		// 마지막 이동 하고 출력
		x += dx[tmp] * (t-sum);
		y += dy[tmp] * (t-sum);
		System.out.print(x + " " + y);
	}
}
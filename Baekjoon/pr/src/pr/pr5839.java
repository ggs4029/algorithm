// 백준 5839번
// 베시와 엘시 두마리의 소가 경주를 할거임.
// 각 소들의 움직임은 구간으로 표현되며 입력으로 주어짐.
// 두 소가 총 달린 시간이 똑같을 때
// 소들이 경주 중에 선두가 바뀌는 횟수를 세는 문제.
// 방법---------------------
// 첫 줄에 n과 m이 주어짐.
// 다음 줄부터 n줄에 걸쳐 베시의 움직임을 입력 받을 거고
// 각 줄은 소의 속도와 그 속도로 달린 시간임.
// 그리고 그 다음 줄부터 m줄에 걸쳐 똑같이 엘시의 움직임을 입력 받음.
// 초마다 각 소들의 위치를 배열에 저장하면서
// 선두가 바뀌는지 매 초마다 체크하고 횟수 세서 출력.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pr5839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] bessie = new int[1_000_001];
		int[] elsie = new int[1_000_001];
		// 소들 위치 저장
		int tmp = 1;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int speed = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			for(int j=0; j<time; j++) {
				bessie[tmp] = bessie[tmp-1] + speed;
				tmp++;
			}
		}
		int run = tmp - 1;
		tmp = 1;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int speed = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			for(int j=0; j<time; j++) {
				elsie[tmp] = elsie[tmp-1] + speed;
				tmp++;
			}
		}
		// 선두 변경 횟수 구하기
		String head = "";
		int output = 0;
		for(int i=1; i<=run; i++) {
			if(bessie[i] > elsie[i]) {			// 베시가 엘시 제치면
				if(head.equals("Elsie"))
					output++;
				head = "Bessie";
			}
			else if(elsie[i] > bessie[i]) {		// 엘시가 베시 제치면
				if(head.equals("Bessie"))
					output++;
				head = "Elsie";
			}
		}
		// 출력
		System.out.print(output);
	}
}
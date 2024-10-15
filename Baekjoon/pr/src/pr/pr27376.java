// 백준 27376번
// 참살이길의 시작점에서 끝점까지 얼마나 걸리는지 구하는 문제
// 신호등의 빨간불 상태에 주의
// 방법---------------------
// 첫 줄에 참살이길의 길이 n과 신호등의 개수 k를 입력 받음.
// 다음 k줄동안 신호등의 좌표와 주기
// 그리고 출발한 이후 처음으로 이 신호등이 초록 불이 될 때까지 걸린 시간을 한줄에 입력 받음.
// 입력 받은 좌표들을 가로등의 위치를 기준으로 정렬하고
// 신호등의 상태에 주의하며 이동시간을 구하고 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class pr27376 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		String[] input = br.readLine().split(" ");
		long n = Long.parseLong(input[0]);
		int k = Integer.parseInt(input[1]);
		long[][] lamp = new long[k][3];
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lamp[i][0] = Long.parseLong(st.nextToken());		// 좌표
			lamp[i][1] = Long.parseLong(st.nextToken());		// 주기
			lamp[i][2] = Long.parseLong(st.nextToken());		// 처음 초록불 걸린 시간
		}
		// 신호등 좌표로 정렬
		Arrays.sort(lamp, (a,b) -> Long.compare(a[0], b[0]));
		// 시간 계산
		long myCar = 0;											// 내 차의 위치
		long time = 0;											// 걸린 시간
		for(long[] l : lamp) {
			// 신호등까지 이동
			time += l[0] - myCar;
			// 신호등의 상태
			if(time<l[2]) {										// 처음 초록불 걸린 시간 이전이면
				time += l[2] - time;							// 바뀔때까지 기다려야함
			}
			else {												// 처음 초록불 이후에 도착하면
				long tmp = time - l[2];							// 처음 초록불 된 후로 몇초 지났는지
				long s = (tmp / l[1]) % 2;						// 신호등의 상태(1이면 빨간불)
				long s_time = l[1] - tmp % l[1];				// 초록불로 바뀌기까지 남은 시간
				time += s * s_time; 							// 신호등 주기 계산(빨간불일때만 더해짐)
			}
			// 차량 위치 이동
			myCar = l[0];
		}
		// 마지막 가로등을 지난 후를 계산
		time += n-myCar;
		// 출력
		System.out.print(time);
	}
}